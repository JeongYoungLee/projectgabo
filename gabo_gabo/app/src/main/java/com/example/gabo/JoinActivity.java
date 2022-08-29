package com.example.gabo;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import com.example.gabo.VO.UsersVO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JoinActivity extends AppCompatActivity {
    private ImageView setImage;
    private EditText edt_id, edt_nick, edt_pw, edt_phone, edt_pwch, edt_mail, edt_name;
    private Button btn_join;
    private RadioButton radio_man, radio_women, gende;
    private RadioGroup rGroup;
    private TextView textView_Date;
    private DatePickerDialog.OnDateSetListener callbackMethod;
    private Date birth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        this.InitializeView();
        this.InitializeListener();

        edt_pw = findViewById(R.id.edt_pw);
        edt_pwch = findViewById(R.id.edt_pwch);
        setImage = findViewById(R.id.setImage);

        edt_pwch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (edt_pw.getText().toString().equals(edt_pwch.getText().toString())) {
                    setImage.setImageResource(R.drawable.img2);
                } else {
                    setImage.setImageResource(R.drawable.join_check);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

}
            });

    }

    public void InitializeView() {
        textView_Date = (TextView) findViewById(R.id.textView_date);
    }

    public void InitializeListener() {
        callbackMethod = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                //textView_Date.setText(year + "년" + monthOfYear + "월" + dayOfMonth + "일");
                textView_Date.setText(year + "-" + monthOfYear + "-" + dayOfMonth);
            }
        };
    }

    public void OnClickHandler(View view) {
        DatePickerDialog dialog = new DatePickerDialog(this, callbackMethod, 1999, 5, 24);

        dialog.show();


        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        edt_nick = findViewById(R.id.edt_nick);
        edt_phone = findViewById(R.id.edt_phone);
        edt_pwch = findViewById(R.id.edt_pwch);
        edt_mail = findViewById(R.id.edt_mail);
        edt_name = findViewById(R.id.edt_name);
        textView_Date = findViewById(R.id.textView_date);
        btn_join = findViewById(R.id.btn_join);
        radio_man = findViewById(R.id.radio_man);
        radio_women = findViewById(R.id.radio_women);
        rGroup = findViewById(R.id.rGroup);
        gende = findViewById(rGroup.getCheckedRadioButtonId());


        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = edt_id.getText().toString();
                String pw = edt_pw.getText().toString();
                String nick = edt_nick.getText().toString();
                String phone = edt_phone.getText().toString();
                String pwch = edt_pwch.getText().toString();
                String mail = edt_mail.getText().toString();
                String name = edt_name.getText().toString();
                String birthdate = textView_Date.getText().toString();
                // 날짜 포맷 String to Date
                try {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    birth = format.parse(birthdate);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String gender = gende.getText().toString();

                UsersVO vo = new UsersVO(id, pw, name, birth, phone, mail, gender, nick);
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.putExtra("vo", vo);
                startActivity(intent);


            }
        });

        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                StringBuilder mStr = new StringBuilder();
                if (i == R.id.radio_man) {
                    mStr.append("radio_men selected");
                } else {
                    mStr.append("radio_women selected");
                }

            }
        });

    }
}
