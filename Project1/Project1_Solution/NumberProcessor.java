

public class NumberProcessor1 {

	
	
	/**
	 * This private method accepts a number and returns true if the number is 
	 * prime, false otherwise.
	 */
	
	private static boolean isPrime(int n)
	{
		if (n< 2)
			return false;
		else if (n == 2)
			return true;
		else {
			int num = (int)Math.sqrt(n);
			for (int i = 3; i<=num;i+=2) {
				if (n%i ==0)
					return false;
			}
		}
		return true;
	}
	
	/** 
	 * 
	 * This private method is used by isUniquePrime() method 
	 * 
	 */
	
	public static int rotation(int n, int divisor)
	{
		if (n<10)
			return n;
		else
			return (n % divisor)*10 +n/divisor;
	}
	
	
	/** 
	    * 
	    *  This private method accepts an integer and returns the inverse of the integer. 
	    *  For example, if num=456 the method returns 654 (six hundred fifty four). Similarly if num=100000 , it returns 1 (one) 
	    *  it is used for the isReversibleSum() method
	    */

	private static int reverseNum(int num)
	{
		int result=0;
		if (num>0)
			{
				while(num>0)
					{
						int rem = num%10;
						result=result*10+rem;
						num/=10;
					}}
		else {
			while(num<0)
			      {
					int rem = num%10;
					result=result*10+rem;
					num/=10;
			      }
			}
		return result;
	}
	
	/** 
	    * 
	    *  This private method accepts an integer and returns the sum of the digits of all its 
	    *  prime factors. 
	    *  For example, if num=121 the method returns 4, which is the sum of its prime factors (11 *11) = 1+1+1+1
	    *   
	    *  it is used for the isReversibleSum() method
	    */
	 public static int sumPrimeDigits(int n) 
	    { 
	        int sum = 0;
	        while (n%2==0) 
	        { 
	           sum+=2;
	            n /= 2; 
	        } 
	  
	        // n must be odd at this point.  So we can 
	        // skip one element (Note i = i +2) 
	        for (int i = 3; i <=n; i+= 2) 
	        { 
	            // While i divides n, print i and divide n 
	            while (n%i == 0) 
	            { 
	            	int num = i;
	                if(num<10)
	                	sum+=num;
	                else {
	                	while (num>0) {
	                		int rem=num%10;
	                		sum+=rem;
	                		num/=10;
	                	}
	                }
	                n /= i; 
	            } 
	        } 
	     return sum;
	       } 
	 
	 /** 
	    * 
	    *  This private method accepts an integer and returns the sum of the digits in the number. 
	    *  For example, if num=121 the method returns 4, which is the sum of its digits 1+2+1
	    *   
	    *  it is used for the isReversibleSum() method
	    */
	 
	 private static int sumDigits(int num) 
	    { 
	        int sum = 0;
	       	if(num<10)
	       		sum+=num;
	       	else
	       	{
	       	   while (num>0) {
	               int rem=num%10;
	               sum+=rem;
	                num/=10;
	                }
	       	}
	        return sum;
	       } 
	 
	 /** 
	    * 
	    *  This private method accepts an integer and returns the  right n digits in the number. 
	    *  For example, if num=121 the method returns 21 for n=2
	    *   
	    *   it is used for the isSquareAdditive() method
	    */
	 
	 private static int nRightDigits(int num, int n) 
	    { 
	        int result = 0;
	        int i = 0;
	       	   while (num>0 && i<n) {
	               int rem=num%10;
	               result += rem*Math.pow(10, i);
	                num/=10;
	                i++;
	                }
	          return result;
	       } 
	 
	 /** 
	    * 
	    *  This private method accepts an integer and returns the  Left n digits in the number. 
	    *  For example, if num=121 the method returns 12 for n=2
	    *   
	    *   it is used for the isSquareAdditive() method
	    */
	 
	 private static int nLeftDigits(int num, int n) 
	    { 
	        int result = 0;
	        int i = 0;
	        int dig = numOfDigits(num);
	        int dif = dig - n;
	        while(dif>0)
	        {
	        	num/=10;
	        	dif--;
	        }
	       	   while (num>0 && i<n) {
	               int rem=num%10;
	               result += rem*Math.pow(10, i);
	                num/=10;
	                i++;
	                }
	          return result;
	       } 
	 
	 
	 /** 
	    * 
	    *  This private method accepts an integer and returns the number of the digits in the number. 
	    *  For example, if num=121 the method returns 3
	    *   
	    *  it is used for the isSquareAdditive() method
	    */
	 private static int numOfDigits(int num) 
	    { 
	        int digit = 0;
	       	if(num<10)
	       		digit+=1;
	       	else
	       	{
	       	   while (num>0) {
	                digit+=1;
	                num/=10;
	                }
	       	}
	        return digit;
	       } 
	 
