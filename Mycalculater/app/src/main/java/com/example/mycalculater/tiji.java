package com.example.mycalculater;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class tiji extends AppCompatActivity {
    TextView show1, show2;
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiji);
        show1 = findViewById(R.id.text1);
        show2 = findViewById(R.id.text2);
        Button butZero = findViewById(R.id.buttonZero);
        butZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show1.append("0");
            }
        });
        Button butOne = findViewById(R.id.buttonOne);
        butOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show1.append("1");
            }
        });
        Button butTwo = findViewById(R.id.buttonTwo);
        butTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show1.append("2");
            }
        });
        Button butThree = findViewById(R.id.buttonThree);
        butThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show1.append("3");
            }
        });
        Button butFour = findViewById(R.id.buttonFour);
        butFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show1.append("4");
            }
        });
        Button butFive = findViewById(R.id.buttonFive);
        butFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show1.append("5");
            }
        });
        Button butSix = findViewById(R.id.buttonSix);
        butSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show1.append("6");
            }
        });
        Button butSeven = findViewById(R.id.buttonSeven);
        butSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show1.append("7");
            }
        });
        Button butEight = findViewById(R.id.buttonEight);
        butEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show1.append("8");
            }
        });
        Button butNine = findViewById(R.id.buttonNine);
        butNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show1.append("9");
            }
        });
        Button butPoint = findViewById(R.id.buttonPoint);//小数点
        butPoint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                show1.append(".");
            }
        });
        Button butClear = findViewById(R.id.buttonClear);//清空
        butClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show1.setText("");
                show2.setText("");
            }
        });
        Button butDelete = findViewById(R.id.buttonDelete);//删除
        butDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = show1.getText().toString();
                if (s.equals("")) {
                    show1.setText("");
                } else {
                    s = s.substring(0, s.length() - 1);
                    show1.setText(s);
                }
            }
        });

        Spinner tiji1 = findViewById(R.id.tiji1);
        Spinner tiji2 = findViewById(R.id.tiji2);
        tiji1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String[] jinzhi = getResources().getStringArray(R.array.tiji);
                flag = 0;
                if(jinzhi[position].equals("立方米")){
                    flag = 3;
                }
                else if(jinzhi[position].equals("立方公里")){
                    flag = 4;
                }

                if(jinzhi[position].equals("升")){
                    flag = 5;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        tiji2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int re = flag;
                String front = show1.getText().toString();
                String[] jinzhi = getResources().getStringArray(R.array.tiji);
            try{
                if(jinzhi[position].equals("立方米")){
                    switch(re){
                        case 3:show2.setText(front);break;
                        case 4:show2.setText(a4to3(front));break;
                        case 5:show2.setText(a5to3(front));break;
                    }
                }
                else if(jinzhi[position].equals("立方公里")){
                    switch(re){
                        case 3:show2.setText(a3to4(front));break;
                        case 4:show2.setText(front);break;
                        case 5:show2.setText(a5to4(front));break;
                    }
                }
                else if(jinzhi[position].equals("升")){
                    switch(re){
                        case 3:show2.setText(a3to5(front));break;
                        case 4:show2.setText(a4to5(front));break;
                        case 5:show2.setText(front);break;
                    }
                }
            }catch (Exception e){
                show1.setText("");
                show2.setText("");
                Toast.makeText(tiji.this,"输入错误", Toast.LENGTH_LONG).show();
            }finally {
            }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    public static String a3to4(String a){
        double b = Double.parseDouble(a);
        return b/1000000000 + "";
    }
    public static String a5to3(String a){
        double b = Double.parseDouble(a);
        return b/1000 + "";
    }
    public static String a4to3(String a){
        double b = Double.parseDouble(a);
        return b*1000000000 + "";
    }
    public static String a5to4(String a){
        double b = Double.parseDouble(a);
        return b + "e-12";
    }
    public static String a3to5(String a){
        double b = Double.parseDouble(a);
        return b*1000 + "";
    }
    public static String a4to5(String a){
        double b = Double.parseDouble(a);
        return b+ "e+12";
    }
}