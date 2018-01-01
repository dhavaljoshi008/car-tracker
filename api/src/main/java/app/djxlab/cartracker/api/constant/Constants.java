/**
 * Constants.java
 * app.djxlab.cartracker.api.constant 
 *
 * @author: Dhaval Joshi.
 */
package app.djxlab.cartracker.api.constant;

public final class Constants {

	// Document types. 
	
	public static final String TYPE_READING = "reading";
	
	public static final String TYPE_VEHICLE = "vehicle";

	public static final String TYPE_ALERT = "alert";
	
	// Alert categories.
	
	public static final String ALERT_ENGINE_RPM = "engineRpm";
	
	public static final String ALERT_FUEL_VOLUME = "fuelVolume";
	
	public static final String ALERT_TIRE_PRESSURE = "tirePressure";
	
	public static final String ALERT_ENGINE_COOLANT_LOW = "engineCoolantLow";
	
	public static final String ALERT_CHECK_ENGINE_LIGHT_ON = "checkEngineLightOn";
	
	public static final String ALERT_OTHER = "other";
	
	
	// Priorities.
	
	public static final String PRIORITY_HIGH = "HIGH";
	
	public static final String PRIORITY_MEDIUM = "MEDIUM";
	
	public static final String PRIORITY_LOW = "LOW";
	
	
	// Business constraints.
	
	public static final double FUEL_THRESHOLD_PERCENT = 0.10; // 10%
	
	public static final double TIRE_PRESSURE_LOW_THRESHOLD = 32;
	
	public static final double TIRE_PRESSURE_HIGH_THRESHOLD = 36;
	
	private Constants() {
		
	}
}
