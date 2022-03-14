package com.example.listapp.adapter;

import android.content.Context;
import android.provider.Contacts;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.listapp.R;
import com.example.listapp.models.Person;

import org.w3c.dom.Text;

import java.io.FilterReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class PersonAdapter extends BaseAdapter implements Filterable {
    private List<Person> people;
    private List<Person> filteredPeople;
    private Context context;

    public PersonAdapter(List<Person> people, Context context) {
        this.filteredPeople = people;
        this.people = people;
        this.context = context;
    }

    @Override
    public int getCount() {
        return filteredPeople.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.person_list, parent, false);
        TextView textViewId = view.findViewById(R.id.textViewId);
        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewAge = view.findViewById(R.id.textViewAge);
        TextView textViewOccupation = view.findViewById(R.id.textViewOccupation);
        //fetch data

        textViewId.setText(String.valueOf(filteredPeople.get(i).getPersonId()));
        textViewName.setText(filteredPeople.get(i).getPersonName());
        textViewAge.setText(String.valueOf(filteredPeople.get(i).getAge()));
        textViewOccupation.setText(filteredPeople.get(i).getOccupation());

//        Person selectedPerson = people.get(i);
//        textViewId.setText(String.valueOf(selectedPerson.getPersonId()));
//        textViewName.setText(selectedPerson.getPersonName());
//        textViewAge.setText(String.valueOf(selectedPerson.getAge()));
//        textViewOccupation.setText(selectedPerson.getOccupation());

        return view;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();

                if (charSequence == null || charSequence.length() == 0) {
                    filterResults.count = people.size();
                    filterResults.values = people;

                } else {
                    String searchStr = charSequence.toString().toLowerCase();
                    List<Person> resultData = new ArrayList<>();

                    for (Person p : people) {
                        if (p.getPersonName().toLowerCase().contains(searchStr)
                                || p.getPersonId() == Integer.parseInt(String.valueOf(searchStr))
                                || p.getOccupation().toLowerCase().contains(searchStr)
                                || p.getAge() == Integer.parseInt(String.valueOf(searchStr))) {
                            resultData.add(p);
                        }
                        filterResults.count = resultData.size();
                        filterResults.values = resultData;
                    }
                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredPeople = (ArrayList<Person>) filterResults.values;
                notifyDataSetChanged();
            }
        };
        return filter;
    }
}
