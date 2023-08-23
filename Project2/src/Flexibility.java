/**
 * Abstract Class to that implements Fitness interface.
 * Defines common behavior exercise classes: 
 * Child of the class: Yoga and Thai Chi	
 * @author Adilet Kuroda 
 * 
 */
public abstract class Flexibility implements Fitness {

	@Override
	public String description() {
		return "Flexibility is uncomfortable and it takes time, so people don't like to do it.";
	}

}
