package core.vehicle.decorator;

import core.vehicle.Vehicle;

public class AeroKit extends VehicleDecorator {

    private int aeroBonus = 5;
    private int handlingBonus = 10;

    public AeroKit(Vehicle wrapped) {
        super(wrapped);
    }

    @Override
    public int getTotalSpeed() {
        return wrapped.getTotalSpeed() + aeroBonus;
    }

    @Override
    public int getHandling() {
        return wrapped.getHandling() + handlingBonus;
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " + AeroKit(speed+" + aeroBonus +
               ", handling+" + handlingBonus + ")";
    }
}
