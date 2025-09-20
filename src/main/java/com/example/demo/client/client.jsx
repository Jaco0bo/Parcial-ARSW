import React, { useState } from 'react';
import axios from 'axios';

function StockApp() {
    const [symbol, setSymbol] = useState('');
    const [interval, setInterval] = useState('1min');
    const [data, setData] = useState(null);

    const handleSearch = async () => {
        try {
            const response = await axios.get(`http://localhost:8080/api/stock/${symbol}?interval=${interval}`);
            setData(response.data);
        } catch (error) {
            console.error('Error fetching stock data:', error);
        }
    };

    return (
        <div>
            <input
                type="text"
                placeholder="Enter Stock Symbol"
                value={symbol}
                onChange={(e) => setSymbol(e.target.value)}
            />
            <select onChange={(e) => setInterval(e.target.value)}>
                <option value="1min">1 Minute</option>
                <option value="5min">5 Minutes</option>
                <option value="15min">15 Minutes</option>
                <option value="30min">30 Minutes</option>
                <option value="60min">1 Hour</option>
            </select>
            <button onClick={handleSearch}>Search</button>
            
            {data && (
                <pre>{JSON.stringify(data, null, 2)}</pre>
            )}
        </div>
    );
}

export default StockApp;
