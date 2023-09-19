package com.example.myapp.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapp.TodoItem;

import java.util.List;

public class TodoRepository {
//    private ContactDao dao;
    private TodoListData contactListData;

    public TodoRepository(Context context, String url) {
//        AppDB db = Room.databaseBuilder(context,
//                        AppDB.class, "ContactsDB")
//                .build();
//        dao = db.contactDao();
        contactListData = new TodoListData();
    }
    // saves the live data of the contacts
    class TodoListData extends MutableLiveData<List<TodoItem>> {
        /// gets the contacts from the dao
        public TodoListData() {
            super();
            new Thread(() -> {
//                List<TodoItem> contactList = dao.index();
//                postValue(contactList);
            }).start();
        }
    }
    // returns the live data
    public LiveData<List<TodoItem>> getAll() {
        return contactListData;
    }
}