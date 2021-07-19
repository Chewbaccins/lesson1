package com.example.lesson1;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int calculatorValue1 = 0; // первое введенное число
    private int calculatorValue2 = 0; // второе введенное число
    private String calculatorAction = ""; // тип действия калькулятора

    private TextView calculatorLine;
    private final int[] numberButtonIds = new int[]{R.id.buttonZero, R.id.buttonOne, R.id.buttonTwo,
            R.id.buttonThree, R.id.buttonFour, R.id.buttonFive, R.id.buttonSix, R.id.buttonSeven,
            R.id.buttonEight, R.id.buttonNine};
    private final int[] actionButtonIds = new int[]{R.id.buttonPlus, R.id.buttonMinus,
            R.id.buttonMultiply, R.id.buttonDivide};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        calculatorLine = findViewById(R.id.CalculatorNumberInput);
        setNumberButtonListeners();
        setActionButtonListeners();
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

    private void setNumberButtonListeners() {
        for (int i = 0; i < numberButtonIds.length; i++) {
            findViewById(numberButtonIds[i]).setOnClickListener(v -> {
                Button button = (Button)v;
                addSymbol(Integer.parseInt(button.getText().toString()));
            });
        }

    }

    private void setActionButtonListeners() {
        for (int i = 0; i < actionButtonIds.length; i++) {
            findViewById(actionButtonIds[i]).setOnClickListener(v -> {
                Button button = (Button)v;
                calculatorValue1 = Integer.parseInt(calculatorLine.getText().toString());
                calculatorAction = button.getText().toString();
                clearView();
            });
        }
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