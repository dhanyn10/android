package com.example.android_events;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.tbl1);
        btn1.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView txt1 = (TextView) findViewById(R.id.teks1);
                        txt1.setText("Horeee");
                    }
                }
        );
        btn1.setOnLongClickListener(
                new Button.OnLongClickListener() {
                    public boolean onLongClick(View v) {
                        TextView txt1 = (TextView) findViewById(R.id.teks1);
                        txt1.setText("Hooorrrayyyy Woooooowww");
                        return true;
                    }
                }
        );
    }
}
