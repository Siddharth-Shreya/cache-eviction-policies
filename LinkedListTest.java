public class LinkedListTest{
    public static void main (String[] args){
        LinkedList A = new LinkedList();
        LinkedList B = new LinkedList();
        LinkedList C = null;
        for(int i = 1; i <= 10; i++){
            A.append(Integer.toString(i));
            B.prepend(Integer.toString(i));
        }
        System.out.println("List A: " + A);
        System.out.println("List B: " + B);

        System.out.println("Iterating through List A: ");
        for(A.moveFront(); A.position() >= 0; A.moveNext()){
            System.out.println(A.getValueAtCursor());
        }

        for(A.moveFront(); B.position() >= 0; B.moveNext()){
            System.out.println(B.getValueAtCursor());
        }

        A.moveFront();
        System.out.println("Cursor Index after moving front: " + A.position());

        for(int i = 0; i < 5; i++){
            System.out.println("Value at cursor after moving 5 spaces: " + A.getValueAtCursor());
        }

        A.insertBefore("-1");
        System.out.println(A);

        System.out.println("Cursor Index after inserting at index 5: " + A.position());

        System.out.println("Length of List A: " + A.length());

        A.deleteFront();
        System.out.println("Deleting front of list A...");
        System.out.println(A);

        System.out.println("ursor Index after deleting front: " + A.position());

        System.out.println("Front of List A now: " + A.front());
        System.out.println("Length of List A after deleting: " + A.length());

        A.insertAfter("-2");
        System.out.println("Value at cursor new: " + A.getValueAtCursor());

        for(int i = 0; i < 3; i++){
            A.movePrev();
        }

        System.out.println("Value at cursor after moving prev 3 spaces: " + A.getValueAtCursor());
        System.out.println(A);





    }
}