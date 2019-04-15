package com.example.amruta.triviaapp.Model.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.amruta.triviaapp.View.HistoryListActivity;
import com.example.amruta.triviaapp.Model.History;
import com.example.amruta.triviaapp.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class CustermerAdapter extends RecyclerView.Adapter<CustermerAdapter.ViewHolder> {
    private List<History> allHistory;
    private Context context;
    private String name;

    public CustermerAdapter(HistoryListActivity historyListActivity, List<History> allHistory) {
        this.allHistory = allHistory;
        this.context = context;
    }

    @NonNull
    @Override
    public CustermerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustermerAdapter.ViewHolder viewHolder, int i) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aa");
        String datetime = dateformat.format(c.getTime());
        // set data on the holder
        viewHolder.tvtime.setText("GAME 1 :" + datetime);
        viewHolder.tvName.setText("Name :" + allHistory.get(i).getNAME());
        viewHolder.tvQS.setText(allHistory.get(i).getQUESTION1());
        viewHolder.tvAns.setText("Answer :" + allHistory.get(i).getANSWER1());
        viewHolder.tvQS1.setText(allHistory.get(i).getQUESTION2());
        viewHolder.tvAns1.setText("Answer :" + allHistory.get(i).getANSWER2());
    }

    @Override
    public int getItemCount() {
        //return originalValues.size();
        return allHistory.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvQS, tvName, tvAns, tvQS1, tvAns1, tvtime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvtime = (TextView) itemView.findViewById(R.id.txtRowTime);
            tvName = (TextView) itemView.findViewById(R.id.txtRowName);
            tvQS = (TextView) itemView.findViewById(R.id.txtRowQue);
            tvAns = (TextView) itemView.findViewById(R.id.txtRowAnswer);
            tvQS1 = (TextView) itemView.findViewById(R.id.txtRowQue1);
            tvAns1 = (TextView) itemView.findViewById(R.id.txtRowAns1);
        }
    }
}
