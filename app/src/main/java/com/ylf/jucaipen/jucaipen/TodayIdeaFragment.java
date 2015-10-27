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
public class TodayIdeaFragment  extends Fragment{
    private  View view;
    private RecyclerView recycleView;
    private  TodayIdeaAdapter adapter;
    private List<TodayIdea> ideas=new ArrayList<TodayIdea>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.ui_todayidea,container,false);
        initView();
        initData();
        return view;
    }

    private void initData() {
        ideas.add(new TodayIdea(1,"10:30","大脸爱凤姐"));
        ideas.add(new TodayIdea(2,"11:30","大脸去找凤姐"));
        ideas.add(new TodayIdea(3,"13:30","大脸喜欢凤姐"));
        adapter.notifyDataSetChanged();
    }

    private void initView() {
        recycleView= (RecyclerView) view.findViewById(R.id.recycleView);
        LinearLayoutManager lm=new LinearLayoutManager(getActivity());
        recycleView.setLayoutManager(lm);
        adapter=new TodayIdeaAdapter(ideas);
        recycleView.setAdapter(adapter);
    }
}
