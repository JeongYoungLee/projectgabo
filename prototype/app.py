from flask import Flask, render_template, redirect, request, url_for, session
import cx_Oracle as db
import os

app = Flask(__name__)

db_id = 'parky'
db_pw = 'qwer1234'
url = '192.168.21.252:1521/xe'

app.secret_key = "gabo"

@app.route('/join', methods=['POST'])
def join():
    print('회원가입 요청')
    id = request.form['id']
    pw = request.form['pw']
    email = request.form['email']
    name = request.form['name']
    nick = request.form['nick']
    phone = request.form['phone']
    birth = request.form['birth']
    gender = request.form['gender']
    
    conn = db.connect(db_id, db_pw, url)
    curs = conn.cursor()
    
    sql = "insert into t_user(user_id, user_pw,user_name,user_nick,user_birth,user_phone,user_email,user_gender,user_startdate) values (:1,:2,:3,:4,:5,:6,:7,:8,sysdate)"
    curs.execute(sql,(id,pw,name,nick,birth,phone,email,gender))
    conn.commit()
    curs.close()
    conn.close()
    print(f'회원정보 : {id},{pw},{name},{nick},{birth},{phone},{email},{gender}')
    return '가입 완료'

@app.route('/login', methods=['POST'])
def login():
    print('로그인 시도')
    id = request.form['id']
    pw = request.form['pw']
    
    conn = db.connect(db_id, db_pw, url)
    curs = conn.cursor()
    
    sql = "select * from t_user where (user_id = :1) and (user_pw = :2)"
    curs.execute(sql,(id,pw))
    result = curs.fetchall()
    print(result)
    curs.close()
    conn.close()
    try :
        ##print("{},{},{},{},{},{},{},{},{},{},{},{}".format(result[0][0],result[0][1],result[0][2],result[0][3].isoformat()[:10],result[0][4],result[0][5],result[0][6],result[0][7],result[0][8].isoformat()[:10],result[0][10],result[0][11],result[0][13]))
        print("{} 로그인".format(result[0][0]))
    
        if result[0][12] == 1:
            ## 블랙리스트
            return "블랙리스트"
        elif result[0][9] is not None:
            return "탈퇴회원"
        else :
            return "{}".format(result[0][0])
            ##return "{},{},{},{},{},{},{},{},{},{},{},{}".format(result[0][0],result[0][1],result[0][2],result[0][3].isoformat()[:10],result[0][4],result[0][5],result[0][6],result[0][7],result[0][8].isoformat()[:10],result[0][10],result[0][11],result[0][13])
    except :
        return "회원아님"

@app.route('/end', methods=['POST'])
def end():
    print('탈퇴 요청')
    id = request.form['id']
    
    conn = db.connect(db_id, db_pw, url)
    curs = conn.cursor()
    
    sql = "update t_user set user_enddate = sysdate where user_id = :1"
    curs.execute(sql(id))
    conn.commit()
    curs.close()
    conn.close()
    
    return "탈퇴"

## mainpage에서 지도에 마커 갱신
@app.route('/mappage', methods=['POST'])
def mappage():
    print('마커갱신')

    conn = db.connect(db_id, db_pw, url)
    curs = conn.cursor()
    
    sql = "select t_id,t_category,t_keywords1,t_keywords2,t_keywords3,t_hideuser,t_finduser,t_approval,t_latitude,t_longitude,t_hidedate,(select user_like from t_user u where u.user_id = t.t_hideuser) from t_treasure t where t_approval = 1"
    curs.execute(sql)
    result = curs.fetchall()
    print(result)
    curs.close()
    conn.close()

    t_table = ""
    
    for i in range(len(result)):
        for j in range(len(result[0])):
            if j ==11:
                t_table += str(result[i][j]) + "/"
            else:
                t_table += str(result[i][j]) + ","
        
    print('갱신완료')
    print(t_table)
    return t_table

    #보물의 모든 정보를 리턴
    # return "{},{},{},{},{},{},{},{},{},{},{}".format(result[0][0],result[0][1],result[0][2],result[0][3],result[0][4],result[0][5],result[0][6],result[0][7],result[0][8],result[0][9],result[0][10],result[0][11])


## 보물 클릭시 정보 전송
@app.route('/clicktrs', methods=['POST'])
def clicktrs():
    print('보물클릭')

    t_id = request.form['t_id']

    conn = db.connect(db_id, db_pw, url)
    curs = conn.cursor()
    
    sql = "select t_category,t_keywords1,t_keywords2,t_keywords3,t_hideuser,t_finduser,t_latitude,t_longitude,t_hidedate,(select user_like from t_user u where u.user_id = t.t_hideuser) from t_treasure t where t_id = :1"
    curs.execute(sql,(t_id))
    result = curs.fetchall()
    print(result)
    curs.close()
    conn.close()

    return "{},{},{},{},{},{},{},{},{},{}".format(result[0][0],result[0][1],result[0][2],result[0][3],result[0][4],result[0][5],result[0][6],result[0][7],result[0][8],result[0][9])

    #보물의 모든 정보를 리턴
    # return "{},{},{},{},{},{},{},{},{},{},{}".format(result[0][0],result[0][1],result[0][2],result[0][3],result[0][4],result[0][5],result[0][6],result[0][7],result[0][8],result[0][9],result[0][10],result[0][11])


