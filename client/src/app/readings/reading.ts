import { Tire } from "./Tire";

export interface Reading {

    vin: string;
	
	latitude: number;
	
	longitude: number;
	
	timestamp: Date;
	
	fuelVolume: number;
	
	speed: number;
	
	engineHp: number;
	
	checkEngineLightOn: boolean;
	
	engineCoolantLow: boolean;
		   
	cruiseControlOn: boolean;
	
	engineRpm: number;
	
	tires: Tire;	
}
