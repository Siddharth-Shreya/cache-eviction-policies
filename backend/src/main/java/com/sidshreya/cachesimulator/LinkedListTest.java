package com.sidshreya.cachesimulator;
public class LinkedListTest{
    public static void main (String[] args){
        LinkedList A = new LinkedList();

        for(int i = 1; i <= 10; i++){
            A.append(Integer.toString(i));
        }
        System.out.println("List A: " + A);
        /* 1 2 3 4 5 6 7 8 9 10 */
        System.out.println("Iterating through List A: ");
        for(A.moveFront(); A.position() >= 0; A.moveNext()){
            System.out.println(A.getValueAtCursor());
        }
        /*
            1
            2
            3
            4
            5
            6
            7
            8
            9
            10
        */
        System.out.println("-----------");
        A.moveFront();
        System.out.println("Cursor Index after moving front: " + A.position());
        /* 0 */

        for(int i = 0; i < 5; i++){
            System.out.println("Value at cursor before moving " + i + " spaces: " + A.getValueAtCursor());
            A.moveNext();
        }
        /*
            Value at cursor after moving 0 spaces: 1
            Value at cursor after moving 1 spaces: 2
            Value at cursor after moving 2 spaces: 3
            Value at cursor after moving 3 spaces: 4
            Value at cursor after moving 4 spaces: 5
        */
        System.out.println("Current cursor element: " + A.getValueAtCursor() + ", Position: " + A.position()); 
        /* Current cursor element: 6, Position: 5 */
        System.out.println("-----------");
        System.out.println("Inserting -1 before cursor element...");
        A.insertBefore("-1");
        System.out.println("List A after inserting -1: " + A); /* 1 2 3 4 5 -1 6 7 8 9 10 */
        System.out.println("Position: " + A.position());
        System.out.println("Length of List A: " + A.length()); /* 11 */
        System.out.println("Current cursor element: " + A.getValueAtCursor()); /* 6 */
        System.out.println("Current cursor position: " + A.position()); /* 6 */

        System.out.println("-----------");
        System.out.println("Deleting front of list A...");
        A.deleteFront();
        System.out.println("List A after deleting front element: " + A); /* 2 3 4 5 -1 6 7 8 9 10 */
        System.out.println("Cursor Index after deleting front: " + A.position()); /* 5 */
        System.out.println("Front of List A now: " + A.front()); /* 2 */
        System.out.println("Length of List A after deleting an element: " + A.length()); /* 10 */

        System.out.println("-----------");
        System.out.println("Inserting -2 after cursor element...");
        A.insertAfter("-2");
        System.out.println("List A now: " + A);
        System.out.println("Value at cursor now: " + A.getValueAtCursor()); /* 6 */
        System.out.println("Value at index 7 now: " + A.getValueAtIndex(7)); /* 7 */


        System.out.println("-----------");
        for(int i = 0; i < 4; i++){
            A.movePrev();
        }
        System.out.println("Value at cursor after moving prev 4 spaces: " + A.getValueAtCursor()); /* 7 */
        
        System.out.println("-----------");
        System.out.println("List A now: " + A); /* 2 3 4 5 -1 6 -2 7 8 9 10 */
        System.out.println("Set index 5 to -3:"); 
        A.setValueAtIndex("-3", 5);
        System.out.println("List A now: " + A); /* 2 3 4 5 -1 -3 -2 7 8 9 10 */

        System.out.println("-----------");
        System.out.println("Deleting 3 elements from back of List A...");
        for(int i = 0; i < 3; i++) {
            A.deleteBack();
        }
        System.out.println("List A now: " + A); /* 2 3 4 5 -1 -3 -2 7 */
        System.out.println("Back of List A now: " + A.back()); /* 7 */

        System.out.println("-----------");
        System.out.println("Now we will delete value at cursor index: " + A.getValueAtCursor()); /* -3 */
        A.delete();
        System.out.println("List A after deleting cursor element: " + A); /* 2 3 4 5 -1 -2 7 */
        
        System.out.println("-----------");
    }
}