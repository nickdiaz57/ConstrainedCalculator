package com.example.constrainedcalculator.view;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.constrainedcalculator.R;
import com.example.constrainedcalculator.databinding.ActivityMainBinding;

public class NewMainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
        binding.numberDisplay.setText("");
    }
}
