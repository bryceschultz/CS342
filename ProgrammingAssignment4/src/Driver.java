/**
 * @author bryce schultz
 * @course CS342
 * @date 8/13/2023
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
 6. creating a LinkedTree class that holds a root (Node), count (int), mostFrequent (Node), deepest (Node), maxDepth (int), foundFirstWord (boolean)
 7. Using our LinkedTree class to create a LinkedTree object that holds all the words from the txt file.
 8. displaying how many total words are in the file
 9. Using the tree from step 7 to identify how many times the following words appear in the text: "transylvania", "harker", "renfield", "vampire", "expostulate"
 10. displaying how many nodes deep the tree is
 11. displaying how many distinct words are in the text
 12. displaying what the word associated with the root node is
 13. displaying the word thats at the deepest node in the tree
 14. displaying the most frequent word and how many times it occurs
 15. displaying the first word in a pre-order traversal of the tree
 16. displaying the first word in a post-order traversal of the tree
 17. displaying the first word in a in-order traversal of the tree
 * </p>
 */

/**
 * Class: Driver
 * Description: this class is used to run and test the LinkedTree, Node, and TextParser classes.
 * The program is run from this class and is invoking methods from the LinkedTree, Node, and TextParser classes.
 */
public class Driver {
    /**
     * main method which instantiates Driver object/class and calls testLinkedTreeProgram
     */
    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.testLinkedTreeProgram();
    }

    /**
     * testLinkedTreeProgram      (test all functionality of LinkedTree, Node, and TextParser classes)
     * Input : none
     * Output : none
     * This method is the main driver for our program and is responsible for facilitating the 17 steps as outlined above.
     */
    private void testLinkedTreeProgram() {
        TextParser parser = new TextParser();
        String[] words = parser.getWordsInFile("./Dracula.txt");
        LinkedTree tree = new LinkedTree(words);
        System.out.println("\n\nText contains " + words.length + " total words");
        tree.findKeyMetrics();
        String[] wordCountsToFind = {"transylvania", "harker", "renfield", "vampire", "expostulate"};
        for (String word: wordCountsToFind) {
            int wordCount = tree.wordCount(word);
            System.out.println("\n" + word + " occurs: " + wordCount + " times");
        }
        System.out.println("\nTree is: " + tree.getMaxDepth() + " nodes deep");
        System.out.println("\nTree contains " + tree.getCount() + " distinct words");
        System.out.println("\nWord at root is: " + tree.getWordAtRoot());
        System.out.println("\nDeepest word(s) is/are: " + tree.getMaxDepthWord());
        tree.displayMostFrequentWord();
        System.out.print("\nFirst word Pre-Order Traversal: ");
        tree.firstWordPreOrderTraversal();
        System.out.print("\n\nFirst word Post-Order Traversal: ");
        tree.firstWordPostOrderTraversal();
        System.out.print("\n\nFirst word In-Order Traversal: ");
        tree.firstWordInOrderTraversal();
        System.out.print("\n\n");
    }
}
