package com.example.random;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void updateUserInfo(View view) {
        rootNode = FirebaseDatabase.getInstance(); //incl whole database
        reference = rootNode.getReference("Users");

        EditText name_editText = findViewById(R.id.name_EditText);
        EditText email_ediText = findViewById(R.id.email_EditText);
        EditText password_editText = findViewById(R.id.password_EditText);

        UserHelperClass helperClass =  new UserHelperClass(name_editText.getText().toString(), password_editText.getText().toString());
        reference.child(email_ediText.getText().toString()).setValue(helperClass);
    }
}