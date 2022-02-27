package com.example.registrationapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegistrationActivity extends AppCompatActivity {
    Button selectBtn;
    TextView selectDept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setTitle("Registration");



        selectBtn = findViewById(R.id.regSelectButton);
        selectDept = findViewById(R.id.selectDeptTextView);

        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationActivity.this, DepartmentActivity.class);
                startForResult.launch(intent);
            }
        });

    }

    ActivityResultLauncher<Intent> startForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result != null && result.getResultCode() == RESULT_OK){
                if (result.getData() != null && result.getData().getStringExtra(DepartmentActivity.DEPT_NAME_KEY) != null) {
                    Log.d("position", "onActivityResult: ");

                       // String deptName = result.getData().getStringExtra(DepartmentActivity.DEPT_NAME_KEY);
                        selectDept.setText(result.getData().getStringExtra(DepartmentActivity.DEPT_NAME_KEY));

//                        tasks.add(new Task(name, date, Integer.parseInt(priority)));
                }

            }

        }
    });

}