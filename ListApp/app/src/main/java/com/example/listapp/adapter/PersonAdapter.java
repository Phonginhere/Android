package com.example.listapp.adapter;

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
        view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.person_list, viewGroup, false);
        TextView textViewId = view.findViewById(R.id.textViewId);
        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewAge = view.findViewById(R.id.textViewAge);
        TextView textViewOccupation = view.findViewById(R.id.textViewOccupation);
        //fetch data
        Person selectedPerson = people.get(i);
        textViewId.setText(String.valueOf(selectedPerson.getPersonId()));
        textViewName.setText(selectedPerson.getPersonName());
        textViewAge.setText(String.valueOf(selectedPerson.getAge()));
        textViewOccupation.setText(selectedPerson.getOccupation());

        return view;
    }




    protected FilterResults  filter(String charText) {
        if(charText != null){
            String filterString = charText.toString().toLowerCase();
            final ArrayList<Person> nlist = new ArrayList<Person>(count);
            int count = people.size();
            Person filterablePerson;

            for (int i = 0; i < count; i++) {
                filterablePerson = people.get(i);
                if (filterablePerson.getPersonName().toLowerCase().contains(filterString)
                        || filterablePerson.getPersonId() == Integer.parseInt(filterString)
                        || filterablePerson.getAge() == Integer.parseInt(filterString)
                        || filterablePerson.getOccupation().toLowerCase().contains(filterString)){
                    nlist.add(filterablePerson);
                }
            }
            results.values = nlist;
            results.count = nlist.size();
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String filterString = constraint.toString().toLowerCase();

                FilterResults results = new FilterResults();

                final List<String> list = originalData;

                int count = list.size();
                final ArrayList<String> nlist = new ArrayList<String>(count);

                String filterableString ;

                for (int i = 0; i < count; i++) {
                    filterableString = list.get(i);
                    if (filterableString.toLowerCase().contains(filterString)) {
                        nlist.add(filterableString);
                    }
                }

                results.values = nlist;
                results.count = nlist.size();

                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredData = (ArrayList<String>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}
