package georest;

import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Map;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

///////////////////////////// Develop Branch /////////////////////

public class SolutionTest {

	Solution solutions;
	@BeforeTest
	public void beforeTest() {
		System.out.println("--------Starting GeoRestArrayTest ------- \n ");  
		solutions = new Solution();	  
	}

	@Test
	public void collectPerfectNumberTest() {
		int max=10000;
		System.out.println("\nCollect Perfect Numbers up to " +max);
		solutions.collectPerfectNumber(max);
	}

	@Test
	public void compareWordContentTest() {
		System.out.println("\n --  compareWordContent-- ;"); 
		Assert.assertTrue(solutions.compareWordContent("VazaR","azRaV"));
	}

	@Test
	public void compareWordContentCaseDiffTest() {
		System.out.println("\n --  compareWordContent-- ;"); 
		Assert.assertFalse(solutions.compareWordContent("Vazar","azRaV"));
	}

	@Test
	public void findStringVrezhInSentenceTest() {

		Assert.assertTrue(solutions.findStringInSentence("Vrezh","I believe Vrezh is here"));
	}

	@Test
	public void noWordInSentenceTest() {

		Assert.assertFalse(solutions.findStringInSentence("","I believe Vrezh is here"));
	}

	@Test
	public void nullInSentenceTest() {

		Assert.assertFalse(solutions.findStringInSentence(null,"I believe Vrezh is here"));
	}

	@Test
	public void findPalindromesInSentenceTest() {

		Set <String> palindromes= solutions.findPalindromesInSentence("I believe racecar is a palindrome");
		if(!palindromes.isEmpty()) {
			System.out.println("\nFollowing palindromes found;"+palindromes); 
		}
		else System.out.println("\n No Palindromes found;"); 
	}

	@Test
	public void isWordPalindromeTest() {

		Assert.assertTrue(solutions.isPalindrome("racecar"));
	}

	@Test
	public void isWordNotPalindromeTest() {

		Assert.assertFalse(solutions.isPalindrome("raceBcar"));
	}

	@Test
	public void findWordJohnInSentenceTest() {
		System.out.println("\n --  findWordInSentenceTest-- ;"); 
		Assert.assertTrue(solutions.findWordInSentence("John","My friend John is here",true));
	}

	@Test
	public void findJohnInSentenceCaseInsensitiveTest() {
		System.out.println("\n --  findWordInSentenceTest-- ;"); 
		Assert.assertTrue(solutions.findWordInSentence("John","My friend gJohN is here",false));
	}

	@Test
	public void countWordsTest() {
		//System.out.println("\n --  findWordInSentenceTest-- ;"); 
		solutions.countWords("John is my friend and he is here");
	}

	@Test
	public void getNumberOfWordsTest() {

		int numberOfWords=solutions.countNumberOfWords("John is my friend and he is here");
		System.out.println("\n --  Number of words is: " +numberOfWords); 
	}

	@Test
	public void fiboTailRecursionTest() {
		int fibo = 9;
		System.out.println("\nFiboTailRecursion of number "+fibo+" is " 
				+solutions.fiboTailRecursion(fibo));
	}

	@Test
	public void fibonacciNumberTest() {
		for (int i=6;i<13;i++) {
			int fibNum=solutions.fibonacciNumber(i);
			System.out.println("Fibonacci number for position "+i+" is "+fibNum);
		}
	}

	@Test
	public void fibonacciRecursiveTest() {

		int positionNum=9;
		System.out.println("\nIn fibonacciRecursive Test for position: "+positionNum);
		int fibNumRecursive=solutions.fibonacciRecursive(positionNum, 0,1);
		System.out.println("Recursive Fibonacci number for position: "+positionNum+" is "+fibNumRecursive);
	}

	@Test
	public void findFirstAnagramTest() {
		String [] anagrams = {"Vrezh","zherV","abc","cab", "cass"};
		String [] anagramsOut;
		///TODO: anagramsOut = solutions.findFirstAnagram(anagrams);
		//System.out.println("\n Anagrams result is " + anagramsOut);
	}

