

public class NumberProcessor {
	
/* Using the for loop, the below method finds all numbers that can divide the parameter input. At the 
 * same time, the for loop accumulates the sum of the divided numbers into the variable sum. Once the loop finishes, 
 * it checks if the sum variable is equal to the parameter input.  If so, then it will return true. 
 * Otherwise, it returns false. 
 */
	public static boolean isSpecial(int input) {
		if (input < 0) {
			input *= -1;  // negative number has both positive and negative divisor 
		}
    	 int sum = 0; // tracks sum of the numbers that can divide input without remainder 
    	 for (int i = 1; i < input; ++i){
    		 if ( input % i == 0) {
    			 sum += i;
    		 }	  
    	 }
    	 if (sum == input && input >0){
    		 return true;
    	 }
    	 else {
    		 return false;	
    	 }
	}

/* The helper method below determines if the number is prime or not.  If the parameter num is less than 
 * 2, it will return false because all of the negative numbers and 1 are not prime.  Otherwise, the loop iterates 
 * up to the given parameter and checks if any index i can divide the given parameter without remainder.  Since prime 
 * numbers can only be divided by one and itself, if any index i can divide the number, then it will return false. 
 * Otherwise, it will return true.  	 
 */
	private static boolean isPrime(int num) { 
		if (num < 2) {
			return false;
		}
		for (int i = 2; i < num; ++i) {
			if (num % i ==0) {
				return false;
			}
		}
		return true;
	}
/* The helper method below determines how many digits a number has by removing one digit 
 * at a time by dividing it with 10 from parameter num until it reaches 0. Each removal is 
 * counts as one digit and it is tracked by the count variable. 
 * 
 */
	private static int numberOfDigits(int num) {
		int count = 0;
		while (num > 0) {
			num /= 10;
			++ count;
		}
		return count;
	}
	
/* This method determines if the number can be a unique prime number by utilizing the helper method prime and 
 * numberOfDigits. The For loop rotates the parameter num and checks if it is still prime.  Once the number 
 * is rotated, if it is not prime, than it will return false.         
 */
     public static boolean isUniquePrime(int num) { 
    	 int numDigit = numberOfDigits(num); // number of digits 
    	 if (isPrime(num) == false) {
    		 return false;
    	 }
    	 for (int i = 1; i < numDigit; ++i) {
    		 int remainder = num % (int)Math.pow(10, numDigit-1); 
    		 // remainder is all the digits except first digit 
    		 int firstDigit = num / (int)Math.pow(10, numDigit-1);
    		 num =  remainder* 10 +  firstDigit;
    		 if (isPrime(num) == false) { // determines if still prime once number is rotated 
    			 return false;
    		 }
    	 }
    	 return true;   	 

}
/* This method first takes a number to its square and determines how many digits the number 
 * has. The rightSide is determined by taking square of parameter num to mod of 10 to the power 
 * of the number of digits of parameter num. The leftSide is determined by diving the square of the parameter num 
 * to 10 to the power of the number of digits of the parameter num. If the right side and left side add up to 
 * number, then it is SquareAdditive.  
 */
     public static boolean isSquareAdditive(int num) {
    	 int sum = 0;
    	 int squareOfNum = num * num;
    	 int numOfDigit = numberOfDigits(num);
    	 int rightSide = squareOfNum % (int)Math.pow(10, numOfDigit);
    	 int leftSide = squareOfNum / (int)Math.pow(10, numOfDigit);
    	 sum = leftSide + rightSide;
    	 if (sum == num) {
    		 return true;
    	 }
    	 else {
    		 return false;	 
    	 }
    	 
     }
/* This method determines the nth number of the sequence. The loop iterates up to and including a 
 * given index and collects the sum of indices.  The Mason Sequence is (1, 3, 6, 10 ....):
 * Each number in the sequence is the sum of all of the numbers of it's index. For example, index 3 is 6 
 * which is 0 + 1 + 2 + 3 = 6.
 */
     public static int masonSequence(int num){
    	 int sequence = 0;
    	 for (int i = 0; i <= num; ++i) {
    		 sequence += i;	 
    	 } 
    	 return sequence;
     }
/* The helper method determines the sum of digits of a number. It takes the last digit 
 * and adds it to sum variable and removes the same digit. This process continues until
 * number becomes 0. 
*/ 
	 private static int sumOfDigits(int num) {
		 int sum = 0;
		 while (num >0) {
			 sum += num%10;
			 num = num/10;
		 }
		 return sum;
	 }

/* This method determines if the reverse of a num is same as the num.  The loop removes the last digit 
 * and makes it the first digit of a new number reverseNum. Consecutive removal 
 * will be next digit of a reverseNum. If the original num is same as reverseNum, that 
 * the number is reversible. 
 */
	 
