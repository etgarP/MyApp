package com.example.myapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.CheckBox;

import com.example.myapp.R;
import com.example.myapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private View last;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setButtons();
    }
    // setting the bottom buttons
    private void setButtons() {
        set(binding.todoBtn, binding.todoArea, new TodoFragment());
        set(binding.workoutBtn, binding.workoutArea, new WorkoutFragment());
        set(binding.meditationBtn, binding.meditationArea, new MeditationFragment());
        set(binding.profileBtn, binding.profileArea, new MeditationFragment());
    }
    // reduces code for setting the bottom buttons
    private void set(View b, View a, Fragment fragment) {
        // sets switching between buttons and sets the fragment
        b.setOnClickListener(view -> {
            // switch button
            a.setBackgroundResource(R.drawable.pressed_icon);
            if (last != null && last != a) {
                TypedValue outValue = new TypedValue();
                getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true);
                last.setBackgroundResource(outValue.resourceId);
            }
            last = a;
            // switch fragments
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.replace(R.id.frameLayout, fragment);
            transaction.commit();
        });
    }
}