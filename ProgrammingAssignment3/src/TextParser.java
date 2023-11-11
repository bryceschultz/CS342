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
