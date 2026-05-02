<html>
<head>
    <title>Add Author</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<div class="container">
    <h1>Add Author</h1>
    <form action="/authors" method="post">
        <label>Name</label>
        <input type="text" name="name" required>

        <label>Email</label>
        <input type="email" name="email" required>

        <label>Expertise</label>
        <input type="text" name="expertise" required>

        <button type="submit">Save Author</button>
    </form>
    <br>
    <a class="button" href="/">Back</a>
</div>
</body>
</html>
