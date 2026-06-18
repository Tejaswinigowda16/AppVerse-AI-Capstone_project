import { useState } from "react";
import axios from "axios";
import "./Login.css";
 
function Login() {
 
  const [loginData, setLoginData] = useState({
    email: "",
    password: ""
  });
 
  const handleChange = (e) => {
    setLoginData({
      ...loginData,
      [e.target.name]: e.target.value
    });
  };
 
  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!loginData.email.includes("@")) {
    alert("Enter valid email");
    return;
}
 
if (loginData.password.trim() === "") {
    alert("Password cannot be empty");
    return;
}
 
    try {
      const response = await axios.post(
        "http://localhost:8081/api/users/login",
        loginData
      );
 
      const token = response.data;
 
      console.log("Response:", token);
 
      if (token && token !== "Invalid Email or Password") {
 
        localStorage.setItem("token", token);
        localStorage.setItem("userEmail", loginData.email);
 
        alert("Login Successful");
 
        window.location.href = "/dashboard";
 
      } else {
 
        alert("Invalid Email or Password");
 
      }
 
    } catch (error) {
      console.error(error);
 
      if (error.response) {
        alert(error.response.data);
      } else {
        alert("Login Failed!");
      }
    }
  };
 
  return (
    <div className="login-page">
      <div className="glass-card">
 
        <h1>🚀 AppVerse</h1>
        <p>Explore the world of apps</p>
 
        <form onSubmit={handleSubmit}>
 
          <input
            type="email"
            name="email"
            placeholder="Email"
            value={loginData.email}
            onChange={handleChange}
            required
          />
 
          <input
            type="password"
            name="password"
            placeholder="Password"
            value={loginData.password}
            onChange={handleChange}
            required
          />
 
          <button type="submit">
            Login
          </button>
 
        </form>
 
        <div className="register-text">
          Don't have account? <a href="/register">Register</a>
        </div>
 
      </div>
    </div>
  );
}
 
export default Login;
 