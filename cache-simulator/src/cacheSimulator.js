import React, { useState, useEffect } from 'react';
import './cacheSimulator.css';
import axios from 'axios';

const CacheSimulator = () => {
    const [policy, setPolicy] = useState('F');
    const [length, setLength] = useState(1);
    const [cacheCreated, setCacheCreated] = useState(false)
    const [cache, setCache] = useState([]);
    const [addedElem, setAddedElem] = useState('');

    const createCache = async () => {
        if (length <= 0){
            alert("Cache length must be greater than zero!");
            return;
        }
        try {
            const response = await axios.post('http://localhost:8080/cache/initialize', null, {
                params: { length, policy }
            });
            console.log(response.data);
            setCache(new Array(parseInt(length)).fill(null));
            setCacheCreated(true);
        } catch (error) {
            console.error("Error initializing cache:", error);
        }
    };

    const resetCache = () => {
        setCacheCreated(false);
        setPolicy('F');
        setLength(1);
        setCache([]);
    };

    const addElementToCache = async () => {
        try {
            // Add element to cache
            const response = await axios.post('http://localhost:8080/cache/add', {
                "value": addedElem
            });
            console.log("Full Response:", response); 
            // Get the updated cache back and reformat
            let cacheContents = String(response.data).trim().split(" ");
            console.log("cache contents:", cacheContents);
            console.log(typeof cacheContents);
            while (cacheContents.length < length){
                cacheContents.push(" ");
            }
            setCache(cacheContents);
            console.log("Current cache:", cache)
            
        } catch (error) {
            console.error("Error adding element to cache:", error);
        }
        setAddedElem('');
    }

    useEffect(() => {
        console.log("Updated cache state:", cache);
    }, [cache]);

    return (
        <div>
            <h1 className="header">Cache Eviction Policies Simulator</h1>
            <div>
                Explanation of different eviction policies.
            </div>
            <div className="container">
                <h2>Create Cache</h2>
                <label className="label">
                    Cache Policy:
                    <select value={policy} onChange={(e) => setPolicy(e.target.value)} className="select" disabled={cacheCreated}>
                        <option value="F">FIFO</option>
                        <option value="L">LRU</option>
                        <option value="C">Clock</option>
                        <option value="M">MRU</option>
                    </select>
                </label>
                <label className="label">
                    Cache Length:
                    <input
                        type="number"
                        value={length}
                        onChange={(e) => setLength(e.target.value)}
                        className="input"
                        disabled={cacheCreated}
                    />
                </label>
                <div className="button-container">
                    <button onClick={createCache} className="button" disabled={cacheCreated}>
                        Create Cache
                    </button>
                    {cacheCreated && (
                        <button onClick={resetCache} className="button">
                            Create Another Cache
                        </button>
                    )}
                </div>
            </div>

            {   
                cacheCreated && (
                    <div>
                        <h2>Add Element to Cache</h2>
                        <input
                            type="text"
                            value={addedElem}
                            onChange={(e) => setAddedElem(e.target.value)}
                            className="input"
                        />
                        <button onClick={addElementToCache} className="button">
                            Add Element
                        </button>
                    </div>
                )
            }

            {
                cacheCreated && (
                    <div className="box-container">
                        {cache.map((item, index) => (
                            <div key={index} className="box">
                                {item}
                            </div>
                        ))}
                        <h3>Hit or miss</h3>
                    </div>
                )
            }

        </div>
    );
};

export default CacheSimulator;
