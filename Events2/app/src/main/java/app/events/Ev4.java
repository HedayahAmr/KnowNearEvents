package app.events;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Ev4 extends AppCompatActivity {
    ListView mListView;
    DatabaseHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_ev4);
        mListView = (ListView)findViewById(R.id.listView);
        myDB = new DatabaseHelper(this);
        ListView();
    }
    public void ListView()
    {
        Cursor res = myDB.getAllRecords();
        ArrayList<String> listData = new ArrayList<>();

        while(res.moveToNext())
        {
         listData.add(res.getString(0));
            listData.add(res.getString(1));
            listData.add(res.getString(2));
            listData.add(res.getString(3));
            listData.add(res.getString(4));
        }
        ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listData);
        mListView.setAdapter(listAdapter);
    }
}
