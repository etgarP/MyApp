package com.example.myapp;

public class Time {
    private int minutes;
    public Time(int minutes) {
        this.minutes = minutes;
    }
    public void setTime(int minutes) {
        this.minutes = minutes;
    }
    public void increaseByOne() {
        if (minutes < 59) minutes++;
    }
    public void lowerByOne() {
        if (minutes > 1) minutes--;
    }
    public long getRawTIme() {
        return minutes * 60 * 1000;
    }
    public String getTimeFromMili(long timeLeft) {
        StringBuilder st = new StringBuilder();
        int seconds = (int) (timeLeft / 1000);
        int justSecs= seconds % 60;
        int minutes = seconds / 60;
        if (minutes < 10) st.append(0);
        st.append(minutes);
        st.append(":");
        if (justSecs < 10) st.append(0);
        st.append(justSecs);
        String time = st.toString();
        return time;
    }

    public String getTimeFromMinutes() {
        StringBuilder st = new StringBuilder();
        if (minutes < 10) st.append(0);
        st.append(minutes);
        st.append(":");
        st.append("00");
        String time = st.toString();
        return time;
    }

    public long getMinutes() {
        return minutes;
    }
}