## 마이페이지 = 숨긴보물수, 찾은보물수, 좋아요, 레벨 갱신
@app.route('/mypage', methods=['POST'])
def mypage():
    print('보물 갱신')
    id = request.form['id']
    
    conn = db.connect(db_id, db_pw, url)
    curs = conn.cursor()
    
    sql = "select (select count(t.t_hideuser) from t_treasure t where t.t_hideuser = :1), (select count(t.t_finduser) from t_treasure t where t.t_finduser = :1) , (select user_like from user where t_hideuser = :1), (select user_level from user where t_hideuser = :1) from t_treasure where t_hideuser = :1 GROUP BY t_hideuser"
    curs.execute(sql,(id))
    result = curs.fetchall()
    
    curs.close()
    conn.close()
    print('갱신 성공')
    
    ## 숨긴보물수, 찾은보물수, 좋아요, 레벨 순
    return "{},{},{},{}".format(result[0][0],result[0][1],result[0][2],result[0][3])

@app.route('/alluserlist', methods=['POST'])
def alluserlist():
    print('모든 유저 리스트 조회')
    
    conn = db.connect(db_id, db_pw, url)
    curs = conn.cursor()
    
    sql = "select * from user"
    curs.execute(sql)
    result = curs.fetchall()
    print(result)
    curs.close()
    conn.close()
    
    listmember = ""
    
    for i in range(len(result)):
        for j in range(len(result[0])):
            if j ==3:
                listmember += str(result[i][j].isoformat()[:10]) + ","
            elif j ==13:
                listmember += str(result[i][j]) + "/"
            else:
                listmember += str(result[i][j]) + ","
        
        
    return listmember

@app.route('/addtreasure', methods=['POST'])
def addtreasure():
    print('보물 등록')
    cate = int(request.form['cate']) ## 코드(숫자)
    key1 = request.form['key1']
    key2 = request.form['key2']
    key3 = request.form['key3']
    hideuser = request.form['hideuser']
    latitude = float(request.form['latitude'])
    longitude = float(request.form['longitude'])
    
    img = request.form['img']
    
    conn = db.connect(db_id, db_pw, url)
    curs = conn.cursor()
    
    sql = "insert into t_treasure values(1,:1,:2,:3,:4,:5,'','',0,:6,:7,sysdate,'')"
    curs.execute(sql(cate,key1,key2,key3,hideuser,latitude,longitude))
    conn.commit()
    curs.close()
    conn.close()
    
    return "등록신청완료"
    
#### 관리자 페이지
@app.route('/', methods=['GET'])
def loginPage():
    return render_template('page-login.html')

#로그인 체크
@app.route('/loginCheck', methods = ['POST']) #로그인 기능
def loginCheck():
    print('로그인 요청')
    admin_id = request.form['id']
    admin_pw = request.form['pw']
    
    conn = db.connect(db_id, db_pw, url)
    curs=conn.cursor()
    sql = "select * from t_admin where admin_id = :1 and admin_pw = :2"
    curs.execute(sql, (admin_id, admin_pw))
    result = curs.fetchall();

    curs.close()
    conn.close()
    print(admin_id)
    print(result[0][0])
    if result[0][0] ==  admin_id and result[0][1]==admin_pw:
        session['admin_id'] = admin_id
        return redirect(url_for('mainPage'))

# 회원가입 페이지
@app.route('/joinPage', methods=['GET'])
def joinPage():
    return render_template('page-join.html')


# 회원가입
@app.route('/joinAdmin', methods = ['POST'])
def joinAdmin():
    print('회원가입 요청')
    admin_id = request.form['id']
    admin_pw = request.form['pw']
    admin_name = request.form['name']
    print(admin_id)
    conn = db.connect(db_id, db_pw, url)
    curs=conn.cursor()
#     sql = "insert into t_admin values('%s', '%s', '%s')" %(admin_id, admin_pw, admin_name)
    sql = "insert into t_admin values(:1, :2, :3)"
#     curs.execute(sql)
    curs.execute(sql,(admin_id,admin_pw,admin_name))

    conn.commit()
    curs.close()
    conn.close()
#     return redirect(url_for('/'))
    return render_template('page-login.html')


@app.route('/mainPage', methods = ['GET'])
def mainPage():
    return render_template('index.html')   

if __name__ == '__main__':
    port = int(os.environ.get("PORT", 5000))
    app.run(host='0.0.0.0', port=port)