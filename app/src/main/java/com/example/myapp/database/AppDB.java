package com.example.myapp.database;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.myapp.TodoItem;
import com.example.myapp.database.daos.TodoDao;

@Database(entities = {TodoItem.class}, version = 1)
//@TypeConverters({LastMessageTypeConverter.class, UserTypeConverter.class,
//        UserPassTypeConverter.class, DataConverter.class})

public abstract class AppDB extends RoomDatabase {
    public abstract TodoDao todoDao();
}