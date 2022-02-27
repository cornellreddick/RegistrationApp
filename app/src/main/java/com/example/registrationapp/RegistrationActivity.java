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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {
    Button selectBtn, submitBtn;
    TextView selectDept;
    EditText nameInput, emailInput, IdInput;
    Profile profile;
    final static public String PROFILE = "USER";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setTitle("Registration");



        selectBtn = findViewById(R.id.regSelectButton);
        submitBtn = findViewById(R.id.regSubmitButton);
        selectDept = findViewById(R.id.selectDeptTextView);
        nameInput = findViewById(R.id.editTextName);
        emailInput = findViewById(R.id.editTextEmail);
        IdInput = findViewById(R.id.editTextId);

        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationActivity.this, DepartmentActivity.class);
                startForResult.launch(intent);
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nameInput.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Please enter name!!", Toast.LENGTH_SHORT).show();
                }else if (emailInput.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Please enter email!!", Toast.LENGTH_SHORT).show();
                }else if (IdInput.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Please enter Id!!", Toast.LENGTH_SHORT).show();
                }else if(selectDept.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Please click the Select Button,  and choose a department!!", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(RegistrationActivity.this, ProfileActivity.class);
                   intent.putExtra(PROFILE, new Profile(nameInput.getText().toString(), emailInput.getText().toString(), IdInput.getText().toString(), selectDept.getText().toString()));
                   startActivity(intent);

                }
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