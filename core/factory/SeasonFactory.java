package factory;

import core.season.Season;
import core.track.Track;

public class SeasonFactory {

    private TrackFactory trackFactory = new TrackFactory();

    public Season buildSimpleSeason(int year) {
        Track[] calendar = new Track[] {
            trackFactory.createTrack("Monza", year),
            trackFactory.createTrack("Spa", year),
            trackFactory.createTrack("Monaco", year)
        };
        return new Season(year, calendar);
    }
}
