import java.util.ArrayList;
/**  This represents daily exercise plan 
 * @author Adilet Kuroda
 *
 */

public class DailyExercise {
	private ArrayList<Fitness> exerciseList;
	private int duration;
	private double calorieTarget;
	private Profile profile;
/**
 * Constructor initializes attributes 
 * @param exerciseList Type of exercise(s) person will perform 
 * @param duration how long person will exercise 
 * @param calorieTarget targeted goal of a person 
 * @param profile Profile of a person that will working out 
 */
	public DailyExercise(ArrayList<Fitness> exerciseList, int duration, double calorieTarget, Profile profile) {
		this.exerciseList = exerciseList;
		this.duration = duration;
		this.calorieTarget = calorieTarget;
		this.profile = profile;
	}
/** Secondary Constructor. Assumption that person will work out 60 minutes 
 * and targeted calorie loss is 500 calories 
 * @param exerciseList Type of exercise(s) person will perform 
 * @param profile  Profile of a person that will working out 
 */
	public DailyExercise(ArrayList<Fitness> exerciseList, Profile profile) {
		this.exerciseList = exerciseList;
		this.profile = profile;
		this.duration = 60;
		this.calorieTarget = 500;
	}
/** Adds additional exercises to given exercise list 
 * @param ex additional exercises 
 */
	public void addExercise(Fitness ex) {
		this.exerciseList.add(ex);
	}
/** Removes exercise that person does not need anymore 
 * @param ex exercise that needs to be removed 
 */
	public void removeExercise(Fitness ex) {
		this.exerciseList.remove(ex);
	}
/**
 * Setter for list of Exercises 
 * @param list collection(s) of exercises 
 */
	public void setExerciseList(ArrayList<Fitness> list) {
		this.exerciseList = list;
	}
/** Setter for time duration
 * @param duration in minutes 
 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
/** Setter for Calorie Target
 * @param target Targeted calorie burn 
 */
		
	public void setCalorieTarget(double target) {
		this.calorieTarget = target;
		
	}
/**
 * Create a profile of a person 
 * @param profile object of profile type. 
 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
/**
 * Returns list of exercises 
 * @return list of Exercises
 */
	public ArrayList<Fitness> getExerciseList(){
		return this.exerciseList;
	}
/** Returns amount of work out time
 * @return work out time period 
 */
	public int getDuration() {
		return this.duration;
	}
/** Getter for Calorie Target 
 * @return number of calories to be burned 
 */
	public double getCalorieTarget() {
		return this.calorieTarget;
	}
/** Getter for profile 
 * @return profile of a person 
 */
	public Profile getProfile() {
		return this.profile;
	}
/** Determines list of exercises full fills all the target muscle groups  
 * the user wants to work on for that specific day. 
 * 
 * @param targetMuscle list of muscles that needs to be worked out
 * @return List of exercises that target that will target given . If there is 
 * is a group of exercises that target all the provided muscles it will return null
 */
	public Fitness[] getExercises(Muscle[] targetMuscle) {
		ArrayList<Fitness>  target = new ArrayList<Fitness>();
		for (int i = 0; i < exerciseList.size(); i++) {
			Fitness templist = this.exerciseList.get(i);
			Muscle [] listMuscle = templist.muscleTargeted();
			int size = targetMuscle.length;
			int count = 0;
			for (Muscle m: listMuscle) {
				for (Muscle t: targetMuscle) {
					if (m.equals(t)) {
						++count; 
					}
				}
			}
			if (count == size) {
				target.add(this.exerciseList.get(i));	
			}
			
		}
		if (target.size() == 0) {
			return null;
		}
		Fitness targetedExercise[] = new Fitness[target.size()];
		for (int i = 0; i < target.size(); i++) {
			targetedExercise[i] = target.get(i);
		}
		return targetedExercise;
	}
/** Determines group of exercises that will target some or all of the muscles user 
 * wants to work out 
 * @param targetMuscle group of muscles that needs to be worked out 
 * @return list of exercises,if there is no exercise that return null
 */
	public Fitness[] getAllExercises(Muscle[] targetMuscle) {
		ArrayList<Fitness>  target = new ArrayList<Fitness>();
		for (int i = 0; i < exerciseList.size(); i++) {
			Fitness templist = this.exerciseList.get(i);
			Muscle [] listMuscle = templist.muscleTargeted();
			int count = 0;
			for (Muscle m: listMuscle) {
				for (Muscle t: targetMuscle) {
					if (m.equals(t)) {
						++count;
					}
					
				}
			}
			if (count > 0) {
				target.add(this.exerciseList.get(i));	
			}
			
		}
		Fitness targetedExercise[] = new Fitness[target.size()];
		for (int i = 0; i < target.size(); i++) {
			targetedExercise[i] = target.get(i);
		}
		return targetedExercise;
		
	}
/** Creates string representation of an object
 * @return String representation of an object
 */
	@Override
	public String toString() {
		return  this.duration + " " + this.profile + " " +this.calorieTarget;
	}
}	
