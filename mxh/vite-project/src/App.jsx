import { useState } from 'react'
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Login from './Components/User/Login';
import Home from './Components/Home/Home';
import Trangchu from './Components/Home/Trangchu'
import Profile from './Components/User/Profile';
import "./App.css"

function App() {
  const [count, setCount] = useState(0);

  return (
    <Router>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/tc" element={<Trangchu />} />
        <Route path="/pf" element={<Profile />} />
      </Routes>
    </Router>
  );
}

export default App;
