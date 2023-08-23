/** Shows how much calories can be burned with cycling and 
 * what muscles cycling will effect 
 * 
 * @author Adilet Kuroda
 *
 */
public class Cycling extends Aerobic  {

	@Override
	public Muscle[] muscleTargeted() {
		Muscle[] muscles = new Muscle[3];
		muscles[0] = Muscle.Glutes;
		muscles[1] = Muscle.Cardio;
		muscles[2] = Muscle.Legs;
		
		return muscles;
	}
	

	@Override
	public double calorieLoss(Intensity intensity, double weight, int duration) {
		double caloriesBurned = 0;
		switch(intensity) {
		case HIGH:
			caloriesBurned = weight * 14.0 * duration/60.0;
			break;
		case MEDIUM:
			caloriesBurned = weight * 8.5 * duration/60.0;
			break;
		case LOW:
			caloriesBurned = weight * 4.0 * duration/60.0;
			break;
		}
		return caloriesBurned;
	}
	@Override 
	public String description() {
		return "Cycling";
	}
}
