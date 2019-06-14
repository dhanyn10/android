package com.example.parse_json_post_request;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView ntext, ptext;
    private RequestQueue mRqueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ntext       = findViewById(R.id.text_name);
        ptext       = findViewById(R.id.text_price);
        Button btnsubmit = findViewById(R.id.btn_submit);
        mRqueue = Volley.newRequestQueue(this);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonInput();
            }
        });
    }
    private void jsonInput()
    {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        try{
            jsonObject.put("token", getResources().getString(R.string.token));
            jsonObject.put("name", ntext.getText().toString());
            jsonObject.put("price", Integer.parseInt(ptext.getText().toString()));
            jsonArray.put(jsonObject);
        }
        catch (Exception err)
        {
            Log.e("ERROR", err.toString());
        }
        String url = "http://10.15.176.160:3000/data";
        JsonObjectRequest jsonreq = new JsonObjectRequest(url, jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("RESPONSE ", response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ERROR ", error.toString());
            }
        });
        mRqueue.add(jsonreq);
    }
}
