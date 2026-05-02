<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Edit Book</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<div class="container">
    <h1>Edit Book</h1>
    <form action="/books/update/${book.id}" method="post">
        <label>Title</label>
        <input type="text" name="title" value="${book.title}" required>

        <label>ISBN</label>
        <input type="text" name="isbn" value="${book.isbn}" required>

        <label>Price</label>
        <input type="number" step="0.01" name="price" value="${book.price}" required>

        <label>Author</label>
        <select name="authorId" required>
            <c:forEach var="author" items="${authors}">
                <option value="${author.id}" <c:if test="${author.id == book.author.id}">selected</c:if>>
                        ${author.name} (${author.email})
                </option>
            </c:forEach>
        </select>

        <button type="submit">Update Book</button>
    </form>
    <br>
    <a class="button" href="/">Back</a>
</div>
</body>
</html>