	@Test
	public void findMiddleIndexTest() {
		int [] intArray={1,2,3,4,5,7,8};
		int middleIndex=solutions.findMiddleIndex(intArray);
		System.out.println("\nMiddle Index of 1,2,3,4,5,7,8 is : "+middleIndex+"\n");
	}
	
	@Test
	public void removeDuplicatesTest() {
		ArrayList<Object> arrayList=new ArrayList<Object> ();
		arrayList.add("Vrezh");
		arrayList.add(10.3);
		solutions.removeDuplicates(arrayList);
		System.out.println("\n");
	}
	
	
	@Test
	public void findMissingNumberTest() {

		int [] numbers={1,2,3,4,5,7};
		int missingInt=solutions.findMissingNumber(numbers);
		System.out.println("\n .... missingInt = "+missingInt+"\n");
	}

	@Test
	public void isNumber7825PrimeTest() {
		Assert.assertFalse (solutions.isPrime(7825));
	}

	@Test
	public void findFactorialTest() {

		Assert.assertTrue(solutions.findFactorial(5)==120);
	}

	@Test
	public void isArmstrongNumberTest() {

		Assert.assertTrue(solutions.isArmstrongNumber(153));
	}

	@Test
	public void isNumber7827PrimeTest() {
		int givenNum=7827;
		Assert.assertFalse (solutions.isPrime(givenNum));
		//for (int i=givenNum;i>2;i--) {
		//solutions.isPrime(i);}		
	}
	@Test
	public void is7919PrimeTest() {
		int givenNum=7919 ;
		Assert.assertTrue (solutions.isPrime(givenNum));
	}
	@Test
	public void is17Prime_RecursiveTest() {
		System.out.println("\n --  isNumberPrime--Recursive example-- ;"); 
		Assert.assertTrue (solutions.isNumberPrimeRecursive(17,2));
	}

	@Test
	public void is7827Prime_RecursiveTest() {
		Assert.assertFalse (solutions.isNumberPrimeRecursive(7827,2));
	}

	@Test
	public void is496PerfectNumberTest() {   
		Assert.assertTrue (solutions.isPerfectNumber(496));
	}

	@Test
	public void is46PerfectNumberTest() {   
		Assert.assertFalse (solutions.isPerfectNumber(46));
	}

	@Test
	public void lengthOfLongestSubstringTest() {
		System.out.println("\n  >> >> lengthOfLongestSubstring >>>>\"bbbbaaaaccfdstt\";>>>> ");
		solutions.lengthOfLongestSubstring("bbbbaaaaccfdstt");
	}

	@Test
	public void lengthOfEmptySubstringTest() {
		System.out.println("\n  >> >> lengthOfEmtySubstring > ");
		solutions.lengthOfLongestSubstring("");
	}

	@Test
	public void printAllPossibleOrderedPairsTest() {
		int[] intArray2={0,1,2,3};
		solutions.printAllPossibleOrderedPairs(intArray2);
	}

	@Test
	public void printBinaryFormatTest() {
		System.out.println("\n  >> >> >> printBinaryFormat(25)->>--");
		solutions.printBinaryFormat(25);
	}

	@Test
	public void printFiveStairsTest() {
		solutions.printStairs(5);
	}

	@Test
	public void print31StairsTest() {
		solutions.printStairs(31);
	}

	@Test
	public void reverseNumberTest() {
		System.out.println("  >> >>> \nreverseNumber(1357-------");
		solutions.reverseNumber(1357);
	}

	@Test
	public void reverseSentenceTest() {
		System.out.println("\n  >>>> >>>>>  reverseSentence(\"Vrezh Is Home\")-");
		solutions.reverseSentence("Vrezh Is Home");
	}

	@Test
	public void reverseStringTest() {
		solutions.reverseString("Vrezh is 12 34 here");
	}

	@Test
	public void reverseNullStringTest() {
		Assert.assertTrue (solutions.reverseString(null)==null);
	}
	@Test
	public void reverseStringRecursiveTest() {
		System.out.println("\n reverseStringRecursive\"Vrezh Is  HomE\"->>" 
				+solutions.reverseStringRecursive("Vrezh Is Home"));

	}

