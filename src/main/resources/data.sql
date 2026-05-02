INSERT INTO authors (id, email, name, expertise) VALUES (1, 'author1@example.com', 'Aarav Mehta', 'Fiction');
INSERT INTO authors (id, email, name, expertise) VALUES (2, 'author2@example.com', 'Isha Kapoor', 'Science');
INSERT INTO authors (id, email, name, expertise) VALUES (3, 'author3@example.com', 'Vihaan Reddy', 'Technology');
INSERT INTO authors (id, email, name, expertise) VALUES (4, 'author4@example.com', 'Anaya Sharma', 'History');
INSERT INTO authors (id, email, name, expertise) VALUES (5, 'author5@example.com', 'Kabir Nair', 'Business');
INSERT INTO authors (id, email, name, expertise) VALUES (6, 'author6@example.com', 'Diya Rao', 'Psychology');
INSERT INTO authors (id, email, name, expertise) VALUES (7, 'author7@example.com', 'Arjun Iyer', 'Design');
INSERT INTO authors (id, email, name, expertise) VALUES (8, 'author8@example.com', 'Myra Sen', 'Philosophy');
INSERT INTO authors (id, email, name, expertise) VALUES (9, 'author9@example.com', 'Reyansh Das', 'Education');
INSERT INTO authors (id, email, name, expertise) VALUES (10, 'author10@example.com', 'Sara Joseph', 'Finance');

INSERT INTO books (id, title, isbn, price, author_id) VALUES (1, 'Modern Fiction Stories', 'ISBN-1001', 399.0, 1);
INSERT INTO books (id, title, isbn, price, author_id) VALUES (2, 'Physics for Beginners', 'ISBN-1002', 499.0, 2);
INSERT INTO books (id, title, isbn, price, author_id) VALUES (3, 'Java Patterns Explained', 'ISBN-1003', 599.0, 3);
INSERT INTO books (id, title, isbn, price, author_id) VALUES (4, 'Indian History Essentials', 'ISBN-1004', 450.0, 4);
INSERT INTO books (id, title, isbn, price, author_id) VALUES (5, 'Startup Strategy 101', 'ISBN-1005', 525.0, 5);
INSERT INTO books (id, title, isbn, price, author_id) VALUES (6, 'Mind and Motivation', 'ISBN-1006', 380.0, 6);
INSERT INTO books (id, title, isbn, price, author_id) VALUES (7, 'UI Design Principles', 'ISBN-1007', 610.0, 7);
INSERT INTO books (id, title, isbn, price, author_id) VALUES (8, 'Thinking Clearly', 'ISBN-1008', 340.0, 8);
INSERT INTO books (id, title, isbn, price, author_id) VALUES (9, 'Teaching with Impact', 'ISBN-1009', 470.0, 9);
INSERT INTO books (id, title, isbn, price, author_id) VALUES (10, 'Practical Finance Basics', 'ISBN-1010', 560.0, 10);

ALTER TABLE authors ALTER COLUMN id RESTART WITH 11;
ALTER TABLE books ALTER COLUMN id RESTART WITH 11;