	/** 
    *
    *  This method returns true if its integer argument is "special", otherwise it returns false
    *  A number is defined to be special if where sum of its aliquot divisors equals to the number itself.   
    *  For example, 6 and 28 are "special whereas 4 and 18 are not.
    *  
*/
	public static boolean isSpecial(int input) {
       boolean result = false;
       int sum=0;   // intialize the sum 
       if(input == 0)
    	   result = false;
       else
       { 
    	     
    	   for(int i=1;i<input;i++)
    	   		{
    		   		if (input%i == 0)     // if i is an aliquot divisor
    		   				sum+=i;
    	   			}
    	   if (sum == input)
    		   result = true;
       }
         return result;
	}
	
	/**  
	    * 
	    * This method returns true if a number is "UniquePrime", false otherwise. 
	    * A number is called "UniquePrime", if the number is a prime number and if
	    *  we repeatedly move the first digit of the number  to the end, the number still remains prime. 
	    *  For example, 197 is a prime number, if we move the first digit to the end, 
	    *  we will have a number 971, which is a prime number, if we again move the first digit to the end, we get 719, which is a prime number.
	    * 
	    */
	 public static boolean isUniquePrime(int num){
		boolean result = true;
		int digits=0, divisor =1, n=num,newNum=n;
		 while (n>0) {
			 digits++;
			 n/=10;
			 }
		 divisor = (int) Math.pow(10, digits-1);
		 do {
			 newNum = rotation(newNum, divisor);
			 if(!isPrime(newNum))
				 result = false;
		 }while(newNum!=num);
		
		 return result;
	}
	
	 /** 
	    * 
	    * Considering the sequence 
        *            1, 3, 6, 10, 15, 21, 28, 36, ...

        * The method returns the nth sequence number. If n is <= 0, it returns 0
	    *
	    */
	 public static int masonSequence(int num)
	{
		if (num<=0)
			return 0;
		else
			return (num*(num+1))/2;
	}
	
	
	
	
	 /** 
	    * 
	    * A composite integer is called ReversibleSum if it fulfills the following two conditions:
	    * 
	    * 1. The sum of its digits is the same as the sum of the digits of its prime factors. For example, 121 has two prime factors 11 * 11. 
	    *        The sum of the digits of the two prime factors is 1 + 1 + 1 + 1 = 4 and the sum of the digits of 121 is 1 + 2 + 1 = 4.
	    * 2. The reverse of the number equals to the number itself. For example, 121 has a reverse 121.
	    *
	    *   The method returns true if the number is ReversibleSum
	    */
public static boolean isReversibleSum(int num)
	{
		boolean result = false;
	    boolean isPrimeSum =false;
		boolean isRev= false;
		 if(sumPrimeDigits(num)==sumDigits(num))
			 isPrimeSum = true;
		 if(num==reverseNum(num))
			 isRev= true;
		if( isRev==true && isPrimeSum== true)
			result = true;
		return result;
	}
	
	/** 
	    * 
	    * This method accepts an  integer and returns true if the number is SquareAdditive, false otherwise.
	    * onsider a k-digit number n. Square it and add the right k digits to the left k or k-1 digits. If the resultant sum is n, then n is called a SquareAdditive number. 
	    * For example, 9 is a SquareAdditive number
	    *
	    */  
  public static boolean isSquareAdditive(int num)
	{
		boolean result=false;
		int sqNum = num*num;
		int digitNum = numOfDigits(num);
		int sqDigitNum = numOfDigits(sqNum);
		int kRight= nRightDigits(sqNum,digitNum);
		int kLeft = nLeftDigits(sqNum, sqDigitNum-digitNum);
		if(num == (kLeft+kRight))
			result=true;
		return result;
	}
	
  
  /** 
   * 
   * This method evaluate and returns the solution of the polynomial anxn + an-1xn-1 + ... + a1x1 + a0
   *
   * it is used by isIncremental method
   */
public static double evaluate(double x, int[] coefficient)
{
	double result=0.0;
	for(int i=coefficient.length-1;i>=0;i--)
		result+=coefficient[i]*Math.pow(x, i);
	return result;
}
  
