package com.example.appdata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

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

        Button btnadd =  findViewById(R.id.btnadd);
        btnadd.setOnClickListener(btnclickadd);
    }

    public void printDatabase()
    {
        String dbstring = dbase.toString();
        txt.setText(dbstring);
        input.setText("");
    }
    private View.OnClickListener btnclickadd = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("STATE", "add");
        }
    };
}
