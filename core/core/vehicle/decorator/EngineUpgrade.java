package core.vehicle.decorator;

import core.vehicle.Vehicle;

public class EngineUpgrade extends VehicleDecorator {

    private int powerBonus = 10;

    public EngineUpgrade(Vehicle wrapped) {
        super(wrapped);
    }

    @Override
    public int getTotalSpeed() {
        return wrapped.getTotalSpeed() + powerBonus;
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " + EngineUpgrade(speed+" + powerBonus + ")";
    }
}
