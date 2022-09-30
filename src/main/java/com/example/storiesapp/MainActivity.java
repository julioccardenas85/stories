package com.example.storiesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.kumulos.android.Kumulos;
import com.kumulos.android.ResponseHandler;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<ListElement> elements = new ArrayList<>();

        HashMap<String, String> params = new HashMap<>();
        Kumulos.call("getAllStoriesV2", params, new ResponseHandler() {
            @Override
            public void onFailure(@Nullable Throwable error) {
                super.onFailure(error);
            }

            @Override
            public void didCompleteWithResult(@Nullable Object result) {
                super.didCompleteWithResult(result);
                ArrayList<LinkedHashMap<String, Object>> objects = (ArrayList<LinkedHashMap<String,Object>>) result;
                for (LinkedHashMap<String, Object> item : objects) {
                    String title = (String) item.get("titles");
                    String url = (String) item.get("imageUrl");
                    elements.add(new ListElement(title, url));
                }
            }
        });

        init(elements);
    }

    public void init (List elements) {
        ListAdapter listAdapter = new ListAdapter(elements, this);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2)); // Sets the elements layout
        recyclerView.setAdapter(listAdapter);
    }

}