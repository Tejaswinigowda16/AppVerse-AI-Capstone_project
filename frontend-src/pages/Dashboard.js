import "./Dashboard.css";
import { useNavigate } from "react-router-dom";
import {useEffect } from "react";
 
function Dashboard() {

    useEffect(() => {
 
    const token = localStorage.getItem("token");
 
    if (!token) {
        alert("Please login first");
        window.location.href = "/login";
    }
 
}, []);
 
    const navigate = useNavigate();
 
    const cards = [
        { icon: "📱", title: "Apps", path: "/apps" },
        { icon: "👥", title: "Users", path: "/users" },
        { icon: "📂", title: "Categories", path: "/categories" },
        { icon: "👨‍💻", title: "Developers", path: "/developers" },
        { icon: "⬇️", title: "Downloads", path: "/downloads" },
        { icon: "⭐", title: "Reviews", path: "/reviews" },
        { icon: "💳", title: "Transactions", path: "/transactions" },
        { icon: "🤖", title: "Recommendations", path: "/recommendations" },
        { icon: "💬", title: "Chat", path: "/chat" }
    ];
 
    return (
        <div className="dashboard-container">

            <div className="dashboard-header">
 
    <h1 className="dashboard-title">
        🚀 Dashboard
    </h1>
 
    <p className="dashboard-subtitle">
        Manage your App Store efficiently.
    </p>
 
</div>
 
            <div className="dashboard-grid">
 
                {cards.map((card, index) => (
 
                    <div
                        className="dashboard-card"
                        key={index}
                        onClick={() => navigate(card.path)}
                    >
 
                        <div className="icon">
                            {card.icon}
                        </div>
 
                        <h3>{card.title}</h3>
 
                        <h2>{card.count}</h2>
 
                        <p>Manage {card.title}</p>
 
                    </div>
 
                ))}
 
            </div>
 
        </div>
    );
}
 
export default Dashboard;