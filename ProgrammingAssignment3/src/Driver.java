/**
 * @author bryce schultz
 * @course CS342
 * @date 8/7/2023
 * @issues none known
 */

/**
 * This module is a programming assignment for CS342 at BU.
 * <p>
 In this module we are:
 1. creating a TextParser object and reading in a file using the text parser
 2. stripping out any non-alphanumeric characters
 3. splitting the text into individual words (based on spaces and new lines)
 4. creating a custom LinkedList class & object that can be used to iterate through a number of nodes
 5. creating a Node class that holds a word (String) and count (int), count indicates how many times that word is found in the text
 6. creating a ArrayQueue class that holds a queue (String[]), count (int), head (int), and tail (int).
 7. Using our ArrayQueue class to create a queue that holds all the words from the txt file.
 8. Using this queue from step 7 to create a new queue and identify how many times we have to remove
 the head of the queue before we find the following words: "superhuman", "chiromancy", "unsatisfactory", "percutaneous", "discernible"
 9. displaying the total number of words in the text
 10. creating a new linkedlist object from a copy of the first 1000 words (WORD_LIST_LENGTH) from the arrayqueue and display how many words occur more than 20 (NUM_OCCURRENCES) times
 11. creating a new linkedlist object from a copy all the words from the arrayqueue (and removing all entries/words from arrayqueue) and display the most frequent word
 12. creating a new linkedlist object from a copy all the words from the arrayqueue (and removing all entries/words from arrayqueue) and display the longest word
 * </p>
 */

/**
 * Class: Driver
 * Description: this class is used to run and test the ArrayQueue, LinkedList, Node, and TextParser classes.
 * The program is run from this class and is invoking methods from the LinkedList, Node, and TextParser classes.
 */
public class Driver {
    private static final int NUM_OCCURRENCES = 20;
    private static final int WORD_LIST_LENGTH = 1000;
    /**
     * main method which instantiates Driver object/class and calls testArrayQueueProgram
     */
    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.testArrayQueueProgram();
    }

    /**
     * testArrayQueueProgram      (test all functionality of ArrayQueue, LinkedList, Node, and TextParser classes)
     * Input : none
     * Output : none
     * This method is the main driver for our program and is responsible for facilitating the 12 steps as outlined above.
     */
    private void testArrayQueueProgram() {
        TextParser parser = new TextParser();
        String[] words = parser.getWordsInFile("./TheFallOfTheHouseOfTheUsher.txt");

        System.out.print("\n");
        ArrayQueue queue = new ArrayQueue(words);
        ArrayQueue tmpQueue;
        String[] wordCountsToFind = {"superhuman", "chiromancy", "unsatisfactory", "percutaneous", "discernible"};
        for (String word: wordCountsToFind) {
            tmpQueue = queue.copy(queue.size());
            Integer wordCount = tmpQueue.find(word);
            if (wordCount == null) System.out.println(word + " never occurs");
            else System.out.println(word + " occurs after removing " + wordCount + " words");
        }

        System.out.print("\nThere are " + queue.size() + " entries/words in the queue");
        System.out.println("\n\n-----------------------------------------------------------");
        tmpQueue = queue.copy(WORD_LIST_LENGTH);
        LinkedList wordCountsShortened = new LinkedList(tmpQueue.removeAllEntries());
        int numOccurrences = wordCountsShortened.getFrequentWords(NUM_OCCURRENCES);
        System.out.println("Out of the first " + WORD_LIST_LENGTH  + " words: ");
        System.out.println(numOccurrences + " words occur more than " + NUM_OCCURRENCES + " times");
        System.out.println("-----------------------------------------------------------");

        System.out.println("\n-----------------------------------------------------------");
        tmpQueue = queue.copy(queue.size());
        LinkedList wordCountsAllWords = new LinkedList(tmpQueue.removeAllEntries());
        String mostFrequentWord = wordCountsAllWords.findMostFrequentWord();
        System.out.println("Out of " + queue.size() + " entries: ");
        System.out.println("Most frequent word is: '" + mostFrequentWord + "'");

        tmpQueue = queue.copy(queue.size());
        wordCountsAllWords = new LinkedList(tmpQueue.removeAllEntries());
        String longestWord = wordCountsAllWords.findLongestWord();
        System.out.println("Longest word is: '" + longestWord + "'");
        System.out.println("-----------------------------------------------------------");
    }
}
