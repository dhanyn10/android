package com.example.appdata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText input;
    TextView txt;
    DatabaseHandler dbase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.textdata);
        txt = findViewById(R.id.txtresult);

        dbase = new DatabaseHandler(this, null, null, 1);
    }

    public void printDatabase()
    {
        String dbstring = dbase.toString();
        txt.setText(dbstring);
        input.setText("");
    }
}
