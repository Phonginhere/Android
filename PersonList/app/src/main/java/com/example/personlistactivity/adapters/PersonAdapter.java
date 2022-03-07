package com.example.personlistactivity.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.personlistactivity.R;
import com.example.personlistactivity.models.Person;

import java.util.List;

public class PersonAdapter extends BaseAdapter {
    private List<Person> persons;
    public PersonAdapter(List<Person> persons){
        super();//call baseAdapter (call parent method)
        this.persons = persons;
    }

    @Override
    public int getCount() {
        //how many list item?
        return persons.size();
    }

    @Override
    public Object getItem(int i) {
        return persons.get(i);//i = 0,1,2,3,...
    }

    @Override
    public long getItemId(int i) {
        //where is primary key
        return persons.get(i).getPersonId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //How is the item's UI?
        //get from xml file
        //findviewbyId
        return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_list_item,viewGroup,false);
    }
}
