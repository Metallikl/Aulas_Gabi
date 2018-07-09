package com.example.user.aula1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_01;
    private EditText et_01;
    private EditText et_02;
    private Button btn_01;
    private Button btn_02;
    private View.OnClickListener clickListner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        tv_01 = findViewById(R.id.tv_01);
        et_01 = findViewById(R.id.et_01);
        et_02 = findViewById(R.id.et_02);
        btn_01 = findViewById(R.id.btn_01);
        btn_02 = findViewById(R.id.btn_02);
        //
        clickListner = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idBtn =  view.getId();
                //
                switch (idBtn){
                    case R.id.btn_01:
                        //codigo do btn
                        String eText1 = et_01.getText().toString();
                        String eText2 = et_02.getText().toString();
                        //
                        if(eText1.isEmpty() || eText2.isEmpty()){
                            mostrarMsg("Login","Usuario ou senha em branco!");
                        }else{
                            if(eText1.equalsIgnoreCase("amora") && eText2.equals("dog")){
                                //
                                Intent intent = new Intent(MainActivity.this,Home.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                //
                                Bundle bundle = new Bundle();
                                bundle.putString("nome_aluno",eText1);
                                intent.putExtras(bundle);
                                //
                                startActivity(intent);
                                //
                                finish();
                            }else{
                                mostrarMsg("Login","Usuario ou senha invalidos !");
                            }
                        }
                        break;
                    case R.id.btn_02:
                        //codigo do btn2
                        et_01.setText("");
                        et_02.setText("");
                        break;

                }

            }
        };
        //
        btn_01.setOnClickListener(clickListner);
        //
        btn_02.setOnClickListener(clickListner);



    }

    private void mostrarMsg(String titulo, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        //
        builder.setIcon(R.drawable.ic_error_outline_black_24dp);
        builder.setTitle(titulo);
        builder.setMessage(msg);
        builder.setPositiveButton("OK",null);
        //
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}
