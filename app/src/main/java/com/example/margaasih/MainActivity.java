package com.example.margaasih;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
     EditText user;
     EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Pindah(View view){
       user = findViewById(R.id.user);
       password = findViewById(R.id.password);
        if (TextUtils.isEmpty(user.getText())){
            user.setError("No Induk Harus Di isi");
        }else if (TextUtils.isEmpty(password.getText())){
            password.setError("Password Tidak Boleh Kosong");
        }else {
//            Intent intent = new Intent(MainActivity.this, Home.class);
//            startActivity(intent);
            //LOGIN
            StringRequest request = new StringRequest(Request.Method.POST, "http://app.sman1margaasih.sch.id:8050/margaasih/tampil.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.contains("1")) {
                                Intent intent = new Intent(MainActivity.this, Home.class);
                                intent.putExtra("TextBox", user.getText().toString());
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "User atau Password salah", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(),"Koneksi Error",Toast.LENGTH_SHORT).show();
                }

        })
            {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("user",user.getText().toString());
                    params.put("password", password.getText().toString());
                return params;
            }
            };

            Volley.newRequestQueue(this).add(request);


            //AKHIR LOGIN
        }
    }
}
