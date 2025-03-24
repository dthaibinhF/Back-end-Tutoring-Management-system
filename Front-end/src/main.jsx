import {StrictMode} from 'react'
import {createRoot} from 'react-dom/client'
import '@ant-design/v5-patch-for-react-19';
import './assets/css/styles.css';
import App from './App.jsx'

createRoot(document.getElementById('root')).render(
    <App/>
)
