/**
 * 
 */
package example.nz.org.take.r2ml.userv.domain;


/**
 * @author Bastian Schenke (bastian.schenke(at)googlemail.com)
 * 
 */
public class Car {
	private boolean convertible = false;
	private boolean rollbar = false;
	private boolean driverAirbag = false;
	private boolean passengerAirbag = false;
	private boolean sideAirbag = false;
	private boolean alarmSystem = false;
	private long price = 0;
	private CarModel model = new CarModel();
	
//	private String potentialOccupantInjuryRating = "";
//	private String potentialTheftRating = "";
//	private String carEligibility = "";

//	/**
//	 * @return the potentialOccupantInjuryRating
//	 */
//	public String getPotentialOccupantInjuryRating() {
//		return potentialOccupantInjuryRating;
//	}
//	/**
//	 * @param potentialOccupantInjuryRating the potentialOccupantInjuryRating to set
//	 */
//	public void setPotentialOccupantInjuryRating(
//			String potentialOccupantInjuryRating) {
//		this.potentialOccupantInjuryRating = potentialOccupantInjuryRating;
//	}
//	/**
//	 * @return the potentialTheftRating
//	 */
//	public String getPotentialTheftRating() {
//		return potentialTheftRating;
//	}
//	/**
//	 * @param potentialTheftRating the potentialTheftRating to set
//	 */
//	public void setPotentialTheftRating(String potentialTheftRating) {
//		this.potentialTheftRating = potentialTheftRating;
//	}	/**
//	 * @return the carEligibility
//	 */
//	public String getCarEligibility() {
//		return carEligibility;
//	}
//	/**
//	 * @param carEligibility the carEligibility to set
//	 */
//	public void setCarEligibility(String carEligibility) {
//		this.carEligibility = carEligibility;
//	}
	
	public boolean isVehicle() {
		return true;
	}
	
	public boolean isCar() {
		return true;
	}
	
	/**
	 * @return the carModel
	 */
	public CarModel getModel() {
		return model;
	}
	/**
	 * @param carModel the carModel to set
	 */
	public void setModel(CarModel carModel) {
		this.model = carModel;
	}
	/**
	 * @return the convertible
	 */
	public boolean isConvertible() {
		return convertible;
	}
	/**
	 * @param convertible the convertible to set
	 */
	public void setConvertible(boolean convertible) {
		this.convertible = convertible;
	}
	/**
	 * @return the driverAirbag
	 */
	public boolean isDriverAirbag() {
		return driverAirbag;
	}
	/**
	 * @param driverAirbag the driverAirbag to set
	 */
	public void setDriverAirbag(boolean driverAirbag) {
		this.driverAirbag = driverAirbag;
	}
	/**
	 * @return the passengerAirbag
	 */
	public boolean isPassengerAirbag() {
		return passengerAirbag;
	}
	/**
	 * @param passengerAirbag the passengerAirbag to set
	 */
	public void setPassengerAirbag(boolean passengerAirbag) {
		this.passengerAirbag = passengerAirbag;
	}
	/**
	 * @return the price
	 */
	public long getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(long price) {
		this.price = price;
	}
	/**
	 * @return the rollbar
	 */
	public boolean isRollbar() {
		return rollbar;
	}
	/**
	 * @param rollbar the rollbar to set
	 */
	public void setRollbar(boolean rollbar) {
		this.rollbar = rollbar;
	}
	/**
	 * @return the sideAirbag
	 */
	public boolean isSideAirbag() {
		return sideAirbag;
	}
	/**
	 * @param sideAirbag the sideAirbag to set
	 */
	public void setSideAirbag(boolean sideAirbag) {
		this.sideAirbag = sideAirbag;
	}
	
	@Override
	public String toString() {
		return "Car[model=" + model + "]";
	}

	/**
	 * @return the alarmSystem
	 */
	public boolean isAlarmSystem() {
		return alarmSystem;
	}

	/**
	 * @param alarmSystem the alarmSystem to set
	 */
	public void setAlarmSystem(boolean alarmSystem) {
		this.alarmSystem = alarmSystem;
	}

}
