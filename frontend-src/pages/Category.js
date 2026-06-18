import { useEffect, useState } from "react";
import axios from "axios";
import "./Category.css";

function Category() {
 
    const [categories, setCategories] = useState([]);
 
    const [categoryData, setCategoryData] = useState({
        categoryId: "",
        categoryName: "",
        description: ""
    });
 
    useEffect(() => {
        fetchCategories();
    }, []);
 
    const fetchCategories = () => {
        axios.get("http://localhost:8081/api/categories")
            .then((response) => {
                setCategories(response.data);
            })
            .catch((error) => {
                console.error(error);
            });
    };
 
    const handleChange = (e) => {
        setCategoryData({
            ...categoryData,
            [e.target.name]: e.target.value
        });
    };
 
    const handleSubmit = () => {
 
        if (categoryData.categoryId) {
 
            axios.put(
                `http://localhost:8081/api/categories/${categoryData.categoryId}`,
                categoryData
            )
            .then(() => {
                alert("Category Updated Successfully");
                resetForm();
                fetchCategories();
            });
 
        } else {
 
            axios.post(
                "http://localhost:8081/api/categories",
                categoryData
            )
            .then(() => {
                alert("Category Added Successfully");
                resetForm();
                fetchCategories();
            });
 
        }
    };
 
    const handleEdit = (category) => {
        setCategoryData(category);
    };
 
    const handleDelete = (id) => {
 
        if (window.confirm("Delete this category?")) {
 
            axios.delete(`http://localhost:8081/api/categories/${id}`)
                .then(() => {
                    alert("Category Deleted Successfully");
                    fetchCategories();
                });
        }
    };
 
    const resetForm = () => {
        setCategoryData({
            categoryId: "",
            categoryName: "",
            description: ""
        });
    };
 
    return (
    <div className="category-container">
 
        <button
            className="back-btn"
            onClick={() => window.location.href="/dashboard"}
        >
            ← Back
        </button>
 
        <h2 className="page-title">
            📁 Category Management
        </h2>
 
        <div className="form-card">
 
            <h3>
                {categoryData.categoryId
                    ? "Update Category"
                    : "Add New Category"}
            </h3>
 
            <input
                type="text"
                name="categoryName"
                placeholder="Category Name"
                value={categoryData.categoryName}
                onChange={handleChange}
            />
 
            <input
                type="text"
                name="description"
                placeholder="Description"
                value={categoryData.description}
                onChange={handleChange}
            />
 
            <div className="btn-group">
 
                <button
                    className="add-btn"
                    onClick={handleSubmit}
                >
                    {categoryData.categoryId
                        ? "Update Category"
                        : "Add Category"}
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
 
            <h2>Categories List</h2>
 
            <table className="category-table">
 
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Category Name</th>
                        <th>Description</th>
                        <th>Actions</th>
                    </tr>
                </thead>
 
                <tbody>
 
                    {categories.map((category) => (
 
                        <tr key={category.categoryId}>
 
                            <td>{category.categoryId}</td>
 
                            <td>{category.categoryName}</td>
 
                            <td>{category.description}</td>
 
                            <td>
 
                                <button
                                    className="edit-btn"
                                    onClick={() => handleEdit(category)}
                                >
                                    Edit
                                </button>
 
                                <button
                                    className="delete-btn"
                                    onClick={() => handleDelete(category.categoryId)}
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
 
export default Category;
 