	 private static boolean isReverse(int num) {
		 int origNum = num;// ensure that when we modify num, original still remain 
		 if (origNum <0) {
			 origNum *= -1;
		 }
		 int pow = numberOfDigits(num)-1;
		 int reverseNum =0;
		 while (num > 0) {
			 int temp = num%10;
			 num  /= 10;
			 reverseNum += temp * (int)Math.pow(10,pow);
			 -- pow;	 
		 }
		 if (reverseNum == origNum) {
			 return true;
		 }
		 else{
			 return false;
		 }
	 }
	 
/* This method utilizes the sumOfDigits method and the isPrime helper method to determine 
 * if there is a prime factor whose sum of integers adds up the sum of integers of 
 * parameter num. The outer loop iterates and finds the numbers i.e i that is prime and can 
 * divide num without the remainder. The inner loop finds if there is only one i or more than one i that 
 * can divide the quotient. There are two variables that track the sum and the multiples of prime numbers. 
 * In order number to be a reversible sum, the following variables need to be equal: the variable multiple to num and sum of  
 * the digit of num to sum of the digits of the prime numbers. Otherwise, this method returns false. 
 */
	 public static boolean isReversibleSum(int num) {
		 if (num < 0) {  
			 num *= -1; // sign does not effect how many prime factors it has. It could be all prime factors times -1.
		 }
		 if (isReverse(num) == false) {
			 return false;
		 }
		 int sum = sumOfDigits(num);
		 int multiple = 1;  // multiplication of number that is prime and can divide num variable 
		 int sum1 = 0; // sum of prime numbers that can divide num without remainder. 
		 int quotient;
		 for (int i = 2; i < num/2 +1; i++) {
			 if (num % i == 0 && isPrime(i)) {
				 quotient = num/i ;
				 multiple *= i;
				 while (true) {
					 if (quotient%i ==0) {
						 quotient /= i;
				    	 multiple *= i; 
				    	 sum1 += sumOfDigits(i);
					 }
					 else {
						 break;
					 }
				 }
				 sum1 += sumOfDigits(i);
				 if (multiple == num && sum1 == sum) {
					 return true;
				 }	  
			 }
		 }
		 return false;
		 }
/* This method determines two factors: size of the array and the sum subset of arrays.
 * The two variables that start and end keeps track of where to start and where to end when we 
 * are determining whether the sum of sub set is equal to the first element. The sub sets of elements 
 * starts from 2 elements and increases by one. The start and end variables determine where the 
 * sub set array will start and where it will end. If the size of the argument array is not right, then
 * when we determine the subsets, the start variable will exceed the size of an array, which automatically 
 * returns false. 
 *      
 */
	 public static  boolean isIncremental(int array[]) {
			int start = 1;
			int end = 2;
			while (end < array.length) {
				int sum = 0;
				while (start != end+1) {
					if (start >= array.length) {
						return false;
					}
					sum += array[start];
					++start;
				}
				if (sum != array[0]) {
					return false;
				}
				else {
					end += (start);
				}
				
			}
			return true;
		}

/* The helper method finds the biggest value in an array starting from index i 
 * to the end of the array, and returns the biggest value as an integer.  
 */

	 private static int maxValue(int[] data, int i) {
		 int maxValue = data[i];
		 for (int j = i+1; j < data.length; ++j) {
			 if (data[j] >= maxValue) {
				 int tempValue = maxValue;
				 maxValue = data[j];
				 data[j] = tempValue;			 
			 }
		 }
		return maxValue;
		  
	 }
/* The maxValue method is used to sort the elements. Each iteration of the loop the helper method
 * maxValue returns a biggest value from index i to remaining of the list.  The returned value gets assigned 
 * a given index i. 
 */	
	 public static void descendingSort (int [ ] data){
		  for (int i = 0; i < data.length; ++i) {
			 data[i] = maxValue(data, i);
		 }	 
	}
/* This method takes one element from the array and checks if one of remaining elements in the 
 * array adds up to 18, and tracks how many elements pair with variable numOfPairs. If numOfPairs 
 * exceeds one, it returns false since criteria requires only one pair. At the end, it 
 * checks if there is a pair that adds up to 18 in a given list. 
 */
	 public static boolean isPairArray(int array[]) {
		 int numOfPairs = 0;
		 for (int i = 0; i < array.length; ++i) {
			 for (int j = i + 1; j < array.length; ++j) {
				 if (array[i] + array[j] == 18) {
					 ++ numOfPairs;
					 if (numOfPairs > 1) {
						 return false;
					 }
				 }	 
			 }
		 }
		 
		 if (numOfPairs < 1) {
			 return false;
		 }
		 else {
			 return true;
		 }
	}
/* This method creates an array size of n*n. The outer loop iterates n times and 
 * inner loop iterates and keeps track of the index. When the array is created, all the 
 * values initialize to 0. The below method only changes the elements that are not 
 * supposed to be 0. The loop starts to change values of the array from last element or
 * right to left. 
 */
	 public static int [ ] arrayPattern(int n) {
		 int size = n*n;
		 int[] array = new int[size];
		 for (int i = n; i >= 1; --i ) {
			 int num = 1;
			 for (int j = n*(i)-1; j >= n*(i-1); --j) {
				 array[j] = num++;
				 if (num > i) {
					 break;			 
				 }	 		 	 	 
			 }	  
		 } 
		 return array; 
	}
/* This method determines if the sum of the elements up to element at index i is equal to 
 * element at the index i. The outer loop starts from the end of the array and the inner loop calculates 
 * the sum of elements up to the element. If sum does not equal to the element, then it returns false 
 * since there is no point of looking further.  
 */
	 public static boolean isSummative(int array[]) {
		 for (int j = array.length-1; j >= 1; --j) {
			 int sum = 0;
			 for (int i = 0; i < j; ++i) {
				 sum += array[i];
			 }
			 if (sum != array[j]) {
				 return false;
			 }
		 }
		 return true;
	}
 		
}
