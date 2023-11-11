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



public class LinkedTree {
    // data members
    private Node root;
    private int count;
    private Node mostFrequent;
    private Node deepest;
    private int maxDepth;
    private boolean foundFirstWord;

    // constructors
    // default constructor
    LinkedTree() {}
    // constructor to populate LinkedTree if array of words is already provided
    LinkedTree(String[] words) {
        this();
        for (String word: words) {
            this.updateOrAdd(word);
        }
    }

    // methods
    /**
     * updateOrAdd       (Add a node to the linkedtree or update a node if one already exists for the word provided)
     * Input : word (String) to be added or updated
     * Output : none
     */
    private void updateOrAdd(String word) {
        if (root == null) {
            Node newNode = createNewNode(word);
            root = newNode;
            return;
        }
        Node tmpNode = internalSearch(root, word);
        if (tmpNode == null) {
            add(root, word);
        } else {
            tmpNode.setCount(tmpNode.getCount() + 1);
        }
    }

    /**
     * add       (Add a node to the linkedtree)
     * Input : root (Node), word (String) to be added
     * Output : none
     * This method uses recursion to find a new spot to add the node/word. This method uses
     * .compareToIgnoreCase from the String class to decide whether to recurse down the left
     * side of tree or right side of tree. When it finally finds a spot where the left child or
     * right child is null it calls createNewNode and calls setLeftChild or setRightChild to
     * link the newNode to root node.
     */
    public void add(Node root, String word) {
        if (root == null) {
            return;
        }
        if (word.compareToIgnoreCase(root.getWord()) < 0) {
            if (root.getLeftChild() == null) {
                Node newNode = createNewNode(word);
                root.setLeftChild(newNode);
                count++;
            } else {
                add(root.getLeftChild(), word);
            }
        } else {
            if (root.getRightChild() == null) {
                Node newNode = createNewNode(word);
                root.setRightChild(newNode);
                count++;
            } else {
                add(root.getRightChild(), word);
            }
        }
    }

    /**
     * createNewNode      (create a new node for a given word and set the count to 1)
     * Input : word (String)
     * Output : none
     */
    private Node createNewNode(String word) {
        Node newNode = new Node();
        newNode.setWord(word);
        newNode.setCount(1);
        return newNode;
    }


    /**
     * internalSearch       (search the linkedtree for a string)
     * Input : root (Node), word (String) to be searched for
     * Output : foundNode (Node)
     * This is a recursive method which uses (root == null) as its base case to exit the recursion if nothing is found.
     * Alternatively if root.getWord is equal to the word were searching for then the current root/node will be returned
     * exiting the recursion and returning the node to its calling method. This method uses .compareToIgnoreCase from the
     * String class to decide whether to recurse down the left side of tree, right side of tree, or return the root
     *
     */
    private Node internalSearch(Node root, String word) {
        Node foundNode = null;
        if (root == null) {
            return null;
        }

        if (word.compareToIgnoreCase(root.getWord()) < 0) {
            if (root.getLeftChild() != null) {
                foundNode = internalSearch(root.getLeftChild(), word);
            }
        } else if (word.compareToIgnoreCase(root.getWord()) > 0) {
            if (root.getRightChild() != null) {
                foundNode = internalSearch(root.getRightChild(), word);
            }
        } else {
            // words are equal
            return root;
        }
        return foundNode;
    }

    /**
     * getWordAtRoot       (return word associated with root node)
     * Input :
     * Output :
     */
    public String getWordAtRoot() {
        return root.getWord();
    }

    /**
     * wordCount      (return the count associated with a particular word/node)
     * Input : word (String)
     * Output : wordCount (Integer)
     * Searches for a specific word in tree, if found it returns the count of the word, otherwise returns null.
     */
    public Integer wordCount(String word) {
        Integer wordCount = null;
        Node tmpNode = internalSearch(root, word);
        if (tmpNode != null) wordCount = tmpNode.getCount();
        return wordCount;
    }

