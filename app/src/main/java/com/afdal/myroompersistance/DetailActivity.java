package com.afdal.myroompersistance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.afdal.myroompersistance.RecycleAdapter;
import com.afdal.myroompersistance.Room.AppDatabase;
import com.afdal.myroompersistance.Room.Mahasiswa;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.afdal.myroompersistance.Room.MyApp.db;
import static com.afdal.myroompersistance.Room.MyApp.db;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.myRecyclerview)
    RecyclerView myRecyclerview;
    RecycleAdapter recycleAdapter;
    List<Mahasiswa> listMahasiswas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        fetchDataFromRoom();
        initRecyclerView();
        setAdapter();
    }

    private void fetchDataFromRoom() {
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "mahasiswa").allowMainThreadQueries().build();
        listMahasiswas = db.userDao().getAll();

        //just checking data from db
        for (int i = 0; i < listMahasiswas.size(); i++) {
            Log.e("Aplikasi", listMahasiswas.get(i).getYear() + i);
            Log.e("Aplikasi", listMahasiswas.get(i).getMajor() + i);
            Log.e("Aplikasi", listMahasiswas.get(i).getName() + i);
            Log.e("Aplikasi", listMahasiswas.get(i).getNim() + i);
        }
    }

    @SuppressLint("WrongConstant")
    private void initRecyclerView() {
        myRecyclerview.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        myRecyclerview.setLayoutManager(llm);
        recycleAdapter = new RecycleAdapter(this, listMahasiswas);
    }

    private void setAdapter() {
        myRecyclerview.setAdapter(recycleAdapter);
    }

    @OnClick(R.id.fab_add)
    void addItems() {
        startActivity(new Intent(DetailActivity.this, MainActivity.class));
    }
}
