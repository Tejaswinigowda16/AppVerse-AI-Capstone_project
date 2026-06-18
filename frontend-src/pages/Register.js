import { useState } from "react";
import axios from "axios"; 
import"./Register.css";
function Register() {
 
    const [user, setUser] = useState({
        fullName: "",
        email: "",
        mobileNumber: "",
        password: "",
        role:"USER"
    });
 
    const handleChange = (e) => {
        setUser({
            ...user,
            [e.target.name]: e.target.value
        });
    };
 
    const handleSubmit = async (e) => {
    e.preventDefault();

    if (!user.email.includes("@")) {
    alert("Enter valid email");
    return;
}
 
if (user.password.length < 6) {
    alert("Password must be at least 6 characters");
    return;
}
 
    try {
        const response = await axios.post("http://localhost:8081/api/users",user)
        ;
 
        alert("Registration Successful!");
 
        console.log(response.data);
 
    } catch (error) {
    console.error(error);
 
    if (error.response) {
        alert(error.response.data);
        console.log(error.response.data);
    } else {
        alert(error.message);
    }
}
};
 
    return (
    <div className="register-page">
        <div className="register-card">
 
            <h1>🚀 AppVerse</h1>
            <p>Create your account</p>
 
            <form onSubmit={handleSubmit}>
 
                <input
                    type="text"
                    name="fullName"
                    placeholder="Full Name"
                    value={user.fullName}
                    onChange={handleChange}
                    required
                />
 
                <input
                    type="email"
                    name="email"
                    placeholder="Email"
                    value={user.email}
                    onChange={handleChange}
                    required
                />
 
                <input
                    type="text"
                    name="mobileNumber"
                    placeholder="Mobile Number"
                    value={user.mobileNumber}
                    onChange={handleChange}
                    required
                />
 
                <input
                    type="password"
                    name="password"
                    placeholder="Password"
                    value={user.password}
                    onChange={handleChange}
                    required
                />
 
                <select
                    name="role"
                    value={user.role}
                    onChange={handleChange}
                >
                    <option value="USER">USER</option>
                    <option value="ADMIN">ADMIN</option>
                </select>
 
                <button type="submit">
                    Register
                </button>
 
            </form>
 
            <a href="/login" className="back-btn">
                ← Back to Login
            </a>
 
        </div>
    </div>
);
 
 
}
 
export default Register;
 