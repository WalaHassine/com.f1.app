package core.engine;

public abstract class Engine {
    protected String name;
    protected int power;       
    protected int reliability; 

    public Engine(String name, int power, int reliability) {
        this.name = name;
        this.power = power;
        this.reliability = reliability;
    }

    public String getName() { return name; }
    public int getPower() { return power; }
    public int getReliability() { return reliability; }

    public abstract String getSpecs();
}
