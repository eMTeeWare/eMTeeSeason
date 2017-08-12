package net.emteeware.emteeseason;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static net.emteeware.emteeseason.R.id.SeriesList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> items = new ArrayList<>();
    ArrayAdapter<String> adapter;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items.add( "Suits");
        ListView listview = (ListView) findViewById(R.id.SeriesList);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);


        listview.setAdapter(adapter);
    }

    public void addItems(View view) {
        items.add("Blue Bloods");
        items.add("Sherlock");
        adapter.notifyDataSetChanged();
    }
}
