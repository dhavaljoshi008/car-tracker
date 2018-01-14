import { Tire } from "../readings/Tire";

export interface Alert {

    vin: string;
	
	make?: string;
	
	model?: string;
		    
    category: string;
    
    priority: string;
    
    timestamp: Date;
        
    message?: string;

    checkEngineLightOn?: boolean;

    engineCoolantLow?: boolean;

    engineRpm?: number;
	    
    redlineRpm?: number;

    fuelVolume?: number;
    
    maxFuelVolume?: number;
    
    tires?: Tire;
}