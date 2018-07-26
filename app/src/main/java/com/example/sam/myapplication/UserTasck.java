package com.example.sam.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

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

/**
 * Created by DELL on 09/01/2018.
 */

public class UserTasck extends AsyncTask<String,Void,String> {
    private Context context;

    UserTasck(Context context) {

        this.context = context;
    }

    @Override
    protected void onPostExecute(String result) {

        if (result.equals("secces") || result.equals("field !")) {

            Toast.makeText(context, result, Toast.LENGTH_LONG).show();

        } else {

            try {
                JSONObject jsonObject = new JSONObject(result);
                if (jsonObject.getInt("success") == 1) {
                    //String name = jsonObject.getString("player_name");
                    Intent i = new Intent(context, MultiPlayerActivity.class);
                    //i.putExtra("player_name",name);
                    context.startActivity(i);
                } else {
                    Toast.makeText(context, jsonObject.getString("message"), Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

        String method = params[0];

        if (method.equals("winer")) {

            String firstname = params[1];
            String lastname = params[2];
            String username = params[3];
            String password = params[4];
            String mobile = params[5];
            String email = params[6];

            try {

                String registerURL = "http://192.168.43.38/voicy/get_info_winer.php";
                URL url = new URL(registerURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

                String data =
                        URLEncoder.encode("root_first_name", "UTF-8") + "="
                                + URLEncoder.encode(firstname, "UTF-8") + "&"
                                + URLEncoder.encode("root_last_name", "UTF-8") + "="
                                + URLEncoder.encode(lastname, "UTF-8") + "&"
                                + URLEncoder.encode("root_user_name", "UTF-8") + "="
                                + URLEncoder.encode(username, "UTF-8") + "&"
                                + URLEncoder.encode("root_password", "UTF-8") + "="
                                + URLEncoder.encode(password, "UTF-8") + "&"
                                + URLEncoder.encode("root_mobile", "UTF-8") + "="
                                + URLEncoder.encode(mobile, "UTF-8") + "&"
                                + URLEncoder.encode("root_email", "UTF-8") + "="
                                + URLEncoder.encode(email, "UTF-8");

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
        } else if (method.equals("login")) {

            String loginURL = "http://192.168.43.38/voicy/login_user.php";
            String username = params[1];
            String password = params[2];

            Informations.username = params[1];
            try {

                URL url = new URL(loginURL);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setDoOutput(true);
                connection.setDoInput(true);
                OutputStream os = connection.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data =
                        URLEncoder.encode("player_name", "UTF-8") + "="
                                + URLEncoder.encode(username, "UTF-8") + "&"
                                + URLEncoder.encode("player_password", "UTF-8") + "="
                                + URLEncoder.encode(password, "UTF-8");

                bw.write(data);
                bw.flush();
                bw.close();
                os.close();

                InputStream in = connection.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(in, "iso-8859-1"));

                String respons = "";
                String line;

                while ((line = br.readLine()) != null) {


                    respons += line + "\n";
                }

                in.close();
                br.close();
                connection.disconnect();

                return respons;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return "field !";
    }

}
