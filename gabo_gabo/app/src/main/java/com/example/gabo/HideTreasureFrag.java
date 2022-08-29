package com.example.gabo;

import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/*-------------보물 등록페이지의 프레그먼트-----------------*/
public class HideTreasureFrag extends Fragment {

    private TextView tv_category;
    private String[] treasureCategory;

    //카테고리선택 스피너(드롭다운)
    private Spinner treasureCategorySpinner;

    private ImageView img_addphoto;  //사진등록버튼
    private Dialog dialog_camera;   //사진등록하기 다이얼로그
    private static final String TAG = "Treasure";
    private static final int REQUEST_TAKE_PHOTO = 1;
    private static final int PICK_FROM_ALBUM = 2;
    private ImageView iv_UserPhoto;
    private String currentPhotoPath;


    //등록신청버튼
    private TextView btn_add_treasure;

    private HashTagEditTextView tagTextView; //입력된 해시태그를 배열로 추출하기 위한 변수
    FrameLayout hash_hint_frame;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.trs_add_lyt,container,false);

        iv_UserPhoto = getActivity().findViewById(R.id.iv_UserPhoto);


        /*--------------------보물등록 카테고리---------------------*/
        //스피너 위치 tv의 아이디
        tv_category = view.findViewById(R.id.tv_category);
        //스피너에 들어갈 데이터
        treasureCategory = new String[]{"카테고리선택","디지털기기", "패션의류/잡화", "뷰티", "출산/유아", "식품","생활용품","홈인테리어","생활가전","스포츠/레저","자동차용품","도서/음반/DVD","완구/취미","문구/오피스","반려동물용품","헬스/건강","여행/티켓","식물"};
        //스피너 객체 생성
        treasureCategorySpinner = view.findViewById(R.id.selectCategorySpinner);

        //배열 어뎁터 생성

        // ArrayAdapter 매개변수
        // 1. Context 페이지 정보
        // getApplicationContext()
        // getActivity()
        // Fragement를 출력하고 있는 Activity를 다운캐스팅 (MainActivity)getActivity()

        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<String>(getActivity(), R.layout.trs_add_category_spinner_txt, treasureCategory);
        //배열 어뎁터 설정. 드롭다운 클릭시 선택창
        categoryAdapter.setDropDownViewResource(R.layout.trs_add_category_dropdown_lyt);
        //설정한 어뎁터 스피너에 셋팅
        treasureCategorySpinner.setAdapter(categoryAdapter);
        //스피너에서 선택했을 경우 이벤트 처리
        treasureCategorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                tv_category.setText(treasureCategory[i]);

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        /*---------------------------------------------해시태그 배열로 추출------------------------------------------*/
        tagTextView = view.findViewById(R.id.editTextTextPersonName);
        String[] hashTagArray = tagTextView.getInsertTag();
        /*---------------------------------------------해시태그입력시 힌트 숨기기------------------------------------------*/
        hash_hint_frame=view.findViewById(R.id.hash_hint_frame);
        tagTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //입력하기 전
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //변화가 있을 때
                hash_hint_frame.setVisibility(View.INVISIBLE);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //입력이 끝났을 때
            }
        });

        /*---------------------------------------------사진등록버튼 클릭시기능------------------------------------------*/
        img_addphoto = view.findViewById(R.id.img_addphoto);
        img_addphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                if(isExistCameraApp()){
//                    Intent cameraAppIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                    startActivityForResult(cameraAppIntent,10000);
//                }
                showDialogCamera();

            }
        });


        /*-----------------------------------------등록신청 버튼------------------------------------*/
        btn_add_treasure = view.findViewById(R.id.btn_add_treasure);
        btn_add_treasure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext().getApplicationContext(),"등록신청완료",Toast.LENGTH_SHORT).show();
            }
        });

        return view;

    }

    /*-------다이얼로그 디자인 함수-------*/
    public void showDialogCamera(){
        dialog_camera = new Dialog(getContext());
        dialog_camera.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog_camera.setContentView(R.layout.dialog_camera_lyt);
        dialog_camera.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        //권한설정요청
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(getActivity().checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED && getActivity().checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "권한 설정 완료");
            }
            else {
                Log.d(TAG, "권한 설정 요청");
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        }

        //사진촬영 버튼
        TextView dialog_btn_cam = dialog_camera.findViewById(R.id.dialog_btn_cam);
        dialog_btn_cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });

        //앨범에서 찾기 버튼
        TextView dialog_btn_album = dialog_camera.findViewById(R.id.dialog_btn_album);
        dialog_btn_album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doTakeAlbumAction();
            }
        });

        //취소 버튼
        TextView dialog_btn_cancle = dialog_camera.findViewById(R.id.dialog_btn_cancle);
        dialog_btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_camera.dismiss();
            }
        });

        dialog_camera.show();

    }





    /*---------원본파일 저장을 위한 함수 -----*/
    private File createImageFile() throws IOException{
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    /*-------카메라 앱으로 사진 촬영-------*/
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            }catch (IOException ex){
                // Error occurred while creating the File
            }
            // Continue only if the File was successfully created
            if (photoFile != null){
                Uri photoURI = FileProvider.getUriForFile(getActivity(),"com.example.gabo.fileprovider",photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,photoURI);
                getActivity().startActivityForResult(takePictureIntent,REQUEST_TAKE_PHOTO);
            }
        }

    }

    /*--------앨범에서 이미지 가져오기-------*/
    public void doTakeAlbumAction(){//앨범에서 이미지 가져오기
        //앨범 호출하기
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
        getActivity().startActivityForResult(intent, PICK_FROM_ALBUM);

    }


    /*-------미리보기 이미지 가져오기-------*/
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            switch (requestCode) {
                case PICK_FROM_ALBUM: { //이후 처리가 카메라와 같아서 일단 break없이 처리
                    if (resultCode==RESULT_OK){
                        Uri selectImageUri = data.getData();
                        iv_UserPhoto.setImageURI(selectImageUri);
                        dialog_camera.dismiss();
                    }
                    break;
                }

                case REQUEST_TAKE_PHOTO: {
                    if (resultCode == RESULT_OK) {
                        File file = new File(currentPhotoPath);
                        Log.d("FindTreasure",currentPhotoPath);
                        Bitmap bitmap;
                        if (Build.VERSION.SDK_INT >= 29) {
                            ImageDecoder.Source source = ImageDecoder.createSource(getContext().getContentResolver(), Uri.fromFile(file));
                            try {
                                bitmap = ImageDecoder.decodeBitmap(source);
                                if (bitmap != null) { iv_UserPhoto.setImageBitmap(bitmap); }
                                dialog_camera.dismiss();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            try {
                                bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), Uri.fromFile(file));
                                if (bitmap != null) { iv_UserPhoto.setImageBitmap(bitmap);}
                                dialog_camera.dismiss();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    break;
                }

            }
        } catch (Exception error) {
            error.printStackTrace();
        }

    }

}
