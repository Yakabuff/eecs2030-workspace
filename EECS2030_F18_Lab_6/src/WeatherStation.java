import java.util.ArrayList;
import java.util.List;

/**
 * A weather station measures temperature and pressure and
 * has a list of subscribed weather observers.
 * When there is an update on the measures, the weather station
 * publishes the update to all currently-subscribed observers.
 */
public class WeatherStation {

	/* 
	 * Your Task: 
	 * Declare an attribute for the ***list*** of subscribed weather observers.  
	 */
	
    List<WeatherObserver> observers = new ArrayList<WeatherObserver>();
	double t;
	double p;
	
	/**
	 * Initialize a new weather station.
	 * @param t initial temperature measure
	 * @param p initial pressure measure 
	 */
	public WeatherStation (double t, double p) {
		/* Your Task */
		this.t= t;
		this.p = p;
	}
	
	/**
	 * Subscribe the input weather observer o as
	 * one of the observers of the current weather station.
	 * Add the input o to the list of subscribed observers. 
	 * @param o a weather observer
	 */
	public void subscribe (WeatherObserver o) {
		/* Your Task */ 
		observers.add(o); //add this observer to the list of subscribers
		o.setWeatherStation(this);  //set THIS station to observers' station
	}

	/**
	 * Unsubscribe the input weather observer o from
	 * the list of observers of the current weather station.
	 * Remove the input o from the list of subscribed observers. 
	 * Assume that the input o is an already-subscribed observer.  
	 * @param o a weather observer
	 */
	public void unsubscribe (WeatherObserver o) {
		/* Your Task */ 
		observers.remove(o);
		o.setWeatherStation(null);
	}

	/**
	 * Publish the latest readings of weather data 
	 * to all subscribed observers. 
	 * That is, perform an update on each subscribed observer. 
	 */
	public void publish() {
		/* Your Task */ 
		for(WeatherObserver o : observers){
			//update
			o.update();
		}
	}
	
	/**
	 * Get the list of subscribed weather observers.
	 * @return an array of subscribed weather observers. 
	 */
	public WeatherObserver[] getObservers() {
		/* Your Task */ 
		WeatherObserver[] subscribed = new WeatherObserver[this.observers.size()];
		for(int i=0; i< this.observers.size();i++){
			subscribed[i] = this.observers.get(i);
		}
		return subscribed;
	}
	
	/**
	 * Get the latest temperature measure.
	 * @return latest temperature measure
	 */
	public double getTemperature() {
		/* Your Task */ 
		return t;
	}
	
	/**
	 * Get the latest pressure measure.
	 * @return latest pressure measure 
	 */
	public double getPressure() {
		/* Your Task */ 
		return p;
	}

	/**
	 * Update the weather data 
	 * @param t new temperature measure
	 * @param p new pressure measure
	 */
	public void set_measurements(double t, double p) {
		/* Your Task */ 
		this.t= t;
		this.p = p;
	}
}