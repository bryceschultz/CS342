/**
 * This module is a programming assignment for CS342 at BU.
 * Programming Assignment #2.
 * <p>
 In this module we are:
 Creating a Linked List Stack class and instantiating an object from this class.
 We are also creating a Node class which will hold the following data members next, row, column.
 Next refers to the next Node in the list. Row and column refer to the row and column that this specific Node
 (which represents a queen) sits on within the game board / chess board.  Each node will be temporarily added to our
 list and the program will then check if the node works with the pre-existing nodes in the list. The criteria
 for a node working within the list is that it is not in the same row as any other nodes, it is not in the same column
 as any other nodes, and it is not diagonal from any other nodes already in the list. If any of the previous 3 conditions
 are true then the node will be popped out of the list and we will look at the next possible candidate. If a candidate
 instead passes the 3 conditions and we don't have 8 nodes in the list then the top Node will be left as is and a
 a new top node will be assigned with the previous top node as its next. The new node will be added with a row count of
 the previous top nodes + 1, and we will begin checking for and handling conflicts again.
 When there are 8 Nodes (equal to NUMBER_OF_QUEENS) in the list then the 8 queens problem is considered solved
 by our program and will output the results in a chess style board.

 The program has been written so that NUMBER_OF_ROWS and NUMBER_COLUMNS in LinkedStack class as well as NUMBER_OF_QUEENS in
 EightQueensProblem class can be updated to reflect a different number of rows, columns, or queens, and the program
 will still work as intended. The program is setup to run the Eight Queens Problem by default but can easily be updated
 to run a 'Nine Queens Problem'.

 * </p>
 *
 * @author bryce schultz
 * @course CS342
 * @dueDate 7/24/2023
 */


public class EightQueensProblem {
    private static final int NUMBER_OF_QUEENS = 8;
    /**
     * main method which instantiates EightQueensProblem object/class and calls solve method
     */
    public static void main(String[] args) {
        EightQueensProblem problem = new EightQueensProblem();
        problem.solve();
    }

    /**
     * solve      (solve the Eight Queens Problem using a Linked List Stack and print the results on a board)
     * Input : none
     * Output : none
     * This method is the main driver for our program and is responsible for facilitating the steps/functionality as outlined above.
     */
    private void solve() {
        LinkedStack stack = new LinkedStack();
        boolean success = false;
        stack.push(1, 1);
        while (!success && (!stack.isEmpty())) {
            boolean conflict = stack.conflictExists();
            if (conflict) {
                stack.handleConflict();
            } else if (!conflict && stack.depth() == NUMBER_OF_QUEENS) {
                success = true;
                System.out.println(stack);
            } else {
                stack.push(stack.depth() + 1, 1);
            }
        }
    }
}
