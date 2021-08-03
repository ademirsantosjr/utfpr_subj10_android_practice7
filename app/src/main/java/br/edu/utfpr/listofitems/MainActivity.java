package br.edu.utfpr.listofitems;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listViewItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewItems = findViewById(R.id.listViewItems);

        listViewItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) listViewItems.getItemAtPosition(position);

                Toast.makeText(getApplicationContext(),
                        getString(R.string.clicked_on) + item,
                        Toast.LENGTH_SHORT).show();
            }
        });

        populateListViewItems();
    }

    private void populateListViewItems() {
        ArrayList<String> items = new ArrayList<>();

        items.add(getString(R.string.rice));
        items.add(getString(R.string.coffee));
        items.add(getString(R.string.milk));
        items.add(getString(R.string.chocolate));
        items.add(getString(R.string.ketchup));
        items.add(getString(R.string.cereal));
        items.add(getString(R.string.apple));
        items.add(getString(R.string.banana));
        items.add(getString(R.string.bread));

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        items);

        listViewItems.setAdapter(adapter);
    }
}