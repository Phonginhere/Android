package com.example.listapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.listapp.MainActivity;
import com.example.listapp.R;
import com.example.listapp.adapter.PersonAdapter;
import com.example.listapp.models.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonList extends AppCompatActivity {
    private List<Person> people = new ArrayList<Person>();
    private ListView listPeople;
    private PersonAdapter personAdapter;
    private Button btnNavigatePlist;
    private EditText editTextTextPersonName;
    private static final String TAG = "PersonList";


    private void getPerson() {
        //sau nay co the goi web service tai day !
        //fake data
        people.add(new Person(1, "phong", 17, "student"));
        people.add(new Person(2, "tuan", 17, "student"));
        people.add(new Person(3, "hoang", 33, "teacher"));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_list);
        listPeople = findViewById(R.id.listPeople);
        getPerson();
        btnNavigatePlist = findViewById(R.id.btnNavigatePlist);
//        editTextTextPersonName = (EditText) findViewById(R.id.editTextTextPersonName);



        //create an ArrayAdaptar from the String Array
        //personAdapter = new PersonAdapter();
        personAdapter = new PersonAdapter(people, this);
        //listPeople.setAdapter(personAdapter);
        //ListView listView = (ListView) findViewById(R.id.listPeople);
        // Assign adapter to ListView
        listPeople.setAdapter(personAdapter);


        btnNavigatePlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PersonList.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.search_view);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                personAdapter.getFilter().filter(s);
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //search_view = (SearchView) findViewById(R.id.search_view);
        int id = item.getItemId();
        if(id == R.id.search_view){
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }
}