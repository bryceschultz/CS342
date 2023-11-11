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
     * wordCount      (Search for word in LinkedList and return getCount if word exists otherwise return 0)
     * Input : word (String) to be searched for
     * Output : count (integer) this represents how many times the word appears in the parsed text
     */
    public int wordCount(String word) {
        Node tmpNode = internalSearch(word);
        int count = 0;
        try {
            count = tmpNode.getCount();
        } catch (Exception e) {
            // word is not in list so we return count = 0 as defined above
        }
        return count;
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
        while (tmp != null) {
            if (tmp.getWord().equals(word)) {
                return tmp;
            }
            tmp = tmp.getNext();
        }
        return null;
    }

    /**
     * orderByCount      (order all the nodes from highest count to lowest count)
     * Input : none
     * Output : none
     * This method iterates through all the nodes and orders them using a bubble sort approach.
     * If a is greater than or equal to b nothing happens, but if b is greater than a then the
     * nodes count and word data members are swapped, effectively making the nodes switch places. For each iteration
     * through the array it is assumed that the nodes are in order, if one set of nodes are found to not be
     * in order then 'sorted' gets set to false which initiates another loop through the array. Only when all "a"
     * nodes have a count greater than "b" nodes will this method/loop stop.
     */
    private void orderByCount() {
        if (head == null) return;
        boolean sorted;
        do {
            sorted = true;
            Node a = head;
            Node b = a.getNext();
            while (a != null && b!= null) {
                if (a.getCount() >= b.getCount()) {
                    // do nothing as theyre in the right order
                } else {
                    // switch the nodes
                    String aWord = a.getWord();
                    int aCount = a.getCount();
                    a.setWord(b.getWord());
                    a.setCount(b.getCount());
                    b.setWord(aWord);
                    b.setCount(aCount);
                    sorted = false;
                }
                a = a.getNext();
                b = a.getNext();
            }
        } while (!sorted);
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
    private Node findMostFrequentWord() {
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
        return mostFrequentWord;
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
    private String findLongestWord() {
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
     * This method goes through all nodes in the linkedlist and prints out nodes whose associated
     * word appears more than numOccurrences times in the parsedText
     */
    public void displayFrequentWords(int numOccurrences) {
        orderByCount();
        String wordCountsStr = "\n";
        int wordCount = 0;
        Node tmp = head;
        if (head == null) return;
        while (tmp != null) {
            if (tmp.getCount() > numOccurrences) {
                wordCountsStr += "'" + tmp.getWord() + "'(" + tmp.getCount() + ") ";
                if (wordCount % 8 == 0 && wordCount != 0) wordCountsStr += "\n";
                wordCount++;
            }
            tmp = tmp.getNext();
        }
        System.out.println(wordCountsStr);
        System.out.println("\nWords occurring more than " + numOccurrences + " times: " + wordCount);
    }

    /**
     * displayMostFrequentWord      (display word that occurs the most in the parsed text)
     * Input : none
     * Output : none
     * This method calls the findMostFrequentWord method and displays the results
     */
    public void displayMostFrequentWord() {
        Node mostFrequentWord = findMostFrequentWord();
        System.out.println("Most frequent word is: '" + mostFrequentWord.getWord() + "' occurring " + mostFrequentWord.getCount() + " times.");
    }

    /**
     * displayLongestWord      (display word thats the longest in the parsed text)
     * Input : none
     * Output : none
     * This method calls the findLongestWord method and displays the results
     */
    public void displayLongestWord() {
        String longestWord = findLongestWord();
        System.out.println("Longest word is: '" + longestWord + "'");
    }

    /**
     * displayNumberOfUniqueWords    (display total number of nodes in LinkedList)
     * Input : none
     * Output : none
     * This method uses the count data member to display how many unique words/entries are in the LinkedList
     */
    public void displayNumberOfUniqueWords() {
        System.out.println("Total entries in list: " + count);
    }
}
