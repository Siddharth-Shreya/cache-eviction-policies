package com.sidshreya.cachesimulator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cache")
public class CacheController {
    
    @Autowired
    private CacheService cacheService;

    @PostMapping("/initialize")
    public String initializeCache(@RequestParam int length, @RequestParam String policy) {
        cacheService.initializeCache(length, policy);
        return "Cache initialized with size " + length + " and policy " + policy;
    }

    @PostMapping("/add")
    public String addValueToCache(@RequestBody CacheRequest request) {
        cacheService.populateCache(request.getValue());
        String contents = cacheService.getCacheContents();
        return contents;
    }

    @GetMapping("/contents")
    public String getCacheContents() {
        return cacheService.getCacheContents();
    }

}
