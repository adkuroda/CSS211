/** Shows how much calories can be burned with pull-up  and 
 * what muscles pull-up will effect 
 * 
 * @author Adilet Kuroda
 *
 */
public class PullUp extends Endurance {
	@Override
	public Muscle[] muscleTargeted() {
		Muscle[] muscles = new Muscle[2];
		muscles[0] = Muscle.Biceps;
		muscles[1] = Muscle.Arms;
		return muscles;
	}

	@Override
	public double calorieLoss(Intensity intensity, double weight, int duration) {
		double caloriesBurned = 0;
		switch(intensity) {
		case HIGH:
			caloriesBurned = weight * 7.5 * duration/60.0;
			break;
		case MEDIUM:
			caloriesBurned = weight * 6.0 * duration/60.0;
			break;
		case LOW:
			caloriesBurned = weight * 4.8 * duration/60.0;
			break;
		default:
			break;
		}
		return caloriesBurned;
	}
	@Override 
	public String description() {
		return "PullUp";
	}

}
