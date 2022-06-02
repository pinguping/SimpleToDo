package sg.edu.rp.c346.id21024120.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button btnAdd, btnClear, btnDelete;
    ListView lvTasks;
    Spinner spn;
    ArrayList<String> alTasks;
    ArrayAdapter<String> aaTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.editText);
        btnAdd = findViewById(R.id.buttonAdd);
        btnClear = findViewById(R.id.buttonClear);
        lvTasks = findViewById(R.id.listViewTasks);
        spn = findViewById(R.id.spinner);
        btnDelete = findViewById(R.id.buttonDelete);

        alTasks = new ArrayList<>();

        aaTasks = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, alTasks);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tasks = et.getText().toString();
                alTasks.add(tasks);
                aaTasks.notifyDataSetChanged();
                et.setText(null);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alTasks.clear();
                aaTasks.notifyDataSetChanged();
                et.setText(null);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(et.getText().toString());
                aaTasks.notifyDataSetChanged();
                et.setText(null);
            }
        });

        lvTasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String colour = alTasks.get(position);
                Toast.makeText(MainActivity.this, "" + alTasks.get(position), Toast.LENGTH_SHORT).show();
                Log.d("LV click", colour);
            }
        });

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        et.setText("Type in a new task here");
                        et.setInputType(1);
                        btnAdd.setEnabled(true);
                        btnDelete.setEnabled(false);
                        break;
                    case 1:
                        et.setText("Type in the index of the task to be removed");
                        et.setInputType(2);
                        btnAdd.setEnabled(false);
                        btnDelete.setEnabled(true);
                        break;
                }
            }

    }
}