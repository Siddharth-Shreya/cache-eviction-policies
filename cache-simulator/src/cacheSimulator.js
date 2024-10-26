import React, { useState } from 'react';
import './cacheSimulator.css';

const CacheSimulator = () => {
    const [policy, setPolicy] = useState('F');
    const [length, setLength] = useState(1);
    const [cacheCreated, setCacheCreated] = useState(false)
    const [cache, setCache] = useState([]);
    const [addedElem, setAddedElem] = useState('');

    const createCache = () => {
        if (length <= 0){
            alert("Cache length must be greater than zero!");
            return;
        }
        console.log(`Creating cache with policy: ${policy} and length: ${length}`);
        setCache(new Array(parseInt(length)).fill(null));
        setCacheCreated(true);
    };

    const resetCache = () => {
        setCacheCreated(false);
        setPolicy('F');
        setLength(1);
    };

    const addElementToCache = () => {
        // send input element to backend 
        // run policy
        // get changed cache back
        // display that in current format
    }

    return (
        <div>
            <h1 className="header">Cache Eviction Policies Simulator</h1>
            
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
                        {cache.map((index) => (
                            <div key={index} className="box">
                                {index}
                            </div>
                        ))}
                    </div>
                )
            }

        </div>
    );
};

export default CacheSimulator;
