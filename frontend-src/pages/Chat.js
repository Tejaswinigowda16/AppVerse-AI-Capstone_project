import React, { useState } from "react";
import axios from "axios";
import "./User.css";
 
function Chat() {
    const [question, setQuestion] = useState("");
    const [response, setResponse] = useState("");
 
    const askQuestion = () => {
        if (question.trim() === "") {
            alert("Please enter a question");
            return;
        }
 
        axios
            .post(
                "http://localhost:8081/api/chat",
                question,
                {
                    headers: {
                        "Content-Type": "text/plain",
                    },
                }
            )
            .then((res) => {
                setResponse(res.data);
            })
            .catch((err) => {
                console.error(err);
                setResponse("Unable to get response from AI.");
            });
    };
 
    return (
        <div className="page-container">
 
            <button
                className="back-btn"
                onClick={() => (window.location.href = "/dashboard")}
            >
                ← Back
            </button>
 
            <div className="chat-card">
 
                <h1 className="chat-title">
                    🤖 AI Assistant
                </h1>
 
                <p className="chat-subtitle">
                    Ask anything about AppVerse
                </p>
 
                <div className="chat-input-container">
 
                    <input
                        type="text"
                        placeholder="Ask something..."
                        value={question}
                        onChange={(e) => setQuestion(e.target.value)}
                        className="chat-input"
                    />
 
                    <button
                        className="chat-btn"
                        onClick={askQuestion}
                    >
                        Ask
                    </button>
 
                </div>
 
                <div className="response-box">
 
                    <h3>Response</h3>
 
                    <p>
                        {response || "Your AI response will appear here."}
                    </p>
 
                </div>
 
            </div>
 
        </div>
    );
}
 
export default Chat;