package com.afdal.myroompersistance.Room;

import android.app.Application;

import androidx.room.Room;

public class MyApp extends Application {

    public static final String DATABASE_NAME = "mahasiswa";

    public static AppDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class,DATABASE_NAME).allowMainThreadQueries().build();
    }
}
