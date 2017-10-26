package jksmall.productivity;

import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import jksmall.productivity.database.DatabaseHelper;

public class EntriesActivity extends ListActivity {

    DatabaseHelper db = new DatabaseHelper(this);

    ArrayList<HashMap<String, String>> entriesList =  db.getEntries();
        ListView lv = getListView();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                student_Id = (TextView) view.findViewById(R.id.student_Id);
                String studentId = student_Id.getText().toString();
                Intent objIndent = new Intent(getApplicationContext(),StudentDetail.class);
                objIndent.putExtra("student_Id", Integer.parseInt( studentId));
                startActivity(objIndent);
            }
        });
        ListAdapter adapter = new SimpleAdapter( MainActivity.this,studentList, R.layout.view_student_entry, new String[] { "id","name"}, new int[] {R.id.student_Id, R.id.student_name});
        setListAdapter(adapter);
}
