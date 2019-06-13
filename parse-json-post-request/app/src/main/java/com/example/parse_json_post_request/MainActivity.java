package com.example.parse_json_post_request;

import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView mtext;
    private RequestQueue mRqueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtext = findViewById(R.id.text_view_result);
        Button btnparse = findViewById(R.id.btn_parse);
        mRqueue = Volley.newRequestQueue(this);

        btnparse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });
    }
    private void jsonParse()
    {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        try{
            jsonObject.put("token", "mOgHIFaj");
            jsonObject.put("name", "android");
            jsonObject.put("price", 3000);
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
                        Log.d("RESPONSE: ", response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ERROR: ", error.toString());
            }
        });
        mRqueue.add(jsonreq);
    }
}
