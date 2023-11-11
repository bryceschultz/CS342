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
 * Class: Node
 * Description: this class is used to build out Node objects that are used inside of a singly linked list.
 * Each node holds a word (String), count (int) which represents how many times it appears in the parsed text,
 * and next (Node) which is a pointer to the next Node in the list.
 */
public class Node {
    // data members
    String word;
    Node leftChild;
    Node rightChild;
    int count;


    // getters and setters
    /** Return word associated with this node */
    public String getWord() {
        return word;
    }
    /** Set word associated with this node */
    public void setWord(String word) {
        this.word = word;
    }
    /** Return the leftchild associated with this node */
    public Node getLeftChild() { return leftChild; }
    /** Set the leftchild associated with this node */
    public void setLeftChild(Node leftChild) {this.leftChild = leftChild; }
    /** return the rightchild associated with this node */
    public Node getRightChild() { return rightChild; }
    /** Set the rightchild associated with this node */
    public void setRightChild(Node rightChild) { this.rightChild = rightChild; }
    /** Return count associated with this node */
    public int getCount() {
        return count;
    }
    /** Set count node associated with this node */
    public void setCount(int count) {
        this.count = count;
    }
}

