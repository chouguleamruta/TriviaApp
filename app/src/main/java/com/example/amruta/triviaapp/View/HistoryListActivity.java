package com.example.amruta.triviaapp.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.amruta.triviaapp.Contoller.DbHelper;
import com.example.amruta.triviaapp.Model.Adapter.CustermerAdapter;
import com.example.amruta.triviaapp.Model.History;
import com.example.amruta.triviaapp.R;

public class HistoryListActivity extends AppCompatActivity {
    public static final String TAG = "HistoryListActivity";
    private RecyclerView recyclerView;
    private DbHelper dbAdapter;
    private CustermerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_list);
        getSupportActionBar().setTitle("History");
        init();
        getList();
    }

    private void getList() {
        Bundle b = getIntent().getExtras();
        String hname = b.getString("HNAME");
        Log.d("TAG", "hname:----" + hname);
        String hquees1 = b.getString("HQUES1");
        Log.d("TAG", "hname:----" + hquees1);
        String hans1 = b.getString("HANS1");
        Log.d("TAG", "hname:----" + hans1);
        String hques2 = b.getString("HQUES2");
        Log.d("TAG", "hname:----" + hques2);
        String hans2 = b.getString("HANS2");
        Log.d("TAG", "hname:----" + hans2);

        //create history
        History history = new History(hname, hquees1, hans1, hques2, hans2);
        dbAdapter = new DbHelper(this);
        dbAdapter.addHistory(history);
        //send list to the adapter
        adapter = new CustermerAdapter(this, dbAdapter.getAllHistory());
        //attach adapter & list to the recycleview
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void init() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

    }
}
