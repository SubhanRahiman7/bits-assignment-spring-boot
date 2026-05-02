<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Books and Authors Dashboard</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<div class="container">
    <h1>Books and Authors Management</h1>

    <c:if test="${not empty success}">
        <div class="alert success">${success}</div>
    </c:if>
    <c:if test="${not empty error}">
        <div class="alert error">${error}</div>
    </c:if>

    <div class="actions">
        <a class="button" href="/authors/new">Add Author</a>
        <a class="button" href="/books/new">Add Book</a>
    </div>

    <h2>Authors List</h2>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Expertise</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="author" items="${authors}">
            <tr>
                <td>${author.id}</td>
                <td>${author.name}</td>
                <td>${author.email}</td>
                <td>${author.expertise}</td>
                <td><a class="button" href="/authors/edit/${author.id}">Edit</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h2>Books List</h2>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>ISBN</th>
            <th>Price</th>
            <th>Author ID</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.isbn}</td>
                <td>${book.price}</td>
                <td>${book.author.id}</td>
                <td><a class="button" href="/books/edit/${book.id}">Edit</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h2>Inner Join Result (Books + Authors)</h2>
    <table>
        <thead>
        <tr>
            <th>Book Title</th>
            <th>ISBN</th>
            <th>Price</th>
            <th>Author Name</th>
            <th>Author Email</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="row" items="${joinedBooks}">
            <tr>
                <td>${row.title}</td>
                <td>${row.isbn}</td>
                <td>${row.price}</td>
                <td>${row.authorName}</td>
                <td>${row.authorEmail}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
