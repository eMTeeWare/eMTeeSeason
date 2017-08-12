package net.emteeware.emteeseason;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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

        ListView listview = (ListView) findViewById(R.id.SeriesList);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);


        listview.setAdapter(adapter);
    }

    public void addItems(View view) {
        final String[] addedSeriesName = {""};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Name der neuen Serie:");


        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                addedSeriesName[0] = input.getText().toString();
                items.add(addedSeriesName[0]);
                adapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();

    }
}
