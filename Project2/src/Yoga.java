/** Shows how much calories can be burned with weighlifting  and 
 * what muscles weightlifting will effect 
 * 
 * @author Adilet Kuroda
 *
 */
public class Yoga extends Flexibility {
	@Override
	public Muscle[] muscleTargeted() {
		Muscle[] muscles = new Muscle[2];
		muscles[0] = Muscle.Triceps;
		muscles[1] = Muscle.Biceps;
		return muscles;
	}

	@Override
	public double calorieLoss(Intensity intensity, double weight, int duration) {
		double caloriesBurned = 0;
		switch(intensity) {
		case HIGH:
			caloriesBurned = weight * 4.0 * duration/60.00;
			break;
		case MEDIUM:
			caloriesBurned = weight * 3.0 * duration/60.00;
			break;
		case LOW:
			caloriesBurned = weight * 2.0 * duration/60.00;
			break;
		}
		return caloriesBurned;
	}
	@Override 
	public String description() {
		return "Yoga";
	}


}
