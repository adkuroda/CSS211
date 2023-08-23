/** Shows how much calories can be burned with swimming  and 
 * what muscles swimming will effect 
 * 
 * @author Adilet Kuroda
 *
 */
public class Swimming extends Aerobic {
	SwimmingType type;
	
	public Swimming (SwimmingType type) {
		this.type = type;
	}
	public Swimming () {
		this(SwimmingType.Freestyle);
	}
/** Setter for type of swimming 
 * @param type Type of swimming participant wants to perform 
 */
	public void setSwimmingType(SwimmingType type) {
		this.type = type;
	}
/** Getter for swimming
 * @return type of swimming that participant choose
 */
	public SwimmingType getSwimmingType() {
		return this.type;
	}

	@Override
	public Muscle[] muscleTargeted() {
		Muscle[] muscles = null;
		switch (type) {
		case Breaststroke:
			muscles = new Muscle[2];
			muscles[0] = Muscle.Glutes;
			muscles[1] = Muscle.Cardio;
			break;
		case Butterflystroke:
			muscles = new Muscle[5];
			muscles[0] = Muscle.Abs;
			muscles[1] = Muscle.Back;
			muscles[2] = Muscle.Shoulders;
			muscles[3] = Muscle.Biceps;
			muscles[4] = Muscle.Triceps;
			break;
		case Freestyle:
			muscles = new Muscle[3];
			muscles[0] = Muscle.Arms;
			muscles[1] = Muscle.Legs;
			muscles[2] = Muscle.Cardio;
			break;
		
		}
		return muscles;
	}

	@Override
	public double calorieLoss(Intensity intensity, double weight, int duration) {
		double caloriesBurned = 0;
		switch(intensity) {
		case HIGH:
			caloriesBurned = weight * 10.0 * duration/60.0;
			break;
		case MEDIUM:
			caloriesBurned = weight * 8.3 * duration/60.0;
			break;
		case LOW:
			caloriesBurned = weight * 6.0 * duration/60.0;
			break;
		}
		return caloriesBurned;
	}
	@Override 
	public String description() {
		return "Swimming";
	}
	

}
