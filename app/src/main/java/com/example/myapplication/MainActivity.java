package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn_add,btn_view;
    EditText et_name,et_age;
    ListView lv_StudentList;
    ArrayAdapter studentArrayAdapter;
    DataBaseHelper dataBaseHelper;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //referances to all buttons an the layout

        btn_add=findViewById(R.id.btn_add);
        btn_view=findViewById(R.id.btn_view);
        et_name=findViewById(R.id.et_name);
        et_age=findViewById(R.id.et_age);
        lv_StudentList=findViewById(R.id.lv_StudentList);
       dataBaseHelper=new DataBaseHelper(MainActivity.this);

        ShowStudentOnListView(dataBaseHelper);

        // button listener
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudentMod studentMod;
                try {
                    studentMod= new StudentMod(-1, et_name.getText().toString(), Integer.parseInt(et_age.getText().toString()));
                    Toast.makeText(MainActivity.this, studentMod.toString(), Toast.LENGTH_SHORT).show();
                }
                catch(Exception e){

                    Toast.makeText(MainActivity.this,"error in crating student", Toast.LENGTH_SHORT).show();
                    studentMod= new StudentMod(-1, "error",0);
                }
DataBaseHelper dataBaseHelper=new DataBaseHelper(MainActivity.this);
                boolean scusess = dataBaseHelper.addOne(studentMod);
                Toast.makeText(MainActivity.this,"scusses add it", Toast.LENGTH_SHORT).show();

                ShowStudentOnListView(dataBaseHelper);


            }
        });

      btn_view.setOnClickListener((view -> {

          DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);

          ShowStudentOnListView(dataBaseHelper);

      }));}

    private void ShowStudentOnListView(DataBaseHelper dataBaseHelper) {
        studentArrayAdapter=new <StudentMod>ArrayAdapter( MainActivity.this ,android.R.layout.simple_expandable_list_item_1, dataBaseHelper.getEveryone());


        lv_StudentList.setAdapter(studentArrayAdapter);
    }
}