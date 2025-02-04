package com.example.registerform;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("success", "onCreate");
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void submit(View v){
        TextView emailInput = findViewById(R.id.inputEmail);
        EditText phoneInput = findViewById(R.id.inputPhone);
        EditText passwordInput = findViewById(R.id.inputPassword);
        Button submitButton = findViewById(R.id.button1);
//        Button button = (Button) v;
//        button.setText("1");
//        Log.d("success", "Text changed");
        if (validEmail() && validPhone()){
            Log.d("success", "Inputs validated");
            Toast.makeText(MainActivity.this, "Submitted", Toast.LENGTH_SHORT).show();
        }
    }
    public boolean validEmail(){
        TextView emailInput = findViewById(R.id.inputEmail);
        EditText phoneInput = findViewById(R.id.inputPhone);
        EditText passwordInput = findViewById(R.id.inputPassword);
        Button submitButton = findViewById(R.id.button1);
        String email = emailInput.getText().toString();
        if (!TextUtils.isEmpty(email) &&
                Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Log.d("success", "Email validated");
            Toast.makeText(MainActivity.this, "Submitted: " + email, Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
    public boolean validPhone(){
        TextView emailInput = findViewById(R.id.inputEmail);
        EditText phoneInput = findViewById(R.id.inputPhone);
        EditText passwordInput = findViewById(R.id.inputPassword);
        Button submitButton = findViewById(R.id.button1);
        String phone = phoneInput.getText().toString();
        if (!TextUtils.isEmpty(phone) &&
                Patterns.PHONE.matcher(phone).matches()){
            Log.d("success", "Phone validated");
            Toast.makeText(MainActivity.this, "Submitted: " + phone, Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}