package com.afdal.myroompersistance.Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Mahasiswa.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MahasiswaDao userDao();
}
