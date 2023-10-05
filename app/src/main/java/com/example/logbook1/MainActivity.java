package com.example.logbook1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView resultcal, solutioncal;
    MaterialButton button_c, button_close_bracket, button_open_bracket, button_div;
    MaterialButton button_1,button_2,button_3,button_4,button_5,button_6,button_7,button_8,button_9,button_zero;
    MaterialButton button_mul, button_sum, button_sub, button_equal,button_ac,button_dot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }
     public void init()
     {
         // Kết nối code và đặt id cho từng button hoặc từng text view
         resultcal = (TextView)findViewById(R.id.result);
         solutioncal = (TextView)findViewById(R.id.solution);
         button_c = (MaterialButton)findViewById(R.id.button_c);
         button_close_bracket = (MaterialButton)findViewById(R.id.button_close_bracket);
         button_open_bracket = (MaterialButton)findViewById(R.id.button_open_bracket);
         button_div = (MaterialButton)findViewById(R.id.button_div);
         button_1 = (MaterialButton)findViewById(R.id.button_1);
         button_2 = (MaterialButton)findViewById(R.id.button_2);
         button_3 = (MaterialButton)findViewById(R.id.button_3);
         button_4 = (MaterialButton)findViewById(R.id.button_4);
         button_5 = (MaterialButton)findViewById(R.id.button_5);
         button_6 = (MaterialButton)findViewById(R.id.button_6);
         button_7 = (MaterialButton)findViewById(R.id.button_7);
         button_8 = (MaterialButton)findViewById(R.id.button_8);
         button_9 = (MaterialButton)findViewById(R.id.button_9);
         button_zero = (MaterialButton)findViewById(R.id.button_zero);
         button_mul = (MaterialButton)findViewById(R.id.button_mul);
         button_sum = (MaterialButton)findViewById(R.id.button_sum);
         button_sub = (MaterialButton)findViewById(R.id.button_sub);
         button_equal = (MaterialButton)findViewById(R.id.button_equal);
         button_ac = (MaterialButton)findViewById(R.id.button_ac);
         button_dot = (MaterialButton)findViewById(R.id.button_dot);

         //Set click button with setOnClickListener
         button_1.setOnClickListener(MainActivity.this);
         button_c.setOnClickListener(this);
         button_close_bracket.setOnClickListener(this);
         button_open_bracket.setOnClickListener(this);
         button_div.setOnClickListener(this);
         button_2.setOnClickListener(this);
         button_3.setOnClickListener(this);
         button_4.setOnClickListener(this);
         button_5.setOnClickListener(this);
         button_6.setOnClickListener(this);
         button_7.setOnClickListener(this);
         button_8.setOnClickListener(this);
         button_9.setOnClickListener(this);
         button_zero.setOnClickListener(this);
         button_mul.setOnClickListener(this);
         button_sum.setOnClickListener(this);
         button_sub.setOnClickListener(this);
         button_equal.setOnClickListener(this);
         button_ac.setOnClickListener(this);
         button_dot.setOnClickListener(this);
     }

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        // Lấy chỗ activity_main android:text="AC"
        String buttonText = button.getText().toString();
        String datacal = solutioncal.getText().toString();

        if(buttonText.equals("AC")){
            solutioncal.setText("");
            resultcal.setText("0");
            return;
        }

        if(buttonText.equals("=")){
            solutioncal.setText(resultcal.getText());
            return;
        }

        if(buttonText.equals("C")){
            datacal = datacal.substring(0,datacal.length()-1);
        }else {
            datacal = datacal + buttonText;
        }

        solutioncal.setText(datacal);
        }
    }
