package com.example.constrainedcalculator.view;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.constrainedcalculator.R;
import com.example.constrainedcalculator.databinding.ActivityMainBinding;
import com.example.constrainedcalculator.viewmodel.MainViewModel;

public class MVVMActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    private ActivityMainBinding binding;
    private int lastOperatorIndex;
    private boolean openParentheses;
    private String substring;

    private static String TAG = "MVVMActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getDisplayString().observe(this, s -> {
            binding.numberDisplay.setText(s);
        });

        binding.btn0.setOnClickListener(view -> addToDisplay(getString(R.string.zero)));
        binding.btn1.setOnClickListener(view -> addToDisplay(getString(R.string.one)));
        binding.btn2.setOnClickListener(view -> addToDisplay(getString(R.string.two)));
        binding.btn3.setOnClickListener(view -> addToDisplay(getString(R.string.three)));
        binding.btn4.setOnClickListener(view -> addToDisplay(getString(R.string.four)));
        binding.btn5.setOnClickListener(view -> addToDisplay(getString(R.string.five)));
        binding.btn6.setOnClickListener(view -> addToDisplay(getString(R.string.six)));
        binding.btn7.setOnClickListener(view -> addToDisplay(getString(R.string.seven)));
        binding.btn8.setOnClickListener(view -> addToDisplay(getString(R.string.eight)));
        binding.btn9.setOnClickListener(view -> addToDisplay(getString(R.string.nine)));

        binding.btnDivide.setOnClickListener(view -> addToDisplay(getString(R.string.divide)));
        binding.btnMultiply.setOnClickListener(view -> addToDisplay(getString(R.string.multiply)));
        binding.btnMinus.setOnClickListener(view -> addToDisplay(getString(R.string.minus)));
        binding.btnPlus.setOnClickListener(view -> addToDisplay(getString(R.string.plus)));

        binding.btnPlusMinus.setOnClickListener(view -> handleNegative());
        binding.btnPoint.setOnClickListener(view -> handlePoint());
        binding.btnParentheses.setOnClickListener(view -> handleParentheses());
        binding.btnEquals.setOnClickListener(view -> viewModel.evaluate((String) binding.numberDisplay.getText()));
        binding.btnClear.setOnClickListener(view -> {
            viewModel.displayEmpty = true;
            viewModel.clear();
        });

        lastOperatorIndex = 0;
        openParentheses = true;
        viewModel.displayEmpty = true;
    }

    public void handleParentheses() {
        String string = binding.numberDisplay.getText().toString();

        if (openParentheses) {
            if (viewModel.displayEmpty) {
                addToDisplay("(");
                openParentheses = false;
            } else {
                if ("(".equals(string.substring(string.length() - 1))) {
                    return;
                } else if (")".equals(string.substring(string.length() - 1))) {
                    addToDisplay("x(");
                    openParentheses = false;
                } else {
                    addToDisplay("(");
                    openParentheses = false;
                }
            }
        } else {
            addToDisplay(")");
            openParentheses = true;
        }
    }

    public void handlePoint() {
        String string = binding.numberDisplay.getText().toString();
        String targetSubstring = string.substring(lastOperatorIndex);

        if (viewModel.displayEmpty) {
            return;
        } else {
            if (targetSubstring.contains(".")) {
                return;
            } else {
                addToDisplay(".");
            }
        }
    }

    public void handleNegative() {
        String string = binding.numberDisplay.getText().toString();

        if (viewModel.displayEmpty) {//if nothing is in the display, add parentheses and minus
            addToDisplay("(-");
            openParentheses = false;
        } else {//if the display is not empty
            if (lastOperatorIndex == string.length() - 1 && lastOperatorIndex != 0) {
                //if the last character is an operator and it isn't at the beginning of the string
                addToDisplay("(-");
                openParentheses = false;
            } else if (lastOperatorIndex == 0) {//if the last operator is at the beginning, or there is no operator
                if (string.charAt(0) == '-') {//if the first character is a negative
                    removeFirstCharacterFromDisplay();
                } else {
                    addToBeginningOfDisplay("-");//if the first character is a number
                    //recheck
                }
            }
        }
    }

    //last character in a string: string.substring(string.length()-1)
    //last operator in a string: string.substring(lastOperatorIndex, lastOperatorIndex + 1)
    //character after the last operator: string.substring(lastOperatorIndex + 1, lastOperatorIndex + 2)

    public void removeLastCharacterFromDisplay() {
        String string = binding.numberDisplay.getText().toString();
        String newString = string.substring(0, string.length() - 1);
        binding.numberDisplay.setText(newString);
    }

    public void removeFirstCharacterFromDisplay() {
        String string = binding.numberDisplay.getText().toString();
        String newString = string.substring(1);
        binding.numberDisplay.setText(newString);
    }

    public void addToBeginningOfDisplay(String chr) {
        binding.numberDisplay.setText(new StringBuilder().append(chr).append(binding.numberDisplay.getText()).toString());
    }

    public void addToDisplay (String chr) {
        viewModel.displayEmpty = false;
        String operators = "÷ x X * / + -";

        if (operators.contains(chr)) {
            lastOperatorIndex = binding.numberDisplay.getText().toString().length();
        }
        //if character is an operator, save its index
        binding.numberDisplay.setText(new StringBuilder().append(binding.numberDisplay.getText()).append(chr).toString());
    }
}
