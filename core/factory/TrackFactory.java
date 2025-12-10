package factory;

import core.track.Track;

public class TrackFactory {

    public Track createTrack(String name, int year) {
        switch (name.toLowerCase()) {
            case "monza":
                return new Track("Monza", "Italy", 5.79, 53, year);
            case "spa":
                return new Track("Spa-Francorchamps", "Belgium", 7.00, 44, year);
            case "monaco":
                return new Track("Monaco", "Monaco", 3.33, 78, year);
            default:
                return new Track(name, "Unknown", 5.0, 50, year);
        }
    }
}
