import React, { useEffect, useState } from "react";
import axios from "axios";
import "./User.css";
 
function Transaction() {
    const [transactions, setTransactions] = useState([]);
 
    const [transactionData, setTransactionData] = useState({
        transactionId: "",
        transactionType: "",
        amount: "",
        transactionDate: "",
        status: ""
    });
 
    useEffect(() => {
        fetchTransactions();
    }, []);
 
    const fetchTransactions = () => {
        axios
            .get("http://localhost:8081/api/transactions")
            .then((response) => {
                setTransactions(response.data);
            })
            .catch((error) => {
                console.error("Error fetching transactions:", error);
            });
    };
 
    const handleChange = (e) => {
        setTransactionData({
            ...transactionData,
            [e.target.name]: e.target.value,
        });
    };
 
    const handleSubmit = (e) => {
        e.preventDefault();
 
        if (transactionData.transactionId) {
            axios
                .put(
                    `http://localhost:8081/api/transactions/${transactionData.transactionId}`,
                    transactionData
                )
                .then(() => {
                    alert("Transaction Updated Successfully");
                    fetchTransactions();
 
                    setTransactionData({
                        transactionId: "",
                        transactionType: "",
                        amount: "",
                        transactionDate: "",
                        status: "",
                    });
                })
                .catch((error) => {
                    console.error("Error updating transaction:", error);
                });
        } else {
            axios
                .post(
                    "http://localhost:8081/api/transactions",
                    transactionData
                )
                .then(() => {
                    alert("Transaction Added Successfully");
                    fetchTransactions();
 
                    setTransactionData({
                        transactionId: "",
                        transactionType: "",
                        amount: "",
                        transactionDate: "",
                        status: "",
                    });
                })
                .catch((error) => {
                    console.error("Error adding transaction:", error);
                });
        }
    };
 
    const handleEdit = (transaction) => {
        setTransactionData(transaction);
    };
 
    const handleDelete = (id) => {
        axios
            .delete(`http://localhost:8081/api/transactions/${id}`)
            .then(() => {
                alert("Transaction Deleted Successfully");
                fetchTransactions();
            })
            .catch((error) => {
                console.error("Error deleting transaction:", error);
            });
    };
 
    const resetForm = () => {
        setTransactionData({
            transactionId: "",
            transactionType: "",
            amount: "",
            transactionDate: "",
            status: "",
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
 
            <h1 className="page-title">
                Transaction Management
            </h1>
 
            <div className="form-card">
 
                <h3>
                    {transactionData.transactionId
                        ? "Update Transaction"
                        : "Add Transaction"}
                </h3>
 
                <div className="form-group">
                    <input
                        type="text"
                        name="transactionType"
                        placeholder="Transaction Type"
                        value={transactionData.transactionType}
                        onChange={handleChange}
                        required
                    />
                </div>
 
                <div className="form-group">
                    <input
                        type="number"
                        name="amount"
                        placeholder="Amount"
                        value={transactionData.amount}
                        onChange={handleChange}
                        required
                    />
                </div>
 
                <div className="form-group">
                    <input
                        type="date"
                        name="transactionDate"
                        value={transactionData.transactionDate}
                        onChange={handleChange}
                        required
                    />
                </div>
 
                <div className="form-group">
                    <input
                        type="text"
                        name="status"
                        placeholder="Status"
                        value={transactionData.status}
                        onChange={handleChange}
                        required
                    />
                </div>
 
                <div className="button-group">
 
                    <button
                        className="save-btn"
                        onClick={handleSubmit}
                    >
                        {transactionData.transactionId
                            ? "Update Transaction"
                            : "Add Transaction"}
                    </button>
 
                    <button
                        className="clear-btn"
                        onClick={resetForm}
                    >
                        Clear
                    </button>
 
                </div>
 
            </div>
 
            <div className="table-card">
 
                <h2>Transactions List</h2>
 
                <table className="user-table">
 
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Type</th>
                            <th>Amount</th>
                            <th>Date</th>
                            <th>Status</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
 
                    <tbody>
 
                        {transactions.map((transaction) => (
 
                            <tr key={transaction.transactionId}>
 
                                <td>{transaction.transactionId}</td>
                                <td>{transaction.transactionType}</td>
                                <td>{transaction.amount}</td>
                                <td>{transaction.transactionDate}</td>
                                <td>{transaction.status}</td>
 
                                <td>
 
                                    <button
                                        className="edit-btn"
                                        onClick={() =>
                                            handleEdit(transaction)
                                        }
                                    >
                                        Edit
                                    </button>
 
                                    <button
                                        className="delete-btn"
                                        onClick={() =>
                                            handleDelete(
                                                transaction.transactionId
                                            )
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
 
export default Transaction;
 