package phong.aprotrain.com.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import phong.aprotrain.com.model.Reminder;

public class customAdapter extends ArrayAdapter<Reminder> {

    public customAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public customAdapter(@NonNull Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public customAdapter(@NonNull Context context, int resource, @NonNull Reminder[] objects) {
        super(context, resource, objects);
    }

    public customAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull Reminder[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public customAdapter(@NonNull Context context, int resource, @NonNull List<Reminder> objects) {
        super(context, resource, objects);
    }

    public customAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<Reminder> objects) {
        super(context, resource, textViewResourceId, objects);
    }
}
