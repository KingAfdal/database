package com.afdal.myroompersistance.Room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Mahasiswa {
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name = "year")
    String year;
    @ColumnInfo(name = "name")
    String name;
    @ColumnInfo(name = "nim")
    String nim;
    @ColumnInfo(name = "major")
    String major;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
