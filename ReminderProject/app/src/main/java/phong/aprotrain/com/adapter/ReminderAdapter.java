package phong.aprotrain.com.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import phong.aprotrain.com.activities.EditActivity;
import phong.aprotrain.com.activities.InsertReminderActivity;
import phong.aprotrain.com.activities.MainActivity;
import phong.aprotrain.com.R;
import phong.aprotrain.com.model.Reminder;

public class ReminderAdapter extends ArrayAdapter<Reminder> {
    private ArrayList<Reminder> reminders;
    private Context context;
    private Button button;

    public void setReminders(ArrayList<Reminder> reminders) {
        this.reminders = reminders;
    }

    public ReminderAdapter(Context context, ArrayList<Reminder> reminders) {
        super(context, 0, reminders);
//        this.context = context;
//        this.reminders = reminders;
    }

    public ArrayList<Reminder> getReminders() {
        return reminders;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Reminder selectedReminder = getItem(position);
//        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
//        }
        TextView textNoiDung = (TextView) view.findViewById(R.id.textNoiDung);
        button = (Button) view.findViewById(R.id.btnOption);

        textNoiDung.setText(selectedReminder.getNoidung());
        if(selectedReminder.isQuantrong() == true){
            button.setBackgroundColor(Color.rgb(0, 255, 0));
        }else{
            button.setBackgroundColor(Color.rgb(255, 0, 0));
        }

        button.setOnClickListener((View viewButton) -> {
            PopupMenu popupMenu = new PopupMenu(getContext(), button);
            // Inflating popup menu from popup_menu.xml file
            popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    // Toast message on menu item clicked
//                    Toast.makeText(getContext(), "You Clicked " + position, Toast.LENGTH_SHORT).show();
//                    menuItemClicked(menuItem, position);
                    Intent intent = new Intent(
                            getContext(),
                            EditActivity.class);
                    intent.putExtra("selectedReminder", selectedReminder);
                    intent.putExtra("position", position);
                    getContext().startActivity(intent);
//
                    return true;
                }
            });
            // Showing the popup menu
            popupMenu.show();
        });




        return view;
    }

    // When user click on Menu Item.
    // @return true if event was handled.
    private boolean menuItemClicked(MenuItem item, int position) {
        switch (item.getItemId()) {
            case R.id.optionEdit:
                Toast.makeText(getContext(), "Bookmark", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(),EditActivity.class);

                getContext().startActivity(intent);
                //MainActivity.onEditViewReminder(position);
                break;
            case R.id.deleteReminder:
                Toast.makeText(getContext(), "Upload", Toast.LENGTH_SHORT).show();
                //MainActivity.onRemoveReminder(position);
                Intent intentRemove = new Intent(getContext(),MainActivity.class);
                getContext().startActivity(intentRemove);
                break;
            default:
                Toast.makeText(getContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }


}
