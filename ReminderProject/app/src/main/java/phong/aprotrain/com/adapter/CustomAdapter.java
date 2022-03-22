package phong.aprotrain.com.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import phong.aprotrain.com.R;
import phong.aprotrain.com.model.Reminder;

public class CustomAdapter extends ArrayAdapter<Reminder> {
    private ArrayList<Reminder> reminders;
    private Context context;

    public CustomAdapter(Context context, ArrayList<Reminder> reminders) {
        super(context, 0, reminders);
//        this.context = context;
//        this.reminders = reminders;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Reminder selectedReminder = getItem(position);
//        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
//        }
        TextView textNoiDung = (TextView) view.findViewById(R.id.textNoiDung);
        Button button = (Button) view.findViewById(R.id.button);

        textNoiDung.setText(selectedReminder.getNoidung());
        if(selectedReminder.isQuantrong() == true){
            button.setBackgroundColor(Color.rgb(0, 255, 0));
        }else{
            button.setBackgroundColor(Color.rgb(255, 0, 0));
        }
        return view;
    }
}
