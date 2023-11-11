/**
 * This module is a programming assignment for CS342 at BU.
 * <p>
 In this module we are:
 1. creating a TextParser object and reading in a file using the text parser
 2. stripping out any non-alphanumeric characters
 3. splitting the text into individual words (based on spaces and new lines)
 4. creating a custom LinkedList class & object that can be used to iterate through a number of nodes
 5. creating a Node class that holds a word (String) and count (int), count indicates how many times that word is found in the text
 6. using our linkedlist to find how many times each of the following words appear in the text: portrait, persian, dorian, experimental, magnetic
 7. displaying the number of unique words in the text (number of nodes in linkedlist)
 8. displaying the total number of words in the text
 9. display which word was found most frequently in the text
 10. displaying any words that were found 20 or more times in the text
 11. displaying the longest word in the text
 * </p>
 *
 * @author bryce schultz
 * @course CS342
 * @dueDate 7/16/2023
 */


/**
 * Class: Driver
 * Description: this class is used to run and test the LinkedList, Node, and TextParser classes.
 * The program is run from this class and is invoking methods from the LinkedList, Node, and TextParser classes.
 */
public class Driver {
    /**
     * main method which instantiates Driver object/class and calls testLinkedListProgram
     */
    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.testLinkedListProgram();
    }

    /**
     * testLinkedListProgram      (test all functionality of LinkedList, Node, and TextParser classes)
     * Input : none
     * Output : none
     * This method is the main driver for our program and is responsible for facilitating the 11 steps as outlined above.
     */
    private void testLinkedListProgram() {
        TextParser parser = new TextParser();
        String[] words = parser.getWordsInFile("./GutenbergEbook.txt");
        LinkedList list = new LinkedList(words);
        System.out.println("\n");
        String[] wordCountsToFind = {"portrait", "persian", "dorian", "experimental", "magnetic"};
        for (String word: wordCountsToFind) {
            int wordCount = list.wordCount(word);
            System.out.println(word + " occurs: " + wordCount + " times");
        }
        list.displayNumberOfUniqueWords();
        System.out.println("List contains " + words.length + " Total words.");
        list.displayFrequentWords(20);
        list.displayMostFrequentWord();
        list.displayLongestWord();
    }
}
