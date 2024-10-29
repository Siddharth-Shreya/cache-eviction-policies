/* INITIAL CODE */

import java.util.Scanner;

public class Cacher{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean hasMode = false;

        while(!hasMode){
            System.out.println("Welcome to the Cache Simulation! \n-----------\nType 'F' for FIFO, 'L' for LRU, 'C' for Clock, or 'M' for MRU. [Type 'H' for help]");

            String mode = s.next();

            if(mode.equals("F") || mode.equals("")){
                //Call FIFO specific methods
                FIFO();
                hasMode = true;
            }
            else if(mode.equals("L")){
                //Call LRU specific methods
                LRU();
                hasMode = true;
            }
            else if(mode.equals("C")){
                //Call Clock specific methods
                Clock();
                hasMode = true;
            }
            else if(mode.equals("M")){
                //Call MRU specific methods
                MRU();
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
        s.close();
        }
        
        public static void FIFO(){
            Scanner s = new Scanner(System.in);
            System.out.println("Type in the desired length of the cache: ");
            int length = s.nextInt();

            LinkedList cache = new LinkedList();

            while(length > 0){
                System.out.println("Type 'exit' to exit the fifo simulation.\nEnter value: ");
                String value = s.next();

                if(value.equals("exit")){
                    break;
                }
                if(cache.length() > 0 && cache.contains(value)){
                    System.out.println("Cache hit for value: " + value);
                }
                else{
                    System.out.println("Cache miss for value: " + value);
                    if(cache.length() >= length){
                        cache.deleteFront();
                    }
                    cache.append(value);
                }
            }
            System.out.println("Final cache contents: " + cache);
            s.close();
        }
        public static void LRU(){
            Scanner s = new Scanner(System.in);
            System.out.println("Type in the desired length of the cache: ");
            int length = s.nextInt();

            LinkedList cache = new LinkedList();

            while(true){
                System.out.println("Type 'exit' to exit the lru simulation.\nEnter value: ");
                String value = s.next();

                if(value.equals("exit")){
                    break;
                }
                if(cache.length() > 0 && cache.contains(value)){
                    System.out.println("Cache hit for value: " + value);
                    cache.moveFront();
                    while(!cache.getValueAtCursor().equals(value)){
                        cache.moveNext();
                    }
                    cache.delete();
                    cache.append(value);
                }
                else{
                    System.out.println("Cache miss for value: " + value);
                    if(cache.length() >= length){
                        cache.deleteFront();
                    }
                    cache.append(value);
                }
            }
        System.out.println("Final cache contents: " + cache);
        s.close();
     }

        public static void Clock(){
            Scanner s = new Scanner(System.in);
            System.out.println("Type in the desired length of the cache: ");
            int length = s.nextInt();

            LinkedList cache = new LinkedList();

            while(true){
                System.out.println("Type 'exit' to exit the clock simulation.\nEnter value: ");
                String value = s.next();

                if(value.equals("exit")){
                    break;
                }

                if(cache.length() > 0 && cache.contains(value)){
                    String item = cache.getValueAtCursor();
                    System.out.println("Cache hit for value: " + value);
                    cache.setReferenceBit(item);
                    return;
                }

                if (cache.length() == length){
                    String item = cache.getValueAtCursor(cache.getClockPointer());
                    while (cache.getReferenceBit(item) == 1){
                        cache.setReferenceBit(0);
                        cache.setClockPointer((cache.getClockPointer() + 1) % length);
                        item = cache.getValueAtIndex(cache.getClockPointer())
                    }
                    cache.setValueAtIndex(cache.getClockPointer());
                    cache.setClockPointer((cache.getClockPointer() + 1) % length);
                    return;
                }
            }
            cache.append(s);

        }

        public static void MRU(){
            Scanner s = new Scanner(System.in);
            System.out.println("Type in the desired length of the cache: ");
            int length = s.nextInt();

            LinkedList cache = new LinkedList();

            while(true){
                System.out.println("Type 'exit' to exit the mru simulation.\nEnter value: ");
                String value = s.next();

                if(value.equals("exit")){
                    break;
                }
                if(cache.length() > 0 && cache.contains(value)){
                    System.out.println("Cache hit for value: " + value);
                    cache.moveFront();
                    while(!cache.getValueAtCursor().equals(value)){
                        cache.moveNext();
                    }
                    cache.delete();
                    cache.append(value);
                }
                else{
                    System.out.println("Cache miss for value: " + value);
                    if(cache.length() >= length){
                        cache.moveBack();
                        cache.delete();
                    }
                    cache.append(value);
                }
            }
        System.out.println("Final cache contents: " + cache);
        s.close();
        }

}