package com.example.logbook1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private TextView solutionTextView;
    private StringBuilder currentInput;
    private double currentResult;
    private String currentOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.result);
        solutionTextView = findViewById(R.id.solution);

        currentInput = new StringBuilder();

        currentResult = 0;

        currentOperator = "";

        //Gọi phương thức để thiết lập nghe nhấn cho các nút số.
        setNumberButtonListeners();
        setOperatorButtonListener();
        setOtherButtonListeners();
    }

    private void setNumberButtonListeners() {
        Button button_zero = findViewById(R.id.button_zero);
        Button button_1 = findViewById(R.id.button_1);
        Button button_2 = findViewById(R.id.button_2);
        Button button_3 = findViewById(R.id.button_3);
        Button button_4 = findViewById(R.id.button_4);
        Button button_5 = findViewById(R.id.button_5);
        Button button_6 = findViewById(R.id.button_6);
        Button button_7 = findViewById(R.id.button_7);
        Button button_8 = findViewById(R.id.button_8);
        Button button_9 = findViewById(R.id.button_9);
        Button button_dot = findViewById(R.id.button_dot);
        button_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberButtonClick(button_zero.getText().toString());
            }
        });
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberButtonClick(button_1.getText().toString());
            }
        });
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberButtonClick(button_2.getText().toString());
            }
        });
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberButtonClick(button_3.getText().toString());
            }
        });
        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberButtonClick(button_4.getText().toString());
            }
        });
        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberButtonClick(button_5.getText().toString());
            }
        });
        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberButtonClick(button_6.getText().toString());
            }
        });
        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberButtonClick(button_7.getText().toString());
            }
        });
        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberButtonClick(button_8.getText().toString());
            }
        });
        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberButtonClick(button_9.getText().toString());
            }
        });
        button_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumberButtonClick(button_dot.getText().toString());
            }
        });
    }

    private void setOperatorButtonListener() {
        Button button_sum = findViewById(R.id.button_sum);
        Button button_sub = findViewById(R.id.button_sub);
        Button button_mul = findViewById(R.id.button_mul);
        Button button_div = findViewById(R.id.button_div);
        button_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleOperatorButtonClick(button_sum.getText().toString());
            }
        });
        button_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleOperatorButtonClick(button_sub.getText().toString());
            }
        });
        button_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleOperatorButtonClick(button_mul.getText().toString());
            }
        });
        button_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleOperatorButtonClick(button_div.getText().toString());
            }
        });
    }

    private void setOtherButtonListeners() {
        Button buttonEqual = findViewById(R.id.button_equal);
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleEqualButtonClick();
            }
        });

        Button buttonAC = findViewById(R.id.button_ac);
        buttonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleACButtonClick();
            }
        });
    }

    private void handleNumberButtonClick(String s) {
        currentInput.append(s);
        updateResultTextView();
        updateSolutionTextView();
    }

    private void handleOperatorButtonClick(String operator) {
        if (currentInput.length() > 0) {
            if (currentResult != 0 && !currentOperator.isEmpty()) {
                handleEqualButtonClick(); // Calculate and update if there's an ongoing operation
            }
            currentResult = Double.parseDouble(currentInput.toString());
            currentOperator = operator;
            currentInput.setLength(0);
            updateSolutionTextView();
        } else if (currentResult != 0 && !currentOperator.isEmpty()) {
            // User entered a new operator without entering a new number
            currentOperator = operator;
            updateSolutionTextView();
        }
    }

    private void handleEqualButtonClick() {
        //Có dấu than là không được rỗng.
        if (currentInput.length() > 0 && !currentOperator.isEmpty()) {
            double operand = Double.parseDouble(currentInput.toString());
            switch (currentOperator) {
                case "+":
                    currentResult = currentResult + operand;
                    break;
                case "-":
                    currentResult = currentResult - operand;
                    break;
                case "*":
                    currentResult = currentResult * operand;
                    break;
                case "/":
                    if (operand != 0) {
                        currentResult = currentResult / operand;
                    } else {
                        // Handle division by zero
                        currentResult = 0;
                    }
                    break;
            }
            currentInput.setLength(0);
            updateResultTextView();
            updateSolutionTextView();
        }
    }

    private void handleACButtonClick() {
        currentInput.setLength(0);
        currentResult = 0;
        currentOperator = "";
        updateResultTextView();
        updateSolutionTextView();
    }

    private void updateResultTextView() {
        resultTextView.setText(currentInput.toString());
    }

    private void updateSolutionTextView() {
        String expression = "";

        if (currentResult != 0 && currentInput.length() == 0) {
            // Only show the result without the operator if there is no current input
            expression += String.valueOf((int) currentResult);
        } else {
            if (currentResult != 0) {
                expression += String.valueOf((int) currentResult);
                if (!currentOperator.isEmpty()) {
                    expression += " " + currentOperator;
                }
            }

            if (currentInput.length() > 0) {
                if (!expression.isEmpty()) {
                    expression += " ";
                }
                expression += currentInput.toString();
            }
        }

        solutionTextView.setText(expression);
    }

}