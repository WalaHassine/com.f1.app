package core.vehicle.decorator;

import core.engine.Engine;
import core.team.Team;
import core.vehicle.Vehicle;

public abstract class VehicleDecorator extends Vehicle {

    protected Vehicle wrapped;

    public VehicleDecorator(Vehicle wrapped) {
        super(wrapped.getModel(), wrapped.getBaseSpeed(), wrapped.getHandling(),
              wrapped.getYear(), wrapped.getEngine(), wrapped.getTeam());
        this.wrapped = wrapped;
    }

    @Override
    public int getBaseSpeed() {
        return wrapped.getBaseSpeed();
    }

    @Override
    public int getHandling() {
        return wrapped.getHandling();
    }

    @Override
    public int getYear() {
        return wrapped.getYear();
    }

    @Override
    public Engine getEngine() {
        return wrapped.getEngine();
    }

    @Override
    public Team getTeam() {
        return wrapped.getTeam();
    }

    @Override
    public abstract int getTotalSpeed();

    @Override
    public abstract String getDescription();
}
