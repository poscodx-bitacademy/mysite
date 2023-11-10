import React from 'react';
import ReactDOM from 'react-dom/client';
import {BrowserRouter as Router} from 'react-router-dom';
import App from './App';

if(process.env.NODE_ENV === 'production') {
    console.log = () => {};
    console.error = () => {};
    console.debug = () => {};
    console.info = () => {};     
}
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <Router>
        <App />
    </Router>
);
