package core.engine;

public class TurboHybridEngine extends Engine {

    public TurboHybridEngine(String name, int power, int reliability) {
        super(name, power, reliability);
    }

    @Override
    public String getSpecs() {
        return "Turbo-Hybrid " + name + " (power=" + power + ", reliability=" + reliability + ")";
    }
}
