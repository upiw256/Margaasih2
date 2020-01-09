package com.example.margaasih;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        Intent i = getIntent();
        String text = i.getStringExtra("TextBox");
        TextView view = findViewById(R.id.username);
        view.setText(text);
    }
    public void news(View view){
            Intent intent = new Intent(Home.this, News.class);
            startActivity(intent);
    }
    public void logout(View view){
        Intent intent = new Intent(Home.this, MainActivity.class);
        startActivity(intent);
    }

}
