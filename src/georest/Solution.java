package georest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.InputStreamReader;
//import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;
//import java.util.Map;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
///////////////////////////// Develop Branch /////////////////////
public class Solution {

	boolean showDetails=false;
	//char myChar='v';
	//int numberOfStairs=5;
	//@Parameters(numberOfStairs)

	public void printStairs(int numberOfStairs){ //2
		System.out.println("<<<<<<<< In printStairs    >>>>>>>>>>>>>>> ");

		if (numberOfStairs<1||numberOfStairs>30) {
			System.out.println("Error: Number of stairs has to be between 1-30");
		}

		else {
			for (int i = 0; i < numberOfStairs; i++) {

				for (int j = 0; j < 5 - i; j++) {
					System.out.print("");
				}
				for (int k = 0; k <= i; k++) {
					System.out.print("# ");
				}
			}
			System.out.println("\n >>> Printing "+numberOfStairs+" stairs");
		}
	}

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
	/***
	 * 
	 * @param numbers (array of numbers)
	 * @param target - sum of two numbers
	 * @return two numbers in the array that will make up the target
	 */

	public HashMap<Integer,Integer> twoSumFast(int[] numbers, int target) {
		System.out.println("<<<<<<<< In  twoSumNew   >>>>>>>>>>>>>>> ");
		if(numbers.length<1) {
			System.out.println("\n Need at least two numbers");
			return null;
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 0;
		int firstNumber;
		int secondNumber;

		for (int i = 0; i < numbers.length; i++) {		
			firstNumber = numbers[i];	

			for (int j=i+1; j< numbers.length; j++) {	
				secondNumber = target - firstNumber;
				if(numbers[j] == secondNumber) {
					map.put(count,firstNumber);
					map.put (count++,secondNumber);							
					return map;
				}			
			}
		}
		System.out.println("No such element found");
		return null;
	}


	/*
	 * a series of numbers in which each number is the sum of the two preceding numbers.
	 *  The simplest is the series 1, 2, 3, 5, 8, etc.
	 */

	public int fibonacciNumber(int numPosition) {
		if (numPosition<0) return -1;  // we won't do negative
		if (numPosition<4) return numPosition;

		int firstNum=2;
		int secondNum=3;;

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
		if (str.length()<2) return str;
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

	
	public boolean findStringInSentence(String w, String s) {
		System.out.println("<<<<<<<< In   indStringInSentence  >>>>>>>>>>>>>>> ");
		if (s == null || s.isEmpty()) return false;
		if (w == null || w.isEmpty()) return false;
		String[] split = s.split(" ");

		for (int i= 0; i < split.length - 1;  i++) {
			
			if(w== (split[i])) {
				System.out.println("Found string "+w+ "in sentence "+s);
				return true;
			}
			
		}

		return false;
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

			if ( isPerfectNumber(i) ) {
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

	public boolean isPerfectNumber(int number){
		int temp = 0;
		for(int i=1;i<=number/2;i++){

			if(number%i == 0){
				temp += i;
				if (showDetails) System.out.println("temp is: "+temp+" i =="+i);
			}
		}
		if(temp == number){		
			System.out.println(number+" is a perfect number");
			return true;
		} else {
			System.out.println(number+" is NOT a perfect number");
			return false;
		}
	}

	public int[] reverseArray(int[] list) {
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

	public String sortString(String inputString) 
	{ 
		// convert input string to char array 
		char tempArray[] = inputString.toCharArray(); 

		// sort tempArray 
		Arrays.sort(tempArray); 

		// return new sorted string 
		return new String(tempArray); 
	} 

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

	public boolean isPrime(int n) 
	{
		if (n <= 1) 
			return false; 
		if (n <= 3) 
			return true; 
		// This is checked so that we can skip 
		// middle five numbers in below loop 
		if (n % 2 == 0 || n % 3 == 0) {
			System.out.println("\nNumber: "+n+ " is NOT a prime divisible by 2 or 3");
			return false; 
		}


		for (int i = 5,j=1; i * i <= n; i = i + 6,j++) {
			System.out.println("\n Iteration # "+j);
			if (n % i == 0 || n % (i + 2) == 0) {
				System.out.println("\nNumber: "+n+ " is NOT a prime");
				return false; 
			}
		}
		System.out.println("\n Yeah! Number: "+n+ " is prime");
		return true; 
	} 
	// divider number should be half of the given and odd
	// recursive example
	public boolean isNumberPrimeRecursive(int givenNum, int dividerNum) {
		System.out.println("<<<<<<<< In   isNumberPrimeRecursive  >>>>>>>>>>>>>>> ");

		if (givenNum%2==0) {
			if(showDetails) System.out.println("\n Number: "+givenNum+ " is even!! hence NOT a prime");
			return false;	   
		}

		if (dividerNum ==(givenNum/2)) {
			System.out.println("\n Yeah! Number: "+givenNum+ " is a prime");
			return false;
		}
		if(givenNum%dividerNum==0) {
			System.out.println("\n Number  "+givenNum+ "... is NOT a prime!");
			return false;	
		}
		return isNumberPrimeRecursive(givenNum, dividerNum-2);
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

	public int countWords(String inputLine){
		System.out.println("<<<<<<<< In  countWords   >>>>>>>>>>>>>>> ");
		int val=0;
		HashMap <String, Integer> dictionary = new HashMap<String, Integer> ();
		//Map dictionary = new Hashtable();         
		// Split the input line.
		String[] words = inputLine.split("\\s+");             

		for(String word: words) {
			// Remove any commas and dots.
			word = word.replace(".", "");
			word = word.replace(",", "");

			if(dictionary.containsKey(word)) {
				val = dictionary.get(word);
				dictionary.put(word, val + 1);
			}
			else
				dictionary.put(word, 1);			
		}
		// Printing all words stored in the map.
		for(String key: dictionary.keySet()) {

			System.out.println(key + ": " + dictionary.get(key));   
		}
		System.out.println("Number of words is: " +val); 
		return val;
			
	}

	public void countWordsReadLine() throws IOException{
		System.out.println("<<<<<<<< In  countWords   >>>>>>>>>>>>>>> ");

		BufferedReader reader = new BufferedReader(new FileReader(new File("input.txt")));

		String inputLine = null;
		HashMap <String, Integer> dictionary = new HashMap<String, Integer> ();
		//Map dictionary = new Hashtable();         

		while((inputLine = reader.readLine()) != null) {

			// Split the input line.
			String[] words = inputLine.split("\\s+");             

			// Ignore empty lines.
			if(inputLine.equals("")) continue;            

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
	//anagrams 
	public String[] findFirstAnagram(String [] input) {
		System.out.println("<<<<<<<< In  findFirstAnagram   >>>>>>>>>>>>>>> ");

		for(int i=0; i < input.length; i++ ) {
			//TODO write code here
		}
		return input;		  		  
	}

	protected boolean isAnagramWithSort(String string1, String string2) {
		if (string1.length() != string2.length()) {
			return false;
		}
		char[] a1 = string1.toCharArray();
		char[] a2 = string2.toCharArray();
		Arrays.sort(a1);
		Arrays.sort(a2);
		boolean isAnagram= Arrays.equals(a1, a2);
		if (isAnagram) {
			System.out.println("\nStrings "+string1+" and "+string2+" are anagrams\n");
		}
		else {
			System.out.println("\nStrings "+string1+" and "+string2+" are NOT anagrams\n");
		}
		return isAnagram;
	}

	// find if a word is present in the sentence

	public boolean findWordInSentence(String word, String sentence, boolean caseSensitive) {

		if(word.length()<1 ||sentence.length()<1) return false;
		if(word.length() > sentence.length()) return false;
		if(!caseSensitive) {
			word = word.toUpperCase();
			sentence = sentence.toUpperCase();						
		}
		String strSentence = sentence;
		int intIndex = strSentence.indexOf(word);

		if(intIndex == - 1) {
			System.out.println("String "+word+" not found in sentence: "+sentence);
			return false;
		} else {
			System.out.println("String "+word+" found in sentence: "+sentence);
			return true;
		}
	}
	// check if two strings have the same letters in any order
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

	public void enqueueDequeueExample(){
		//A Queue in Java is just an interface.
		//LinkedList class implements Queue interface.

		Queue<String> citiesQueue = new LinkedList<>();

		citiesQueue.add("New York");
		citiesQueue.add("Seattle");
		citiesQueue.add("Edmonds");
		citiesQueue.add("Moscow");
		citiesQueue.add("Tokyo");

		System.out.println("CitiesQueue : " + citiesQueue);
		System.out.println("Size of waitingQueue : " + citiesQueue.size());
		// Removing an element from the Queue using remove() 
		//(The Dequeue operation)
		// The remove() method throws NoSuchElementException if the Queue is empty
		if(!citiesQueue.isEmpty()) {
			String name = citiesQueue.remove();
			System.out.println("Removed from Queue : " + name + 
					" | New CitiesQueue : " + citiesQueue);
			{

				// Removing element from the Queue using poll()
				// NOTE: poll() method returns null if the Queue is empty.
				name = citiesQueue.poll();
				System.out.println("Removed from Queue : " + name +
						" | New CitiesQueue : " + citiesQueue);
			}
		}
	}
	// =================== PALINDROMES = reads back and forth same===============
	//In this approach, we'll simply iterate over the input string to find all the substrings. 
	//At the same time, we'll check whether the substring is a palindrome or not:
	public Set<String> findAllPalindromesUsingBruteForceApproach(String input) {
		Set<String> palindromes = new HashSet<>();
		for (int i = 0; i < input.length(); i++) {
			for (int j = i + 1; j <= input.length(); j++) {
				if (isPalindrome(input.substring(i, j))) {
					palindromes.add(input.substring(i, j));
				}
			}
		}
		return palindromes;
	}

	private Set<String> findPalindromes(String input, int low, int high) {
		Set<String> result = new HashSet<>();
		while (low >= 0 && high < input.length() && input.charAt(low) == input.charAt(high)) {
			result.add(input.substring(low, high + 1));
			low--;
			high++;
		}
		return result;
	}
	// this is for the whole string compare
	private boolean isPalindrome(String input) {
		StringBuilder plain = new StringBuilder(input);
		StringBuilder reverse = plain.reverse();
		return (reverse.toString()).equals(input);
	}

	//centralization approach: consider each character as the pivot and
	// expand if the characters on the left and right side match, qualifying 
	// the string to be a palindrome, we continue to the next character.
	// 
	// demonstration wherein we'll consider each character as the center of a palindrome:

	public Set<String> findAllPalindromesUsingCenter(String input) {
		Set<String> palindromes = new HashSet<>();
		for (int i = 0; i < input.length(); i++) {
			palindromes.addAll(findPalindromes(input, i, i + 1));
			palindromes.addAll(findPalindromes(input, i, i));
		}
		return palindromes;
	}

	// =================== END PALINDROMES ================

	public String replaceText(String text, HashMap<String, String> namesMap){

		String firstName = namesMap.get("[first name]");  
		String lastName = namesMap.get("[last name]");

		text = text.replace("[first name]", firstName);
		text = text.replace("[last name]", lastName);

		//FOR LOOP
		System.out.println("For Loop:");
		for (Map.Entry<String, String> entry : namesMap.entrySet()) {
			System.out.println("Key: "+entry.getKey() + " & Value: " + entry.getValue());
		}

		//WHILE LOOP & ITERATOR
		System.out.println("While Loop:");
		Iterator<Entry<String, String>> mapIterator = namesMap.entrySet().iterator();
		while (mapIterator.hasNext()) {
			Map.Entry<String, String> entry = (Entry<String, String>) mapIterator.next();
			System.out.println("Key: "+entry.getKey() + " & Value: " + entry.getValue());
		}     
		return text;            
	}



	public void switchMethod(){
		int i=2;
		switch(i)
		{
		case 0:
			System.out.println("Case0 ");
		case 1:
			System.out.println("Case1 ");
		case 2:
			System.out.println("Case2 ");
		case 3:
			System.out.println("Case3 ");
		case 4:
			System.out.println("Case4 ");
		case 5:
			System.out.println("Case5 ");

		default:
			System.out.println("Default ");
		}
	}

}














