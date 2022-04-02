package com.rachid_abbad.rachid_abbad_examen.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.rachid_abbad.rachid_abbad_examen.R;
import com.rachid_abbad.rachid_abbad_examen.classes.Prof_Rachid;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Informations_Rachid_Activity extends AppCompatActivity {

    Button sup200,deleteAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informations__rachid_);

        sup200 = findViewById(R.id.sup200);
        deleteAll = findViewById(R.id.delete);

        sup200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Prof_Rachid> list = new ArrayList<Prof_Rachid>();
                String url = "http://iot-nodemcu-projects.000webhostapp.com/module_prof/selection_prof_sup200.php";
                RequestQueue requestQueue = Volley.newRequestQueue(Informations_Rachid_Activity.this);
                JsonArrayRequest request = new JsonArrayRequest(url,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                Log.e("responce", response.toString());
                                try {
                                    list.clear();
                                    for (int i = 0; i < response.length(); i++) {
                                        JSONObject jsonObject = response.getJSONObject(i);
                                        list.add(new Prof_Rachid(jsonObject.getString("cne"), jsonObject.getString("nom"), jsonObject.getString("specialite")));
                                    }
                                } catch (JSONException e) {

                                }
                                Intent i = new Intent("com.rachid_abbad.rachid_abbad_examen_app2.MainActivity");
                                Bundle b = new Bundle();
                                b.putSerializable("list",list);
                                startActivity(i);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.e("ReponseError", error.getMessage());
                            }
                        });

                requestQueue.add(request);

            }
        });
    }
}