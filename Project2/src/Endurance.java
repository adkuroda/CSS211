/**
 * Abstract Class to that implements Fitness interface.
 * Defines common behavior exercise classes: 
 * Child of the class: Squat and Pull up  
 * @author Adilet Kuroda
 *
 */
public abstract class Endurance implements Fitness {

	@Override
	public String description() {
		return "Endurance is all about sweat and patience.";
	}


}
