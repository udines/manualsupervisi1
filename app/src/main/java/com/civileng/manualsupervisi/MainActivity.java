package com.civileng.manualsupervisi;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView divisi;
    private RecyclerView recyclerView;
    private TextView textHtml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
            if (getSupportActionBar() != null) {
                getSupportActionBar().hide();
            }
        }*/
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageButton homeButton = (ImageButton)findViewById(R.id.main_home);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        ImageButton backButton = (ImageButton)findViewById(R.id.main_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                divisi.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.VISIBLE);
                textHtml.setVisibility(View.GONE);
            }
        });

        divisi = (TextView)findViewById(R.id.main_divisi);
        recyclerView = (RecyclerView)findViewById(R.id.main_recyclerview);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        textHtml = (TextView)findViewById(R.id.main_html);
        textHtml.setVisibility(View.GONE);


        DatabaseReference listRef = FirebaseDatabase.getInstance().getReference().child("list");
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
                    public void onClick(String id) {
                        if (id.equals("pengantar")) {
                            divisi.setVisibility(View.GONE);
                            recyclerView.setVisibility(View.GONE);
                            textHtml.setText(Html.fromHtml(getString(R.string.pengantar_html)));
                            textHtml.setVisibility(View.VISIBLE);
                        }
                    }
                });
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        /*ListModel listModel;
        listModel = new ListModel("pengantar", "Pengantar", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("1", "1. Ruang Lingkup", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("2", "2. Acuan Normatif", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("3", "3. Istilah dan Definisi", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("4", "4. Ketentuan Umum", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("5", "5. Pendekatan Penanganan Rehabilitasi dan Rekonstruksi", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("6", "6. Kebutuhan Data", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("7", "7. Evaluasi Kondisi Perkerasan", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("8", "8. Pengembangan Alternatif Strategi Penanganan", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("9", "9. Desain Teknis", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("10", "10. Analisis Biaya Siklus Hidup", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("11", "11. Pengusulan Strategi Penanganan", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("L1", "Lampiran 1", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("L2", "Lampiran 2", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("L3", "Lampiran 3", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("L4", "Lampiran 4", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("L5", "Lampiran 5", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("L6", "Lampiran 6", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("L7", "Lampiran 7", "");
        listRef.push().setValue(listModel);*/

    }

    private class Adapter extends RecyclerView.Adapter<ListViewHolder> {

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
}
