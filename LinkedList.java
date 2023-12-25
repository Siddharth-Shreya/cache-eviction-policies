/*
This code creates a linked list in Java.
This will be used to simulate the cache.
*/

public class LinkedList{

    private int position;
    private int length;  
    private int clockPointer;
    private int compulsoryMisses;
    private int capacityMisses;
    private Node front;
    private Node back;
    private Node cursor;

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
        System.out.println("Linked List Class" + node );
    }

    // initalize linked list instance
    public LinkedList () {
        this.position = 0;
        this.length = 0;  
        this.clockPointer = 0;
        this.compulsoryMisses = 0;
        this.capacityMisses = 0;
        this.front = new Node("0");
        this.back = new Node("0");
        this.cursor = this.front;
    }

    /* Accessor Functions */

    // front - returns value of first element
    public String front() {
        return this.front.data;
    }

    // length - returns current length of list
    public int length () {
        return this.length;
    }
    
    // Position - gets position at which cursor is at
    public int position() {
        return this.position;
    }

    // getValueAtCursor - get value at cursor
    public String getValueAtCursor() {
        return this.cursor.data;
    }
 
    // getValueAtIndex - get value in list at a specified index
    public String getValueAtIndex(int index) {
        this.moveFront(); 
        while(this.position() != index){
            this.moveNext();
        }
        return this.getValueAtCursor();

    }
 
    // Contains - checks if the element is present in the list
    public boolean contains (String x) {
        this.moveFront(); 
        while(this.position() != -1){
            if(this.getValueAtCursor().equals(x)){
                return true;
            }
            this.moveNext();
        }
        return false;
    }

    /* Manipulator Functions */

    // moveFront - move cursor to first element
    public void moveFront () {
        if(this.length > 0){
            this.position = 0;
            this.cursor = this.front;
        }
    }
 
    // moveBack - move cursor to last element
    public void moveBack () {

    }
    
    // moveNext - move cursor to the next element
    public void moveNext () {

    }
 
    // movePrev - move cursor to the previous element
    public void movePrev () {

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

    public String toString(){
        String s = "";
        for(this.moveFront(); position() != -1; this.moveNext()){
            s += this.getValueAtCursor();
        }
        return s;
    }
} 