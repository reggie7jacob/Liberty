package georest;

import java.util.HashMap;
//import java.util.Map;

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
	  int max=9000;
		System.out.println("\n > collectPerfectNumber up to " +max);
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
  public void findStringVrezhInSentence() {
		System.out.println("\n --  findWordInSentenceTest-- ;"); 
		 Assert.assertTrue(solutions.findStringInSentence("Vrezh","I believe Vrezh is here"));
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
	  ///TODO
   System.out.println("Test not implemented");
  }

  @Test
  public void getSubStringTest() {
	  ///TODO
   System.out.println("Test not implemented");
  }

  @Test
  public void getWordsFromStringTest() {
	  ///TODO
   System.out.println("Test not implemented");
  }

  @Test
  public void isNumber7825PrimeTest() {
		int givenNum=7825;
		solutions.isPrime(givenNum);
  }
  
  @Test
  public void isNumber7827PrimeTest() {
		int givenNum=7827;
		solutions.isPrime(givenNum);
		//for (int i=givenNum;i>2;i--) {
			//solutions.isPrime(i);
		//}		
  }
  @Test
  public void is7919PrimeTest() {
		int givenNum=7919 ;
		solutions.isPrime(givenNum);
  }
  @Test
  public void isNumberPrimeRecursiveTest() {
		System.out.println("\n --  isNumberPrime--Recursive example-- ;"); 
		solutions.isNumberPrimeRecursive(15,1);
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
  public void reverseArrayTest() {
	  ///TODO System.out.println("Test not implemented");
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
  
}
