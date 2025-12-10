package core.track;

public class Track {
    private String name;
    private String country;
    private double lengthKm;
    private int laps;
    private int layoutYear;

    public Track(String name, String country, double lengthKm, int laps, int layoutYear) {
        this.name = name;
        this.country = country;
        this.lengthKm = lengthKm;
        this.laps = laps;
        this.layoutYear = layoutYear;
    }

    public String getName() { return name; }
    public String getCountry() { return country; }
    public double getLengthKm() { return lengthKm; }
    public int getLaps() { return laps; }
    public int getLayoutYear() { return layoutYear; }

    @Override
    public String toString() {
        return name + " (" + country + "), " + lengthKm + " km, laps=" +
               laps + ", layout " + layoutYear;
    }
}
