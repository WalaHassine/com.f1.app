package core.team;

public class Team {
    private String name;
    private String engineSupplier;
    private int performance; // 0–100
    private int reliability; // 0–100

    public Team(String name, String engineSupplier, int performance, int reliability) {
        this.name = name;
        this.engineSupplier = engineSupplier;
        this.performance = performance;
        this.reliability = reliability;
    }

    public String getName() { return name; }
    public String getEngineSupplier() { return engineSupplier; }
    public int getPerformance() { return performance; }
    public int getReliability() { return reliability; }

    @Override
    public String toString() {
        return name + " (Engine: " + engineSupplier + ", perf=" + performance +
               ", rel=" + reliability + ")";
    }
}
