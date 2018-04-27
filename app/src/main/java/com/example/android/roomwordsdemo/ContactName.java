package com.example.android.roomwordsdemo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

@Entity(tableName = "contactName")
public class ContactName {

    public ContactName( int keyId, String name) {
        this.keyId = keyId;
        this.name = name;
    }

    @PrimaryKey
    private int keyId;


    @ColumnInfo(name = "name")
    private String name;


    public int getKeyId() {
        return keyId;
    }

    public String getName() {
        return name;
    }
}
