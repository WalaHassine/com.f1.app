package core.season;

import core.track.Track;

public class Season {
    private int year;
    private Track[] calendar;

    public Season(int year, Track[] calendar) {
        this.year = year;
        this.calendar = calendar;
    }

    public int getYear() { return year; }
    public Track[] getCalendar() { return calendar; }
}
