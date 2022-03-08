package com.example.listapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.listapp.R;
import com.example.listapp.models.Person;

import java.util.List;

public class PersonAdapter extends BaseAdapter {
    private List<Person> people;

    public PersonAdapter(List<Person> people) {
        super(); // gọi base Adapter
        this.people = people;
    }

    @Override
    public int getCount(){
        return people.size();
    }

    @Override
    public Object getItem(int i){
        return people.get(i);
    }

    @Override
    public long getItemId(int i){
        return people.get(i).getPersonId();
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_list,viewGroup);
        return view;
    }
}
