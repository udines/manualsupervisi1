package com.civileng.manualsupervisi;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView divisi;
    private RecyclerView recyclerView;
    private TextView textHtml;
    private String prevTipe, prevDiv, prevId;
    private String nextTipe, nextDiv, nextId;
    private FrameLayout layout;

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

        layout = (FrameLayout)findViewById(R.id.main_content);

        ImageButton homeButton = (ImageButton)findViewById(R.id.main_home);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavUtils.navigateUpTo(MainActivity.this, new Intent(getApplicationContext(), StartActivity.class));
            }
        });
        ImageButton backButton = (ImageButton)findViewById(R.id.main_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                updateUI(prevTipe, prevDiv, prevId);
                onBackPressed();
            }
        });

//        divisi = (TextView)findViewById(R.id.main_divisi);
//        recyclerView = (RecyclerView)findViewById(R.id.main_recyclerview);
//        recyclerView.setNestedScrollingEnabled(false);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//        textHtml = (TextView)findViewById(R.id.main_html);
//        textHtml.setVisibility(View.GONE);

//        populateList("list");
//        updateUI("list", "Panduan Penanganan\nnRehabilitasi dan Rekonstruksi", "main");
        ListModel model = new ListModel("main", "list", "Panduan Penanganan\nRehabilitasi dan Rekonstruksi", "");
        updateUI(model);

        /*DatabaseReference listRef = FirebaseDatabase.getInstance().getReference().child("list_menu").child("10C");
        ListModel listModel;
        listModel = new ListModel("10C1", "10.1. Biaya inisial", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("10C2", "10.2. Ekivalen biaya tahunan seragam (EUAC)", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("10C3", "10.3. EUAC per meter persegi perkerasan", "");
        listRef.push().setValue(listModel);*/

        /*listModel = new ListModel("7C1", "7.1. Kondisi umum", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("7C2", "7.2. Analisis variasi nilai indeks kerusakan atau indeks kondisi", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("7C3", "7.3. Evaluasi jenis dan tingkat kerusakan", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("7C4", "7.4. Evaluasi kapasitas struktural perkerasan", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("7C5", "7.5. Pengecekan penanganan sebelumnya", "");
        listRef.push().setValue(listModel);*/

        /*listModel = new ListModel("6C1", "6.1. Sejarah konstruksi dan pemeliharaan jalan", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("6C2", "6.2. Pembebanan lalu lintas", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("6C3", "6.3. Kondisi kerusakan perkerasan", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("6C4", "6.4. Drainase", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("6C5", "6.5. Pengujian non-destruktif", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("6C6", "6.6. Pengujian destruktif", "");
        listRef.push().setValue(listModel);
        listModel = new ListModel("6C7", "6.7. Ketidakrataan dan tahanan gelincir", "");
        listRef.push().setValue(listModel);*/

        /*listModel = new ListModel("pengantar", "Pengantar", "");
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

    public void updateUI(ListModel listModel) {
        ContentFragment fragment = new ContentFragment();
        fragment.setListModel(listModel);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_content, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    /*private void updateUI(String tipe, String div, String id) {
        switch (tipe) {
            case "list" :
                textHtml.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                divisi.setVisibility(View.VISIBLE);
                divisi.setText(div);
                populateList(id);
                break;
            case "page" :
                divisi.setVisibility(View.GONE);
                recyclerView.setVisibility(View.GONE);
                textHtml.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
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
                        if (model.getId().equals("pengantar")) {
                            divisi.setVisibility(View.GONE);
                            recyclerView.setVisibility(View.GONE);
                            textHtml.setText(Html.fromHtml(getString(R.string.pengantar_html)));
                            textHtml.setVisibility(View.VISIBLE);
                        } else {
                            updateUI(model.getTipe(), model.getTitle(), model.getId());
                        }
                    }
                });
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
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
    }*/
}
