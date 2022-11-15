package com.example.mycalculater;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    //堆栈的设置
    Stack<Double> StackNum = new Stack<Double>();//数栈
    Stack<Character> StackSymbol = new Stack<Character>();//符号栈
    TextView show1, show2;
    String s = "";//总的计算表达式

    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            show1 = findViewById(R.id.text1);
            show2 = findViewById(R.id.text2);
            Button butEqual = findViewById(R.id.buttonEqual);//等于号
            butEqual.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s = show2.getText().toString();//获取总运算表达式
                    /*s += "=";
                    show1.setText(s);
                    double r = calculate(s);//开始计算
                    String ru = "";
                    ru=String.format("%.10f",r); //保留10位小数
                    show2.setText(ru);//显示结果*/
                    try{
                        s += "=";
                        show1.setText(s);
                        double r = calculate(s);//开始计算
                        String ru = "";
                        ru=String.format("%.10f",r); //保留10位小数
                        if(ru.indexOf(".") > 0){ //去0
                            //正则表达
                            ru = ru.replaceAll("0+?$", "");//去掉后面无用的零
                            ru = ru.replaceAll("[.]$", "");//如小数点后面全是零则去掉小数点
                        }
                        show2.setText(ru);//显示结果
                    }catch(Exception e){
                        show2.setText("");
                        Toast.makeText(MainActivity.this,"输入错误", Toast.LENGTH_LONG).show();
                    }
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

            Button butMinus = findViewById(R.id.buttonMinus);//减法
            butMinus.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    show2.append("-");
                }
            });
            Button butPlus = findViewById(R.id.buttonPlus);//加法
            butPlus.setOnClickListener(new View.OnClickListener() {
                 public void onClick(View v) {
                       show2.append("+");
                 }
            });
            Button butMul = findViewById(R.id.buttonMul);//乘法
            butMul.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    show2.append("*");
                }
            });

            Button butDiv = findViewById(R.id.buttonDiv);//除法
            butDiv.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    show2.append("/");
                }
            });

            Button butPoint = findViewById(R.id.buttonPoint);//小数点
            butPoint.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    show2.append(".");
                }
            });
            Button butLeft = findViewById(R.id.buttonLeft);//左括号
            butLeft.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                        show2.append("(");
                }
            });
            Button butRight = findViewById(R.id.buttonRight);//右括号
            butRight.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                        show2.append(")");
                }
            });
            //数字0-9
            Button butZero = findViewById(R.id.buttonZero);
            butZero.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("0");
                }
            });

            Button butOne = findViewById(R.id.buttonOne);
            butOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("1");
                }
            });

            Button butTwo = findViewById(R.id.buttonTwo);
            butTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("2");
                }
            });

            Button butThree = findViewById(R.id.buttonThree);
            butThree.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("3");
                }
            });

            Button butFour = findViewById(R.id.buttonFour);
            butFour.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("4");
                }
            });

            Button butFive = findViewById(R.id.buttonFive);
            butFive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("5");
                }
            });


            Button butSix = findViewById(R.id.buttonSix);
            butSix.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("6");
                }
            });

            Button butSeven = findViewById(R.id.buttonSeven);
            butSeven.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("7");
                }
            });

            Button butEight = findViewById(R.id.buttonEight);
            butEight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("8");
                }
            });

            Button butNine = findViewById(R.id.buttonNine);
            butNine.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    show2.append("9");
                }
            });



            Button butDelete = findViewById(R.id.buttonDelete);//删除
            butDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String s = show2.getText().toString();
                    if(s.equals("")){
                        show2.setText("");
                    }else {
                        s = s.substring(0, s.length() - 1);
                        show2.setText(s);
                    }
                }
            });
            Button butFang = findViewById(R.id.buttonFang);//平方
            butFang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String s = show2.getText().toString();
                    try {
                        show1.setText(s + "^2=");

                        double r = Double.parseDouble(s);
                        r *= r;
                        String ru = "";
                        ru=String.format("%.10f",r);
                        show2.setText(ru);
                    }catch(Exception e){
                        show2.setText("");
                        Toast.makeText(MainActivity.this,"输入错误", Toast.LENGTH_LONG).show();
                    }
                }

            });
            Button butGen = findViewById(R.id.buttonGen);//开根号
            butGen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String s = show2.getText().toString();
                    try {
                            show1.setText("√" + s + "=");
                            double r = Double.parseDouble(s);
                            r = Math.sqrt(r);
                            String ru = "";
                            ru=String.format("%.12f",r);
                            show2.setText(ru);
                    }catch(Exception e){
                        show2.setText("");
                        Toast.makeText(MainActivity.this,"输入错误", Toast.LENGTH_LONG).show();
                    }
                }
            });
            Button butPai = findViewById(R.id.buttonPai);//π
            butPai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s = show2.getText().toString();
                    show2.setText(s + "3.14159");
                }
            });
            Button butE = findViewById(R.id.buttonE);//e
            butE.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s = show2.getText().toString();
                    show2.setText(s + "2.718");
                }
            });
            Button butHelp = findViewById(R.id.buttonHelp);//Setting and help
            butHelp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    final String[] s={"quit","yes"};
                    boolean []b={false,false};
                    final View viewDialog = LayoutInflater.from(MainActivity.this).inflate(R.layout.help, null, false);
                    AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Setting").setView(viewDialog);
                    builder.setPositiveButton("Quit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            android.os.Process.killProcess(android.os.Process.myPid());
                        }
                    });
                    builder.setNegativeButton("OK", null);
                    builder.create().show();
                }
            });
        Button butHex = findViewById(R.id.buttonHex);//进制转换
        butHex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,jinzhi.class);
                startActivity(intent);


            }
        });
        Button butOct = findViewById(R.id.buttonOct);//长度转换
        butOct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,changdu.class);
                startActivity(intent);
            }
        });
        Button butBin = findViewById(R.id.buttonBin);//体积转换
        butBin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,tiji.class);
                startActivity(intent);
            }
        });
        Button butSin = findViewById(R.id.buttonSin);//sin函数
        butSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            try{
                s = show2.getText().toString();
                show1.setText("sin " + s + "=");

                double r = Double.parseDouble(s);
                r = Math.sin(r);
                String ru = "";
                ru=String.format("%.12f",r);
                show2.setText(ru);
            }catch(Exception e){
                show2.setText("");
                Toast.makeText(MainActivity.this,"输入错误", Toast.LENGTH_LONG).show();
            }
            }
        });
        Button butCos = findViewById(R.id.buttonCos);//cos函数
        butCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            try{
                s = show2.getText().toString();
                show1.setText("cos " + s + "=");

                double r = Double.parseDouble(s);
                r = Math.cos(r);
                String ru = "";
                ru=String.format("%.12f",r);
                show2.setText(ru);
            }catch(Exception e){
                show2.setText("");
                Toast.makeText(MainActivity.this,"输入错误", Toast.LENGTH_LONG).show();
            }
            }
        });
        }

    //计算函数
    public double calculate(String formula) {

        char CurrentOperator;
        int ct = 0;
        double x = 0, y = 0,number = 0;
        String dp = "";
        StackSymbol.push('#');
        char c = formula.charAt(ct++);//从运算表达式读入一个字符
        while (c != '=') {//如果不是等于号
            //如果当前字符不是操作运算符，即是数字
            if (c != '+' && c != '-' && c != '*' && c != '/' && c != '(' && c != ')' && c != '=') {
                while (c == '.' || (c >= '0' && c <= '9')) {//如果是数字或者小数点，那么一直读取，并存取到dp里面
                    dp += c;
                    c = formula.charAt(ct++);
                }
                number = Double.parseDouble(dp);//将dp转化为double类型
                dp = "";
                StackNum.push(number);//将该数入栈
            } else {
                //如果是操作运算符，那么判断优先级后进行操作，
                //当前运算符优先级级小于上一个运算符优先级，将当前运算符入栈
                //当前运算符优先级级等于上一个运算符优先级，即（）那么直接删除）
                //当前运算符优先级级大于上一个运算符优先级，取得数栈的前两个数，并与当前运算符进行运算，后将结果入数栈
                switch (Judge(StackSymbol.peek(), c)) {
                    case -1:
                        StackSymbol.push(c);
                        c = formula.charAt(ct++);
                        break;
                    case 0:
                        StackSymbol.pop();
                        c = formula.charAt(ct++);
                        break;
                    case 1:
                        CurrentOperator = StackSymbol.pop();
                        y = StackNum.pop();
                        x = StackNum.pop();
                        StackNum.push(Operate(x, y, CurrentOperator));
                        break;
                }
            }
        }
        //如果是=，那么会直接退出，所以还需要进行一次运算，才能得出最后结果
        CurrentOperator = StackSymbol.pop();
        y = StackNum.pop();
        x = StackNum.pop();
        StackNum.push(Operate(x, y, CurrentOperator));
        double result = StackNum.peek();
        StackNum.clear();
        StackSymbol.clear();

        return result;
    }
    //判断优先级
    private int Judge(char a, char b) {
        int c = 0;
        switch (a) {
            case '+':
            case '-':
                if (b == '*' || b == '/' || b == '(')
                    c = -1;
                else
                    c = 1;
                break;

            case '*':
            case '/':
                if (b == '(')
                    c = -1;
                else
                    c = 1;
                break;

            case '(':
                if (b == ')')
                    c = 0;
                else
                    c = -1;
                break;
            case ')':
                c = 1;
                break;
            case '#':
                if (b == '#')
                    c = 0;
                else
                    c = -1;
                break;
        }
        return c;
    }
    //根据运算符进行运算
    private double Operate(double x, double y, char c) {
        double z = 0;
        switch (c) {
            case '+':
                z = x + y;
                break;
            case '-':
                z = x - y;
                break;
            case '*':
                z = x * y;
                break;
            case '/':
                z = x / y;
                break;
        }
        return z;
    }
}