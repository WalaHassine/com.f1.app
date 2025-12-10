package progress;

public abstract class Unlockable {
    private String id;
    private String name;
    private int cost;
    private UnlockType type;

    public Unlockable(String id, String name, int cost, UnlockType type) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.type = type;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getCost() { return cost; }
    public UnlockType getType() { return type; }

    @Override
    public String toString() {
        return "[" + type + "] " + name + " (cost=" + cost + ")";
    }
}
