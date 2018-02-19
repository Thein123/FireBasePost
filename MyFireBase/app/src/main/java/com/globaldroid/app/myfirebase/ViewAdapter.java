package com.globaldroid.app.myfirebase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {


    Context context;
    List<StatusData> statusFeed;

    public ViewAdapter(Context context, List<StatusData> tempList) {

        this.statusFeed = tempList;

        this.context = context;

    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.status_style, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        StatusData statusData = statusFeed.get(position);

        holder.tvstatus.setText(statusData.mystatus);



    }

    @Override
    public int getItemCount() {

        return statusFeed.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvstatus;

        public ViewHolder(View itemView) {

            super(itemView);

            tvstatus = (TextView) itemView.findViewById(R.id.status_text);


        }
    }
}
