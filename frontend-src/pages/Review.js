import { useEffect, useState } from "react";
import axios from "axios";
import"./User.css";
 
function Review() {
 
    const [reviews, setReviews] = useState([]);
 
    const [reviewData, setReviewData] = useState({
        reviewId: "",
        comment: "",
        rating: "",
        reviewDate: "",
        userId: "",
        appId: ""
    });
 
    useEffect(() => {
        fetchReviews();
    }, []);
 
    const fetchReviews = () => {
        axios.get("http://localhost:8081/api/reviews")
            .then((response) => {
                console.log("REVIEWS DATA:",response.data);
                setReviews(response.data);
            })
            .catch((error) => {
                console.error(error);
            });
    };
 
    const handleChange = (e) => {
        setReviewData({
            ...reviewData,
            [e.target.name]: e.target.value
        });
    };
 
    const handleSubmit = () => {
 
        if (reviewData.reviewId) {
 
            axios.put(
                `http://localhost:8081/api/reviews/${reviewData.reviewId}`,
                reviewData
            )
            .then(() => {
                alert("Review Updated Successfully");
                resetForm();
                fetchReviews();
            });
 
        } else {
 
            axios.post(
                "http://localhost:8081/api/reviews",
                reviewData
            )
            .then(() => {
                alert("Review Added Successfully");
                resetForm();
                fetchReviews();
            });
        }
    };
 
    const handleEdit = (review) => {
        setReviewData(review);
    };
 
    const handleDelete = (id) => {
 
        if (window.confirm("Delete this review?")) {
 
            axios.delete(`http://localhost:8081/api/reviews/${id}`)
                .then(() => {
                    alert("Review Deleted Successfully");
                    fetchReviews();
                });
        }
    };
 
    const resetForm = () => {
        setReviewData({
            reviewId: "",
            comment: "",
            rating: "",
            reviewDate: "",
            userId: "",
            appId: ""
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
            Review Management
        </h1>
 
        <div className="form-card">
 
            <h3>
                {reviewData.reviewId
                    ? "Update Review"
                    : "Add Review"}
            </h3>
 
            <div className="form-group">
                <input
                    type="text"
                    name="comment"
                    placeholder="Comment"
                    value={reviewData.comment}
                    onChange={handleChange}
                />
            </div>
 
            <div className="form-group">
                <input
                    type="number"
                    name="rating"
                    placeholder="Rating (1-5)"
                    value={reviewData.rating}
                    onChange={handleChange}
                />
            </div>
 
            <div className="form-group">
                <input
                    type="date"
                    name="reviewDate"
                    value={reviewData.reviewDate}
                    onChange={handleChange}
                />
            </div>
 
            <div className="form-group">
                <input
                    type="number"
                    name="userId"
                    placeholder="User ID"
                    value={reviewData.userId}
                    onChange={handleChange}
                />
            </div>
 
            <div className="form-group">
                <input
                    type="number"
                    name="appId"
                    placeholder="App ID"
                    value={reviewData.appId}
                    onChange={handleChange}
                />
            </div>
 
            <div className="button-group">
 
                <button
                    className="primary-btn"
                    onClick={handleSubmit}
                >
                    {reviewData.reviewId
                        ? "Update Review"
                        : "Add Review"}
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
 
            <h3>Reviews List</h3>
 
            <table className="user-table">
 
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Comment</th>
                        <th>Rating</th>
                        <th>Review Date</th>
                        <th>User ID</th>
                        <th>App ID</th>
                        <th>Actions</th>
                    </tr>
                </thead>
 
                <tbody>
 
                    {reviews.map((review) => (
 
                        <tr key={review.reviewId}>
 
                            <td>{review.reviewId}</td>
                            <td>{review.comment}</td>
                            <td>{review.rating}</td>
                            <td>{review.reviewDate}</td>
                            <td>{review.userId}</td>
                            <td>{review.appId}</td>
 
                            <td>
 
                                <button
                                    className="edit-btn"
                                    onClick={() => handleEdit(review)}
                                >
                                    Edit
                                </button>
 
                                <button
                                    className="delete-btn"
                                    onClick={() => handleDelete(review.reviewId)}
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
 
export default Review;
 