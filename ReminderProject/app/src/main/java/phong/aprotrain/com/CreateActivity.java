package phong.aprotrain.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textViewValidate;
    private Button buttonStatus;
    private Button buttonCancel;
    private Button buttonCommit;
    private String textStatus;
    private Boolean isValidInput;

    private String errorText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_view);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));

        //ánh xạ
        editText = (EditText) findViewById(R.id.editText);
        buttonStatus = (Button) findViewById(R.id.buttonStatus);
        buttonCancel = (Button) findViewById(R.id.buttonCancel);
        buttonCommit = (Button) findViewById(R.id.buttonCommit);
        textViewValidate = (TextView) findViewById(R.id.textViewValidate);


        //hoạt động của text: validate dữ liệu
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String text = editText.getText().toString().trim();
                isValidInput = (text.length() > 0);
                CreateActivity.this.errorText = isValidInput == true ? "" : "Text must not blank";
                buttonCommit.setEnabled(isValidInput);
                textViewValidate.setText(CreateActivity.this.errorText);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //hủy và back lại sang trang chính
        buttonCancel.setOnClickListener((View view) -> { //thuc thi click trong interface, on click la ban se lam gi do
            //show small alert
                    Intent createIntent = new Intent(CreateActivity.this, MainActivity.class);
                    startActivity(createIntent);
            });

        //chuyển thanh trạng thái
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

        //gửi
        buttonCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = buttonStatus.getText().toString();
                String text = editText.getText().toString().trim();
                String statusName = buttonStatus.getText().toString().trim();
                if(text != null){
                    if(s.contains("Important") ){
                        MainActivity.onCreateReminder(text, true);
                    }else if(s.contains("Unimportant") ) {
                        MainActivity.onCreateReminder(text, false);
                    }
                    Intent createIntent = new Intent(CreateActivity.this, MainActivity.class);
                    startActivity(createIntent);
                }

            }
        });
    }
}