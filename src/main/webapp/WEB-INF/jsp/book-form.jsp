<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Add Book</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<div class="container">
    <h1>Add Book</h1>
    <form action="/books" method="post">
        <label>Title</label>
        <input type="text" name="title" required>

        <label>ISBN</label>
        <input type="text" name="isbn" required>

        <label>Price</label>
        <input type="number" step="0.01" name="price" required>

        <label>Author</label>
        <select name="authorId" required>
            <c:forEach var="author" items="${authors}">
                <option value="${author.id}">${author.name} (${author.email})</option>
            </c:forEach>
        </select>

        <button type="submit">Save Book</button>
    </form>
    <br>
    <a class="button" href="/">Back</a>
</div>
</body>
</html>
