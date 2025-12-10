package core.vehicle.decorator;

import core.vehicle.Vehicle;

public class TyrePackage extends VehicleDecorator {

    private int handlingBonus = 8;

    public TyrePackage(Vehicle wrapped) {
        super(wrapped);
    }

    @Override
    public int getTotalSpeed() {
        return wrapped.getTotalSpeed(); // pneus : impact surtout handling
    }

    @Override
    public int getHandling() {
        return wrapped.getHandling() + handlingBonus;
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " + TyrePackage(handling+" + handlingBonus + ")";
    }
}
