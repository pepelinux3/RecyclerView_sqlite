package com.example.recyclerview_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerPersonajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPersonajes = (RecyclerView)findViewById(R.id.recycler_id);
        recyclerPersonajes.setLayoutManager(new LinearLayoutManager(this));

        DatabaseAcces databaseAcces = DatabaseAcces.getInstance(getApplicationContext());
        databaseAcces.open();

        AdaptadorPersonajes adapter = new AdaptadorPersonajes(databaseAcces.getGrupos());
        recyclerPersonajes.setAdapter(adapter);

        databaseAcces.close();
    }


}
