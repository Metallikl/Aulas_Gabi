package com.example.user.aula1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv_01;
    private EditText et_01;
    private Button btn_01;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        tv_01 = findViewById(R.id.tv_01);
        et_01 = findViewById(R.id.et_01);
        btn_01 = findViewById(R.id.btn_01);
        //
        btn_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = et_01.getText().toString();
                //
                Toast.makeText(getBaseContext(),texto,Toast.LENGTH_LONG).show();
            }
        });




    }


}
