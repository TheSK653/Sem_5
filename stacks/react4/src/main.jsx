import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import Api from './components/Api.jsx'
import Timer from './components/Timer.jsx'
import Live from './components/Live.jsx'


createRoot(document.getElementById('root')).render(
  <StrictMode>
    {/* <App /> */}
    <Live />
    {/* <Api />
    <Timer /> */}
  </StrictMode>,
)
