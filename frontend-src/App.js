import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
 
import Navbar from "./components/Navbar";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Register from "./pages/Register";
import Apps from "./pages/Apps";
import Category from "./pages/Category";
import Developer from "./pages/Developer";
import Download from "./pages/Download";
import Review from "./pages/Review";
import Transaction from "./pages/Transaction";
import User from "./pages/User";
import Recommendation from "./pages/Recommendation";
import Chat from "./pages/Chat";
import Dashboard from "./pages/Dashboard";
 
function App() {
    return (
        <BrowserRouter>
 
            <Navbar />

            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/login" element={<Login />} />
                <Route path="/register" element={<Register />} />
                <Route path="/apps" element={<Apps />} />
                <Route path="/categories" element={<Category />} />
                <Route path="/developers" element={<Developer />} />
                <Route path="/downloads" element={<Download />} />
                <Route path="/reviews" element={<Review />} />
                <Route path="/transactions" element={<Transaction />} />
                <Route path="/users" element={<User />} />
                <Route path="/recommendations" element={<Recommendation />} />
                <Route path="/chat" element={<Chat />} />
                <Route path="/dashboard" element={<Dashboard />} />
            </Routes>
 
        </BrowserRouter>
    );
}
 
export default App;
 