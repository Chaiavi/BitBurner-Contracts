package org.bitburner;

public class Stopwatch {
    private long startTime = 0;

    public Stopwatch() {
        startTime = System.currentTimeMillis();
    }

    public String getElapsedTime() {
        return millisecondsToStr(System.currentTimeMillis() - startTime);
    }

    public String millisecondsToStr(long millis) {
        long hours = millis / 3600000;
        long minutes = (millis % 3600000) / 60000;
        long seconds = (millis % 60000) / 1000;
        long milliseconds = millis % 1000;

        return String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, milliseconds);
    }
}

