import java.util.ArrayList;
/**
 * @author Adiet Kuroda
 * @version 1.0
 */


public class WeeklyExercise {
	private ArrayList<Fitness> exerciseList;
	private int days;
	private double weeklyCalorieTarget;
	private Profile profile;
/**
 * Constructor to initialize the Object 
 * @param exerciseList List of exercise person will perform 
 * @param days number of days person want to work in a week 
 * @param weeklyCalorieTarget Desired calorie target participant 
 * @param profile profile of a participant 
 */
	public WeeklyExercise(ArrayList<Fitness> exerciseList, int days, double weeklyCalorieTarget, Profile profile) {
		this.exerciseList = exerciseList;
		this.days = days;
		this.weeklyCalorieTarget = weeklyCalorieTarget;
		this.profile = profile;
		
	}
/** Constructor to create an object with two parameters. number of days is initialized to 7
 *  and calorie target initialized to 3500
 * 
 * @param exerciseList List of exercise participant will perform
 * @param profile profile of a participant 
 */
	public WeeklyExercise(ArrayList<Fitness> exerciseList, Profile profile) {
		this.profile = profile;
		this.exerciseList = exerciseList;
		this.days = 7;
		this.weeklyCalorieTarget = 3500;
	}
/** Adds more exercises for participant to work-out 
 * 
 * @param ex Type of exercise participant to perform 
 */
	public void addExercise(Fitness ex) {
		this.exerciseList.add(ex);
	}
/** Removes exercise that participant does not want to perform any further 
 * @param ex  Type of exercise participant does not want to perform
 */
	public void removeExercise(Fitness ex) {
		this.exerciseList.remove(ex);
	}
/**
 * Setter for exerciseList 
 * @param list list of exercises 
 */
	public void setExerciseList(ArrayList<Fitness> list) {
		this.exerciseList = list;
	}
/** setter for number of Days 
 * 
 * @param days represents how many days person want to perform exercise during a week 
 */
	public void setDays(int days) {
		this.days = days;
	}
/** Setter for weeklyCalorieTarget
 * 
 * @param target number representing calories participant want to burn during a week 
 */
	public void setWeeklyCalorieTarget(double target) {
		this.weeklyCalorieTarget = target;
	}
/**
 * Setter for participant profile 
 * @param profile general participant information 
 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
/**
 * Getter for list of Exercises 
 * @return list of exercise participant wishes to perform 
 */
	public ArrayList<Fitness> getExerciseList( ){
		return this.exerciseList;
	}
/** Getter for Days  
 * @return number of days participant wishes to work out during a week 
 */
	public int getDays() {
		return this.days;
	}
/**
 *  Getter for participant's profile 
 * @return participants profile 
 */
	public Profile getProfile() {
		return this.profile;
	}
/**
 * Getter for number of Calories
 * @return number of calories participant wishes to burn 
 */
	public double getWeeklyCalorieTarget() {
		return this.weeklyCalorieTarget;
	}
/** Determines list of exercises person should perform in order to achieve targeted calorie
 * based on provided intensity 
 * 
 * @param intensity level of intensity participant will work-out 
 * @return list of exercise participant should perform to achieve the targeted calories
 */
	public ArrayList<DailyExercise>getWeeklyExercises(Intensity intensity){
		ArrayList<DailyExercise> dailyExercise = new ArrayList<DailyExercise>();
		double dailyLoss = this.weeklyCalorieTarget/this.days;
		for (int i = 0; i < this.exerciseList.size(); i++) {
			Fitness f = this.exerciseList.get(i);
			int j = 0;
			for(j = 0; j<= dailyLoss; j++) {
				double loss = f.calorieLoss(intensity, this.profile.getWeight(), j);
				double lossNext = f.calorieLoss(intensity, this.profile.getWeight(), (j+1));			
				if (loss <= dailyLoss && lossNext >dailyLoss) {
					break;
				}		
			}
			ArrayList<Fitness> fit = new ArrayList<Fitness>();
			fit.add(f);
			dailyExercise.add(new DailyExercise(fit, j, dailyLoss, profile));	
		}
		return dailyExercise;
	}
/** Determines list of exercises person should perform in order to achieve targeted calorie
* based on working out with low intensity 
* @return list of exercise participant should perform to achieve the targeted calorie
*/
	public ArrayList<DailyExercise>getWeeklyExercises(){
		ArrayList<DailyExercise> dailyExercise = new ArrayList<DailyExercise>();
		double dailyLoss = this.weeklyCalorieTarget/this.days;
		for (int i = 0; i < this.exerciseList.size(); i++) {
			Fitness f = this.exerciseList.get(i);
			int j = 1;
			for(j = 0; j<= dailyLoss; j++) {
				double loss = f.calorieLoss(Intensity.LOW, this.profile.getWeight(), j);
				double lossNext = f.calorieLoss(Intensity.LOW, this.profile.getWeight(), (j+1));			
				if (loss <= dailyLoss && lossNext >dailyLoss) {
					break;
				}		
			}
			ArrayList<Fitness> fit = new ArrayList<Fitness>();
			fit.add(f);
			dailyExercise.add(new DailyExercise(fit, j, dailyLoss, profile));	
		}
		return dailyExercise;
	}
/**
 * Provides instruction how to to achieve targeted weight in given number of a day
 * @param targetWeight weight target participant wants to achieve 
 * @param withInDays number of days participant would like to achieve
 * @return Instruction How to achieve the goal 
 * @throws TargetWeightException if participant provides unattainable weight target 
 */
	public String targetedCalorieLoss(double targetWeight, int withInDays) throws TargetWeightException {
		if (targetWeight > this.profile.getWeight()) {
			throw new TargetWeightException("Only works to lose weight"); 
		}
		double weightToLoose = this.profile.getWeight()-targetWeight;
		double caloriesPerDay = ( weightToLoose* 7000)/withInDays;
		double targetedIntake = this.profile.dailyCalorieIntake() - ( weightToLoose* 7000)/withInDays;
		String s = String.format("You need to lose %.2f calories per day or decrease your intake from "
				+ "%.2f to %.2f inorder to lose %.2f kg of weight", caloriesPerDay, this.profile.dailyCalorieIntake(),
				targetedIntake, weightToLoose);
		return s;
	}
}
