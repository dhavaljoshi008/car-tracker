/**
 * Alert.java
 * app.djxlab.cartracker.api.entity 
 *
 * @author: Dhaval Joshi.
 */
package app.djxlab.cartracker.api.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import app.djxlab.cartracker.api.constant.Constants;

@Document(collection = "dataCollection")
public class Alert {
	
	@Id
	private String id;
	
	private String vin;
	
	private String make;
	
	private String model;
		
    private final String type = Constants.TYPE_ALERT;
    
    private String category;
    
    private String priority;
    
    private Date timestamp;
        
    private String message;
    
    private Alert() {
    		
    }
    
    public Alert(String priority, String vin, String make, String model,  String message) {
    		this.timestamp = new Date();
    		this.priority = priority;
    		this.vin = vin;
    		this.make = make;
    		this.model = model;
    		this.message = message;
    		this.category = Constants.ALERT_OTHER;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Date getTimestamp() {
		return timestamp;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
