package georest;
import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
//import java.util.Map;

public class Solution {

	boolean showDetails=false;
	//char myChar='v';
	//int numberOfStairs=5;
	//@Parameters(numberOfStairs)
	//@Test	
	public void printStairs(int numberOfStairs){ //2
		System.out.println("<<<<<<<< In printStairs    >>>>>>>>>>>>>>> ");

		if (numberOfStairs<1)  System.out.println("Illegal input, needs to be at least 1");

		else {
			for (int i = 0; i < numberOfStairs; i++) {

				for (int j = 0; j < 5 - i; j++) {
					System.out.print("");
				}
				for (int k = 0; k <= i; k++) {
					System.out.print("# ");
				}
				System.out.println();
			}
		}
		System.out.println("\n >>> Printing Stairs-5");
	}

	@Test
	public int reverseNumber(int number){  //1357
		System.out.println("<<<<<<<< In  reverseNumber   >>>>>>>>>>>>>>> ");

		int reverse = 0;
		while(number != 0){
			reverse = (reverse*10)+(number%10);
			number = number/10;

			if(showDetails) System.out.println("reverse is: "+reverse+ "  number is: "+number);
		}
		System.out.println("reverse is: "+reverse);
		return reverse;
	}


	public void printBinaryFormat(int number){ //25
		System.out.println("<<<<<<<< In  printBinaryFormat   >>>>>>>>>>>>>>> ");
		int binary[] = new int[25];
		int index = 0;
		System.out.println("Print binary of a given integer: "+number);
		while(number > 0){
			binary[index++] = number%2;
			number = number/2;
			if(showDetails) System.out.println("number now is: "+number);
		}
		for(int i = index-1;i >= 0;i--){
			System.out.println("Binary of "+i+"=" + binary[i]);
		}
	}


	public int findMiddleIndex(int[] numbers){
		System.out.println("<<<<<<<< In  findMiddleIndex   >>>>>>>>>>>>>>> ");

		int endIndex = numbers.length - 1;
		int startIndex = 0;
		int sumLeft = 0;
		int sumRight = 0;
		while (true) {
			if (sumLeft > sumRight) {
				sumRight += numbers[endIndex--];
				System.out.println("endIndex is: "+endIndex+ "  sumRight is " +sumRight );
			} else {
				sumLeft += numbers[startIndex++];
				System.out.println("startIndex is: "+startIndex+ "  sumLeft is " +sumLeft );
			}
			if (startIndex > endIndex) {

				if (sumLeft == sumRight) {
					break;
				} else {
					System.out.println("Please pass proper array to match the requirement");
					return -1;
							
				}
			}
		}
		return endIndex;
	}

	public int[] twoSum(int[] nums, int target) {
		System.out.println("<<<<<<<< In  twoSum   >>>>>>>>>>>>>>> ");

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {

			int complement = target - nums[i];

			if (map.containsKey(complement)) {

				System.out.println(" twoSum >>>  indices are " +map.get(complement)+" and "+ i );

				int[] values= { map.get(complement), i };
				return values;
			}
			map.put(nums[i], i);
			System.out.println(" indecies map now is " +map.get(complement)+" and "+ i );
		}
		throw new IllegalArgumentException("No two sum solution");
	}


	public int[] twoSumNew(int[] numbers, int target) {
		System.out.println("<<<<<<<< In  twoSumNew   >>>>>>>>>>>>>>> ");
		
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				result[1] = numbers[i];
				result[0] = map.get(target - numbers[i]);
				return result;
			}
			map.put(numbers[i], i);
		}
		return result;
	}

