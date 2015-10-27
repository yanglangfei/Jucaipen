package com.ylf.jucaipen.jucaipen;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2015/10/27.
 */
public class CommAdapter  extends RecyclerView.Adapter<CommAdapter.MyHolder>{
    private final List<Communction> communctions;

    public CommAdapter(List<Communction> communctions) {
        this.communctions=communctions;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ui_commitem,null);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder myHolder, int i) {
      ImageView userLogo= (ImageView) myHolder.itemView.findViewById(R.id.userLogo);
        TextView userName= (TextView) myHolder.itemView.findViewById(R.id.userName);
        TextView time= (TextView) myHolder.itemView.findViewById(R.id.time);
        TextView tv_content= (TextView) myHolder.itemView.findViewById(R.id.tv_content);
        userName.setText(communctions.get(i).getUserName());
        time.setText(communctions.get(i).getTime());
        tv_content.setText(communctions.get(i).getContent());
    }

    @Override
    public int getItemCount() {
        return communctions.size();
    }

    public class MyHolder extends  RecyclerView.ViewHolder{
        private  View itemView;
        public MyHolder(View itemView) {
            super(itemView);
            this.itemView=itemView;
        }
    }
}
