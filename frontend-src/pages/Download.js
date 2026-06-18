import { useEffect, useState } from "react";
import axios from "axios";
import"./User.css";
 
function Download() {
 
    const [downloads, setDownloads] = useState([]);
 
    const [downloadData, setDownloadData] = useState({
        downloadId: "",
        userId: "",
        appId: "",
        downloadDate: ""
    });
 
    useEffect(() => {
        fetchDownloads();
    }, []);
 
    const fetchDownloads = () => {
        axios.get("http://localhost:8081/api/downloads")
            .then((response) => {
                setDownloads(response.data);
            })
            .catch((error) => {
                console.error(error);
            });
    };
 
    const handleChange = (e) => {
        setDownloadData({
            ...downloadData,
            [e.target.name]: e.target.value
        });
    };
 
    const handleSubmit = () => {
 
        if (downloadData.downloadId) {
 
            axios.put(
                `http://localhost:8081/api/downloads/${downloadData.downloadId}`,
                downloadData
            )
            .then(() => {
                alert("Download Updated Successfully");
                resetForm();
                fetchDownloads();
            });
 
        } else {
 
            axios.post(
                "http://localhost:8081/api/downloads",
                downloadData
            )
            .then(() => {
                alert("Download Added Successfully");
                resetForm();
                fetchDownloads();
            });
        }
        };
 
    const handleEdit = (download) => {
        setDownloadData(download);
    };
 
    const handleDelete = (id) => {
 
        if (window.confirm("Delete this download?")) {
 
            axios.delete(`http://localhost:8081/api/downloads/${id}`)
                .then(() => {
                    alert("Download Deleted Successfully");
                    fetchDownloads();
                });
        }
    };
 
    const resetForm = () => {
        setDownloadData({
            downloadId: "",
            userId: "",
            appId: "",
            downloadDate: ""
        });
    };
 
    return (
    <div className="page-container">
 
        <button
            className="back-btn"
            onClick={() => window.location.href="/dashboard"}
        >
            ← Back
        </button>
 
        <h1 className="page-title">
            Download Management
        </h1>
 
        <div className="form-card">
 
            <h3>
                {downloadData.downloadId
                    ? "Update Download"
                    : "Add Download"}
            </h3>
 
            <div className="form-group">
                <input
                    type="number"
                    name="userId"
                    placeholder="User ID"
                    value={downloadData.userId}
                    onChange={handleChange}
                />
            </div>
 
            <div className="form-group">
                <input
                    type="number"
                    name="appId"
                    placeholder="App ID"
                    value={downloadData.appId}
                    onChange={handleChange}
                />
            </div>
 
            <div className="form-group">
                <input
                    type="date"
                    name="downloadDate"
                    value={downloadData.downloadDate}
                    onChange={handleChange}
                />
            </div>
 
            <div className="button-group">
                <button
                    className="primary-btn"
                    onClick={handleSubmit}
                >
                    {downloadData.downloadId
                        ? "Update Download"
                        : "Add Download"}
                </button>
 
                <button
                    className="secondary-btn"
                    onClick={resetForm}
                >
                    Clear
                </button>
            </div>
 
        </div>
 
        <div className="table-card">
 
            <h3>Downloads List</h3>
 
            <table className="user-table">
 
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>User ID</th>
                        <th>App ID</th>
                        <th>Download Date</th>
                        <th>Actions</th>
                    </tr>
                </thead>
 
                <tbody>
 
                    {downloads.map((download) => (
 
                        <tr key={download.downloadId}>
 
                            <td>{download.downloadId}</td>
 
                            <td>{download.userId}</td>
 
                            <td>{download.appId}</td>
 
                            <td>{download.downloadDate}</td>
 
                            <td>
 
                                <button
                                    className="edit-btn"
                                    onClick={() => handleEdit(download)}
                                >
                                    Edit
                                </button>
 
                                <button
                                    className="delete-btn"
                                    onClick={() => handleDelete(download.downloadId)}
                                >
                                    Delete
                                </button>
 
                            </td>
 
                        </tr>
 
                    ))}
 
                </tbody>
 
            </table>
 
        </div>
 
    </div>
);
 
}
 
export default Download;
 