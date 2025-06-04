CREATE TABLE authors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    birth_date TIMESTAMP,
    nationality VARCHAR(50),
    biography VARCHAR(1000),
    book_count INT
);

CREATE TABLE books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    isbn VARCHAR(20) NOT NULL UNIQUE,
    genre ENUM('FICTION', 'NON_FICTION', 'SCI_FI', 'FANTASY', 'ROMANCE', 'MYSTERY') NOT NULL,
    published_date TIMESTAMP,
    pages INT CHECK (pages > 0),
    description TEXT,
    available BOOLEAN DEFAULT TRUE,
    author_id BIGINT,
    FOREIGN KEY (author_id) REFERENCES authors(id)
);
