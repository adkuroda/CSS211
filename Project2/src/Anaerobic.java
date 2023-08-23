/**
 * Abstract Class to that implements Fitness interface.
 * Defines common behavior exercise classes: 
 * Child of the class: Weighlifting and Plymetrics 
 * @author Adilet Kuroda
 *
 */
public abstract class Anaerobic implements Fitness {

	@Override
	public String description() {
		return "Anaerobic means \"without oxygen.\""; 
	}

}
