package com.nehaanand.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView converterText;
    private EditText inchesEdit;
    private Button convertButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupButtonClickListener();

    }

    private void setupButtonClickListener() {
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inchesEdit.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter a value in inches", Toast.LENGTH_LONG).show();
                }else{
                    convertIntoMeters();
                }
            }
        });
    }

    private void findViews(){
        converterText = findViewById(R.id.text_view_converter);
        inchesEdit = findViewById(R.id.edit_text_inches);
        convertButton = findViewById(R.id.button_convert);
        resultText = findViewById(R.id.text_view_result);
    }
    private void convertIntoMeters() {
        String inchesText = inchesEdit.getText().toString();
        int inchesvalue = Integer.parseInt(inchesText);
        double metersvalue = (inchesvalue*0.0254);
        String metersconverted = String.valueOf(metersvalue);
        resultText.setText("Given value after conversion is : " + metersconverted);
    }
}