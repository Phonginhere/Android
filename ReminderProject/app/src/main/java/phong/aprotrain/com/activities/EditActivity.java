package phong.aprotrain.com.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import phong.aprotrain.com.R;
import phong.aprotrain.com.model.Reminder;
import phong.aprotrain.com.repositories.IReminderRepository;
import phong.aprotrain.com.repositories.ReminderRepository;

public class EditActivity extends BaseActivity {

    private  EditText editText;
    private Button buttonCancel;
    private TextView textViewValidate;
    private  Button buttonStatus;
    private Button buttonCommit;
    private TextView textHiddenId;
    private String textStatus;
    private Boolean isValidInput;
    private Reminder selectedReminder;

    private String errorText = "";
    private  int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));


        editText = (EditText) findViewById(R.id.editText);
        buttonStatus = (Button) findViewById(R.id.buttonStatus);
        buttonCancel = (Button) findViewById(R.id.buttonCancel);
        buttonCommit = (Button) findViewById(R.id.buttonCommit);
        textViewValidate = (TextView) findViewById(R.id.textViewValidate);
        textHiddenId = (TextView) findViewById(R.id.textHiddenId);
        selectedReminder = (Reminder) getIntent().getSerializableExtra("selectedReminder");
        position = getIntent().getIntExtra("position", position);
        editText.setText(selectedReminder.getNoidung());
        buttonStatus.setText(selectedReminder.isQuantrong() == true ?
                "Important" : "Unimportant");

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String text = editText.getText().toString().trim();
                isValidInput = (text.length() > 0);
                EditActivity.this.errorText = isValidInput == true ? "" : "Text must not blank";
                buttonCommit.setEnabled(isValidInput);
                textViewValidate.setText(EditActivity.this.errorText);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        buttonCancel.setOnClickListener((View view) -> { //thuc thi click trong interface, on click la ban se lam gi do
            //show small alert
            Intent createIntent = new Intent(EditActivity.this, MainActivity.class);
            startActivity(createIntent);
        });

        buttonStatus.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = buttonStatus.getText().toString();
                if(s.contains("Important") ){
                    buttonStatus.setText("Unimportant");
                }else if(s.contains("Unimportant") ) {
                    buttonStatus.setText("Important");
                }
            }
        }));
        buttonCommit.setOnClickListener((View view) -> {
            Log.d("xx", "ddd");
            String status = buttonStatus.getText().toString();
            String noidung = editText.getText().toString().trim();
            if(noidung != null){
                Boolean newStatus = status.trim().toLowerCase().equals("important");
                selectedReminder.setQuantrong(newStatus);
                selectedReminder.setNoidung(noidung);
                reminderRepository.updateReminder(position, selectedReminder);
                //goback
                this.finish();
                //reload Main
            }

        });

    }


}