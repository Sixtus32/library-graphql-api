


-- Insert sample authors
INSERT INTO authors (name, email, birth_date, nationality, biography) VALUES
('Gabriel García Márquez', 'gabo@example.com', '1927-03-06 00:00:00', 'Colombian', 'Nobel Prize winner in Literature, known for magical realism'),
('J.K. Rowling', 'jk@example.com', '1965-07-31 00:00:00', 'British', 'Author of the Harry Potter series'),
('George Orwell', 'orwell@example.com', '1903-06-25 00:00:00', 'British', 'Author of 1984 and Animal Farm'),
('Jane Austen', 'jane@example.com', '1775-12-16 00:00:00', 'British', 'English novelist known for her wit and social commentary'),
('Stephen King', 'stephen@example.com', '1947-09-21 00:00:00', 'American', 'Master of horror and supernatural fiction');

-- Insert sample books
INSERT INTO books (title, isbn, genre, published_date, pages, description, available, author_id) VALUES
('One Hundred Years of Solitude', '978-0060883287', 'FICTION', '1967-06-05 00:00:00', 417, 'The story of the Buendía family over seven generations', true, 1),
('Love in the Time of Cholera', '978-0307389732', 'ROMANCE', '1985-12-01 00:00:00', 348, 'A love story spanning fifty years', true, 1),
('Harry Potter and the Philosopher''s Stone', '978-0747532699', 'FANTASY', '1997-06-26 00:00:00', 223, 'The first book in the Harry Potter series', true, 2),
('Harry Potter and the Chamber of Secrets', '978-0747538493', 'FANTASY', '1998-07-02 00:00:00', 251, 'The second book in the Harry Potter series', false, 2),
('1984', '978-0451524935', 'SCI_FI', '1949-06-08 00:00:00', 328, 'A dystopian social science fiction novel', true, 3),
('Animal Farm', '978-0451526342', 'FICTION', '1945-08-17 00:00:00', 112, 'An allegorical novella about farm animals', true, 3),
('Pride and Prejudice', '978-0141439518', 'ROMANCE', '1813-01-28 00:00:00', 432, 'A romantic novel about manners and marriage', true, 4),
('Emma', '978-0141439587', 'ROMANCE', '1815-12-23 00:00:00', 474, 'The story of Emma Woodhouse and her matchmaking', false, 4),
('The Shining', '978-0307743657', 'MYSTERY', '1977-01-28 00:00:00', 447, 'A horror novel about the haunted Overlook Hotel', true, 5),
('It', '978-1501142970', 'MYSTERY', '1986-09-15 00:00:00', 1138, 'A horror novel about a shape-shifting entity', true, 5);
