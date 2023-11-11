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


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Class: TextParser
 * Description: this class is used to read in text from a file.
 */
public class TextParser {
    /**
     * getWordsInFile      (return an array of words from a file)
     * Input : path (String)
     * Output : words (String[])
     * This method takes a path as input and uses regex to remove any non alphanumeric characters, then make all
     * the text lowercase, and then uses regex to split the text string into an array of Strings based on any white space
     * in the original String/text (for example spaces, newlines) and will then return the words after
     * the regex processing.
     */
    public String[] getWordsInFile(String path)  {
        Path fileName = Path.of(path);
        String fileContent = null;
        try {
            fileContent = Files.readString(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] words = fileContent.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase().split("\\s+");
        return words;
    }
}
