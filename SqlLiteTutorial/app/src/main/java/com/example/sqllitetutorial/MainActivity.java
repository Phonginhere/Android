package com.example.sqllitetutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.sqllitetutorial.db.DatabaseHelper;
import com.example.sqllitetutorial.model.Customer;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    // references to buttons and other controls on the layout
    private Button btnViewAll, btnAdd;
    private EditText etAge, etName;
    private Switch swActive;
    private ListView lvCustomerList;
    private ArrayAdapter customerArrayAdapter;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        btnViewAll = findViewById(R.id.btnViewAll);
        etAge = findViewById(R.id.etAge);
        etName = findViewById(R.id.etName);
        swActive = findViewById(R.id.swActive);
        lvCustomerList = findViewById(R.id.lvCustomerList);

        databaseHelper = new DatabaseHelper(MainActivity.this);

        showCustomerOnListView(databaseHelper);

        //button listeners for the add and view all buttonsX

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Customer customer;
                try{
                    customer = new Customer(-1, etName.getText().toString(), Integer.parseInt(etAge.getText().toString()), swActive.isChecked());
                    //Toast.makeText(MainActivity.this, customer.toString(), Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    //Toast.makeText(MainActivity.this, "Error Creating ...", Toast.LENGTH_SHORT).show();
                    customer = new Customer(-1, "error", 0, false);
                }
                DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
                boolean success = databaseHelper.addOne(customer);
                Toast.makeText(MainActivity.this, "Is it ok?: "+success, Toast.LENGTH_SHORT).show();
                showCustomerOnListView(databaseHelper);
            }
        });

        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
//                List<Customer> customers = databaseHelper.getEveryOne();

                showCustomerOnListView(databaseHelper);


            }
        });
        lvCustomerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Customer clickedCustomer = (Customer) parent.getItemAtPosition(i);
                databaseHelper.deleteOne(clickedCustomer);
                showCustomerOnListView(databaseHelper);
                Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void showCustomerOnListView(DatabaseHelper databaseHelper2) {
        customerArrayAdapter = new ArrayAdapter<Customer>(MainActivity.this, android.R.layout.simple_list_item_1, databaseHelper2.getEveryOne());
        lvCustomerList.setAdapter(customerArrayAdapter);
    }
}