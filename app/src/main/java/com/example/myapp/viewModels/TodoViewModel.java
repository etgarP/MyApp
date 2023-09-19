package com.example.myapp.viewModels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapp.TodoItem;

import java.util.List;

public class TodoViewModel extends ViewModel {
//    private ContactsRepository mRepository;
    private LiveData<List<TodoItem>> todoItems;
    public TodoViewModel(Context context, String url) {
//        mRepository = new ContactsRepository(context, url);
//        contacts = mRepository.getAll();
    }
    // get the contacts
    public LiveData<List<TodoItem>> get() {
        return todoItems;
    }
    // reloads the contacts
//    public void reload() { mRepository.reload(); }
}