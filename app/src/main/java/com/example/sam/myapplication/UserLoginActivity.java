package com.example.sam.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class UserLoginActivity extends AppCompatActivity {
    EditText EditRootLoginUserName,EditRootLoginPaassword;
    Button BtnRootLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        EditRootLoginUserName=(EditText)findViewById(R.id.edit_root_login_user_name);
        EditRootLoginPaassword=(EditText)findViewById(R.id.edit_root_login_password);

        //BtnRootLogin=(Button)findViewById(R.id.btn_root_login);

        /*BtnRootLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String root_user_name = EditRootLoginUserName.getText().toString();
                String root_password = EditRootLoginPaassword.getText().toString();
                String method = "login";

                RootTasck task = new RootTasck();
                task.execute(method,root_user_name,root_password);
            }
        });*/
    }



    public void bbtn_root_login(View view){
        Toast.makeText(this, "xfhdfhdh", Toast.LENGTH_SHORT).show();

        String username = EditRootLoginUserName.getText().toString();
        String password = EditRootLoginPaassword.getText().toString();
        String method = "login";

        UserTasck task = new UserTasck(this);
        task.execute(method,username,password);
    }

    public void regester(View view) {

        String username = EditRootLoginUserName.getText().toString();
        String password = EditRootLoginPaassword.getText().toString();
        String method = "register";

        UserTasck tasck = new UserTasck(this);
        tasck.execute(method,username,password);

    }
}
