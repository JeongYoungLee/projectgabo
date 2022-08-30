package com.example.gabo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.NaverMapSdk;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.OverlayImage;
import com.naver.maps.map.util.FusedLocationSource;


//메인 액티비티
public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private NaverMap naverMap;
    private FusedLocationSource locationSource;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1000;
    private static final String[] PERMISSIONS = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION};

    //프레그먼트 객체
    private HideTreasureFrag fragmHideTreasure; //보물등록
    private trsListview fragTresureListview;  //보물리스트
    private mypageFrag mypageFrag; //마이페이지

    private FragmentManager fm;
    private BottomNavigationView navi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //기본상단바 안보이게 하기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        fragmHideTreasure = new HideTreasureFrag();
        fragTresureListview = new trsListview();
        mypageFrag = new mypageFrag();

        fm = getSupportFragmentManager();
        /*fm.beginTransaction().replace(R.id.frame,fragmHideTreasure).commit();*/

        //바텀시트
        BottomSheetDialogFrag bottomDialog = new BottomSheetDialogFrag();


        /*------------------------------------------지도--------------------------------------------*/
        //네이버지도
        NaverMapSdk.getInstance(this).setClient(
                new NaverMapSdk.NaverCloudPlatformClient("nww1ikjspq")
        );
        //지도 객체 생성
        MapFragment mapFragment = (MapFragment) fm.findFragmentById(R.id.frame);
        if (mapFragment == null) {
            mapFragment = MapFragment.newInstance();
            fm.beginTransaction().replace(R.id.frame, mapFragment).commit();
        }
        // 현재위치
        // OnMapReady에서 NaverMap 객체를 받는다.
        mapFragment.getMapAsync(this);
        locationSource = new FusedLocationSource(this,LOCATION_PERMISSION_REQUEST_CODE);



        /*------------------------------------------네비게이션--------------------------------------------*/
        navi = findViewById(R.id.Navi);
        navi.getMenu().getItem(2).setChecked(true);
        //맵 객체 다시 생성하래서 다시 함
        MapFragment finalMapFragment = mapFragment;
        navi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int selectId = item.getItemId();
                if (selectId==R.id.page1){
                    fm.beginTransaction().replace(R.id.frame,fragTresureListview).commit();
                }else if (selectId==R.id.page2){
                    fm.beginTransaction().replace(R.id.frame,fragmHideTreasure).commit();
                }else if (selectId==R.id.page3){
                    fm.beginTransaction().replace(R.id.frame, finalMapFragment).commit();
//                    bottomDialog.show(fm,"Test");  보물 정보(핀) 누르면 바텀시트 튀어나오기.필요한 곳에다 옮겨쓰기
                }else if (selectId==R.id.page4){
//                    fm.beginTransaction().replace(R.id.frame,mypageFrag).commit();
                    bottomDialog.show(fm,"Test");
                }
                return true;
            }
        });
        /** 처음 바텀 적용
        BottomNavigationView bottom_btn = findViewById(R.id.page3);
        bottom_btn.performClick();
         */
        System.out.println(locationSource);
        System.out.println(locationSource.);
    }



    //marker 찍는 법
    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        Marker marker = new Marker();
        marker.setIcon(OverlayImage.fromResource(R.drawable.marker_blue));
        marker.setWidth(100);
        marker.setHeight(100);
        marker.setPosition(new LatLng(35.146678,126.922288));
        marker.setPosition(new LatLng(35.146939,126.922313));
        marker.setMap(naverMap);

        // 현재위치 표시
        this.naverMap = naverMap;
        naverMap.setLocationSource(locationSource); // 현재 위치
        //현재 위치 표시할 때 권한 확인
        ActivityCompat.requestPermissions(this,PERMISSIONS,LOCATION_PERMISSION_REQUEST_CODE);
    }

    // 좌표를 나타내는 클래스
    LatLng coord = new LatLng(35.146678,126.922288);
    // 토스트로 위도 경도 출력
    // Toast.makeText(context,
    //    "위도: " + coord.latitude + ", 경도: " + coord.longitude,
    //    Toast.LENGTH_SHORT).show();

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(locationSource.onRequestPermissionsResult(requestCode, permissions, grantResults)){
            if(!locationSource.isActivated()){
                naverMap.setLocationTrackingMode(LocationTrackingMode.None);
                return;
            }else{
                naverMap.setLocationTrackingMode(LocationTrackingMode.Follow);
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }



}