/**
 * NullAlert.java
 * app.djxlab.cartracker.api.entity 
 *
 * @author: Dhaval Joshi.
 */
package app.djxlab.cartracker.api.entity;

import app.djxlab.cartracker.api.constant.Constants;

public class NullAlert extends Alert {
	
	public NullAlert() {
		super(Constants.PRIORITY_LOW, "", "", "", "ALERT: NULL");
		this.setCategory(Constants.ALERT_OTHER);
	}
}
