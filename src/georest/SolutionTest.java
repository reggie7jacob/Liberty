package georest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SolutionTest {
	
	Solution solutions;
	@BeforeTest
	public void beforeTest() {
		System.out.println("--------Starting GeoRestArrayTest ------- \n ");  
		solutions = new Solution();	  
	}


  @Test
  public void SimpleArraySumTest() {
   System.out.println("Test not implemented");
  }

  @Test
  public void collectPerfectNumberTest() {
	  int max=900000;
		System.out.println("\n > collectPerfectNumber up to " +max);
		solutions.collectPerfectNumber(max);
  }
  
  @Test
  public void compareWordContentTest() {
		System.out.println("\n --  compareWordContent-- ;"); 
		solutions.compareWordContent("VazaR","azRaV");
  }

  @Test
  public void countWordsTest() {
   System.out.println("Test not implemented");
  }

  @Test
  public void fiboTailRecursionTest() {
		int fibo = 13;
		System.out.println("\n fiboTailRecursion of number "+fibo+" is " 
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
	  int positionNum=13;
		int fibNumRecursive=solutions.fibonacciRecursive(positionNum, 2,3);
		System.out.println("Recursive Fibonacci number for position >> "+positionNum+" is "+fibNumRecursive);

  }

  @Test
  public void findFirstAnagramTest() {
		String [] anagrams = {"Vrezh","zherV","abc","cab", "cass"};
		String [] anagramsOut;
		anagramsOut = solutions.findFirstAnagram(anagrams);
		System.out.println("\n Anagrams result is " + anagramsOut);
		
  }

  @Test
  public void findMiddleIndexTest() {
		int [] intArray={1,2,3,4,5,7};
	  solutions.findMiddleIndex(intArray);
  }

  @Test
  public void findMissingTest() {

		int [] numbers={1,2,3,4,5,7};
		int missingInt=solutions.findMissing(numbers);
		System.out.println("\n .... missingInt = "+missingInt+"\n");
  }

  @Test
  public void getNumberOfWordsTest() {
   System.out.println("Test not implemented");
  }

  @Test
  public void getSubStringTest() {
   System.out.println("Test not implemented");
  }

  @Test
  public void getWordsFromStringTest() {
   System.out.println("Test not implemented");
  }

  @Test
  public void isNumberPrimeTest() {
		System.out.println("\n >>  isNumberPrime();"); 
		int givenNum=18;
		solutions.isNumberPrime(givenNum);

		for (int i=givenNum;i>2;i--) {
			solutions.isNumberPrime(i);
		}		
  }

  @Test
  public void isNumberPrimeRecursiveTest() {
		System.out.println("\n --  isNumberPrime--Recursive example-- ;"); 
		solutions.isNumberPrimeRecursive(17,9);
  }

  @Test
  public void isPerfectNumberTest() {
		System.out.println("\n >> isPerfectNumber(8,true);");         
		solutions.isPerfectNumber(8,true);
  }

  @Test
  public void lengthOfLongestSubstringTest() {
		System.out.println("\n  >> >> lengthOfLongestSubstring >>>>\"bbbbaaaaccfdstt\";>>>> ");
		String someLetters="bbbbaaaaccfdstt";
		solutions.lengthOfLongestSubstring(someLetters);
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
  public void printStairsTest() {
		System.out.println("\n >>> Printing Stairs-5");
		solutions.printStairs(5);
  }

  @Test
  public void reverseArrayTest() {
	  System.out.println("Test not implemented");
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
		solutions.reverseString("Vreezhh");
  }

  @Test
  public void reverseStringRecursiveTest() {
	  System.out.println("\n reverseStringRecursive\"Vrezh Is  HomE\"->>" 
			  +solutions.reverseStringRecursive("Vrezh Is Home"));

  }

  @Test
  public void reverseStringStackTest() {
		System.out.println("\n  >>>> >>>> reverseStringStack(\"Vagram is Not Here\")-");
		solutions.reverseStringStack("Vagram is Not Here");
  }

  @Test
  public void reverseWithoutSplitTest() {
		System.out.println("\n  >>>> >>>>>  reverseSentence(\"ABC Reverse without splitXYZ\")-");
		String reversedSentence=solutions.reverseWithoutSplit("ABC Reverse without splitXYZ");
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
		solutions.twoSum(intArray,113);
  }

  @Test
  public void twoSumNewTest() {
		int [] input={2,3,4,9,111,56,44,3};
		int [] sum=solutions.twoSumNew(input,12);
		for (int i=0;i<sum.length;i++) {
			System.out.println("\n ??? >>>>  twoSumNew(intArray,11) =====?? "+sum[i]);
		}

  }
}
