import { Link } from "react-router-dom";
import "./Navbar.css";
 
function Navbar() {
 
    const loggedIn = localStorage.getItem("userEmail");
 
    return (
        <nav className="navbar">
 
            <Link to="/dashboard" className="logo">
    🚀 AppVerse
</Link>
 
            {loggedIn ? (
                <>
 
                    <button
                        className="logout-btn"
                        onClick={() => {
                            localStorage.removeItem("userEmail");
localStorage.removeItem("token");
 
window.location.href = "/login";
                        }}
                    >
                        Logout
                    </button>
                </>
            ) : (
                <>
                    <Link to="/login">Login</Link>
                    <Link to="/register">Register</Link>
                </>
            )}
 
        </nav>
    );
}
 
export default Navbar;
 