  /**
   * 
   * This private method accepts a, b, c coefficients of 
   * a quadratic equation and returns if a positive root 
   * is found. The method is used by isIncremental method 
   */
	private static boolean roots( double a, double b, double c) {
		
		boolean result = false;
		double det = Math.pow(b, 2)- 4*a*c;
		double[] roots= new double[2];
		if(det>0) 
		{
			roots[0] = (-b+Math.sqrt(det))/(2*a);
			roots[1] = (-b-Math.sqrt(det))/(2*a);
		}
		else if(det==0)
		{
			roots[0]=roots[1]=-b/(2*a);
		}
		else
			roots[0]=roots[1]=0;

		int[] intRoots = new int[2];
		intRoots[0] = (int)roots[0];
		intRoots[1] = (int)roots[1];
		if(roots[0]>0)
		{
			if (evaluate((int)roots[0], new int[]{(int)c,1,1})==0)
					result=true;
		}
		else if(roots[1]>0)
			{
			 if  (evaluate((int)roots[1], new int[]{(int)c,1,1})==0)
				   result=true;
			}
		
		return result;
			}
	
  
  /** 
   * 
   * This method returns true if the array is Incremental false otherwise. 
   * An array is called Incremental if it has the following properties:
   *        - The value of the first element equals the sum of the next two elements, which is equals to the next three elements, equals to the sum of the next four elements, etc.
   *        - It has a size of x*(x+1)/2 for some positive integer x .
   *
   *  For example {6, 2, 4, 2, 2, 2, 1, 5, 0, 0} isIncremental, whereas {2, 1, 2, 3, 5, 6} is not
   */
  
  public static boolean isIncremental( int[] array)
	{
		boolean result=false;
		boolean size  = roots(1,1,-(2*array.length));
		if(size)
		{
			if(array.length==1)
				result=true;
			else
			{
			int sum = array[0];
			int j=2, i=1;
			while(true)
			{
				result = true;
				int sum2 = 0;
				for(int k=i;k<i+j;k++)
					sum2+=array[k];
				if(sum!=sum2)
				{
					result=false;
					break;
				}
				if(i+j>=array.length)
					break;
				i=i+j;
				j++;
   		}
				}}
		
	return result;
	}
	
	/** 
	    * 
	    *  this method accepts positive integer and returns an array of size n2 with elements in a specific pattern. 
	    *  For example, for n = 2, the method returns an array with elements {0,1,2,1}.
	    */
  public static int [ ] arrayPattern(int n)
	{
		int[] newArray = new int[n*n];
		if(n==0)
			return newArray;
		
		for(int i=n-1;i<newArray.length;i+=n) {
			for (int j = i; j>=i-i/n;j--)
				newArray[j]=i-j+1;
		}
		return newArray;
	}
 
    
	
	
	/** 
	    * 
	    * This method returns true if the array is PairArray, false otherwise.
	    * An array is called PairArray if exactly one pair of its elements sum to 18. 
	    * For example, {4,16,14, 13} is PairArray as only 4 and 14 sum to 18
	    * The array {18,3,0,15,5} is not PairArray as more than one pair (18,0) and (3,15) sum to 18. 
	    * {4,1,11} is not also PairArray as no pair sums to 18
	    *
	    *
	    */
	public static boolean isPairArray(int array[])
	{
		boolean result = false;
		int  count =0;
		if(array.length<=1)
			return false;
		for (int i=0;i<array.length;i++)
		{
			for(int j = i+1;j<array.length;j++) {
				if (array[i]+array[j]==18)
					count++;
			    }
		  }
		if(count==1)
			result=true;
		return result;
		
	}
	
	/** 
	   * 
	    * This method accepts array of integers and sort the array using Selection sort.
	    *   
	    */
	 public static void descendingSort (int [ ] data)
    { 
            for (int i = 0; i < data.length-1; i++) 
            	{ 
            		int max = data[i];
            		int max_idx = i; 
            		for (int j = i+1; j < data.length; j++) 
            			{
            				if (data[j] > max) {
            						max = data[j];                
            						max_idx = j; 
            					}
            			}
            // Swap the found minimum element with the assumed maximum element 
            int temp = data[max_idx]; 
            data[max_idx] = data[i]; 
            data[i] = temp;
            	}
    }
	  /** 
	    * 
	    * This method returns true if the array is Summative, false otherwise.
	    * An array is called Summative if the nth element (n >0) of the array is the sum of the first n elements. 
	    * 
	    * For example, {2, 2, 4, 8, 16, 32, 64} is Summative, whereas {1, 1, 2, 4, 9, 17} is not.
	    *
	    */
	     
	   
		public static boolean isSummative(int [] input)
		{
			boolean result=true;
			if (input.length==0)
			    result=false;
			else if(input.length==1)
				result=true;
			else {
				for (int j = input.length-1;j>0;j--)
				{
					int sum = 0;
				for(int i =j-1;i>=0;i--)
					sum+=input[i];
				if(sum!=input[j])
				   {
					  result=false;
					  break;
				   }
				}
			}
			return result;
	} 
		
		public static void main (String args[])
		{
			
			int array1[] []={ {2,17,25,0,-13, 10,0},{18},{18,0,0,0},{14,4,7,8},{12,9,6,9}};
			//int array[] = {1,9,10,45,34,55,99,703,999,222};
			 NumberProcessor1.arrayPattern(3);
		int array[] =	{297,1,5,54,555,2728,5292,452};
			for (int i: array)
			//	System.out.print(i +" , ");
			
			System.out.print(NumberProcessor1.isSquareAdditive(i)+"  ");
		}
		
	
	}

	


