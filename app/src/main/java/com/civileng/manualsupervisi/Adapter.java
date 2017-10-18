package com.civileng.manualsupervisi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by fata on 10/18/2017.
 */

public class Adapter extends RecyclerView.Adapter<ListViewHolder> {

    private ArrayList<ListModel> arrayList;
    private LayoutInflater layoutInflater;
    private ListClickListener clickListener;

    public Adapter(ArrayList<ListModel> arrayList, LayoutInflater layoutInflater, ListClickListener clickListener) {
        this.arrayList = arrayList;
        this.layoutInflater = layoutInflater;
        this.clickListener = clickListener;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_list, parent, false);
        return new ListViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        holder.setView(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}