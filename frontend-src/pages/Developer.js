import { useEffect, useState } from "react";
import axios from "axios";
import "./User.css";
 
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  ArcElement,
  Title,
  Tooltip,
  Legend,
} from "chart.js";
 
import { Bar, Doughnut } from "react-chartjs-2";
 
ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  ArcElement,
  Title,
  Tooltip,
  Legend
);
 
function Developer() {
  const [developers, setDevelopers] = useState([]);
 
  const [developerData, setDeveloperData] = useState({
    developerId: "",
    developerName: "",
    email: "",
    companyName: "",
    website: "",
  });
 
  // Analytics Data
  const totalDownloads = 3;
  const publishedApps = 8;
  const avgRating = 4.5;
  const totalReviews = 4;
 
  const barData = {
    labels: [
      "WhatsApp",
      "Spotify",
      "Netflix",
      "Instagram",
      "Snapchat",

    ],
    datasets: [
      {
        label: "Downloads",
        data: [1, 2, 0, 0],
        backgroundColor: [
          "#4F46E5",
          "#EC4899",
          "#06B6D4",
          "#22C55E",
          "#F59E0B",
          "#EF4444",
          "#8B5CF6",
          "#14B8A6",
        ],
      },
    ],
  };
 
  const doughnutData = {
    labels: ["WhatsApp","Spotify","Netflix","Instagram","Snapchat"],
    datasets: [
      {
        data: [1, 2],
        backgroundColor: ["#60A5FA", "#22C55E"],
      },
    ],
  };
 
  useEffect(() => {
    fetchDevelopers();
  }, []);
 
  const fetchDevelopers = () => {
    axios
      .get("http://localhost:8081/api/developers")
      .then((response) => {
        setDevelopers(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  };
 
  const handleChange = (e) => {
    setDeveloperData({
      ...developerData,
      [e.target.name]: e.target.value,
    });
  };
 
  const handleSubmit = () => {
    if (developerData.developerId) {
      axios
        .put(
          `http://localhost:8081/api/developers/${developerData.developerId}`,
          developerData
        )
        .then(() => {
          alert("Developer Updated Successfully");
          resetForm();
          fetchDevelopers();
        });
    } else {
      axios
        .post("http://localhost:8081/api/developers", developerData)
        .then(() => {
          alert("Developer Added Successfully");
          resetForm();
          fetchDevelopers();
        });
    }
  };
 
  const handleEdit = (developer) => {
    setDeveloperData(developer);
  };
 
  const handleDelete = (id) => {
    if (window.confirm("Delete this developer?")) {
      axios
        .delete(`http://localhost:8081/api/developers/${id}`)
        .then(() => {
          alert("Developer Deleted Successfully");
          fetchDevelopers();
        });
    }
  };
 
  const resetForm = () => {
    setDeveloperData({
      developerId: "",
      developerName: "",
      email: "",
      companyName: "",
      website: "",
    });
  };
 
  return (
    <div className="page-container">
      <button
        className="back-btn"
        onClick={() => (window.location.href = "/dashboard")}
      >
        &larr; Back
      </button>
 
      <h1 className="page-title">👤 Developer Management</h1>
 
      {/* Analytics Cards */}
      <div className="analytics-container">
        <div className="analytics-card downloads">
          <h2>{totalDownloads}</h2>
          <p>Total Downloads</p>
        </div>
 
        <div className="analytics-card apps">
          <h2>{publishedApps}</h2>
          <p>Published Apps</p>
        </div>
 
        <div className="analytics-card rating">
          <h2>{avgRating}</h2>
          <p>Average Rating</p>
        </div>
 
        <div className="analytics-card reviews">
          <h2>{totalReviews}</h2>
          <p>Total Reviews</p>
        </div>
      </div>
 
      {/* Charts */}
      <div
        style={{
          display: "flex",
          gap: "30px",
          marginBottom: "30px",
          flexWrap: "wrap",
        }}
      >
        <div
          style={{
            flex: 1,
            minWidth: "400px",
            background: "#fff",
            padding: "20px",
            borderRadius: "15px",
          }}
        >
          <h3>Downloads per App</h3>
          <Bar data={barData} />
        </div>
 
        <div
          style={{
            flex: 1,
            minWidth: "400px",
            background: "#fff",
            padding: "20px",
            borderRadius: "15px",
          }}
        >
          <h3>Download Distribution</h3>
          <Doughnut data={doughnutData} />
        </div>
      </div>
 
      <div className="form-card">
        <h3>
          {developerData.developerId
            ? "Update Developer"
            : "Add Developer"}
        </h3>
 
        <div className="form-group">
          <input
            type="text"
            name="developerName"
            placeholder="Developer Name"
            value={developerData.developerName}
            onChange={handleChange}
          />
        </div>
 
        <div className="form-group">
          <input
            type="email"
            name="email"
            placeholder="Email"
            value={developerData.email}
            onChange={handleChange}
          />
        </div>
 
        <div className="form-group">
          <input
            type="text"
            name="companyName"
            placeholder="Company Name"
            value={developerData.companyName}
            onChange={handleChange}
          />
        </div>
 
        <div className="form-group">
          <input
            type="text"
            name="website"
            placeholder="Website"
            value={developerData.website}
            onChange={handleChange}
          />
        </div>
 
        <div className="button-group">
          <button className="primary-btn" onClick={handleSubmit}>
            {developerData.developerId
              ? "Update Developer"
              : "Add Developer"}
          </button>
 
          <button className="secondary-btn" onClick={resetForm}>
            Clear
          </button>
        </div>
      </div>
 
      <div className="table-card">
        <h3>Developers List</h3>
 
        <table className="user-table">
          <thead>
            <tr>
              <th>ID</th>
              <th>Developer Name</th>
              <th>Email</th>
              <th>Company Name</th>
              <th>Website</th>
              <th>Actions</th>
            </tr>
          </thead>
 
          <tbody>
            {developers.map((developer) => (
              <tr key={developer.developerId}>
                <td>{developer.developerId}</td>
                <td>{developer.developerName}</td>
                <td>{developer.email}</td>
                <td>{developer.companyName}</td>
                <td>{developer.website}</td>
 
                <td>
                  <button
                    className="edit-btn"
                    onClick={() => handleEdit(developer)}
                  >
                    Edit
                  </button>
 
                  <button
                    className="delete-btn"
                    onClick={() =>
                      handleDelete(developer.developerId)
                    }
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
 
export default Developer;
 