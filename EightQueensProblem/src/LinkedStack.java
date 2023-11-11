/**
 * Class: LinkedStack
 * Description: this class is used to build out a Linked List Stack data structure which is made up of nodes
 * The top variable (which is a Node) shown below is the top most node in the stack
 */
public class LinkedStack {
    private static final int NUMBER_OF_ROWS = 8;
    private static final int NUMBER_OF_COLUMNS = 8;
    private static final int INDEX_OFFSET = 1;
    // data members
    private Node top;
    private int count;

    // constructors
    public LinkedStack() {
        count = 0;
    }

    // methods
    /**
     * push       (Add a node to the linked list stack and set the new node as the top)
     * Input : row (int), column (int)
     * Output : none
     */
    public void push(int row, int column) {
        Node newNode = new Node();
        newNode.setRow(row);
        newNode.setColumn(column);
        newNode.setNext(top);
        top = newNode;
        count++;
    }

    /**
     * isEmpty       (Return if the linked list stack is empty)
     * Input : none
     * Output : Boolean
     */
    public boolean isEmpty() {
        return (count == 0);
    }

    /**
     * depth       (Return count of linked list stack)
     * Input : none
     * Output : int
     */
    public int depth() {
        return count;
    }

    /**
     * handleConflict       (Change position of top node due to conflict)
     * Input : none
     * Output : none
     * This method is used to jump to the next column or runBack to the previous top Node if the top Node
     * that were currently working with is at the last column of the grid. If this method is being called
     * then the current Node has a conflict with other Nodes in our list.
     */
    public void handleConflict() {
        if (isEmpty()) {
            return;
        }
        while (depth() > 1) {
            if (top.getColumn() != NUMBER_OF_COLUMNS) {
                // update the top node column and return to caller method
                top.setColumn(top.getColumn() + 1);
                return;
            } else {
                // pop the top Node out of the list so were now working with the previous top and decrement the count
                top = top.getNext();
                count--;
            }
        }
    }

    /**
     * conflictExists       (Check if the current top node position conflicts with any other nodes in our list)
     * Input : none
     * Output : boolean
     * This method is used to see if the current top node shares a row or shares a column or is at a diagonal
     * with any other nodes in our list. If any of the previous statements are true then the top node position
     * has to change which is done using the handleConflict method
     */
    public boolean conflictExists() {
        if (isEmpty()) {
            return false;
        }
        Node tmp = top;
        while(tmp != null) {
            if (tmp == top) {
                // top of stack so do nothing
            } else {
                // check if the tmp node and the top node share a column or row or are diagonal from each other
                if ((tmp.getRow() == top.getRow() || tmp.getColumn() == top.getColumn()) || (areDiagonal(tmp.getRow(), tmp.getColumn(), top.getRow(), top.getColumn()))) {
                    return true;
                }
            }
            tmp = tmp.getNext();
        }
        return false;
    }

    /**
     * areDiagonal      (Check if x1,y1 is diagonal with x2, y2)
     * Input : int x1, int y1, int x2, int y2
     * Output : boolean
     * This method is used to see if one set of row/column is diagonal with a different set of row/column.
     * This method is a helper method for our conflictExists method.
     */
    private boolean areDiagonal(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) == Math.abs(y1 - y2);
    }

    /**
     * findQueenLocationsForGrid      (Find queen locations from our solution that can map to the index of
     * the grid we output to the console)
     * Input : none
     * Output : queenLocations (int[])
     * This method is used to create a list of queen Locations that we can cross-reference with our
     * index when outputting the solution to the console.
     */
    private int[] findQueenLocationsForGrid() {
        int[] queenLocations = new int[NUMBER_OF_ROWS];
        Node tmp = top;
        for (int i = 0; i < queenLocations.length; i++) {
            queenLocations[i] = ((tmp.getColumn() - INDEX_OFFSET) + ((tmp.getRow()-INDEX_OFFSET) * NUMBER_OF_COLUMNS));
            tmp = tmp.getNext();
        }
        return queenLocations;
    }

    /**
     * printNodes      (print nodes in list in simple format)
     * Input : none
     * Output : none
     * This method prints the nodes rows/columns to the console. Was helpful when working through the problem
     * but is not used in the final solution.
     */
    public void printNodes() {
        String rtn = "";
        if (isEmpty()) {
            return;
        }

        Node tmp = top;
        while(tmp != null) {
            rtn += "-> (" + tmp.getRow() + ", " + tmp.getColumn() + ")";
            tmp = tmp.getNext();
        }
        System.out.println(rtn);
    }


    /**
     * toString      (display linked list stack results and eight queens solution in grid/chess table format)
     * Input : none
     * Output : rtn (String)
     * This method iterates through each cell in the grid (calculated as NUMBER_OF_ROWS * NUMBER_OF_COLUMNS)
     * and checks to see if the cell index is listed in the queenLocations list (from findQueenLocationsForGrid)
     * if the cell index matches any int in queenLocations then that cell will contain a Q (for queen)
     * while every cell that doesn't meet this condition will be empty.
     */
    @Override
    public String toString() {
        String rtn = "";
        int row = 0;
        if (isEmpty()) {
            return "<Empty>";
        }
        rtn += "\n\t" ;
        for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
            rtn += "  " +  (i + INDEX_OFFSET) + " ";
        }

        int[] queenLocations = findQueenLocationsForGrid();
        for (int i = 0; i < NUMBER_OF_ROWS * NUMBER_OF_COLUMNS; i++) {
            boolean placeMarker = false;
            for (int queenLocation: queenLocations) {
                if (queenLocation == i)
                    placeMarker = true;
            }
            if (i % NUMBER_OF_COLUMNS == 0) {
                row++;
                rtn += "\n\t";
                for (int i2 = 0; i2 < NUMBER_OF_COLUMNS; i2++) {
                    if (i2 == NUMBER_OF_COLUMNS - INDEX_OFFSET) rtn += "+---+";
                    else rtn += "+---";
                }
                rtn += "\n" + row + "\t|";
            }
            if (placeMarker) rtn += " Q |";
            else rtn += "   |";
        }
        rtn += "\n\t";
        for (int i2 = 0; i2 < NUMBER_OF_COLUMNS; i2++) {
            if (i2 == NUMBER_OF_COLUMNS - INDEX_OFFSET) rtn += "+---+";
            else rtn += "+---";
        }
        return rtn;
    }
}
