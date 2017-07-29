package com.eelve.leosiyi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button equal;
    Button remove;
    Button add;
    Button subtraction;
    Button multiply;
    Button division;
    TextView showresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zero = (Button)findViewById(R.id.zero);
        one = (Button)findViewById(R.id.one);
        two = (Button)findViewById(R.id.two);
        three = (Button)findViewById(R.id.three);
        four = (Button)findViewById(R.id.four);
        five = (Button)findViewById(R.id.five);
        six = (Button)findViewById(R.id.six);
        seven = (Button)findViewById(R.id.seven);
        eight = (Button)findViewById(R.id.eight);
        nine = (Button)findViewById(R.id.nine);
        remove = (Button)findViewById(R.id.remove);
        add = (Button)findViewById(R.id.add);
        subtraction = (Button)findViewById(R.id.subtraction);
        multiply = (Button)findViewById(R.id.multiply);
        division = (Button)findViewById(R.id.division);
        equal = (Button)findViewById(R.id.equal);

        showresult = (TextView)findViewById(R.id.result);

        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        remove.setOnClickListener(this);
        add.setOnClickListener(this);
        subtraction.setOnClickListener(this);
        multiply.setOnClickListener(this);
        division.setOnClickListener(this);
        equal.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String str = showresult.getText().toString();
        switch (view.getId()) {
            case R.id.zero:
            case R.id.one:
            case R.id.two:
            case R.id.three:
            case R.id.four:
            case R.id.five:
            case R.id.six:
            case R.id.seven:
            case R.id.eight:
            case R.id.nine:
                showresult.setText(str + ((Button)view).getText());
                break ;
            case R.id.add:
            case R.id.subtraction:
            case R.id.multiply:
            case R.id.division:

                showresult.setText(str+ " " + ((Button)view).getText()+" ");
                break;
            case R.id.remove:
             if (str!=null&&!str.equals("")){
                 showresult.setText(str.substring(0,str.length()-1));
                }
                break;
            case R.id.equal:
                getResult();
                break ;

        }
    }
    private void getResult(){
        String exp = showresult.getText().toString();
        if (exp == null||exp.equals("")){
            return;
        }
        if(!exp.contains(" ")) {
            return;
        }

        double result = 0 ;
        String s1 = exp.substring(0,exp.indexOf(" ")); //运算符前面的字符串
        String op = exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2) ;
        String s2 = exp.substring(exp.indexOf(" ")+3) ;
        if (!s1.equals(" ")&&!s2.equals(" ")){
            double d1 = Double.parseDouble(s1) ;
            double d2 = Double.parseDouble(s2) ;
            if (op.equals("+")){
                result = d1 + d2 ;

            }else  if (op.equals("-")){
                result = d1 - d2 ;

            }else  if (op.equals("*")){
                result = d1 * d2 ;

            }else  if (op.equals("/")){
                if(d2 == 0){
                    result = 0 ;
                }else {
                    result = d1/d2 ;
                }
            }
            if (s1.contains(".")&&s2.contains(".")) {
                int r = (int) result;
                showresult.setText(r+"");
            }else {
                showresult.setText(result+"");

            }
        }else if (!s1.equals("")&&s2.equals("")){
            showresult.setText(exp);
        }else if (s1.equals("")&&!s2.equals("")){
            double d2 = Double.parseDouble(s2) ;
            if (op.equals("+")){
                result = 0 + d2 ;

            }else  if (op.equals("-")){
                result = 0 - d2 ;

            }else  if (op.equals("*")){
                result = 0 ;

            }else  if (op.equals("/")){
                result = 0 ;
            }
            if (s2.contains(".")) {
                int r = (int) result;
                showresult.setText(r+"");
            }else {
                showresult.setText(result+"");
            }
        }else {
            showresult.setText("");

        }
    }

}
