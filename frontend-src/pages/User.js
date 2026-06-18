import React, { useEffect, useState } from "react";
import axios from "axios";
import "./User.css"; 

function User() {
  const [users, setUsers] = useState([]);
 
  const [user, setUser] = useState({
    fullName: "",
    email: "",
    mobileNumber: "",
    password: "",
    role: ""
  });
 
  const [editingId, setEditingId] = useState(null);
 
  useEffect(() => {
    fetchUsers();
  }, []);
 
  const fetchUsers = () => {
    axios.get("http://localhost:8081/api/users")
      .then((response) => {
        setUsers(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  };
 
  const handleChange = (e) => {
    setUser({
      ...user,
      [e.target.name]: e.target.value
    });
  };
 
  const handleSubmit = () => {
    if (editingId) {
      axios.put(
        `http://localhost:8081/api/users/${editingId}`,
        user
      )
      .then(() => {
        fetchUsers();
        clearForm();
      })
      .catch((error) => {
        console.error(error);
      });
    } else {
      axios.post(
        "http://localhost:8081/api/users",
        user
      )
      .then(() => {
        fetchUsers();
        clearForm();
      })
      .catch((error) => {
        console.error(error);
      });
    }
  };
 
  const handleEdit = (u) => {
    setEditingId(u.userId);
 
    setUser({
      fullName: u.fullName,
      email: u.email,
      mobileNumber: u.mobileNumber,
      password: u.password,
      role: u.role
    });
  };
 
  const handleDelete = (id) => {
    axios.delete(`http://localhost:8081/api/users/${id}`)
      .then(() => {
        fetchUsers();
      })
      .catch((error) => {
        console.error(error);
      });
  };
 
  const clearForm = () => {
    setEditingId(null);
 
    setUser({
      fullName: "",
      email: "",
      mobileNumber: "",
      password: "",
      role: ""
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
 
        <h2 className="page-title">
            👤 User Management
        </h2>
 
        <div className="form-card">
 
            <h3>Add New User</h3>
 
            <div className="form-group">
                <input
                    type="text"
                    name="fullName"
                    placeholder="Full Name"
                    value={user.fullName}
                    onChange={handleChange}
                />
            </div>
 
            <div className="form-group">
                <input
                    type="email"
                    name="email"
                    placeholder="Email"
                    value={user.email}
                    onChange={handleChange}
                />
            </div>
 
            <div className="form-group">
                <input
                    type="text"
                    name="mobileNumber"
                    placeholder="Mobile Number"
                    value={user.mobileNumber}
                    onChange={handleChange}
                />
            </div>
 
            <div className="form-group">
                <input
                    type="password"
                    name="password"
                    placeholder="Password"
                    value={user.password}
                    onChange={handleChange}
                />
            </div>
 
            <div className="form-group">
                <input
                    type="text"
                    name="role"
                    placeholder="Role"
                    value={user.role}
                    onChange={handleChange}
                />
            </div>
 
            <button
                className="primary-btn"
                onClick={handleSubmit}
            >
                {editingId ? "Update User" : "Add User"}
            </button>
 
            <button
                className="secondary-btn"
                onClick={clearForm}
            >
                Clear
            </button>
 
        </div>
 
        <div className="table-card">
 
            <h2 className="page-title">
                Users List
            </h2>
 
            <table className="user-table">
 
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Full Name</th>
                        <th>Email</th>
                        <th>Mobile</th>
                        <th>Password</th>
                        <th>Role</th>
                        <th>Actions</th>
                    </tr>
                </thead>
 
                <tbody>
 
                    {users.map((u) => (
 
                        <tr key={u.userId}>
 
                            <td>{u.userId}</td>
                            <td>{u.fullName}</td>
                            <td>{u.email}</td>
                            <td>{u.mobileNumber}</td>
                            <td>........</td>
                            <td>{u.role}</td>
 
                            <td>
 
                                <button
                                    className="edit-btn"
                                    onClick={() => handleEdit(u)}
                                >
                                    Edit
                                </button>
 
                                <button
                                    className="delete-btn"
                                    onClick={() => handleDelete(u.userId)}
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
 
export default User;
