package com.civileng.manualsupervisi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by fata on 10/18/2017.
 */

public class ContentFragment extends Fragment {

    private TextView divisi;
    private RecyclerView recyclerView;
    private TextView textHtml;
    private ListModel listModel;

    public void setListModel(ListModel listModel) {
        this.listModel = listModel;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        divisi = (TextView)view.findViewById(R.id.main_divisi);
        recyclerView = (RecyclerView)view.findViewById(R.id.main_recyclerview);
        textHtml = (TextView)view.findViewById(R.id.main_html);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        switch (listModel.getTipe()) {
            case "list" :
                textHtml.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                divisi.setVisibility(View.VISIBLE);
                divisi.setText(listModel.getTitle());
                populateList(listModel.getId());
                break;
            case "page" :
                divisi.setVisibility(View.GONE);
                recyclerView.setVisibility(View.GONE);
                textHtml.setVisibility(View.VISIBLE);
                int stringId = this.getResources().getIdentifier(listModel.getId(), "string", getActivity().getPackageName());
                textHtml.setText(Html.fromHtml(getString(stringId)));
                break;
            default:
                break;
        }
        return view;
    }

    private void populateList(String id) {
        DatabaseReference listRef = FirebaseDatabase.getInstance().getReference().child("list_menu").child(id);
        listRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<ListModel> arrayList = new ArrayList<ListModel>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    ListModel listModel = dataSnapshot1.getValue(ListModel.class);
                    arrayList.add(listModel);
                }
                Adapter adapter = new Adapter(arrayList, getLayoutInflater(), new ListClickListener() {
                    @Override
                    public void onClick(ListModel model) {
                        ((MainActivity)getActivity()).updateUI(model);
                    }
                });
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
