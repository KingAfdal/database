package com.afdal.myroompersistance.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.*;

@Dao
public interface MahasiswaDao {

    @Query("SELECT * FROM mahasiswa")
    List<Mahasiswa> getAll();

    @Query("SELECT * FROM mahasiswa WHERE name LIKE :nama ")
    Mahasiswa findByName(String nama);

    @Insert
    void insertAll(Mahasiswa mahasiswa);

    @Delete
    public void deleteUsers(Mahasiswa users);

    @Update
    public void update(Mahasiswa mahasiswa);
}

