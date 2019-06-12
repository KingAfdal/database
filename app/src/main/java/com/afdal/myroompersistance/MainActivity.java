package com.afdal.myroompersistance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.afdal.myroompersistance.Room.Mahasiswa;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;

import static com.afdal.myroompersistance.Room.MyApp.db;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etName)
    EditText etName;
    @BindView(R.id.etNim)
    EditText etNim;
    @BindView(R.id.etMajor)
    EditText etMajor;
    @BindView(R.id.etYear)
    EditText etYear;

    Mahasiswa mahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Stetho.initializeWithDefaults(this);
        new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
    }

    @OnClick(R.id.btInsert)
    void buttonListener(){
        if (!etName.getText().toString().isEmpty()&&!etNim.getText().toString().isEmpty()&&!etMajor
                .getText().toString().isEmpty()&&!etYear.getText().toString().isEmpty()){
            mahasiswa = new Mahasiswa();
            mahasiswa.setName(etName.getText().toString());
            mahasiswa.setMajor(etMajor.getText().toString());
            mahasiswa.setNim(etNim.getText().toString());
            mahasiswa.setYear(etYear.getText().toString());

            db.userDao().insertAll(mahasiswa);
            startActivity(new Intent(MainActivity.this, DetailActivity.class));
        }else {
            Toast.makeText(this, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }
    }
}
