<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ShopIt - Home</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }

        /* Header */
        header {
            background-color: #333;
            color: white;
            padding: 20px;
            text-align: center;
        }

        header h1 {
            margin: 0;
            font-size: 36px;
        }

        nav {
            background-color: #444;
            padding: 10px;
            text-align: center;
        }

        nav a {
            color: white;
            text-decoration: none;
            margin: 0 15px;
            font-weight: bold;
        }

        nav a:hover {
            text-decoration: underline;
        }

        /* Hero Section */
        .hero {
            background: url('https://via.placeholder.com/1200x400') no-repeat center center/cover;
            color: white;
            padding: 80px 20px;
            text-align: center;
        }

        .hero h2 {
            font-size: 48px;
            margin-bottom: 10px;
        }

        .hero p {
            font-size: 20px;
        }

        /* Products Section */
        .products {
            padding: 40px 20px;
            text-align: center;
        }

        .products h3 {
            font-size: 28px;
            margin-bottom: 30px;
        }

        .product-grid {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
        }

        .product {
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 0 10px #ccc;
            width: 220px;
            padding: 20px;
        }

        .product img {
            width: 100%;
            height: 150px;
            object-fit: cover;
        }

        .product h4 {
            margin: 10px 0 5px;
        }

        .product p {
            font-size: 14px;
            color: #555;
        }

        .product .price {
            color: green;
            font-weight: bold;
            margin-top: 5px;
        }

        /* Footer */
        footer {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 15px;
            margin-top: 40px;
        }
    </style>
</head>
<body>

    <header>
        <h1>ShopIt</h1>
    </header>

    <nav>
        <a href="home.jsp">Home</a>
        <a href="products.jsp">Products</a>
        <!-- <a href="login.jsp">Login</a>
        <a href="register.jsp">Register</a> -->
        <a href="cart.jsp">Cart</a>
    </nav>

    <div class="hero">
        <h2>Welcome to ShopIt</h2>
        <p>Your one-stop shop for everything you love</p>
    </div>

    <section class="products">
        <h3>Featured Products</h3>
        <div class="product-grid">
            <div class="product">
                <img src="https://via.placeholder.com/200x150" alt="Product 1">
                <h4>Product 1</h4>
                <p>Awesome gadget you'll love</p>
                <div class="price">$29.99</div>
            </div>
            <div class="product">
                <img src="https://via.placeholder.com/200x150" alt="Product 2">
                <h4>Product 2</h4>
                <p>Top quality and best value</p>
                <div class="price">$49.99</div>
            </div>
            <div class="product">
                <img src="https://via.placeholder.com/200x150" alt="Product 3">
                <h4>Product 3</h4>
                <p>Limited time offer</p>
                <div class="price">$19.99</div>
            </div>
        </div>
    </section>

    <footer>
        &copy; 2025 ShopIt. All rights reserved.
    </footer>

</body>
</html>
