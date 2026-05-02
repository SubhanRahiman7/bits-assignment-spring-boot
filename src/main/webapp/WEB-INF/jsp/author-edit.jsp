<html>
<head>
    <title>Edit Author</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<div class="container">
    <h1>Edit Author</h1>
    <form action="/authors/update/${author.id}" method="post">
        <label>Name</label>
        <input type="text" name="name" value="${author.name}" required>

        <label>Email</label>
        <input type="email" name="email" value="${author.email}" required>

        <label>Expertise</label>
        <input type="text" name="expertise" value="${author.expertise}" required>

        <button type="submit">Update Author</button>
    </form>
    <br>
    <a class="button" href="/">Back</a>
</div>
</body>
</html>
