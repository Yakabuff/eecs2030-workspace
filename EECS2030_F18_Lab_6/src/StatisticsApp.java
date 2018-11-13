import java.util.ArrayList;
import java.util.List;

/**
 * A weather statistics app calculates the 
 * minimum, maximum, and average temperature 
 * read so far from its subscribed weather station, if any.
 */
public class StatisticsApp extends WeatherObserver {
	
	List<Double> temp = new ArrayList<Double>();
	WeatherStation ws;
	double current;
	double min;
	double max;
	double avg;
	
	/**
	 * Update the reading of this weather observer.
	 * Update the current temperature and the 
	 * maximum, minimum, and average accordingly.
	 */
	public void update() {
		/* Your Task */
		temp.add(ws.getTemperature());
		this.current = ws.getTemperature();
		this.avg = this.getAverageTemperature();
		this.max = this.getMaxTemperature();
		this.min = this.getMinTemperature();
		
		
	}

	/* See the method description in the parent class */
	public WeatherStation getWeatherStation() {
		/* Your Task */
		return this.ws;
	}

	/* See the method description in the parent class */
	public void setWeatherStation(WeatherStation ws) {
		/* Your Task */ 
		this.ws = ws;
	}

	/**
	 * Get the minimum temperature based on the readings so far.
	 * @return minimum temperature based on the readings so far
	 */
	public double getMinTemperature() {
		/* Your Task */
		double min = temp.get(0);
		for(Double d : temp){
			
			if(d < min){
				min = d;
			}
		}
		return min;
	}

	/**
	 * Get the maximum temperature based on the readings so far.
	 * @return maximum temperature based on the readings so far
	 */
	public double getMaxTemperature() {
		/* Your Task */
		double max = 0;
		for(Double d : temp){
			if(d > max){
				max = d;
			}
		}
		return max;
	}

	/**
	 * Get the average temperature based on the readings so far.
	 * @return average temperature based on the readings so far
	 */
	public double getAverageTemperature() {
		/* Your Task */
		double avg=0;
		double total = 0;
		for(Double d : temp){
			total = total + d;
		}
		avg = total / temp.size();
		
		return avg;
	}
}

