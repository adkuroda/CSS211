/** Create a profile for a person with attributes of age, height, weight and gender 
 * @author Adilet Kuroda
 */
public class Profile {
	private int age;
	private double height; //meters 
	private double weight; // in kilogram 
	private Gender gender;
/** 
 * Constructor to initialize person object
 * @param age: attribute age of a person
 * @param height attribute height of a person
 * @param weight attribute of a person 
 * @param gender attribute gender of a person
 */
	public Profile(int age, double height, double weight, Gender gender) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
	}
	/**
	 * Setter for attribute height 
	 * @param height height of participant 
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	/**
	 * Setter for attribute weight
	 * @param weight participants weight in kilogram 
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	/**
	 *  * Setter for attribute age
	 * @param age participant's age in years
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 *  * Setter for attribute gender 
	 * @param gender gender of participant 
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	/**
	 * Getter for height attribute 
	 * @return height of an object
	 */
	public double getHeight() {
		return this.height;
	}
	/**
	 * Getter for weight attribute 
	 * @return gender of an weight
	 */
	public double getWeight() {
		return this.weight;
	}
	/**
	 * Getter for age attribute 
	 * @return age of an object
	 */
	public int getAge() {
		return this.age;
	}
	/**
	 * Getter for gender attribute 
	 * @return gender of an object
	 */
	public Gender getGender() {
		return this.gender;
	}

	@Override 
/** form an object into a it's String form 
 *  @return String representation of an object
 */
	public String toString() {
		String formatStr = String.format("Age %d, Weight %.1fkg, Height %.1fm, Gender %s", 
							getAge(), getWeight(), getHeight(), getGender());
		return formatStr;
	}
/** Calculates objects calorie intake based on gender, height and weight 
 * 
 * @return calorie in take.  
 */
	public double dailyCalorieIntake() {
		double BMR = 0;
		if (this.gender.equals(Gender.FEMALE)) {
			BMR = 655.1 + ( 9.563 * this.weight) + ( 1.85 * this.height)*Math.pow(10, 2) - ( 4.676 * this.age );
		}
		else {
			BMR = 66.47 + ( 13.75 * this.weight) + ( 5.003 * this.height)*Math.pow(10, 2) - ( 6.755 * this.age );
		}
		return BMR;
	}
/** Calculate BMI of a person 
 * @return number representing a BMI 
 */
	public double calcBMI() {
		return this.weight/(this.height * this.height);
	}
}



















