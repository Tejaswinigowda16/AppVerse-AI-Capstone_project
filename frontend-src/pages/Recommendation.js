import React, { useEffect, useState } from "react";
import axios from "axios";
import"./User.css";
 
function Recommendation() {
 
    const [recommendations, setRecommendations] = useState([]);
 
    useEffect(() => {
        fetchRecommendations();
    }, []);
 
    const fetchRecommendations = () => {
 
        axios.get("http://localhost:8081/api/recommendations")
            .then((response) => {
                setRecommendations(response.data);
            })
            .catch((error) => {
                console.error(error);
            });
    };
 
    return (
    <div className="page-container">
 
        <button
            className="back-btn"
            onClick={() => window.location.href = "/dashboard"}
        >
            ← Back
        </button>
 
        <h1 className="page-title">
            Recommended Apps
        </h1>
 
        <div className="table-card">
 
            <h3>Recommendations List</h3>
 
            <table className="user-table">
 
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>App Name</th>
                        <th>Description</th>
                        <th>Version</th>
                        <th>Price</th>
                    </tr>
                </thead>
 
                <tbody>
 
                    {recommendations.map((app) => (
 
                        <tr key={app.appId}>
 
                            <td>{app.appId}</td>
 
                            <td>{app.appName}</td>
 
                            <td>{app.description}</td>
 
                            <td>{app.version}</td>
 
                            <td>
                                {app.price === 0
                                    ? "Free"
                                    : `₹${app.price}`}
                            </td>
 
                        </tr>
 
                    ))}
 
                </tbody>
 
            </table>
 
        </div>
 
    </div>
);
}
 
export default Recommendation;
 