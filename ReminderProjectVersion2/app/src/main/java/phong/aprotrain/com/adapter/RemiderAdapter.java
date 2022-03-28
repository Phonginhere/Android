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
import androidx.annotation.Nullable;

import java.util.ArrayList;

import phong.aprotrain.com.R;
import phong.aprotrain.com.model.Reminder;

public class RemiderAdapter extends ArrayAdapter<Reminder> {
    private ArrayList<Reminder> reminders;
    private Context context;
    private Button button;

    public void setReminders(ArrayList<Reminder> reminders){ this.reminders = reminders}

    public RemiderAdapter(Context context, ArrayList<Reminder> reminders) {
            super(context, 0, reminders);
    }
    public ArrayList<Reminder> getReminders(){return reminders;}

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        Reminder selectedReminder = getItem(position);
        view = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        TextView textViewName = (TextView) view.findViewById(R.id.textViewName);
        TextView textViewDateTime = (TextView) view.findViewById(R.id.textViewDateTime);
        View ViewImportant = (View) view.findViewById(R.id.ViewImportant);

        if(selectedReminder.isQuantrong() == true){
            ViewImportant.setBackgroundColor(Color.rgb(0, 255, 0));
        }else{
            ViewImportant.setBackgroundColor(Color.rgb(0, 255, 0));
        }

        return super.getView(position, view, parent);
    }
}
