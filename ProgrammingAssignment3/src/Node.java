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
 * Class: Node
 * Description: this class is used to build out Node objects that are used inside of a singly linked list.
 * Each node holds a word (String), count (int) which represents how many times it appears in the parsed text,
 * and next (Node) which is a pointer to the next Node in the list.
 */
public class Node {
    // data members
    String word;
    Node next;
    int count;


    // getters and setters
    /**
     * Return word associated with this node
     */
    public String getWord() {
        return word;
    }
    /**
     * Set word associated with this node
     */
    public void setWord(String word) {
        this.word = word;
    }
    /**
     * Return next node associated with this node
     */
    public Node getNext() {
        return next;
    }
    /**
     * Set the next node associated with this node
     */
    public void setNext(Node next) {
        this.next = next;
    }
    /**
     * Return count associated with this node
     */
    public int getCount() {
        return count;
    }
    /**
     * Set count node associated with this node
     */
    public void setCount(int count) {
        this.count = count;
    }
}

