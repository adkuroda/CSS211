/** Shows how much calories can be burned with Plyometrics  and 
 * what muscles Plyometrics will effect 
 * 
 * @author Adilet Kuroda
 *
 */
public class Plyometrics extends Anaerobic {
	@Override
	public Muscle[] muscleTargeted() {
		Muscle[] muscles = new Muscle[3];
		muscles[0] = Muscle.Abs;
		muscles[1] = Muscle.Legs;
		muscles[2] = Muscle.Glutes;
		return muscles;
	}

	@Override
	public double calorieLoss(Intensity intensity, double weight, int duration) {
		double caloriesBurned = 0;
		switch(intensity) {
		case HIGH:
			caloriesBurned = weight * 7.4 * duration/60.0;
			break;
		case MEDIUM:
			caloriesBurned = weight * 4.8 * duration/60.0;
			break;
		case LOW:
			caloriesBurned = weight * 2.5 * duration/60.0;
			break;
		}
		return caloriesBurned;
	}
	@Override 
	public String description() {
		return "Plyometrics";
	}

}
