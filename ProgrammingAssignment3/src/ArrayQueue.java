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
 * Class: ArrayQueue
 * Description: this class is used to build out a ArrayQueue data structure which is comprised of 4 data members
 * The queue (String[]) data member is used to collect/hold a number of strings which can be used to run queries against.
 * The count (int) indicates the size of the ArrayQueue. The head (int) is an indices pointer to first item in the ArrayQueue.
 * The tail (int) is a pointer to the last item in the ArrayQueue.
 */
public class ArrayQueue {
    // data members
    private String[] queue;
    private int count;
    private int head;
    private int tail;

    // constructors
    // default constructor
    ArrayQueue() {
        queue = new String[0];
        head = tail = count = 0;
    }
    // constructor to populate ArrayQueue if array of words is already provided
    ArrayQueue(String[] words) {
        this();
        for (int i = 0; i < words.length; i++) {
            add(words[i]);
        }
    }

    // methods
    /**
     * add        (adds a new string to the arrayqueue)
     * Input : word (String) to be added to queue as the
     * Output :
     *  Checks to make sure the queue isn't full (and calls resize if it is)
     *  then adds the word to the next spot in the queue and incrementing tail and count by 1
     */
    public void add(String word) {
        // Resize the queue if necessary
        if (isFull()) {
            resize();
        }

        queue[tail++] = word;
        count++;

        // Cure wrap
        if (tail == queue.length) {
            tail = 0;
        }
    }

    /**
     * copy        (Returns a copy of the arrayqueue object)
     * Input : numEntries (int) number of words to be returned from arrayqueue
     * Output : newArrayQueue (ArrayQueue)
     * Returns a copy of the arrayqueue object. If numEntries is smaller than queue.length
     * then only a partial copy of the arrayqueue will be returned.
     */
    public ArrayQueue copy(int numEntries) {
        String[] newQueue = new String[numEntries];

        int tmp = head;
        for (int i = 0; i < numEntries; i++) {
            newQueue[i] = queue[tmp++];
            if (tmp == numEntries) {
                tmp = 0;
            }
        }
        head = 0;
        tail = count;
        ArrayQueue newArrayQueue = new ArrayQueue(newQueue);
        return newArrayQueue;
    }

    /**
     * remove        removes the word at the head of the queue
     * Input :
     * Output : rtn (String)
     * Removes the word at the head of queue (and returns it) by incrementing the head by 1 and decrementing the count by 1
     */
    public String remove() {
        if (isEmpty()) {
            return null;
        }

        String rtn = queue[head++];
        count--;

        // Cure wrap
        if (head == queue.length) {
            head = 0;
        }
        return rtn;
    }

    /**
     * removeAllEntries        empties out the arrayqueue
     * Input :
     * Output : allEntries (String[])
     * Iterates through the arrayqueue and removes each entry. This method returns an array of Strings to the calling method
     * so that it can be used to easily populate a LinkedList to be further queried against.
     */
    public String[] removeAllEntries() {
        String[] allEntries = new String[queue.length];
        for (int i = 0; i < queue.length; i++) {
            allEntries[i] = remove();
        }
        return allEntries;
    }

    /**
     * find        finds the first spot a word appears in the arrayqueue
     * Input : word (String)
     * Output : (Integer)
     * This method goes through the arrayqueue to find the first time a specific
     * word appears in the queue. If the word is found then the words indices within the arrayqueue is
     * returned, otherwise null is returned.
     */
    public Integer find(String word) {
        Integer foundAt = null;
        for (int i = 0; i < queue.length; i++) {
            if (queue[head].equals(word)) {
                foundAt = i;
                break;
            }
            remove();
        }
        return foundAt;
    }

    /**
     * resize        resizes the queue to fit one more word
     * Input :
     * Output :
     * This method is called when the add method is called and the queue is already full
     */
    private void resize() {
        String[] newQueue = new String[count+1];
        int tmp = head;
        for (int i = 0; i < count; i++) {
            newQueue[i] = queue[tmp++];
            if (tmp == queue.length) {
                tmp = 0;
            }
        }
        head = 0;
        tail = count;
        queue = newQueue;
    }

    /**
     * size        returns the count of the arrayqueue
     * Input :
     * Output : count (int)
     */
    public int size() {
        return count;
    }

    /**
     * isEmpty        returns if the arrayqueue isEmpty
     * Input :
     * Output : (boolean)
     * the arrayqueue isEmpty if count==0
     */
    private boolean isEmpty() {
        return count == 0;
    }

    /**
     * isFull       returns if the arrayqueue isFull
     * Input :
     * Output : (boolean)
     * the arrayqueue isFull if count==queue.length
     */
    public boolean isFull() {
        return (count == queue.length);
    }

}
