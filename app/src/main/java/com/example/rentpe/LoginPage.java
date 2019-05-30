package com.example.rentpe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class LoginPage extends AppCompatActivity {
    private Button login;
    private TextView skip;
    private EditText user_name,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        user_name = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.pass);
        login = (Button) findViewById(R.id.button3);
        skip=(TextView) findViewById(R.id.skip);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean is_valid=checkDataEntered();
                    if(is_valid){
                        Toast.makeText(getApplicationContext(),"OKAY",LENGTH_SHORT).show();
                    }

            }
        });



    }

        Boolean checkDataEntered()
        {
            if(user_name.getText().toString().trim().length()==0)
            {
                user_name.setError("Email Address must not be empty ");
                return false;
            }
            else if(Patterns.EMAIL_ADDRESS.matcher(user_name.getText().toString().trim()).matches()==false)
            {
                user_name.setError("Enter Valid Email Address");
                return false;
            }
            else if(password.getText().toString().length()<8)
            {
                password.setError("Password must be greater than equal to 8 characters");
                return false;
            }
            return true;
        }


    }


