package com.example.sam.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserRegisterActivity extends AppCompatActivity {
    EditText EditRootRegisterFirstName,EditRootRegisterLastName,EditRootRegisterUserName,
            EditRootRegisterPassword,EditRootRegisterMobile,
            EditRootRegisterEmail;
    Button BtnRootRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_rigister);

        EditRootRegisterFirstName=(EditText)findViewById(R.id.edit_root_register_first_name);
        EditRootRegisterLastName=(EditText)findViewById(R.id.edit_root_register_last_name);
        EditRootRegisterUserName=(EditText)findViewById(R.id.edit_root_register_user_name);
        EditRootRegisterPassword=(EditText)findViewById(R.id.edit_root_register_password);
        EditRootRegisterMobile=(EditText)findViewById(R.id.edit_root_register_mobile);
        EditRootRegisterEmail=(EditText)findViewById(R.id.edit_root_register_email);

        BtnRootRegister=(Button)findViewById(R.id.btn_root_register);
       /* BtnRootRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
    }

    public void bbtn_root_register(View view){
        String firstname, lastname, username, password, mobile, email;
        String method = "register";


        firstname = EditRootRegisterFirstName.getText().toString();
        lastname  = EditRootRegisterLastName.getText().toString();
        username  = EditRootRegisterUserName.getText().toString();
        password  = EditRootRegisterPassword.getText().toString();
        mobile    = EditRootRegisterMobile.getText().toString();
        email     = EditRootRegisterEmail.getText().toString();

        UserTasck task = new UserTasck(this);
        task.execute(method,firstname,lastname, username, password, mobile, email);
    }
}

