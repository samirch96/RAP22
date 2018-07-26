package com.example.sam.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class UserUpdateActivity extends AppCompatActivity {
    EditText EditRootUpdateId,EditRootUpdateFirstName,EditRootUpdateLastName,EditRootUpdateUserName,
             EditRootUpdatePassword,EditRootUpdateMobile,
             EditRootUpdateEmail;
    Button   BtnRootUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_update);

        EditRootUpdateId=(EditText)findViewById(R.id.edit_root_update_id);
        EditRootUpdateFirstName=(EditText)findViewById(R.id.edit_root_update_first_name);
        EditRootUpdateLastName=(EditText)findViewById(R.id.edit_root_update_last_name);
        EditRootUpdateUserName=(EditText)findViewById(R.id.edit_root_update_user_name);
        EditRootUpdatePassword=(EditText)findViewById(R.id.edit_root_update_password);
        EditRootUpdateMobile=(EditText)findViewById(R.id.edit_root_update_mobile);
        EditRootUpdateEmail=(EditText)findViewById(R.id.edit_root_update_email);

        String method = "get_info" ;
        new Task().execute(method);

        BtnRootUpdate=(Button)findViewById(R.id.btn_root_update);
        /*BtnRootUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
    }

    public void bbtn_root_update(View view){
        String method = "update";

        String id = EditRootUpdateId.getText().toString();
        String firstname = EditRootUpdateFirstName.getText().toString();
        String lastname  = EditRootUpdateLastName.getText().toString();
        String username  = EditRootUpdateUserName.getText().toString();
        String password  = EditRootUpdatePassword.getText().toString();
        String mobile    = EditRootUpdateMobile.getText().toString();
        String email     = EditRootUpdateEmail.getText().toString();

        if(notEmty()){

            new Task().execute(method,id,firstname,lastname,username,password,mobile,email);
            Intent i = new Intent(getBaseContext(), MultiPlayerActivity.class);
            startActivity(i);
        }
    }
    private boolean notEmty() {

        boolean notEmty = true;

        if(TextUtils.isEmpty(EditRootUpdateId.getText().toString())){

            notEmty = false;
            EditRootUpdateId.setError("error not null");
        }

        if(TextUtils.isEmpty(EditRootUpdateFirstName.getText().toString())){

            notEmty = false;
            EditRootUpdateFirstName.setError("error not null");
        }

        if(TextUtils.isEmpty(EditRootUpdateLastName.getText().toString())){

            notEmty = false;
            EditRootUpdateLastName.setError("error not null");
        }

        if(TextUtils.isEmpty(EditRootUpdateUserName.getText().toString())){

            notEmty = false;
            EditRootUpdateUserName.setError("error not null");
        }

        if(TextUtils.isEmpty(EditRootUpdatePassword.getText().toString())){

            notEmty = false;
            EditRootUpdatePassword.setError("error not null");
        }

        if(TextUtils.isEmpty(EditRootUpdateMobile.getText().toString())){

            notEmty = false;
            EditRootUpdateMobile.setError("error not null");
        }

        if(TextUtils.isEmpty(EditRootUpdateEmail.getText().toString())){

            notEmty = false;
            EditRootUpdateEmail.setError("error not null");
        }

        return notEmty;
    }


    private class Task extends AsyncTask<String,Void,String> {

        final String getInfoURl = "http://192.168.43.38/hospital/get_info_root.php";
        @Override
        protected String doInBackground(String... params) {

            String uername = Informations.username;
            String method = params[0];

            if(method.equals("get_info")){

                try {

                    URL url = new URL(getInfoURl);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setDoInput(true);
                    connection.setDoOutput(true);

                    OutputStream os = connection.getOutputStream();
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));

                    String data = URLEncoder.encode("username","UTF-8")+"="
                            + URLEncoder.encode(uername,"UTF-8");

                    bw.write(data);
                    bw.flush();
                    bw.close();

                    InputStream in = connection.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(in,"UTF-8"));
                    String result = "";
                    String line;

                    while((line = br.readLine()) != null){
                        result += line;
                    }

                    return result;

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }if(method.equals("update")){

                String id = params[1];
                String firstname = params[2];
                String lastname  = params[3];
                String username  = Informations.username;
                String password  = params[5];
                String mobile  = params[6];
                String email = params[7];

                try {

                    String registerURL = "http://192.168.43.38/hospital/update_root.php";
                    URL url = new URL(registerURL);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    OutputStream os = httpURLConnection.getOutputStream();
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));

                    String data =
                            URLEncoder.encode("root_id","UTF-8")+"="
                                    +URLEncoder.encode(id,"UTF-8")+
                                    URLEncoder.encode("root_first_name","UTF-8")+"="
                                    +URLEncoder.encode(firstname,"UTF-8")+"&"
                                    +URLEncoder.encode("root_last_name","UTF-8")+"="
                                    +URLEncoder.encode(lastname,"UTF-8")+"&"
                                    +URLEncoder.encode("root_user_name","UTF-8")+"="
                                    +URLEncoder.encode(username,"UTF-8")+"&"
                                    +URLEncoder.encode("root_password","UTF-8")+"="
                                    +URLEncoder.encode(password,"UTF-8")+"&"
                                    +URLEncoder.encode("root_mobile","UTF-8")+"="
                                    +URLEncoder.encode(mobile,"UTF-8")+
                                    URLEncoder.encode("root_email","UTF-8")+"="
                                    +URLEncoder.encode(email,"UTF-8");

                    bw.write(data);
                    bw.flush();
                    bw.close();
                    os.close();

                    InputStream is = httpURLConnection.getInputStream();
                    is.close();
                    return "secces";
                } catch (MalformedURLException e) {

                    e.printStackTrace();

                } catch (IOException e) {
                    e.printStackTrace();

                }

            }



            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            try {

                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("result");
                JSONObject object = jsonArray.getJSONObject(0);

                String id = object.getString("root_id");
                String firstname = object.getString("root_first_name");
                String lastname = object.getString("root_last_name");
                String username = object.getString("root_user_name");
                String password = object.getString("root_password");
                String mobile = object.getString("root_mobile");
                String email = object.getString("root_email");

                EditRootUpdateId.setText(id);
                EditRootUpdateFirstName.setText(firstname);
                EditRootUpdateLastName.setText(lastname);
                EditRootUpdateUserName.setText(username);
                EditRootUpdatePassword.setText(password);
                EditRootUpdateMobile.setText(mobile);
                EditRootUpdateEmail.setText(email);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
    }
}
