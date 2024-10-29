package com.sidshreya.cachesimulator;
import org.springframework.stereotype.Service;

@Service
public class CacheService {
    private LinkedList cache;
    private int cacheSize;
    private String cachePolicy;

    public void initializeCache(int length, String policy) {
        this.cachePolicy = policy;
        this.cacheSize = length;
        this.cache = new LinkedList();
    }

    public void populateCache(String value) {
        if (cachePolicy.equals("F")){
            addValueFifo(value);
        } else if (cachePolicy.equals("L")){
            addValueLru(value);
        } else if (cachePolicy.equals("M")){
            addValueMru(value);
        } else if (cachePolicy.equals("C")){
            addValueClock(value);
        }
    }

    public void addValueFifo(String value) {
        if(cache.length() > 0 && cache.contains(value)){
            System.out.println("Cache hit for value: " + value);
        }
        else{
            System.out.println("Cache miss for value: " + value);
            if(cache.length() >= cacheSize){
                cache.deleteFront();
            }
            cache.append(value);
        }
    }

    public void addValueLru(String value) {
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
            if(cache.length() >= cacheSize){
                cache.deleteFront();
            }
            cache.append(value);
        }
    }

    public void addValueClock(String value) {
        if (cache.length() > 0 && cache.contains(value)) {
            String item = cache.getValueAtCursor();
            System.out.println("Cache hit for value: " + value);
            cache.setReferenceBit(1);
            return;
        }
    
        if (cache.length() == cacheSize) {
            String item = cache.getValueAtIndex(cache.getClockPointer());
            while (cache.getReferenceBit() == 1) {
                cache.setReferenceBit(0);
                cache.setClockPointer((cache.getClockPointer() + 1) % cacheSize);
                item = cache.getValueAtIndex(cache.getClockPointer());
            }
            cache.setValueAtIndex(value, cache.getClockPointer());
            cache.setClockPointer((cache.getClockPointer() + 1) % cacheSize);
        } else {
            cache.append(value);
        }
    }
    

    public void addValueMru(String value) {
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
            if(cache.length() >= cacheSize){
                cache.moveBack();
                cache.delete();
            }
            cache.append(value);
        }
    }

    public String getCacheContents() {
        return cache.listToString();
    }
}
