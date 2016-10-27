package com.example.bridgeit.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText mName,mPhone,mEmail;
    private Button mSave;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEmail = (EditText)findViewById(R.id.edit_email);
        mName = (EditText)findViewById(R.id.edit_name);
        mPhone = (EditText)findViewById(R.id.edit_pass);
        mSave = (Button)findViewById(R.id.btn_save);
preferences = getSharedPreferences(MyPREFERENCES,MODE_PRIVATE);
        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mName.getText().toString();
                String pass = mPhone.getText().toString();
                String email = mEmail.getText().toString();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(Name,name);
                editor.putString(Phone,pass);
                editor.putString(Email,email);
                editor.commit();
                Toast.makeText(MainActivity.this,"Saved successfully",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
