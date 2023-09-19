package com.example.myapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class TodoItem {
    @SerializedName("name")
    private String name;
    @SerializedName("category")
    private String category;
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    private int id;

    public TodoItem(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
