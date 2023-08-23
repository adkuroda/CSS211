/**
 * Main interface for Fitness application. 
 * Contians two methods: calories() and description)
 * @author Adilet Kuroda
 */
public interface Fitness {
	
/** Determines which muscle will be effected by an exercise 
 * @return Array of Muscles.  
 */
	public Muscle [] muscleTargeted();
/** Calculate how many calories a person can burn based on given exercise 
 * and provided parameters 
 * @param intensity level of intensity  
 * @param weight - weight of a person performing an exercise 
 * @param duration - how much time person performed exercise 
 * @return double representing calories burned on given exercise 
 */
	
	public double calorieLoss(Intensity intensity, double weight, int duration);
	
	/** Creates a short description for given exercise
	 * @return Description of exercise of fitness type
	 */
	public String description();
	

}
