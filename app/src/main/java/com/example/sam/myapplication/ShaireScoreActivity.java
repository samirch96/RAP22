package com.example.sam.myapplication;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.io.File;
import java.io.FileOutputStream;

public class ShaireScoreActivity extends CatgCardViewActivity {
    private static final int MY_PERMISSION_REQUEST = 1;
    private static final int RESULT_LOAD_IMAGE = 2;
    Button load, save,share,go;
    TextView textView1,textView2,textView3;
    EditText editText1,editText2;
    ImageView imageView;
    String currentImage = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shaire_score);

        if(ContextCompat.checkSelfPermission(ShaireScoreActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(ShaireScoreActivity.this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                ActivityCompat.requestPermissions(ShaireScoreActivity.this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},MY_PERMISSION_REQUEST);
            }else {
                ActivityCompat.requestPermissions(ShaireScoreActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},MY_PERMISSION_REQUEST);
            }
        }else {

        }

        imageView = (ImageView)findViewById(R.id.imageView);

        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);

        SharedPreferences sharedPreferences1 = getSharedPreferences("xx", Context.MODE_PRIVATE);
        switch (Catg_id){
            case 1 : textView3.setText("your score" + sharedPreferences1.getInt("pt_a", 0));break;
            case 2 : textView3.setText("your score" + sharedPreferences1.getInt("pt_m", 0));break;
            case 3 : textView3.setText("your score" + sharedPreferences1.getInt("pt_i", 0));break;
            case 4 : textView3.setText("your score" + sharedPreferences1.getInt("pt_c", 0));break;
            case 5 : textView3.setText("your score" + sharedPreferences1.getInt("pt_e", 0));break;
            case 6 : textView3.setText("your score" + sharedPreferences1.getInt("pt_s", 0));break;
            case 7 : textView3.setText("your score" + sharedPreferences1.getInt("pt_b", 0));break;
            case 8 : textView3.setText("your score" + sharedPreferences1.getInt("pt_f", 0));break;
        }


        editText2 = (EditText) findViewById(R.id.editText2);

        go = (Button) findViewById(R.id.go);

        save = (Button) findViewById(R.id.save);
        share= (Button) findViewById(R.id.share);

        share.setEnabled(false);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View content = findViewById(R.id.lay);
                Bitmap bitmap = getScreenShot(content);
                currentImage = "meme" + System.currentTimeMillis()+" .png";
                store(bitmap, currentImage);
                share.setEnabled(true);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareImage(currentImage);
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText(editText1.getText().toString());
                textView2.setText(editText2.getText().toString());

                editText1.setText("");
                editText2.setText("");
            }
        });
    }

    public static Bitmap getScreenShot(View view){
        view.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return bitmap;
    }

    public void store(Bitmap bm, String fileName){
        String dirPath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/MEME";
        File dir = new File(dirPath);
        if(!dir.exists()){
            dir.mkdir();
        }
        File file =  new File(dirPath, fileName);
        try{
            FileOutputStream fos = new FileOutputStream(file);
            bm.compress(Bitmap.CompressFormat.PNG, 100 , fos);
            fos.flush();
            fos.close();
            Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error saving", Toast.LENGTH_SHORT).show();
        }
    }

    private void shareImage(String fileName){
        String dirPath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/MEME";
        Uri uri = Uri.fromFile(new File(dirPath, fileName));
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("image/*");

        intent.putExtra(Intent.EXTRA_SUBJECT,"");
        intent.putExtra(Intent.EXTRA_TEXT, "");
        intent.putExtra(Intent.EXTRA_STREAM,uri);

        try{
            startActivity(Intent.createChooser(intent, "Share via"));
        }catch (ActivityNotFoundException e){
            Toast.makeText(this, "No Sharing app found!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==RESULT_LOAD_IMAGE && resultCode== RESULT_OK && null != data ){
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null,null,null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            imageView.setImageBitmap(BitmapFactory.decodeFile((picturePath)));
            save.setEnabled(true);
            share.setEnabled(false);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case MY_PERMISSION_REQUEST:{
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    if (ContextCompat.checkSelfPermission(ShaireScoreActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED){

                    }
                }else {
                    Toast.makeText(this, "No permission granted", Toast.LENGTH_SHORT).show();
                    finish();
                }
                return;
            }
        }
    }
}
