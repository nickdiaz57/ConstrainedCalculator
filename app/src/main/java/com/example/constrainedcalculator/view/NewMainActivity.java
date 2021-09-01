package com.example.constrainedcalculator.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.constrainedcalculator.Evaluator;
import com.example.constrainedcalculator.R;
import com.example.constrainedcalculator.databinding.ActivityMainBinding;

public class NewMainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;
    Evaluator evaluator = new Evaluator();
    String previousParentheses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        previousParentheses = ")";

        binding.btn0.setOnClickListener(this);
        binding.btn1.setOnClickListener(this);
        binding.btn2.setOnClickListener(this);
        binding.btn3.setOnClickListener(this);
        binding.btn4.setOnClickListener(this);
        binding.btn5.setOnClickListener(this);
        binding.btn6.setOnClickListener(this);
        binding.btn7.setOnClickListener(this);
        binding.btn8.setOnClickListener(this);
        binding.btn9.setOnClickListener(this);
        binding.btnClear.setOnClickListener(this);

        binding.btnDivide.setOnClickListener(view -> addToDisplay(getString(R.string.divide)));
        binding.btnMultiply.setOnClickListener(view -> addToDisplay(getString(R.string.multiply)));
        binding.btnMinus.setOnClickListener(view -> addToDisplay(getString(R.string.minus)));
        binding.btnPlus.setOnClickListener(view -> addToDisplay(getString(R.string.plus)));
        binding.btnPoint.setOnClickListener(view -> addToDisplay(getString(R.string.point)));
//        binding.btnPercent.setOnClickListener(view -> parseOutput());
        binding.btnParentheses.setOnClickListener(view -> handleParentheses());
        binding.btnEquals.setOnClickListener(view -> evaluateExpression());
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn0) addToDisplay(getString(R.string.zero));
        else if (id == R.id.btn1) addToDisplay(getString(R.string.one));
        else if (id == R.id.btn2) addToDisplay(getString(R.string.two));
        else if (id == R.id.btn3) addToDisplay(getString(R.string.three));
        else if (id == R.id.btn4) addToDisplay(getString(R.string.four));
        else if (id == R.id.btn5) addToDisplay(getString(R.string.five));
        else if (id == R.id.btn6) addToDisplay(getString(R.string.six));
        else if (id == R.id.btn7) addToDisplay(getString(R.string.seven));
        else if (id == R.id.btn8) addToDisplay(getString(R.string.eight));
        else if (id == R.id.btn9) addToDisplay(getString(R.string.nine));
        else if (id == R.id.btn_clear) clearDisplay();
    }

    public void addToDisplay (String chr) {
        binding.numberDisplay.setText(new StringBuilder().append(binding.numberDisplay.getText()).append(chr).toString());
    }

    public void clearDisplay() {
        previousParentheses = ")";
        binding.numberDisplay.setText("");
    }

    public void handleParentheses() {
        if (previousParentheses == ")") {
            addToDisplay("(");
            previousParentheses = "(";
        } else {
            addToDisplay(")");
            previousParentheses = ")";
        }
    }

    public void evaluateExpression() {
        String output = (String) binding.numberDisplay.getText();
        output = output.replace('x', '*');
        output = output.replace('X', '*');
        output = output.replace('÷', '/');

        try {
            output = String.valueOf(evaluator.eval(output));
            binding.numberDisplay.setText(output);
        } catch (Exception e) {
            Toast.makeText(NewMainActivity.this, "Invalid Expression", Toast.LENGTH_SHORT).show();
            clearDisplay();
        }
    }
    //dont allow another operator in string if previous character is an operator
    //iterate through string before current position, check if an operator is present
    //if there is, everything after that operator will get a set of parentheses and a negative operator
    //figure out something for the percent
    //change to an edittext instead of a textview, useful for editing expressions in the middle
    //add top row of keys and backspace button
}
