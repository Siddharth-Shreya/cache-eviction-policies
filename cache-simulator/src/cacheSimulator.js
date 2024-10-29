import React, { useState, useEffect } from 'react';
import './cacheSimulator.css';
import axios from 'axios';

const CacheSimulator = () => {
    const [policy, setPolicy] = useState('F');
    const [length, setLength] = useState(1);
    const [cacheCreated, setCacheCreated] = useState(false)
    const [cache, setCache] = useState([]);
    const [hitOrMiss, setHitOrMiss] = useState(null);
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
        setHitOrMiss(null);
    };

    const addElementToCache = async () => {
        try {
            // Add element to cache
            const response = await axios.post('http://localhost:8080/cache/add', {
                "value": addedElem
            });
            console.log("Full Response:", response); 
            // Get the updated cache back and reformat
            let cacheContents = String(response.data.cacheContents).trim().split(" ");
            let hitOrMiss = response.data.hitOrMiss;
            while (cacheContents.length < length){
                cacheContents.push(" ");
            }
            setCache(cacheContents);
            setHitOrMiss(hitOrMiss);            
        } catch (error) {
            console.error("Error adding element to cache:", error);
        }
        setAddedElem('');
    }

    useEffect(() => {
        console.log("Cache:", cache);
        console.log("hitOrMiss:", hitOrMiss);
    }, [cache, hitOrMiss]);

    return (
        <div>
            {/* Heading */}
            <h1 className="header">Cache Eviction Policies Simulator</h1>
            <div>
                Explanation of different eviction policies.
            </div>

            {/* left and right boxes */}
            <div className="lr">
                {/* Cache config */}
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
                                Reset Cache
                            </button>
                        )}
                    </div>
                </div>
                {/* Cache input and display */}
                <div className="container">
                    {   
                        cacheCreated ? (
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
                        ) : (
                            <h4>Cache will appear here</h4>
                        )
                    }

                    {
                        cacheCreated && (
                            <div className="cache-container">
                                <div className="box-container">
                                    {cache.map((item, index) => (
                                        <div key={index} className="box">
                                            {item}
                                        </div>
                                    ))}
                                </div>
                                <div style={{marginBottom:"20px"}}>
                                    {hitOrMiss === "MISS" &&
                                        (<h3 style={{color:"red"}}>{hitOrMiss}</h3>)
                                    }
                                    {hitOrMiss === "HIT" &&
                                        (<h3 style={{color:"green"}}>{hitOrMiss}</h3>)
                                    }
                                </div>
                            </div>
                        )
                    }
                </div>
            </div>
            
            <div className='footer'>
                <p><a href="https://github.com/Siddharth-Shreya/cache-eviction-policies" rel="noreferrer" target="_blank">Source Code</a></p>
                <p>Built by: <a href="https://www.linkedin.com/in/siddharthsundar" rel="noreferrer" target="_blank">Siddharth Sundar</a> and <a href="https://www.linkedin.com/in/shreyasundar" rel="noreferrer" target="_blank">Shreya Sundar</a></p>
            </div>
        </div>
    );
};

export default CacheSimulator;
