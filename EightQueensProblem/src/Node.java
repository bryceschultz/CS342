/**
 * Class: Node
 * Description: this class is used to build out Node objects that are used inside of a linked list stack.
 * Each node holds a row (int) and column (int) which represents the row and column as it would appear on a chess board.
 * Each node also holds next (Node) which is a pointer to the next Node in the list/stack.
 */
public class Node {
    // data members
    private Node next;
    private int row;
    private int column;

    // getters and setters
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
     * Return row associated with this node
     */
    public int getRow() {
        return row;
    }
    /**
     * Set row associated with this node
     */
    public void setRow(int row) {
        this.row = row;
    }
    /**
     * Return column associated with this node
     */
    public int getColumn() {
        return column;
    }
    /**
     * Set column associated with this node
     */
    public void setColumn(int column) {
        this.column = column;
    }
}
