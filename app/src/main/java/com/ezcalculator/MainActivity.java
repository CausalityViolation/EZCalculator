package com.ezcalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;
    private Button num0;
    private Button multi;
    private Button div;
    private Button add;
    private Button subtract;
    private Button clear;
    private Button comma;
    private Button percentage;
    private Button switchOperator;
    private Button equals;
    private TextView info;
    private TextView result;

    private final char ADDITION = '+';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '÷';
    private final char SUBTRACTION = '-';
    private final char EQUALS = '=';

    private double value1 = Double.NaN;
    private double value2;
    private char ACTION;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();


        num0.setOnClickListener(v -> info.setText(info.getText().toString() + "0"));

        num1.setOnClickListener(view -> info.setText(info.getText().toString() + "1"));

        num2.setOnClickListener(view -> info.setText(info.getText().toString() + "2"));

        num3.setOnClickListener(view -> info.setText(info.getText().toString() + "3"));

        num4.setOnClickListener(view -> info.setText(info.getText().toString() + "4"));

        num5.setOnClickListener(view -> info.setText(info.getText().toString() + "5"));

        num6.setOnClickListener(view -> info.setText(info.getText().toString() + "6"));

        num7.setOnClickListener(view -> info.setText(info.getText().toString() + "7"));

        num8.setOnClickListener(view -> info.setText(info.getText().toString() + "8"));

        num9.setOnClickListener(view -> info.setText(info.getText().toString() + "9"));

        multi.setOnClickListener(view -> {

            if (!info.getText().toString().isEmpty()) {

                calculate();

                ACTION = MULTIPLICATION;
                result.setText(value1 + " * ");
                info.setText(null);

            }


        });

        div.setOnClickListener(view -> {

            if (!info.getText().toString().isEmpty()) {

                calculate();

                ACTION = DIVISION;
                result.setText(value1 + " ÷ ");
                info.setText(null);
            }
        });

        add.setOnClickListener(view -> {

            if (!info.getText().toString().isEmpty()) {

                calculate();

                ACTION = ADDITION;
                result.setText(value1 + " + ");
                info.setText(null);
            }

        });

        subtract.setOnClickListener(view -> {

            if (!info.getText().toString().isEmpty()) {

                calculate();

                ACTION = SUBTRACTION;
                result.setText(value1 + " - ");
                info.setText(null);
            }

        });


        clear.setOnClickListener(view -> {

           info.setText(null);
           result.setText(null);

        });

        comma.setOnClickListener(view -> {

            if (!info.getText().toString().contains(".")) {
                info.setText(info.getText().toString() + ".");
            }

        });


        switchOperator.setOnClickListener(view -> {

            if (info.getText().toString().contains("-")) {
                info.setText(info.getText().toString().replace("-", ""));

            } else {
                info.setText("-" + info.getText().toString());
            }

        });

        equals.setOnClickListener(view -> {


            if (info.getText().toString().isEmpty() || info.getText().toString().equals(".")) {
                info.setText("");

            } else {

                if (info.getText().toString().equals("-")) {
                    info.setText("");
                } else {

                    calculate();

                    ACTION = EQUALS;
                    result.setText(result.getText().toString() + value2 + " = " + value1);
                    info.setText(null);

                }


            }

        });


    }

    private void setupUIViews() {

        num1 = findViewById(R.id.btn1);
        num2 = findViewById(R.id.btn2);
        num3 = findViewById(R.id.btn3);
        num4 = findViewById(R.id.btn4);
        num5 = findViewById(R.id.btn5);
        num6 = findViewById(R.id.btn6);
        num7 = findViewById(R.id.btn7);
        num8 = findViewById(R.id.btn8);
        num9 = findViewById(R.id.btn9);
        num0 = findViewById(R.id.btn0);
        multi = findViewById(R.id.multiplication);
        div = findViewById(R.id.division);
        add = findViewById(R.id.addition);
        subtract = findViewById(R.id.subtraction);
        clear = findViewById(R.id.btnClear);
        comma = findViewById(R.id.btnComma);
        switchOperator = findViewById(R.id.plusminus);
        equals = findViewById(R.id.btnEquals);
        info = findViewById(R.id.info);
        result = findViewById(R.id.twResults);
        percentage = findViewById(R.id.percentage);

    }


    private void calculate() {

        if (!Double.isNaN(value1)) {

            value2 = Double.parseDouble(info.getText().toString());

            switch (ACTION) {

                case ADDITION:
                    value1 = value1 + value2;
                    break;

                case SUBTRACTION:
                    value1 = value1 - value2;
                    break;

                case MULTIPLICATION:
                    value1 = value1 * value2;
                    break;

                case DIVISION:
                    value1 = value1 / value2;
                    break;

                case EQUALS:
                    break;


            }

        } else {

            value1 = Double.parseDouble(info.getText().toString());

        }
    }

}