/*
 * a series of numbers in which each number is the sum of the two preceding numbers.
 *  The simplest is the series 1, 2, 3, 5, 8, etc.
 */

	public int fibonacciNumber(int numPosition) {
		
		int firstNum=2;
		int secondNum=3;;

		if (numPosition<0) return -1;  // we won't do negative
		if (numPosition<4) return numPosition;

		for (int i=4;i<=numPosition;i++) {
			int sum =firstNum+secondNum;
			firstNum=secondNum;
			secondNum=sum;
		}
		return secondNum;
	}

	public int fiboTailRecursion(int number){
		
		if(number == 1 || number == 2){
			return 1; 
			} 
		if(showDetails)System.out.println("<<<< currentFibo 2 > "+number);		
		return fiboTailRecursion(number-1) + fiboTailRecursion(number -2); //tail recursion }
	}
	
	//have to pass initial numbers, 
	public int fibonacciRecursive(int numPosition, int firstNum, int secondNum) {
		
		if (numPosition<4) return secondNum;  // .......
		int sum =firstNum+secondNum;

		firstNum=secondNum;
		secondNum=sum;
		System.out.println("<<<< firstNum > "+firstNum+" secondNum > " +secondNum);
		return fibonacciRecursive(numPosition-1,firstNum, secondNum );
	}

	public  void SimpleArraySum () {
		System.out.println("<<<<<<<< In SimpleArraySum    >>>>>>>>>>>>>>> ");
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int numberOfInts=0;
		int sum = 0;
		try {
			numberOfInts = bufferedReader.read();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//int[] arrayOfIntegers=new int[numberOfInts] ;
		try {
			System.out.println("Please enter a number: \n");
			numberOfInts = bufferedReader.read();
			numberOfInts=numberOfInts/10;
			System.out.println("numberOfInts =: "+numberOfInts+"\n");

			for(int i = 0; i < numberOfInts; i++) {

				sum += bufferedReader.read();
				System.out.println("In the loop ---- and the sum is: "+sum);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println("The sum is: "+sum);
	}
	
	public String reverseStringRecursive(String str){
		
		String reverse = "";
		if(str.length() < 2){
			return str;
		} else {
			reverse += str.charAt(str.length()-1) + 
					reverseStringRecursive(str.substring(0,str.length()-1));
		}
		if (showDetails) System.out.println("The reversed word is: "+reverse);
		return reverse;
	}

	
	public String reverseString(String str){
		System.out.println("<<<<<<<< In  reverseString   >>>>>>>>>>>>>>> ");
		
			String reverse = "";
		
	      for(int i = str.length() - 1; i >= 0; i--)
	        {
	            reverse = reverse + str.charAt(i);
	        }
	      	System.out.println("Reversed string is:");
	        System.out.println(reverse);
	        return reverse;	
	}
	

	public String reverseStringStack(String s) {
		System.out.println("<<<<<<<< In   reverseStringStack  >>>>>>>>>>>>>>> ");
		
		Stack<Character> charStack = new Stack<>();
		String reversed = "";
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			charStack.push(ch);
		}
		
		for (int i = 0; i < s.length(); i++) {
			char ch = charStack.pop();
			reversed += ch;		}
		System.out.println("The reversed string by Stack is:  " + reversed);
		return reversed;
	}


	public String reverseSentence(String s) {
		System.out.println("<<<<<<<< In   reverseSentence  >>>>>>>>>>>>>>> ");
		if (s == null || s.isEmpty()) return s;
		
		String[] split = s.split(" ");
		String result = "";

		for (int i = split.length - 1; i >= 0; i--) {
			result += (split[i] + " ");
		}
		System.out.println(result.trim());
		return result.trim();
	}

	public String reverseWithoutSplit(String s){
		System.out.println("<<<<<<<< In   reverseWithoutSplit  >>>>>>>>>>>>>>> ");
		if (s == null || s.isEmpty()) return s;

		int spaceIndex = 0;
		int startIndex = 0;

		int length = s.length();
		StringBuilder reversedSentence = new StringBuilder();

		while (spaceIndex > -1){
			spaceIndex = s.indexOf(' ', startIndex);
			if (spaceIndex > -1) reversedSentence.insert(0, s.substring(startIndex, spaceIndex)).insert(0, ' ');

			else reversedSentence.insert(0, s.subSequence(startIndex, length));

			startIndex = spaceIndex + 1;
		}

		return reversedSentence.toString();
	}


	// length of substring with non repeating chars
	public int lengthOfLongestSubstring(String s) {
		System.out.println("<<<<<<<< In   lengthOfLongestSubstring  >>>>>>>>>>>>>>> ");
		if (s.length()<2) return s.length();

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max=0;

		for (int i=0, j=0; i<s.length(); ++i){

			if (map.containsKey(s.charAt(i))){
				j = Math.max(j,map.get(s.charAt(i))+1);
			}

			max = Math.max(max,i-j+1);
		}
		System.out.println(" max is >>"+max);
		return max;
	}


	public String collectPerfectNumber(int max) {
		System.out.println("<<<<<<<< In  collectPerfectNumber   >>>>>>>>>>>>>>> ");
		
		String integers="";

		for (int i=0;i<max;i++) {

			if ( isPerfectNumber(i,false) ) {
				integers+=i;
				integers+=", ";
			}
		}
		System.out.println("perfect integers are: "+integers);
		return integers;
	}

	/*
	 * Perfect number, a positive integer that is equal to the sum of its proper divisors. 
	 * The smallest perfect number is 6, which is the sum of 1, 2, and 3. 
	 * Other perfect numbers are 28, 496, and 8,128
	 */
	
	public boolean isPerfectNumber(int number, boolean printOut){
		int temp = 0;
		
		for(int i=1;i<=number/2;i++){

			if(number%i == 0){
				temp += i;
				if (printOut) System.out.println("temp is: "+temp+" i =="+i);
			}
		}
		
		if(temp == number){
			if (printOut) System.out.println(number+" is a perfect number");

			return true;
		} else {
			if (printOut) System.out.println(number+" is NOT a perfect number");
			return false;
		}
	}
	
	public static int[] reverseArray(int[] list) {
		System.out.println("<<<<<<<< In   reverseArray  >>>>>>>>>>>>>>> ");
		
		   int[] result = new int[list.length];

		   for (int i = 0, j = result.length - 1; i < list.length; i++, j--) {
			   
		      result[j] = list[i];
		   }
		   return result;
		}

	//==================== 

	public int getNumberOfWords(String sentence)
	{
		System.out.println("<<<<<<<< In  getNumberOfWords   >>>>>>>>>>>>>>> ");
		int counter=0;
		for(int i=0;i<sentence.length();i++)
		{
			if(sentence.charAt(i)==' ')
				counter++;
		}
		return counter+1;
	}

	public char[] getSubString(String sentence,int start,int end){ 
	//method to give substring, replacement of String.substring() 
		System.out.println("<<<<<<<< In  getSubString   >>>>>>>>>>>>>>> ");
		
		int counter=0;
		char charArrayToReturn[]=new char[end-start];
		for(int i=start;i<end;i++)
		{
			charArrayToReturn[counter++]=sentence.charAt(i);
		}
		return charArrayToReturn;
	}
	
    public static String sortString(String inputString) 
    { 
        // convert input string to char array 
        char tempArray[] = inputString.toCharArray(); 
          
        // sort tempArray 
        Arrays.sort(tempArray); 
          
        // return new sorted string 
        return new String(tempArray); 
    } 

	public char[][] getWordsFromString(String sentence){
		System.out.println("<<<<<<<< In getWordsFromString    >>>>>>>>>>>>>>> ");
		
		int wordsCounter=0;
		int spaceIndex=0;
		int length=sentence.length();
		char wordsArray[][]=new char[getNumberOfWords(sentence)][]; 
		for(int i=0;i<length;i++)
		{
			if(sentence.charAt(i)==' ' || i+1==length)
			{
				wordsArray[wordsCounter++]=getSubString(sentence, spaceIndex,i+1); //get each word as substring
				spaceIndex=i+1; //increment space index
			}
		}
		return  wordsArray; //return the 2 dimensional char array
	}


	/*    public String joinedString (String stringArray){

      String joinedString="";
      ArrayList <String> stringArrayList=new ArrayList<String>();
      int endString;
      //int [] positions=new int[25];

        for (String str : stringArrayList){
            endString=str.length();
            joinedString= joinedString.concat(stringArray);
        }
        return joinedString;
    }*/

	//perfect integers are: 0, 6, 28, 496, 8128, 


	// find first missing next number// given 1,2,3,4,6 it will return 5
	public int findMissing(int[] numbers) {
		System.out.println("<<<<<<<< In   findMissing  >>>>>>>>>>>>>>> ");

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i]+1 !=numbers[i+1]) {
				System.out.println("Looking missing number in the cycle # " +i);
				return numbers[i]+1;
			}
			else System.out.println("No missing number ");
		}
		return 0;
	}


	public boolean isNumberPrime(int givenNum) {
		
		if (givenNum%2==0) {
			System.out.println("Number: "+givenNum+ " is even >> NOT a prime");
			return false;	   
		}
		if (givenNum<0) givenNum*=-1;	//if range includes negatives, no need to run twice
		if (givenNum<8) {
			System.out.println("Number: "+givenNum+ " is a single digit prime");
			return true;	   
		}

		for(int i=3; i<=givenNum/2; i+=2) {

			if(givenNum%i==0) {
				if(showDetails) System.out.println("\n Dividing  "+givenNum+ " by: "+i+"... is NOT a prime");
				return false;	
			}
		}
		System.out.println("\n Yeah! Number: "+givenNum+ " is prime");
		return true;
	}

	// divider number should be half of the given and odd
	// recursive example
	public void isNumberPrimeRecursive(int givenNum, int dividerNum) {
		System.out.println("<<<<<<<< In   isNumberPrimeRecursive  >>>>>>>>>>>>>>> ");
		
		if (givenNum%2==0) {
			if(showDetails) System.out.println("\n Number: "+givenNum+ " is even!! hence NOT a prime");
			return;	   
		}

		if (dividerNum<3) {
			System.out.println("\n Yeah! Number: "+givenNum+ " is a prime");
			return;
		}
		if(givenNum%dividerNum==0) {
			System.out.println("\n Dividing  "+givenNum+ " by: "+dividerNum+"... is NOT a prime");
			return;	
		}
		isNumberPrimeRecursive(givenNum, dividerNum-2);
	}

	public void stringManipulation() {
		System.out.println("<<<<<<<< In   stringManipulation  >>>>>>>>>>>>>>> ");

		char ch[] = {'M','y',' ','J','a','v','a',' ','e','x','a','m','p','l','e'};
		/**
		 * We can copy a char array to a string by using 
		 * copyValueOf() method.
		 */
		String chStr = String.copyValueOf(ch);
		System.out.println("\n My ----------.chStr .======================..is: " + chStr);


		String myName="Vrezh";
		System.out.println("111111 myName >" +myName);
		myName="asdf";
		System.out.println("222222 myName >>" +myName);
		String onlyName=myName;
		System.out.println("33333 onlyName >>>" +onlyName);
		
		System.out.println("\n myName == onlyName true? :" + (myName == onlyName)); 
		System.out.println("\n myName.equals(onlyName)? : " + myName.equals(onlyName) );

		myName+="_FullName";
		System.out.println("\n myName+=\"FullName\" now is..." +myName);
		System.out.println("\n onlyName  >>>" +onlyName);

		System.out.println(myName == onlyName); 
		System.out.println(myName.equals(onlyName) );

	}
		
	  public void printAllPossibleOrderedPairs(int[] items) {
		  System.out.println("<<<<<<<< In  printAllPossibleOrderedPairs   >>>>>>>>>>>>>>> ");
		  
		  System.out.println("Printing all Pairs: ///////////");
		    
		  for (int firstItem : items) {
		    	
		        for (int secondItem : items) {
		        	
		            System.out.println(firstItem + ", " + secondItem+" -- ");
		        }
		    }
		}
	  
	  public void countWords() throws IOException{
		  System.out.println("<<<<<<<< In  countWords   >>>>>>>>>>>>>>> ");
		  
			BufferedReader reader = new BufferedReader(new FileReader(new File("input.txt")));

		        String inputLine = null;
		        HashMap <String, Integer> dictionary = new HashMap<String, Integer> ();
		        //Map dictionary = new Hashtable();         

		        while((inputLine = reader.readLine()) != null) {

		            // Split the input line.
		            String[] words = inputLine.split("\\s+");             

		            // Ignore empty lines.
		            if(inputLine.equals(""))
		                continue;            

		            for(String word: words) {

		                // Remove any commas and dots.
		                word = word.replace(".", "");
		                word = word.replace(",", "");
		                
		                if(dictionary.containsKey(word)) {

		                    Integer val = dictionary.get(word);
		                    dictionary.put(word, val + 1);
		                }
		                else
		                    dictionary.put(word, 1);
		            }
		        }
		         
		        // Printing all words stored in the map.
		        for(String key: dictionary.keySet())

		            System.out.println(key + ": " + dictionary.get(key));        
		         
		        try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }

	  public String[] findFirstAnagram(String [] input) {
		  System.out.println("<<<<<<<< In  findFirstAnagram   >>>>>>>>>>>>>>> ");
		  
		  for(int i=0; i < input.length; i++ ) {
			  		 
			  
		  }
		  
		return input;		  		  
	  }
	  
	  public boolean compareWordContent(String first, String second) {
		  System.out.println("<<<<<<<< In  compareWordContent   >>>>>>>>>>>>>>> ");

		  if (first.length()!=second.length()) {
			  return false;
		  }
	        char[] charArrayFirst = first.toCharArray();
	        Arrays.sort(charArrayFirst);
	        
	        char[] charArraySecond = second.toCharArray();
	        Arrays.sort(charArraySecond);	        
	        
	        first= String.valueOf(charArrayFirst);	        
	        second= String.valueOf(charArraySecond);
		  		
		 if(first.equalsIgnoreCase(second)) {
			  System.out.println("\n Two strings are now the same: " +first);
			 return true;
		 }	
		 System.out.println("\n Two strings are not the same: first is" +first+"Second is "+second);
		  return false;		  		  		  
	  }
	  
}