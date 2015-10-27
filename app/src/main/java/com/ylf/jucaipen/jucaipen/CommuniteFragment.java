package com.ylf.jucaipen.jucaipen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/27.
 */
public class CommuniteFragment  extends Fragment{
    private  View view;
    private RecyclerView comm_rv;
    private  CommAdapter adaper;
    private List<Communction> communctions=new ArrayList<Communction>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.ui_comm,container,false);
        initView();
        initData();
        return view;
    }

    private void initData() {
        communctions.add(new Communction("111",1,"张三","10:10","我在这儿"));
        communctions.add(new Communction("111",2,"李四","10:30","谁在这儿"));
        communctions.add(new Communction("111",3,"王五","10:40","不在这儿"));
        adaper.notifyDataSetChanged();
    }

    private void initView() {
        comm_rv= (RecyclerView) view.findViewById(R.id.comm_rv);
        LinearLayoutManager lm=new LinearLayoutManager(getActivity());
        comm_rv.setLayoutManager(lm);
        adaper=new CommAdapter(communctions);
        comm_rv.setAdapter(adaper);

    }
}
