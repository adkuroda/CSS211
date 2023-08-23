/** Shows how much calories can be burned with weightlifting and 
 * what muscles weightlifting will effect 
 * 
 * @author Adilet Kuroda
 *
 */
public class WeightLifting extends Anaerobic {

	@Override
	public Muscle[] muscleTargeted() {
		Muscle[] muscles = new Muscle[4];
		muscles[0] = Muscle.Shoulders;
		muscles[1] = Muscle.Legs;
		muscles[2] = Muscle.Arms;
		muscles[3] = Muscle.Triceps;
		return muscles;
	}

	@Override
	public double calorieLoss(Intensity intensity, double weight, int duration) {
		double caloriesBurned = 0;
		switch(intensity) {
		case HIGH:
			caloriesBurned = weight * 6.0 * duration/60.0;
			break;
		case MEDIUM:
			caloriesBurned = weight * 5.0 * duration/60.0;
			break;
		case LOW:
			caloriesBurned = weight * 3.5 * duration/60.0;
			break;
		}
		return caloriesBurned;
	}
	@Override 
	public String description() {
		return "WeightLifting";
	}

}
