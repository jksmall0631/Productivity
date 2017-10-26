package jksmall.productivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import jksmall.productivity.database.DatabaseContract.DatabaseEntry;
import jksmall.productivity.database.DatabaseHelper;

public class NewTaskActivity extends AppCompatActivity {

    Button btnCreate;
    EditText editTextTitle;
    EditText editTextNotes;
    EditText editTextTime;
    ToggleButton toggleMon;
    ToggleButton toggleTue;
    ToggleButton toggleWed;
    ToggleButton toggleThu;
    ToggleButton toggleFri;
    ToggleButton toggleSat;
    ToggleButton toggleSun;
    Switch switchLock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        editTextTitle = (EditText) findViewById(R.id.editText4);
        editTextNotes = (EditText) findViewById(R.id.editText6);
        editTextTime = (EditText) findViewById(R.id.editText3);
        toggleMon = (ToggleButton) findViewById(R.id.button3);
        toggleTue = (ToggleButton) findViewById(R.id.button4);
        toggleWed = (ToggleButton) findViewById(R.id.button5);
        toggleThu = (ToggleButton) findViewById(R.id.button6);
        toggleFri = (ToggleButton) findViewById(R.id.button7);
        toggleSat = (ToggleButton) findViewById(R.id.button8);
        toggleSun = (ToggleButton) findViewById(R.id.button2);
        switchLock = (Switch) findViewById(R.id.switch1);

        final DatabaseHelper db = new DatabaseHelper(this);

        btnCreate = (Button) findViewById(R.id.buttonCreate);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DatabaseEntry entry = new DatabaseEntry();

                entry.title = editTextTitle.getText().toString();
                entry.notes = editTextNotes.getText().toString();
                entry.time = editTextTime.getText().toString();
                entry.mon = toggleMon.isChecked() ? 1 : 0;
                entry.tue = toggleTue.isChecked() ? 1 : 0;
                entry.wed = toggleWed.isChecked() ? 1 : 0;
                entry.thu = toggleThu.isChecked() ? 1 : 0;
                entry.fri = toggleFri.isChecked() ? 1 : 0;
                entry.sat = toggleSat.isChecked() ? 1 : 0;
                entry.sun = toggleSun.isChecked() ? 1 : 0;
                entry.lock = switchLock.isChecked() ? 1 : 0;

                db.addEntry(entry);

                Toast.makeText(NewTaskActivity.this, "New Event Created",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
