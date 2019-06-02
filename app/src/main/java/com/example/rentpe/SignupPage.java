package com.example.rentpe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import fr.ganfra.materialspinner.MaterialSpinner;

public class SignupPage extends AppCompatActivity {
    private static final String[] ITEMS = {"+91"};

    private ArrayAdapter<String> adapter;
    private EditText name,email,mobile,password,confirm_password;
     MaterialSpinner spinner6;
     private Button register;
     private RadioButton r1,r2;
     private TextView jump_to_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ITEMS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        initSpinnerHintAndCustomHintView();

        name=(EditText) findViewById(R.id.name);
        email=(EditText) findViewById(R.id.email);
        mobile=(EditText)findViewById(R.id.mobile);
        password=(EditText) findViewById(R.id.password);
        confirm_password=(EditText) findViewById(R.id.confirm_password);
        r1=(RadioButton) findViewById(R.id.rb1);
        r2=(RadioButton) findViewById(R.id.rb2);
        jump_to_login=(TextView) findViewById(R.id.textView9);
        register=(Button) findViewById(R.id.button4);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean is_valid=checkDataEntered2();
                int gender;
                if(r1.isChecked()) gender=0;
                else if(r2.isChecked()) gender=1;


            }
        });

      jump_to_login.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent=new Intent(SignupPage.this,LoginPage.class);
          startActivity(intent);
          }
      });

    }

    Boolean checkDataEntered2()
    {

        if(name.getText().toString().trim().length()==0)
        {
            name.setError("Full Name must not be empty");
            return false;
        }
        else if(email.getText().toString().trim().length()==0)
        {
            email.setError("Email Address must not be empty ");
            return false;
        }
         else if(Patterns.EMAIL_ADDRESS.matcher(email.getText().toString().trim()).matches()==false)
        {
            email.setError("Enter Valid Email Address");
            return false;
        }
         else if(mobile.getText().toString().trim().length()!=10)
         {
             mobile.setError("Mobile Number must be of 10 digits");
             return false;
         }
        else if(password.getText().toString().length()<8)
        {
            password.setError("Password must be greater than equal to 8 characters");
            return false;
        }
        else if(password.getText().toString().equals(confirm_password.getText().toString())==false)
        {
            confirm_password.setError("Password and Confirm Password not match");
            return false;
        }

        return true;
    }


    private void initSpinnerHintAndCustomHintView() {
        spinner6 = findViewById(R.id.spinner6);
        spinner6.setAdapter(adapter);
    }
}
