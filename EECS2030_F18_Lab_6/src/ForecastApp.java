import java.util.ArrayList;
import java.util.List;

/**
 * A weather forecast app determines if the pressure readings from 
 * its subscribed weather station, if any, indicate it is likely to rain
 * due to a reduction on the pressure level.
 */
public class ForecastApp extends WeatherObserver {
	
	/**
	 * Update the reading of this weather observer.
	 * Update the current and last readings of pressure.
	 */
	List<Double>pres = new ArrayList<Double>();
	WeatherStation ws;
	double currentPressure;
	double lastPressure;
	
	
	public void update() {
		/* Your Task */
		pres.add(ws.getPressure());
		if(pres.size()==1){
			currentPressure = pres.get(0);
			this.lastPressure = currentPressure;
		}else{
			this.lastPressure = currentPressure;
			currentPressure = pres.get(pres.size()-1);
			
		}
		
		
	}
	
	/* See the method description in the parent class */
	public WeatherStation getWeatherStation() {
		/* Your Task */
		//Get the weather station to which the current weather observer is subscribed to.
		
		return ws;
		
		
	}
	
	/* See the method description in the parent class */
	public void setWeatherStation(WeatherStation ws) {
		/* Your Task */
		
		this.ws = ws;
		
	} 
	
	/**
	 * Get the pressure level read from the last update.
	 * @return pressure level read from the last update
	 */
	public double getCurrentPressure() {
		/* Your Task */
		
		return this.currentPressure;
		
	}
	
	/**
	 * Get the pressure level read from the second last update.
	 * @return pressure level read from the second last update
	 */
	public double getLastPressure() {
		/* Your Task */
		return this.lastPressure;
	}
	
	/**
	 * Based on the last and second last readings of the pressure level,
	 * it is determined as likely to rain if there is a reduction 
	 * on the pressure level; otherwise it is unlikely to rain.
	 * @return whether or not it is likely to rain.
	 */
	public boolean isLikelyToRain() {
		/* Your Task */
		if(getLastPressure() > getCurrentPressure()){
			return true;
		}
		return false;
	}
}