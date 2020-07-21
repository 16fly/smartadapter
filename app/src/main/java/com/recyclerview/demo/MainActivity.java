package com.recyclerview.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn1:
                startActivity(new Intent(this, Main2Activity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(this, Main3Activity.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(this, Main4Activity.class));
                break;
            case R.id.btn4:
                startActivity(new Intent(this, Main5Activity.class));
                break;
            case R.id.btn5:
                startActivity(new Intent(this, Main6Activity.class));
                break;
        }
    }
}
