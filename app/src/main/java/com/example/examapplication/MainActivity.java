package com.example.examapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.examapplication.model.LoginModel;
import com.example.examapplication.model.LoginResponse;
import com.example.examapplication.network.NetworkServices;

public class MainActivity extends AppCompatActivity{

    EditText password;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.main_email);
        password = findViewById(R.id.main_password);

        findViewById(R.id.main_button_singin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = email.getText().toString();
                String pass = password.getText().toString();
                if (login.contains("@") && !pass.isEmpty()) {
                    signRequest(new LoginModel(login, pass));
                } else
                    Toast.makeText(MainActivity.this, "Данные введены неверно", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.main_button_profile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    private void signRequest(LoginModel loginModel) {
        NetworkServices.getInstance().getJSONApi().login(loginModel).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    Intent intent1 = new Intent(MainActivity.this, BottomNavigationActivity.class);
                    startActivity(intent1);
                } else
                    Toast.makeText(MainActivity.this, "Данные введены неверно", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
