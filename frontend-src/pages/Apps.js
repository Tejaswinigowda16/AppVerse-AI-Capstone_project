import { useEffect, useState } from "react";
import axios from "axios";
import "./Apps.css";
 
function Apps() {
 
    const [apps, setApps] = useState([]);
 
    const [appData, setAppData] = useState({
        appId: "",
        appName: "",
        description: "",
        version: "",
        price: ""
    });
 
    useEffect(() => {
        fetchApps();
    }, []);
 
    const fetchApps = () => {
        axios.get("http://localhost:8081/api/apps")
            .then((response) => {
                setApps(response.data);
            })
            .catch((error) => {
                console.error(error);
            });
    };
 
    const handleChange = (e) => {
        setAppData({
            ...appData,
            [e.target.name]: e.target.value
        });
    };
 
    const handleSubmit = () => {
 
        if (appData.appId) {
 
            axios.put(
                `http://localhost:8081/api/apps/${appData.appId}`,
                appData
            )
            .then(() => {
                alert("App Updated Successfully");
                resetForm();
                fetchApps();
            })
            .catch((error) => {
                console.error(error);
            });
 
        } else {
 
            axios.post(
                "http://localhost:8081/api/apps",
                appData
            )
            .then(() => {
                alert("App Added Successfully");
                resetForm();
                fetchApps();
            })
            .catch((error) => {
                console.error(error);
            });
        }
    };
 
    const handleEdit = (app) => {
        setAppData(app);
    };
 
    const handleDelete = (id) => {
 
        if (window.confirm("Delete this app?")) {
 
            axios.delete(`http://localhost:8081/api/apps/${id}`)
                .then(() => {
                    alert("App Deleted Successfully");
                    fetchApps();
                })
                .catch((error) => {
                    console.error(error);
                });
        }
    };
 
    const resetForm = () => {
        setAppData({
            appId: "",
            appName: "",
            description: "",
            version: "",
            price: ""
        });
    };
 
    return (
    <div className="apps-container">

        <button
  className="back-btn"
  onClick={() => window.location.href="/dashboard"}
>
  ← Back
</button>
 
        <h1 className="page-title">
            📱 Apps Management
        </h1>
 
        <div className="app-form">
 
            <h2>
                {appData.appId ? "Update App" : "Add New App"}
            </h2>
 
            <input
                type="text"
                name="appName"
                placeholder="App Name"
                value={appData.appName}
                onChange={handleChange}
            />
 
            <input
                type="text"
                name="description"
                placeholder="Description"
                value={appData.description}
                onChange={handleChange}
            />
 
            <input
                type="text"
                name="version"
                placeholder="Version"
                value={appData.version}
                onChange={handleChange}
            />
 
            <input
                type="number"
                name="price"
                placeholder="Price"
                value={appData.price}
                onChange={handleChange}
            />
 
            <div className="button-group">
 
                <button
                    className="save-btn"
                    onClick={handleSubmit}
                >
                    {appData.appId ? "Update" : "Add App"}
                </button>
 
                <button
                    className="clear-btn"
                    onClick={resetForm}
                >
                    Clear
                </button>
 
            </div>
 
        </div>
 
        <h2 className="list-title">
            Available Apps
        </h2>
 
        <div className="apps-grid">
 
            {apps.map((app) => (
 
                <div className="app-card" key={app.appId}>
 
                    <div className="app-icon">
                        📱
                    </div>
 
                    <h3>{app.appName}</h3>
 
                    <p>{app.description}</p>
 
                    <p>
                        Version: {app.version}
                    </p>
 
                    <p>
                        Price:
                        {" "}
                        {app.price === 0
                            ? "Free"
                            : `₹${app.price}`}
                    </p>
 
                    <div className="card-buttons">
 
                        <button
                            className="edit-btn"
                            onClick={() => handleEdit(app)}
                        >
                            Edit
                        </button>
 
                        <button
                            className="delete-btn"
                            onClick={() => handleDelete(app.appId)}
                        >
                            Delete
                        </button>
 
                    </div>
 
                </div>
 
            ))}
 
        </div>

    </div>
);
}
 
export default Apps;
 