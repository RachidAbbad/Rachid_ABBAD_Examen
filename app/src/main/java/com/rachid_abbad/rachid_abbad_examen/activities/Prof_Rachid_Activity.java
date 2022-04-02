package com.rachid_abbad.rachid_abbad_examen.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.rachid_abbad.rachid_abbad_examen.R;
import com.rachid_abbad.rachid_abbad_examen.adapters.Prof_Rachid_Adapter;
import com.rachid_abbad.rachid_abbad_examen.classes.Prof_Rachid;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Prof_Rachid_Activity extends AppCompatActivity {

    EditText cin, nom, specialite;
    Button btn_add, btn_delete, btn_edit, btn_show;
    RecyclerView rv;
    List<Prof_Rachid> list;
    Prof_Rachid_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof__rachid_);

        cin = findViewById(R.id.cin);
        nom = findViewById(R.id.nom);
        specialite = findViewById(R.id.specialite);
        btn_add = findViewById(R.id.btn_add);
        btn_delete = findViewById(R.id.btn_delete);
        btn_edit = findViewById(R.id.btn_edit);
        btn_show = findViewById(R.id.btn_show);
        rv = findViewById(R.id.rv);

        list = new ArrayList<Prof_Rachid>();

        adapter = new Prof_Rachid_Adapter(this,R.layout.prof_layout, list, this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDistant();
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertToDistant();
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete_from_distant();
            }
        });

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                majToDistant();
            }
        });
    }

    void showDistant() {

        String url = "http://iot-nodemcu-projects.000webhostapp.com/module_prof/selection_prof.php";
        RequestQueue requestQueue = Volley.newRequestQueue(Prof_Rachid_Activity.this);
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
                        adapter.notifyDataSetChanged();
                        Toast.makeText(Prof_Rachid_Activity.this, "Done", Toast.LENGTH_LONG).show();
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

    void insertToDistant() {
        String url = "https://iot-nodemcu-projects.000webhostapp.com/module_prof/ajout_prof.php?cin="+cin.getText().toString()+"&nom="+nom.getText().toString()+"&specialite="+specialite.getText().toString();
        RequestQueue queue = Volley.newRequestQueue(Prof_Rachid_Activity.this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Prof_Rachid_Activity.this, response, Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Prof_Rachid_Activity.this, "Error", Toast.LENGTH_LONG).show();
            }
        });

        queue.add(stringRequest);

    }


    void delete_from_distant() {
        String url = "https://iot-nodemcu-projects.000webhostapp.com/module_prof/delete_prof.php?cin="+cin.getText().toString();
        RequestQueue queue = Volley.newRequestQueue(Prof_Rachid_Activity.this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Prof_Rachid_Activity.this, response, Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Prof_Rachid_Activity.this, "Error", Toast.LENGTH_LONG).show();
            }
        });

        queue.add(stringRequest);

    }

    void majToDistant() {
        String url = "https://iot-nodemcu-projects.000webhostapp.com/module_prof/maj_prof.php?cin="+cin.getText().toString()+"&nom="+nom.getText().toString()+"&specialite="+specialite.getText().toString();
        RequestQueue queue = Volley.newRequestQueue(Prof_Rachid_Activity.this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Prof_Rachid_Activity.this, response, Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Prof_Rachid_Activity.this, "Error", Toast.LENGTH_LONG).show();
            }
        });

        queue.add(stringRequest);

    }
}