	@Test
	public void reverseStringStackTest() {
		System.out.println("\n>>>> >>>> reverseStringStack(\"Vagram is Not Here\")");
		solutions.reverseStringStack("Vagram is Not Here");
	}

	
	@Test
	public void reverseNullStringStackTest() {
		Assert.assertTrue (solutions.reverseStringStack(null)==null);
	}

	@Test
	public void parenthesisMatchTest() {
		System.out.println("\n>parenthesisMatchTest");
		Assert.assertTrue (solutions.checkIfParenthesisMatch("((X+Y)) this is a (match)" , '(', ')'));
	}

	@Test
	public void parenthesisDoNotMatchTest() {
		System.out.println("\n>parenthesisDoNotMatchTest");
		Assert.assertFalse (solutions.checkIfParenthesisMatch("((X+Y))) (Abc abc" , '(', ')'));
	}

	@Test
	public void parenthesisDoNotMatchTest2() {
		System.out.println("\n>parenthesisDoNotMatchTest");
		Assert.assertFalse (solutions.checkIfParenthesisMatch("((X+Y)) {(((this } is Not a (match}" , '{', '}'));
	}

	@Test
	public void parenthesisMatchTest2() {
		System.out.println("\n>parenthesisMatchTest2");
		Assert.assertTrue (solutions.checkIfParenthesisMatch("((X+Y)) {(((this is a (match)}" , '{', '}'));
	}

	@Test
	public void reverseWithoutSplitTest() {
		System.out.println("\n>>>> >>>>>  reverseSentence(\"ABC Reverse without split XYZ\")-");
		String reversedSentence=solutions.reverseSentenceWithoutSplit("ABC Reverse without split XYZ");
		System.out.println(reversedSentence);
	}

	@Test
	public void stringManipulationTest() {
		solutions.stringManipulation();
	}

	@Test
	public void twoSumTest() {
		System.out.println(" >>> >>>> {2,3,4,9,Integer.MAX_VALUE+1,111,56,44,3} twoSum(intArray,113) ===== ");
		int [] intArray = {2,3,4,9,Integer.MAX_VALUE+1,111,56,44,3};
		solutions.twoSumFast(intArray,113);
	}

	@Test
	public void twoSumTestOneLoop() {
		int [] input={2,3,4,8,111,56,44};
		HashMap <Integer, Integer> sumMap = solutions.twoSumFast(input,5);			
		System.out.println("\n First " +sumMap.get(0)+ " Second " +sumMap.get(1));

	}

	@Test
	public void twoSumNewTestMultipleLoops() {
		int [] input={2,3,4,8,111,56,44};
		HashMap <Integer, Integer> sumMap = solutions.twoSumFast(input,119);			
		System.out.println("\n First " +sumMap.get(0)+ " Second " +sumMap.get(1));

	}

	@Test
	public void twoStringsAreAnagramsTest() {
		Assert.assertTrue (solutions.isAnagramWithSort("abracadabra", "abrcadabraa"));
	}

	@Test
	public void twoStringsAreNotAnagramsTest() {
		Assert.assertFalse (solutions.isAnagramWithSort("abracadabr", "abrcadabraa"));	
	}

	@Test
	public void replaceTextMap() {

		HashMap<String, String> mapNames = new HashMap <String, String>();

		mapNames.put("[first name]","John");
		mapNames.put("[last name]","Smith");

		String text = "Hello [first name] [last name]";

		text = solutions.replaceText(text, mapNames);
		System.out.println("Resulting text is : " + text);
	}

	@Test
	public void testSwitch() {
		solutions.switchMethod();

	}
	@Test
	public void smallestDistancePairTest() {
		int[] intArray2={1,5,9,13,13,10,11,12,15};
		int result=solutions.smallestDistancePair(intArray2,8);
		System.out.println("Smallest  is : " + result);//=2
	}
	
	@Test
	public void smallestDistancePairTestB() {
		int[] intArray2={1,5,9,13,19,13,13,19};
		int result=solutions.smallestDistancePair(intArray2,8);
		System.out.println("Smallest  is : " + result);//=12
	}
	
	
}
