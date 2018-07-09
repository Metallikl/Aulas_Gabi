package com.example.user.aula1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class Home extends AppCompatActivity {

    private TextView tv_aluno;
    private TextView tv_dia1;
    private TextView tv_dia2;
    private TextView tv_dia3;
    private ListView list_prof;
    private String nome_aluno;
    private List<Professor> prof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //
        iniVars();
        //


    }

    private void iniVars() {
        nome_aluno = getIntent().getExtras().getString("nome_aluno","Aluno");
        //
        tv_aluno = findViewById(R.id.home_tv_aluno);
        tv_aluno.setText("Bem vindo," +nome_aluno);
        //
        tv_dia1 = findViewById(R.id.home_tv_dia1);
        tv_dia2 = findViewById(R.id.home_tv_dia2);
        tv_dia3 = findViewById(R.id.home_tv_dia3);
        //
        list_prof = findViewById(R.id.home_list_prof);
        //
        gerarListaProf();
        
        //
        String[] from = {"imagem","nome"};
        int[] to = {R.id.celula_img_prof,R.id.celula_tv_prof};
        
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                generateSimpleProfList(),
                R.layout.celula_professor,
                from,
                to);
        //
        list_prof.setAdapter(adapter);

    }

    private List<HashMap<String, String>> generateSimpleProfList() {
        List<HashMap<String,String>> simpleList = new ArrayList<>();
        for(int i = 0; i < prof.size();i++){
            HashMap<String,String> aux = new HashMap<>();
            aux.put("imagem", String.valueOf(prof.get(i).getFoto()));
            aux.put("nome", prof.get(i).getNome());
            simpleList.add(aux);
        }
        return simpleList;
    }

    private void gerarListaProf() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        //
        prof = new ArrayList<>();
        //
        Professor prof1 = new Professor();
        prof1.setNome("Monica");
        prof1.setFoto(R.drawable.monica);
        prof1.setDia_semana(new int[]{2,4,6});
        //
        Professor prof2 = new Professor();
        prof2.setNome("Cebolinha");
        prof2.setFoto(R.drawable.cebolinha);
        prof2.setDia_semana(new int[]{3,5,7});
        //
        Professor prof3 = new Professor();
        prof3.setNome("Magali");
        prof3.setFoto(R.drawable.magali);
        prof3.setDia_semana(new int[]{3,5,7});
        //
        Professor prof4 = new Professor();
        prof4.setNome("Nimbus");
        prof4.setFoto(R.drawable.nimbus);
        prof4.setDia_semana(new int[]{2,4,6});
        //
        Professor prof5 = new Professor();
        prof5.setNome("Cascao");
        prof5.setFoto(R.drawable.cascao);
        prof5.setDia_semana(new int[]{1,2,3,4,5,6,7});
        //
        Professor prof6 = new Professor();
        prof6.setNome("Franjinha");
        prof6.setFoto(R.drawable.franjinha);
        prof6.setDia_semana(new int[]{1,2,3,4,5,6,7});
        //
        Professor prof7 = new Professor();
        prof7.setNome("Rosinha");
        prof7.setFoto(R.drawable.rosinha);
        prof7.setDia_semana(new int[]{2,4,6});
        //Addicionando na lista
        prof.add(prof1);
        prof.add(prof2);
        prof.add(prof3);
        prof.add(prof4);
        prof.add(prof5);
        prof.add(prof6);
        prof.add(prof7);
    }
}
