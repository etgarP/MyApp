package com.example.myapp.database.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.myapp.TodoItem;

import java.util.List;

@Dao
public interface TodoDao {
    @Query("SELECT * FROM TodoItem")
    List<TodoItem> index();

    @Query("SELECT * FROM TodoItem WHERE id = :id")
    TodoItem get(int id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(TodoItem contact);

    @Delete
    void delete(TodoItem contact);

    @Transaction
    default void insertIfNotExists(TodoItem contact) {
        if (get(contact.getId()) == null) {
            insert(contact);
        }
    }
    @Query("DELETE FROM todoItem")
    void deleteAllData();
}