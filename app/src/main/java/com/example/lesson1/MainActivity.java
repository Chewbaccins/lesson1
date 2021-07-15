package com.example.lesson1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int calculatorValue1 = 0; // первое введенное число
    private int calculatorValue2 = 0; // второе введенное число
    private String calculatorAction = ""; // тип действия калькулятора

    private TextView calculatorLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculatorLine = findViewById(R.id.CalculatorNumberInput);
        Button button0 = findViewById(R.id.buttonZero);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol(0);
            }
        });
        Button button1 = findViewById(R.id.buttonOne);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol(1);
            }
        });
        Button button2 = findViewById(R.id.buttonTwo);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol(2);
            }
        });
        Button button3 = findViewById(R.id.buttonThree);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol(3);
            }
        });
        Button button4 = findViewById(R.id.buttonFour);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol(4);
            }
        });
        Button button5 = findViewById(R.id.buttonFive);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol(5);
            }
        });
        Button button6 = findViewById(R.id.buttonSix);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol(6);
            }
        });
        Button button7 = findViewById(R.id.buttonSeven);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol(7);
            }
        });
        Button button8 = findViewById(R.id.buttonEight);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol(8);
            }
        });
        Button button9 = findViewById(R.id.buttonNine);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSymbol(9);
            }
        });
        Button buttonPlus = findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorValue1 = Integer.parseInt(calculatorLine.getText().toString());
                calculatorAction = "+";
                clearView();
            }
        });
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorValue1 = Integer.parseInt(calculatorLine.getText().toString());
                calculatorAction = "x";
                clearView();
            }
        });
        Button buttonMinus = findViewById(R.id.buttonMinus);
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorValue1 = Integer.parseInt(calculatorLine.getText().toString());
                calculatorAction = "-";
                clearView();
            }
        });
        Button buttonDivide = findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorValue1 = Integer.parseInt(calculatorLine.getText().toString());
                calculatorAction = "/";
                clearView();
            }
        });
        Button buttonEqual = findViewById(R.id.buttonEqual);
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatorValue2 = Integer.parseInt(calculatorLine.getText().toString());
                compute(calculatorValue1, calculatorValue2, calculatorAction);
            }
        });
        Button buttonClear = findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearView();
                calculatorValue1 = 0;
                calculatorValue2 = 0;
            }
        });
    }

    private void addSymbol(int num) {
        String line = calculatorLine.getText().toString();

        if (line.equals("0")) line = "";
        line = line + Integer.toString(num);
        calculatorLine.setText(line);
    }

    private void clearView() {
        calculatorLine.setText("0");
    }

    private int compute(int val1, int val2, String act) {
        int result = 0;
        if (act.equals("+")) result = val1 + val2;
        if (act.equals("-")) result = val1 - val2;
        if (act.equals("x")) result = val1 * val2;
        if (act.equals("/")) result = val1 / val2;
        String line = Integer.toString(result);
        calculatorLine.setText(line);
        return result;
    }
}