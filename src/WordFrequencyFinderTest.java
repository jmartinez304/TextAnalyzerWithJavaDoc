import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

/**
 * This is a JUnit testing class for the class WordFrequencyFinder. Each test
 * will verify each of the methods of that class.
 *
 */

public class WordFrequencyFinderTest {

	@Test
	/**
	 * This test involves testing the extractText method. This test has the text of
	 * the HTML file and verifies that the extracted text using the method is the
	 * correct one.
	 * 
	 * @throws IOException if there is a problem with the URL
	 */
	public void test1() throws IOException {
		assertEquals("Hello world! Hello World!", WordFrequencyFinder.extractText(
				"https://gist.githubusercontent.com/jmartinez304/39cdab4d14ab4c435ee79af7cfd2c2fe/raw/8107dea2e96602f279d8d3ab1c18ea1dfc2dc3e6/helloWorld.html"));

	}

	@Test
	/**
	 * This test involves verifying the wordFrquency method. In this test, we give
	 * this method a String and verify that it counts the frequency of the words in
	 * the string by comparing it to a HashMap that has the correct words and
	 * frequency values of each one.
	 * 
	 * @throws FileNotFoundException if the file is not found
	 */
	public void test2() throws FileNotFoundException {
		HashMap<String, Integer> wordsTestVariable = new HashMap<String, Integer>();
		wordsTestVariable.put("HELLO", 2);
		wordsTestVariable.put("WORLD", 2);
		HashMap<String, Integer> words = new HashMap<String, Integer>();
		String play = "Hello World! Hello World!";
		WordFrequencyFinder.wordFrequency(play, words);
		assertTrue(wordsTestVariable.equals(words));
	}

	@Test
	/**
	 * This test involves testing the sortByValue method. Here we verify that the
	 * HashMap that is sent to the method comes back with the Map entries sorted
	 * from lowest to highest. The values are compared with the correct values which
	 * are stored inside an ArrayList and we compare them one by one in a for loop.
	 */
	public void test3() {
		int count = 0;
		ArrayList<Integer> arrli = new ArrayList<Integer>();
		arrli.add(2);
		arrli.add(5);
		arrli.add(7);
		HashMap<String, Integer> wordsTestVariable = new HashMap<String, Integer>();
		wordsTestVariable.put("HELLO", 2);
		wordsTestVariable.put("MY", 7);
		wordsTestVariable.put("WORLD", 5);
		Map<String, Integer> sortedList = WordFrequencyFinder.sortByValue(wordsTestVariable);
		for (Map.Entry<String, Integer> aa : sortedList.entrySet()) {
			assertEquals((int) arrli.get(count), (int) aa.getValue());
			count++;
		}

	}

	@Test
	/**
	 * This test involves testing the method getWordList method and the
	 * WordFrequencyFinder constructor method. Here we verify that the URL we sent
	 * to the constructor made the correct list of entries and sorted them and for
	 * this, we use the getWordList class to obtain that list and compare each entry
	 * of the list with an ArrayList that has the correct values.
	 * 
	 * @throws IOException if there is a problem with the URL
	 */
	public void test4() throws IOException {
		int count = 0;
		ArrayList<Integer> arrli = new ArrayList<Integer>();
		arrli.add(2);
		arrli.add(1);
		arrli.add(1);
		WordFrequencyFinder wordFinder = new WordFrequencyFinder(
				"https://raw.githubusercontent.com/jmartinez304/myappsample/master/index.html");
		LinkedHashMap<String, Integer> importedList = wordFinder.getWordList();
		for (Map.Entry<String, Integer> en : importedList.entrySet()) {
//			System.out.println("Key: " + en.getKey() + " Value: " + en.getValue());
			assertEquals((int) arrli.get(count), (int) en.getValue());
			count++;
		}
	}

}
