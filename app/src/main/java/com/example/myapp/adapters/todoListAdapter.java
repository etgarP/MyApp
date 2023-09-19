package com.example.myapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;
import com.example.myapp.TodoItem;

import java.util.List;

public class todoListAdapter extends RecyclerView.Adapter<todoListAdapter.TodoViewHolder>{
    private final LayoutInflater mInflater;
    private List<TodoItem> todoItems;
    private Context context;
    public todoListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    // holds the contact view
    class TodoViewHolder extends RecyclerView.ViewHolder {
        private final CheckBox checkBox;
        private final LinearLayout linearLayout;
        private TodoItem todoItem;
        // saves all the elements
        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.todoLayout);
            checkBox = itemView.findViewById(R.id.todoCheckBox);
        }
    }

    // inflates the to do layout
    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.todo_item_layout, parent, false);
        return new TodoViewHolder(itemView);
    }
    // sets the details
    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position)  {
        if (todoItems != null) {
            final TodoItem current = todoItems.get(position);
            holder.checkBox.setText(current.getName());
            holder.linearLayout.setOnLongClickListener(v -> {
                // todo add here what to do on long press
                return false;
            });
        }
    }

    @Override
    public int getItemCount() {
        if (todoItems != null) {
            return todoItems.size();
        }
        else return 0;
    }

    // set TodoItems
    public void setTodoItems(List<TodoItem> s) {
        todoItems = s;
        notifyDataSetChanged();
    }
}
