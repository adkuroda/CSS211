/** Shows how much calories can be burned with thaichi  and 
 * what muscles thaichi will effect 
 * 
 * @author Adilet Kuroda
 *
 */
public class TaiChi extends Flexibility {
	@Override
	public Muscle[] muscleTargeted() {
		Muscle[] muscles = new Muscle[2];
		muscles[0] = Muscle.Arms;
		muscles[1] = Muscle.Legs;
		return muscles;
	}

	@Override
	public double calorieLoss(Intensity intensity, double weight, int duration) {
		double caloriesBurned = 0;
		switch(intensity) {
		case HIGH:
			caloriesBurned = weight * 5.0 * duration/60.0;
			break;
		case MEDIUM:
			caloriesBurned = weight * 3.0 * duration/60.0;
			break;
		case LOW:
			caloriesBurned = weight * 1.5 * duration/60.0;
			break;
		}
		return caloriesBurned;
	}
	@Override 
	public String description() {
		return "TaiChi";
	}
}
