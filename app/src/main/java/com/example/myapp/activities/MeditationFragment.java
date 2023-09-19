package com.example.myapp.activities;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.myapp.R;
import com.example.myapp.Time;
import com.example.myapp.databinding.FragmentMeditationBinding;

public class MeditationFragment extends Fragment {
    private FragmentMeditationBinding binding;
    private ProgressBar countdownProgress;
    private CountDownTimer countDownTimer;
    private boolean hasStarted;
    private Time time;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ProgressBar countdownProgress = binding.countdownProgress;
        hasStarted = false;
        time = new Time(10);
        binding.timer.setText(time.getTimeFromMinutes());
        binding.startMeditation.setOnClickListener(v -> {
            if (!hasStarted) {
                countDownTimer = StartTimer(countdownProgress, time.getRawTIme());
                hasStarted = true;
                binding.startMeditation.setImageResource(R.drawable.stop_icon);
                binding.up.setVisibility(View.GONE);
                binding.down.setVisibility(View.GONE);
                countDownTimer.start();
            } else {
                binding.up.setVisibility(View.VISIBLE);
                binding.down.setVisibility(View.VISIBLE);
                countDownTimer.cancel();
                countDownTimer.onFinish();
                binding.startMeditation.setImageResource(R.drawable.play_icon);
                hasStarted = false;
            }
        });
        binding.up.setOnClickListener(v -> {
            time.increaseByOne();
            binding.timer.setText(time.getTimeFromMinutes());
        });
        binding.down.setOnClickListener(v -> {
            time.lowerByOne();
            binding.timer.setText(time.getTimeFromMinutes());
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMeditationBinding.inflate(inflater, container, false);
        createNotificationChannel(getActivity());
        return binding.getRoot();
    }

    private CountDownTimer StartTimer(ProgressBar countdownProgress, long Total) {
        return new CountDownTimer(Total, 1) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Calculate the progress value based on time left
                int progress = (int) (millisUntilFinished * 100 / Total);
                countdownProgress.setProgress(progress);
                binding.timer.setText(time.getTimeFromMili((int) millisUntilFinished));
            }

            @Override
            public void onFinish() {
                // Handle countdown completion
                countdownProgress.setProgress(100);
                binding.timer.setText(time.getTimeFromMili(Total));
            }
        };
    }

    private void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "meditation over";
            String description = "alerts on finished meditation";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel("meditation_channel_id", name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}