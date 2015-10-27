package com.ylf.jucaipen.jucaipen;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2015/10/27.
 */
public class TodayIdeaAdapter extends RecyclerView.Adapter<TodayIdeaAdapter.Holder>{


    private final List<TodayIdea> ideas;

    public TodayIdeaAdapter(List<TodayIdea> ideas) {
        this.ideas=ideas;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ui_todayitem,null);
        Holder holder=new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int i) {
        TextView date= (TextView) holder.view.findViewById(R.id.today_date);
        TextView ideaContent= (TextView) holder.view.findViewById(R.id.ideaContent);
        date.setText(ideas.get(i).getTime());
        ideaContent.setText(ideas.get(i).getContent());
    }

    @Override
    public int getItemCount() {
        return ideas.size();
    }

    public class Holder extends  RecyclerView.ViewHolder{
        private  View view;
        public Holder(View view) {
            super(view);
            this.view=view;
        }
    }
}
