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
 * Class: LinkedList
 * Description: this class is used to build out a LinkedList data structure which is made up of nodes
 * The head variable (which is a Node) shown below is the first node in the list
 */
public class LinkedList {
    // data members
    private Node head;
    int count;

    // constructors
    // default constructor
    LinkedList() {
    }
    // constructor to populate LinkedList if array of words is already provided
    LinkedList(String[] words) {
        this();
        for (String word: words) {
            this.updateOrAdd(word);
        }
    }

    // methods
    /**
     * addToHead        (Create a node for a new word and add set it as head)
     * Input : word (String) to be added to new node as head
     * Output : none
     * Will always setCount to 1 as its called the first time a new word is found
     */
    public void addToHead(String word) {
        Node newNode = new Node();
        newNode.setWord(word);
        newNode.setCount(1);
        newNode.setNext(head);
        head = newNode;
        count++;
    }

    /**
     * updateOrAdd       (Add a node to the linkedList or update a node if one already exists for the word provided)
     * Input : word (String) to be added or updated
     * Output : none
     */
    private void updateOrAdd(String word) {
        Node tmpNode = internalSearch(word);
        if (tmpNode == null) {
            addToHead(word);
        } else {
            tmpNode.setCount(tmpNode.getCount() + 1);
        }
    }

    /**
     * internalSearch      (Search for word in LinkedList and return Node if it exists otherwise return null)
     * Input : word (String) to be searched for
     * Output : tmp (Node) or null
     * This method allows other methods defined within the LinkedList class to find/update specific nodes in
     * the LinkedList based on the word provided. The internalSearch starts at the first node (head) then
     * iterates through all other nodes until the desired node is found, if its not found the method returns null.
     */
    private Node internalSearch(String word) {
        Node tmp = head;
        while (tmp != null && tmp.getWord() != null) {
            if (tmp.getWord().equals(word)) {
                return tmp;
            }
            tmp = tmp.getNext();
        }
        return null;
    }

    /**
     * findMostFrequentWord      (Find word which occurs the most in parsed text)
     * Input : none
     * Output : mostFrequentWord (Node)
     * This method starts at the head of the linkedlist then goes through each node in the list
     * and if it encounters a node with a 'count' higher than the 'mostFrequentWord' node count
     * it will set mostFrequent word to the new Node. After going through all the nodes it will
     * return the mostFrequentWord Node.
     */
    public String findMostFrequentWord() {
        if (head == null) return null;
        Node a = head;
        Node mostFrequentWord = a;
        while (a != null && mostFrequentWord != null) {
            if (a.getCount() >= mostFrequentWord.getCount()) {
                mostFrequentWord.setWord(a.getWord());
                mostFrequentWord.setCount(a.getCount());
            }
            a = a.getNext();
        }
        return mostFrequentWord.getWord();
    }

    /**
     * findLongestWord      (find longest word in the linkedList)
     * Input : none
     * Output : longestWord (String)
     * This method starts at the head of the linkedlist then goes through each node in the list
     * and if it encounters a node with a length greater than the 'longestWord' length
     * it will set 'longestWord' to the word associated with that node. After going through
     * all the nodes it will return the longestWord String.
     */
    public String findLongestWord() {
        if (head == null) return null;
        String longestWord = "";
        Node tmpNode = head;
        while (tmpNode != null) {
            if (tmpNode.getWord().length() >= longestWord.length()) {
                longestWord = tmpNode.getWord();
            }
            tmpNode = tmpNode.getNext();
        }
        return longestWord;
    }

    /**
     * displayFrequentWords      (display words that occur more than numOccurrences times)
     * Input : numOccurrences (int)
     * Output : none
     * This method goes through all nodes in the linkedlist and returns the number of words that occur
     * more than numOccurrences times
     */
    public int getFrequentWords(int numOccurrences) {
        int wordCount = 0;
        Node tmp = head;
        if (head == null) return 0;
        while (tmp != null) {
            if (tmp.getCount() > numOccurrences) {
                wordCount++;
            }
            tmp = tmp.getNext();
        }
        return wordCount;
    }
}
