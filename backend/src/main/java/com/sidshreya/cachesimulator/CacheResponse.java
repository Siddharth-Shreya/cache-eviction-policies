/*
 * Response format for cache - maintains the cache contents and hit/miss values
 */

package com.sidshreya.cachesimulator;

public class CacheResponse {
    private String cacheContents;
    private String hitOrMiss;

    public CacheResponse(String cacheContents, String hitOrMiss) {
        this.cacheContents = cacheContents;
        this.hitOrMiss = hitOrMiss;
    }

    public String getCacheContents() {
        return cacheContents;
    }

    public String getHitOrMiss() {
        return hitOrMiss;
    }

}