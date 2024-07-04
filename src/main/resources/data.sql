-- Create items table
CREATE TABLE IF NOT EXISTS items (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

-- Insert sample data
INSERT INTO items (name, quantity, price) VALUES ('Item 1', 100, 19.99);
INSERT INTO items (name, quantity, price) VALUES ('Item 2', 200, 29.99);
INSERT INTO items (name, quantity, price) VALUES ('Item 3', 150, 9.99);
