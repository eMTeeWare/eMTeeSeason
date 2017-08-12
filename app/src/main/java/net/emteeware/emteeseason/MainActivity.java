package net.emteeware.emteeseason;

import android.content.Context;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import static net.emteeware.emteeseason.R.id.SeriesList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> items = new ArrayList<>();
    ArrayAdapter<String> adapter;
    String filename = "seriesListStore";


    @Override
    @SuppressWarnings("unchecked")
    public void onCreate(Bundle savedInstanceState)
    {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(getFilesDir(), filename)))) {
            Object inputObject = ois.readObject();
            if(inputObject instanceof ArrayList) {
                items = (ArrayList<String>) inputObject;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

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
                try {
                    ObjectOutput out = new ObjectOutputStream(new FileOutputStream(new File(getFilesDir(), filename)));
                    out.writeObject(items);

                } catch (IOException e) {
                    e.printStackTrace();
                }


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
