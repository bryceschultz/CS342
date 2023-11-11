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
