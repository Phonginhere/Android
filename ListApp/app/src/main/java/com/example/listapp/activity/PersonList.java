package com.example.listapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listapp.MainActivity;
import com.example.listapp.R;
import com.example.listapp.adapter.PersonAdapter;
import com.example.listapp.models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PersonList extends Activity {
    private List<Person> people = new ArrayList<Person>();
    private ListView listPeople;
    private PersonAdapter personAdapter;
    private Button btnNavigatePlist;
    private EditText editTextTextPersonName;

    private static final String TAG = "PersonList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_list);;
        Log.d(TAG, "oncreate: Started");
        listPeople = findViewById(R.id.listPeople);
        btnNavigatePlist = findViewById(R.id.btnNavigatePlist);
        editTextTextPersonName = (EditText) findViewById(R.id.editTextTextPersonName);

        editTextTextPersonName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String text = editTextTextPersonName.getText().toString().toLowerCase(Locale.getDefault());
                personAdapter.filter(text);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        people.add(new Person(1, "phong", 17, "student"));
        people.add(new Person(2, "tuan", 17, "student"));
        people.add(new Person(3, "hoang", 33, "teacher"));

        //create an ArrayAdaptar from the String Array
        //personAdapter = new PersonAdapter();
        personAdapter = new PersonAdapter(people);
        //listPeople.setAdapter(personAdapter);
        //ListView listView = (ListView) findViewById(R.id.listPeople);
        // Assign adapter to ListView
        listPeople.setAdapter(personAdapter);
//        ArrayList<String> names = new ArrayList<>();
//        names.add("Mitch");
//        names.add("haha");

        //ArrayAdapter adapter = new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1, people);


        btnNavigatePlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PersonList.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}