package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends IllegalStateException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -288979685441144222L;
	private double batteryLevel;
	
	public NotEnoughBatteryException(final double batteryLevel) {
		super();
		this.batteryLevel = batteryLevel;
	}
	
	@Override
	public String toString() {
		return "Cannot move, low battery: " + this.batteryLevel;
	}
	
	@Override
    public String getMessage() {
        return this.toString();
    }

}
