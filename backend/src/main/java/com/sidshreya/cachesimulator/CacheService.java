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

    public boolean populateCache(String value) {
        if (cachePolicy.equals("F")){
            return addValueFifo(value);
        } else if (cachePolicy.equals("L")){
            return addValueLru(value);
        } else if (cachePolicy.equals("M")){
            return addValueMru(value);
        } else if (cachePolicy.equals("C")){
            return addValueClock(value);
        }
        return false;
    }

    public boolean addValueFifo(String value) {
        boolean hitOrMiss;
        if(cache.length() > 0 && cache.contains(value)){
            hitOrMiss = true;
        }
        else{
            hitOrMiss = false;
            if(cache.length() >= cacheSize){
                cache.deleteFront();
            }
            cache.append(value);
        }
        return hitOrMiss;
    }

    public boolean addValueLru(String value) {
        boolean hitOrMiss;
        if(cache.length() > 0 && cache.contains(value)){
            hitOrMiss = true;
            cache.moveFront();
            while(!cache.getValueAtCursor().equals(value)){
                cache.moveNext();
            }
            cache.delete();
            cache.append(value);
        }
        else{
            hitOrMiss = false;
            if(cache.length() >= cacheSize){
                cache.deleteFront();
            }
            cache.append(value);
        }

        return hitOrMiss;
    }

    public boolean addValueClock(String value) {
        boolean hitOrMiss;
        if (cache.length() > 0 && cache.contains(value)) {
            String item = cache.getValueAtCursor();
            hitOrMiss = true;
            cache.setReferenceBit(1);
            return hitOrMiss;
        } else {
            hitOrMiss = false;
        }
    
        if (cache.length() == cacheSize) {
            String item = cache.getValueAtIndex(cache.getClockPointer());
            System.out.println("ITEM:" + item)
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

        return hitOrMiss;
    }
    

    public boolean addValueMru(String value) {
        boolean hitOrMiss;
        if(cache.length() > 0 && cache.contains(value)){
            hitOrMiss = true;
            cache.moveFront();
            while(!cache.getValueAtCursor().equals(value)){
                cache.moveNext();
            }
            cache.delete();
            cache.append(value);
        }
        else{
            hitOrMiss = false;
            if(cache.length() >= cacheSize){
                cache.moveBack();
                cache.delete();
            }
            cache.append(value);
        }
        return hitOrMiss;
    }

    public String getCacheContents() {
        return cache.listToString();
    }
}