    /**
     * firstWordPreOrderTraversal      (print first word output from preOrderTraversal)
     * Input :
     * Output :
     * sets foundFirstWord to false then initiates preOrderTraversal recursive method
     */
    public void firstWordPreOrderTraversal() {
        foundFirstWord = false;
        preOrderTraversal(root);
    }
    /**
     * preOrderTraversal      (recurses through binary tree in preOrderTraversal fashion and stops after first print)
     * Input :
     * Output :
     */
    private void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        if (root != null && !foundFirstWord) {
            System.out.print(root.getWord());
            foundFirstWord = true;
            return;
        }
        preOrderTraversal(root.getLeftChild());
        preOrderTraversal(root.getRightChild());
    }

    /**
     * firstWordPostOrderTraversal      (print first word output from postOrderTraversal)
     * Input :
     * Output :
     * sets foundFirstWord to false then initiates postOrderTraversal recursive method
     */
    public void firstWordPostOrderTraversal() {
        foundFirstWord = false;
        postOrderTraversal(root);
    }
    /**
     * postOrderTraversal      (recurses through binary tree in postOrderTraversal fashion and stops after first print)
     * Input :
     * Output :
     */
    private void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.getLeftChild());
        postOrderTraversal(root.getRightChild());
        if (root != null && !foundFirstWord) {
            System.out.print(root.getWord());
            foundFirstWord = true;
            return;
        }
    }

    /**
     * firstWordInOrderTraversal      (print first word output from InOrderTraversal)
     * Input :
     * Output :
     * sets foundFirstWord to false then initiates inOrderTraversal recursive method
     */
    public void firstWordInOrderTraversal() {
        foundFirstWord = false;
        inOrderTraversal(root);
    }
    /**
     * inOrderTraversal      (recurses through binary tree in inOrderTraversal fashion and stops after first print)
     * Input :
     * Output :
     */
    private void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.getLeftChild());
        if (root != null && !foundFirstWord) {
            System.out.print(root.getWord());
            foundFirstWord = true;
            return;
        }
       inOrderTraversal(root.getRightChild());
    }

    /**
     * resetKeyMetrics      (sets data members associated with key metrics back to their original values)
     * Input :
     * Output :
     */
    private void resetKeyMetrics() {
        maxDepth = 1;
        deepest = root;
        mostFrequent = root;
    }
    /**
     * findKeyMetrics      (calls resetKeyMetrics then calls findKeyMetrics (private) which is a recursive method)
     * Input :
     * Output :
     */
    public void findKeyMetrics() {
        resetKeyMetrics();
        findKeyMetrics(root, maxDepth);
    }
    /**
     * findKeyMetrics      (goes through entire linkedtree and identifies key metrics for this program)
     * Input :
     * Output :
     * This method goes through the linkedtree using recursion and identifies the
     * maxdepth of the tree, the word at the deepest point of the tree and the most
     * frequent word within the tree
     */
    private void findKeyMetrics(Node root, int depth) {
        if (root == null) {
            return;
        }
        findKeyMetrics(root.getLeftChild(), depth+1);
        if (depth > maxDepth) {
            deepest = root;
            maxDepth = depth;
        }
        if (mostFrequent.getCount() < root.getCount()) {
            mostFrequent = root;
        }
        findKeyMetrics(root.getRightChild(), depth+1);
    }

    /**
     * getCount      (returns count associated with the linkedtree)
     * Input :
     * Output :
     */
    public int getCount() { return count; }

    /**
     * getMaxDepth      (returns maxDepth associated with the linkedtree)
     * Input :
     * Output :
     */
    public int getMaxDepth() { return maxDepth; }

    /**
     * getMaxDepthWord      (returns word associated with the deepest node of the linkedtree)
     * Input :
     * Output :
     */
    public String getMaxDepthWord() { return deepest.getWord(); }

    /**
     * getMaxDepthWord      (displays the most word from the linkedtree with the highest count and displays its count)
     * Input :
     * Output :
     */
    public void displayMostFrequentWord() {
        System.out.println("\nMost frequent word is: '" + mostFrequent.getWord() + "' occurring " + mostFrequent.getCount() + " times");
    }
}
