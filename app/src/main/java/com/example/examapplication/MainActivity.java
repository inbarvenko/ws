package com.example.examapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.examapplication.ui.home.HomeFragment;
import com.example.examapplication.ui.profile.ProfileFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setOnClick();
    }

    private void setOnClick() {
        findViewById(R.id.main_button_singin).setOnClickListener(this);
        findViewById(R.id.main_button_profile).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_button_singin: {
                SingIn();
            }break;
            case R.id.main_button_profile: {
                startActivity(new Intent(getApplicationContext(), ProfileFragment.class));
            }break;
        }
    }

    private void SingIn() {
        EditText password = findViewById(R.id.main_password);
        EditText email = findViewById(R.id.main_email);
        String mail = email.getText().toString();
        String pass = password.getText().toString();
        String[] logins = getResources().getStringArray(R.array.logins);
        String[] passwords = getResources().getStringArray(R.array.passwords);

        boolean isCorrectInputData = false;
        for(int i = 0; i < logins.length && !isCorrectInputData; i++) {
            if (mail.equals(logins[i]) & pass.equals(passwords[i]))
            {
                startActivity(new Intent(getApplicationContext(), HomeFragment.class));
                isCorrectInputData = true;
            }
            else{
                Toast.makeText(getApplicationContext(), "Проверьте введенные данные", Toast.LENGTH_LONG).show();
            }
        }
    }
}
