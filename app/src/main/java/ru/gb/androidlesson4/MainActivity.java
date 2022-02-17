package ru.gb.androidlesson4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Buttons variables
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;
    private Button buttonDecimal;

    private EditText editTextForm;
    private TextView resultText;

    private Button plusButton;
    private Button minusButton;
    private Button multiButton;
    private  Button divisionButton;
    private Button deleteButton;
    private Button resultButton;

    private String inputString = "";
    private double firstNumber;
    private double secondNumber;

    private char operationChar = '0';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button4 = findViewById(R.id.button_4);
        button5 = findViewById(R.id.button_5);
        button6 = findViewById(R.id.button_6);
        button7 = findViewById(R.id.button_7);
        button8 = findViewById(R.id.button_8);
        button9 = findViewById(R.id.button_9);
        button0 = findViewById(R.id.button_0);
        buttonDecimal = findViewById(R.id.button_decimal);

        editTextForm = findViewById(R.id.edit_text_form);
        resultText = findViewById(R.id.result_number);

        plusButton = findViewById(R.id.plus_button);
        minusButton = findViewById(R.id.minus_button);
        multiButton = findViewById(R.id.multi_button);
        divisionButton = findViewById(R.id.division_button);
        deleteButton = findViewById(R.id.delete_button);
        resultButton = findViewById(R.id.result_button);


        button1.setOnClickListener(v -> {
            inputString += "1";
            editTextForm.setText(inputString);
        });
        button2.setOnClickListener(v -> {
            inputString += "2";
            editTextForm.setText(inputString);
        });
        button3.setOnClickListener(v -> {
            inputString += "3";
            editTextForm.setText(inputString);
        });
        button4.setOnClickListener(v -> {
            inputString += "4";
            editTextForm.setText(inputString);
        });
        button5.setOnClickListener(v -> {
            inputString += "5";
            editTextForm.setText(inputString);
        });
        button6.setOnClickListener(v -> {
            inputString += "6";
            editTextForm.setText(inputString);
        });
        button7.setOnClickListener(v -> {
            inputString += "7";
            editTextForm.setText(inputString);
        });
        button8.setOnClickListener(v -> {
            inputString += "8";
            editTextForm.setText(inputString);
        });
        button9.setOnClickListener(v -> {
            inputString += "9";
            editTextForm.setText(inputString);
        });

        button0.setOnClickListener(v -> {
            inputString += "0";
            editTextForm.setText(inputString);
        });

        buttonDecimal.setOnClickListener(v -> {
            inputString += ".";
            editTextForm.setText(inputString);
        });

        deleteButton.setOnClickListener(v -> {
            inputString = "";
            editTextForm.setText(inputString);
        });

        plusButton.setOnClickListener(v -> {
            if (operationChar == '0') {
                firstNumber = Double.parseDouble(inputString);
                inputString += " + ";
            }
            else if (operationChar == '+') {}
            else {
                inputString = inputString.replace(operationChar, '+');
            }
            operationChar = '+';
            editTextForm.setText(inputString);

        });

        minusButton.setOnClickListener(v -> {
            if (operationChar == '0' && !inputString.equals("")) {
                firstNumber = Double.parseDouble(inputString);
                inputString += " - ";
            }
            else if (operationChar == '-') {}
            else {
                inputString = inputString.replace(operationChar, '-');
            }
            operationChar = '-';
            editTextForm.setText(inputString);

        });

        multiButton.setOnClickListener(v -> {
            if (operationChar == '0') {
                firstNumber = Double.parseDouble(inputString);
                inputString += " * ";
            }
            else if (operationChar == '*') {}
            else {
                inputString = inputString.replace(operationChar, '*');
            }
            operationChar = '*';
            editTextForm.setText(inputString);

        });

        divisionButton.setOnClickListener(v -> {
            if (operationChar == '0') {
                firstNumber = Double.parseDouble(inputString);
                inputString += " ÷ ";
            }
            else if (operationChar == '÷') {}
            else {
                inputString = inputString.replace(operationChar, '÷');
            }
            operationChar = '÷';
            editTextForm.setText(inputString);

        });



        resultButton.setOnClickListener(v -> {
            String substring = inputString.substring(inputString.indexOf(operationChar) + 2);
            secondNumber = Double.parseDouble(substring);
            String result = Double.toString(calcAction(firstNumber, secondNumber, operationChar));
            operationChar = '0';
            display(result);
            inputString = result;
            editTextForm.setText(inputString);
        });


    }

    double calcAction(double firstNumber, double secondNumber, char operation) {
        if (operation == '+') {
            return firstNumber + secondNumber;
        }
        else if (operation == '-') {
            return firstNumber - secondNumber;
        }
        else if (operation == '*') {
            return firstNumber * secondNumber;
        }
        else if (operation == '÷') {
            return firstNumber / secondNumber;
        }
        return 0;
    }

    void display (String result) {
        double resultNum = Double.parseDouble(result);
        if (resultNum % 1 > 0) {
            resultText.setText(result);
        }
        else {
            resultText.setText(Integer.toString((int)(resultNum)));
        }
    }
}