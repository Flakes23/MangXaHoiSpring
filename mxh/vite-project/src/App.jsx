import { useState } from 'react'
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Login from './Components/User/Login';
import Trangchu from './Components/Home/Trangchu'
import Profile from './Components/User/Profile';
import AddFriend from './Components/User/AddFriend';
import "./App.css"

function App() {
  const [count, setCount] = useState(0);

  return (
    <Router>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/tc" element={<Trangchu />} />
        <Route path="/profile" element={<Profile />} />
        <Route path="/addfriend" element={<AddFriend />} />
      </Routes>
    </Router>
  );
}

export default App;
