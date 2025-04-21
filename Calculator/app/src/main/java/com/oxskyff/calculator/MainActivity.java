package com.oxskyff.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Duration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View view) {
        EditText numerator1 = (EditText) findViewById(R.id.first_operator);
        EditText numerator2 = (EditText) findViewById(R.id.second_operator);
        RadioGroup symbolButton = (RadioGroup) findViewById(R.id.radioGroup2);
        int checked_id = symbolButton.getCheckedRadioButtonId();
        RadioButton ra = findViewById(checked_id);

            String symbol = (String) ra.getText();





        TextView resultText = (TextView) findViewById(R.id.result);
        try {
            Integer a = Integer.parseInt(numerator1.getText().toString());
            Integer b = Integer.parseInt(numerator2.getText().toString());
            int finalResult = compute(symbol, a , b);
            String resultado = String.format("%s %d %s %d %s %d", "The result of", a, symbol, b,"=", finalResult );
            resultText.setText(resultado);

        } catch (NumberFormatException ex) {
           resultText.setText("The operation is invalid. Try again.");
        }
        Toast.makeText(this, "Operation compleated", Toast.LENGTH_SHORT).show();
        /*Toast toast = Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show(); */


    }

    private int compute (String symbol, int a, int b) {
        switch (symbol) {
            case "+":
                return a + b;
            case "-" :
                return a - b ;
            case "x" :
                return a * b;
            case "/":
                return a / b;
        }
        return 0;
    }


}