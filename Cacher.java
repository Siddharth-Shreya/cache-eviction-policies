import java.util.Scanner;

public class Cacher {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean hasMode = false;

        while(hasMode == false){
            System.out.println("Welcome to the Cache Simulation! \n-----------\nType 'F' for FIFO, 'L' for LRU, 'C' for Clock, or 'M' for MRU. [Type 'H' for help]");

            String mode = s.next();

            if(mode.equals("F") || mode.equals("")){
                //Call FIFO specific methods
                hasMode = true;
            }
            else if(mode.equals("L")){
                //Call LRU specific methods
                hasMode = true;
            }
            else if(mode.equals("C")){
                //Call Clock specific methods
                hasMode = true;
            }
            else if(mode.equals("M"){
                //Call MRU specific methods
                hasMode = true;
            }
            else{
                if(mode.length() > 0){
                    System.out.println("That is not a valid input. Please choose a policy you would like to run.");
                }
                System.out.println("'F' - FIFO simulates a cache where the first node in is the first out.");
                System.out.println("'L' - LRU simulates a cache where the order is dependent on the least recently used node.");
                System.out.println("'C' - Clock simulates a cache based on the reference bit of a specific clock pointer.");
                System.out.println("'M' - MRU simulates a cache based on [write description].");
            }
        }

        while(hasMode == true){
            //Write input to determine the length of the list or whatever. Use int x = s.nextInt();
            System.out.println("Type in the desired length of the cache.");

            int length = s.nextInt();
        }

        //Apparently this is needed but I never use it
        s.close();

        LinkedList cache = new LinkedList();

        cache.moveFront();
        cache.append(null);
    }

    public void fifo(int length, String s){

    }
}
