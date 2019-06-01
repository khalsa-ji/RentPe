package com.example.rentpe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import fr.ganfra.materialspinner.MaterialSpinner;

public class SignupPage extends AppCompatActivity {
    private static final String[] ITEMS = {"+91", "+44", "+62","+44 1624","+39 06 698","+61 89164"};

    private ArrayAdapter<String> adapter;

    MaterialSpinner spinner6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ITEMS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        initSpinnerHintAndCustomHintView();

    }

    private void initSpinnerHintAndCustomHintView() {
        spinner6 = findViewById(R.id.spinner6);
        spinner6.setAdapter(adapter);
    }
}
