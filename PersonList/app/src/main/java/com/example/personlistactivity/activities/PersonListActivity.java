package com.example.personlistactivity.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.personlistactivity.R;
import com.example.personlistactivity.adapters.PersonAdapter;
import com.example.personlistactivity.models.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonListActivity extends AppCompatActivity {

    private ListView ListViewPersons;
    private List<Person> personList = new ArrayList<Person>();
    private PersonAdapter personsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_list);
        ListViewPersons = findViewById(R.id.ListViewPersons);
        //fake list
        personList.add(new Person(1,"Cong Anh","anh@gmail.com","0123123123"));
        personList.add(new Person(2,"Cong Minh","minh@gmail.com","0123123123"));
        personList.add(new Person(3,"Plinh","linh@gmail.com","0123123123"));
        personList.add(new Person(4,"Cong","cong@gmail.com","0123123123"));
        personList.add(new Person(5,"Lan","lan@gmail.com","0123123123"));

        //objects(data) => Adapter => ListView(UI)
        personsAdapter = new PersonAdapter(personList);
        ListViewPersons.setAdapter(personsAdapter);
    }
}