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
    const [loading, setLoading] = useState('');

    const createCache = async () => {
        if (length <= 0){
            alert("Cache length must be greater than zero!");
            return;
        }
        setLoading(true);
        try {
            await axios.post('https://cache-eviction-policies-1.onrender.com/cache/initialize', null, {
                params: { length, policy }
            });
            setCache(new Array(parseInt(length)).fill(null));
            setCacheCreated(true);
        } catch (error) {
            console.error("Error initializing cache:", error);
        }
        setLoading(false);
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
            const response = await axios.post('https://cache-eviction-policies-1.onrender.com/cache/add', {
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
    }

    useEffect(() => {
        console.log("Added element:", addedElem)
        console.log("Cache:", cache);
        console.log("hitOrMiss:", hitOrMiss);
    }, [cache, hitOrMiss, addedElem]);

    return (
        <div>
            {/* Heading */}
            <h1 className="header">Cache Eviction Policies Simulator</h1>
            <div className="about-container">
                <div className="about-cell">
                    <h5>FIFO</h5>
                    <p>First in, first out: evicts items in the order they were added.</p>
                </div>
                <div className="about-cell">
                    <h5>LRU</h5>
                    <p>Least recently used: Evicts items that haven't been used recently.</p>
                </div>
                <div className="about-cell">
                    <h5>MRU</h5>
                    <p>Most recently used: Evicts items that have been used recently.</p>
                </div>
                <div className="about-cell">
                    <h5>Clock</h5>
                    <p>Uses a pointer to circularly (like a clock) go through cache items. When the clock encounters an item marked as unused, it evicts it.</p>
                </div>
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
                            <div>
                                <h4>Cache will appear here</h4>
                                {loading && 
                                    <div class="lds-roller"><div></div><div></div><div></div><div></div><div></div><div></div><div></div><div></div></div>
                                }
                            </div>
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
                <p><a href="https://github.com/Siddharth-Shreya/cache-eviction-policies" rel="noreferrer" target="_blank">Source Code</a> | <a href="https://github.com/Siddharth-Shreya/cache-eviction-policies/blob/main/README.md" rel="noreferrer" target="_blank">About</a></p>
                <p>Built by <a href="https://www.linkedin.com/in/siddharthsundar" rel="noreferrer" target="_blank">Siddharth Sundar</a> and <a href="https://www.linkedin.com/in/shreyasundar" rel="noreferrer" target="_blank">Shreya Sundar</a></p>
            </div>
        </div>
    );
};

export default CacheSimulator;
