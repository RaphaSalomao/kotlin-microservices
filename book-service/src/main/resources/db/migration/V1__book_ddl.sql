CREATE TABLE book (
  id UUID PRIMARY KEY default uuid_generate_v4(),
  author VARCHAR(255) NOT NULL,
  launch_date TIMESTAMP NOT NULL,
  price NUMERIC(65,2) NOT NULL,
  title VARCHAR(255) NOT NULL
);