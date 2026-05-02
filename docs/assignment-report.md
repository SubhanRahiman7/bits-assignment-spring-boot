# Spring Boot Assignment Report

## 1) Entity Relationship Design

This project manages two entities:

- `Author`: `id`, `name`, `email`, `expertise`
- `Book`: `id`, `title`, `isbn`, `price`, `author`

Relationship:

- One `Author` can have many `Book` entries (`@OneToMany`)
- Each `Book` belongs to exactly one `Author` (`@ManyToOne`)

## 2) Implementation Details

### Populate Database

- Tables are generated using JPA entity annotations.
- `data.sql` inserts 10 rows into `authors` and 10 rows into `books`.

### Create Operation

- JSP forms:
  - `author-form.jsp`
  - `book-form.jsp`
- Controller endpoints:
  - `POST /authors`
  - `POST /books`
- Integrity handling:
  - Unique constraint violations for `email` and `isbn` are caught and shown as messages.

### Read Operation

- Main dashboard JSP:
  - `index.jsp`
- Controller endpoint:
  - `GET /`
- Inner join query:
  - `BookRepository#findBooksWithAuthorDetails()` uses JPQL `inner join`.

### Update Operation

- JSP forms:
  - `author-edit.jsp`
  - `book-edit.jsp`
- Controller endpoints:
  - `POST /authors/update/{id}`
  - `POST /books/update/{id}`

## 3) Testing

- Repository test:
  - `BookRepositoryTest` verifies the inner join custom query.
- Service tests:
  - `AuthorServiceTest`
  - `BookServiceTest`

## 4) Challenges Faced and Solutions

- **JSP + Spring Boot setup:** Added Jasper and JSTL dependencies to render JSP correctly.
- **Data initialization order:** Enabled `spring.jpa.defer-datasource-initialization=true` so `data.sql` runs after schema creation.
- **Integrity violation handling:** Added `DataIntegrityViolationException` handling in controller methods for user-friendly messages.

## 5) Screenshots and GitHub URL

Add screenshots for:

1. Dashboard with lists and join result
2. Add author form
3. Add book form
4. Edit author/book form
5. Test run output

GitHub URL:

- `<PASTE_YOUR_GITHUB_REPO_LINK_HERE>`
