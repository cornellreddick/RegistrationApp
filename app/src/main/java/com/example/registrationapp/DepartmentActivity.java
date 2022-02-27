package com.example.registrationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class DepartmentActivity extends AppCompatActivity {
    final static public String DEPT_NAME_KEY = "deptName";
    RadioGroup radioGroup;
    Button selectButton, cancelButton;
    RadioButton radioButton;
    String deptName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);
        setTitle("Department");


        selectButton = findViewById(R.id.deptSelectBtn);
        cancelButton = findViewById(R.id.deptCancelBtn);
        radioGroup = findViewById(R.id.deptRadioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                radioButton = findViewById(checkedId);
                        if (checkedId == R.id.radioButtonCS) {
                            radioButton.getText();
                        } else if (checkedId == R.id.radioButtonSIS) {
                            radioButton.getText();
                        } else if (checkedId == R.id.radioButtonBIO) {
                            radioButton.getText();
                        } else if (checkedId == R.id.radioButtonData) {
                            radioButton.getText();
                        }
                    }
        });

        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (radioGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please select a Radio Button", Toast.LENGTH_SHORT).show();
                }else{
                    deptName = radioButton.getText().toString();
                    Intent intent = new Intent(DepartmentActivity.this, RegistrationActivity.class);
                    intent.putExtra(DEPT_NAME_KEY, deptName);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}