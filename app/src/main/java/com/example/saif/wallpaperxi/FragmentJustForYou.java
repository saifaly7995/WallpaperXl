package com.example.saif.wallpaperxi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FragmentJustForYou extends Fragment {
    View view;
    RecyclerView lv;
    List<ListItem> listItems;

    String url ="https://myappwithvolley.000webhostapp.com/fetchimagejson.php";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.just_for_you, container, false);
        lv = (RecyclerView) view.findViewById(R.id.lisview_id);

        lv.setLayoutManager(new LinearLayoutManager(getContext()));

        listItems= new ArrayList<>();
        String url ="https://myappwithvolley.000webhostapp.com/fetchimagejson.php";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.

                        try {
                            JSONObject jsonObject= new JSONObject(response);
                            JSONArray jsonArray= jsonObject.getJSONArray("wallpapers");

                            for (int i=0;i<jsonArray.length();i++)
                            {
                                JSONObject o=jsonArray.getJSONObject(i);
                                ListItem item = new ListItem(o.getString("image_name"),o.getString("url"));
                                listItems.add(item);

                            }
                            lv.setAdapter(new AdapterExplore(listItems,getContext()));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(getContext());
        queue.add(stringRequest);


        lv.setAdapter(new AdapterJustForYou(listItems,getContext()));

        return view;
    }


}
