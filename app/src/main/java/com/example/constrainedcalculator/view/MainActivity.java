package com.example.constrainedcalculator.view;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.constrainedcalculator.Evaluator;
import com.example.constrainedcalculator.R;


public class MainActivity extends AppCompatActivity {

    String output;
    String previousParentheses;
    TextView numberDisplay;
    Evaluator evaluator = new Evaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = "";
        previousParentheses = ")";
        numberDisplay = findViewById(R.id.number_display);
    }
//
//    public void clearDisplay() {
//        output = "";
//        previousParentheses = ")";
//        numberDisplay.setText(output);
//    }
//
//    public void setNumberDisplay() {
//        numberDisplay.setText(output);
//    }
//
//    public void parseOutput() {
//        output = output.replace('x', '*');
//        output = output.replace('X', '*');
//        output = output.replace('÷', '/');
//    }
//
//    public void evaluateExpression(View view) {
//        parseOutput();
//        try {
//            output = String.valueOf(evaluator.eval(output));
//            setNumberDisplay();
//        } catch (Exception e) {
//            clearDisplay();
//        }
//    }
//
//    public void btnClear(View view) {
//        clearDisplay();
//    }
//
//    public void btnOne(View view) {
//        output = output + "1";
//        setNumberDisplay();
//    }
//
//    public void btnTwo(View view) {
//        output = output + "2";
//        setNumberDisplay();
//    }
//
//    public void btnThree(View view) {
//        output = output + "3";
//        setNumberDisplay();
//    }
//
//    public void btnFour(View view) {
//        output = output + "4";
//        setNumberDisplay();
//    }
//
//    public void btnFive(View view) {
//        output = output + "5";
//        setNumberDisplay();
//    }
//
//    public void btnSix(View view) {
//        output = output + "6";
//        setNumberDisplay();
//    }
//
//    public void btnSeven(View view) {
//        output = output + "7";
//        setNumberDisplay();
//    }
//
//    public void btnEight(View view) {
//        output = output + "8";
//        setNumberDisplay();
//    }
//
//    public void btnNine(View view) {
//        output = output + "9";
//        setNumberDisplay();
//    }
//
//    public void btnZero(View view) {
//        output = output + "0";
//        setNumberDisplay();
//    }
//
//    public void btnPlus(View view) {
//        output = output + "+";
//        setNumberDisplay();
//    }
//
//    public void btnMinus(View view) {
//        output = output + "-";
//        setNumberDisplay();
//    }
//
//    public void btnMultiply(View view) {
//        output = output + "x";
//        setNumberDisplay();
//    }
//
//    public void btnDivide(View view) {
//        output = output + "÷";
//        setNumberDisplay();
//    }
//
//    public void btnPoint(View view) {
//        output = output + ".";
//        setNumberDisplay();
//    }
//
//    public void btnPlusMinus(View view) {
//        output = output + ".";
//        setNumberDisplay();
//    }
//
//    public void btnPercent(View view) {
//        output = output + '%';
//        setNumberDisplay();
//    }
//
//    public void btnParentheses(View view) {
//        if (previousParentheses == ")") {
//            output = output + "(";
//            previousParentheses = "(";
//        } else {
//            output = output + ")";
//            previousParentheses = ")";
//        }
//        setNumberDisplay();
//    }
}
