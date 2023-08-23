/** Shows how much calories can be burned with squat and 
 * what muscles squat will effect 
 * 
 * @author Adilet Kuroda
 *
 */
public class Squat extends Endurance {
	@Override
	public Muscle[] muscleTargeted() {
		Muscle[] muscles = new Muscle[3];
		muscles[0] = Muscle.Glutes;
		muscles[1] = Muscle.Abs;
		muscles[2] = Muscle.Back;
		return muscles;
	}

	@Override
	public double calorieLoss(Intensity intensity, double weight, int duration) {
		double caloriesBurned = 0;
		switch(intensity) {
		case HIGH:
			caloriesBurned = weight * 7.0 * duration/60.0;
			break;
		case MEDIUM:
			caloriesBurned = weight * 5.0 * duration/60.0;
			break;
		case LOW:
			caloriesBurned = weight * 2.5 * duration/60.0;
			break;
		}
		return caloriesBurned;
	}
	@Override 
	public String description() {
		return "Squat";
	}

}
