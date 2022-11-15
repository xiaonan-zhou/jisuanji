package com.example.mycalculater;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class jinzhi extends AppCompatActivity {
    TextView show1, show2;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jinzhi);
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
        Button butA = findViewById(R.id.buttonA);
        butA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show1.append("A");
            }
        });
        Button butB = findViewById(R.id.buttonB);
        butB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show1.append("B");
            }
        });
        Button butC = findViewById(R.id.buttonC);
        butC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show1.append("C");
            }
        });
        Button butD = findViewById(R.id.buttonD);
        butD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show1.append("D");
            }
        });
        Button butE = findViewById(R.id.buttonE);
        butE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show1.append("E");
            }
        });
        Button butF = findViewById(R.id.buttonF);
        butF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show1.append("F");
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
        Spinner jinzhi1 = findViewById(R.id.jinzhi1);
        Spinner jinzhi2 = findViewById(R.id.jinzhi2);
        jinzhi1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] jinzhi = getResources().getStringArray(R.array.jinzhi);

                if (jinzhi[position].equals("二进制")) {
                    flag = 2;
                } else if (jinzhi[position].equals("八进制")) {
                    flag = 8;
                } else if (jinzhi[position].equals("十进制")) {
                    flag = 10;
                } else if (jinzhi[position].equals("十六进制")) {
                    flag = 16;
                }
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        jinzhi2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                int re = flag;
                String front = show1.getText().toString();
                String[] jinzhi = getResources().getStringArray(R.array.jinzhi);
                try{
                if (jinzhi[position].equals("二进制")) {
                    switch (re) {
                        case 2:
                            show2.setText(front);
                            break;
                        case 8:
                            show2.setText(a8to2(front));
                            break;
                        case 10:
                            show2.setText(a10to2(front));
                            break;
                        case 16:
                            show2.setText(a16to2(front));
                            break;
                    }

                } else if (jinzhi[position].equals("八进制")) {
                    switch (re) {
                        case 2:
                            show2.setText(a2to8(front));
                            break;
                        case 8:
                            show2.setText(front);
                            break;
                        case 10:
                            show2.setText(a10to8(front));
                            break;
                        case 16:
                            show2.setText(a16to8(front));
                            break;
                    }

                } else if (jinzhi[position].equals("十进制")) {
                    switch (re) {
                        case 2:
                            show2.setText(a2to10(front));
                            break;
                        case 8:
                            show2.setText(a8to10(front));
                            break;
                        case 10:
                            show2.setText(front);
                            break;
                        case 16:
                            show2.setText(a16to10(front));
                            break;
                    }
                } else if (jinzhi[position].equals("十六进制")) {
                    switch (re) {
                        case 2:
                            show2.setText(a2to16(front));
                            break;
                        case 8:
                            show2.setText(a8to16(front));
                            break;
                        case 10:
                            show2.setText(a10to16(front));
                            break;
                        case 16:
                            show2.setText(front);
                            break;
                    }
                }
                }catch (Exception e){
                    show1.setText("");
                    show2.setText("");
                    Toast.makeText(jinzhi.this,"输入错误", Toast.LENGTH_LONG).show();
                }finally {
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
            });
    }

        public static String a2to8(String a){
            return Integer.toOctalString(Integer.parseInt(a, 2))+"";
        }
        public static String a2to10(String a){
            return Integer.parseInt(a, 2) +"";
        }
        public static String a2to16(String a){
            return Integer.toHexString(Integer.parseInt(a, 2))+"";
        }
        public static String a8to2(String a){
            return Integer.toBinaryString(Integer.parseInt(a, 8));
        }
        public static String a8to10(String a){
            return Integer.toString(Integer.parseInt(a, 8));
        }
        public static String a8to16(String a){
            return Integer.toHexString(Integer.parseInt(a, 8));
        }
        public static String a10to2(String a){
            return Integer.toBinaryString(Integer.parseInt(a));
        }
        public static String a10to8(String a){
            return Integer.toOctalString(Integer.parseInt(a));
        }
        public static String a10to16(String a){
            return Integer.toHexString(Integer.parseInt(a));
        }
        public static String a16to2(String a){
            return Integer.toBinaryString(Integer.parseInt(a,16));
        }
        public static String a16to8(String a){
            return Integer.toOctalString(Integer.parseInt(a,16));
        }
        public static String a16to10(String a){
            return Integer.toString(Integer.parseInt(a,16))+"";
        }
    }
