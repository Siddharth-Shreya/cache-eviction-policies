/*
This code creates a linked list in Java.
This will be used to simulate the cache.
*/

public class LinkedList{
    int position;
    int length;  
    int clockPointer;
    int compulsoryMisses;
    int capacityMisses;
    Node front;
    Node back;
    Node cursor;

    private class Node {
        Node prev;
        Node next;
        String data;
        int referenceBit;
        // Node constructor
        Node (String data) {
            this.data = data;
            this.prev = null;
            this.next = null;
            this.referenceBit = 0;
        }
    }

    public static void main(String[] args){
        System.out.println("Linked List Class");
    }

    // initalize linked list instance
    public LinkedList () {
        this.position;
        this.length;  
        this.clockPointer;
        this.compulsoryMisses;
        this.capacityMisses;
        this.front;
        this.back;
        this.cursor;
    }

    /* Accessor Functions */

    // front - returns value of first element
    public String front () {

    }

    // length - returns current length of list
    public int length () {

    }
    
    // Position - gets position at which cursor is at
    public int position () {

    }

    // Get - get value at cursor
    public String get () {

    }
 
    // getValueAtIndex - get value in list at a specified index
    public String getValueAtIndex (int index) {

    }
 
    // Contains - checks if the element is present in the list
    public boolean contains (String x) {

    }

    /* Manipulator Functions */

    // moveFront - move cursor to first element
    public void moveFront () {

    }
 
    // moveBack - move cursor to last element
    public void moveBack (int index) {

    }
    
    // moveNext - move cursor to the next element
    public void moveNext (String x) {

    }
 
    // movePrev - move cursor to the previous element
    public void movePrev (String x) {

    }
    
    // prepend - add value at beginning of list
    public void prepend (String x) {

    }
 
    // append - add value at end of list
    public void append (String x) {

    }

    // insertBefore - insert node before cursor element
    public void insertBefore (String x) {

    }
    
    // insertAfter - insert node after cursor element
    public void insertAfter (String x) {

    }
 
    // deleteFront - delete the first element of the list
    public void deleteFront (String x) {

    }
 
    // deleteBack - delete the last element of the list
    public void deleteBack () {

    }
 
    // delete element at cursor
    public void delete () {

    }
 
    // printList 
    public void printList () {

    }

    /* Cache specific */

    // get compulsory misses
    public int getCompulsoryMisses () {

    }
 
    // increment compulsory misses
    public void incrementCompulsoryMisses () {

    }

    // get capacity misses
    public int getCapacityMisses () {

    }

    // increment capacity misses
    public void incrementCapacityMisses () {

    }

    /* Clock specific */

    // get reference bit
    public void getReferenceBit () {

    }
 
    // set reference bit
    public void setReferenceBit (int value) {

    }
 
    // get clock pointer
    public int getClockPointer () {

    }
    
    // set clock pointer
    public void setClockPointer (int value) {

    }
}