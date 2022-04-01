CREATE TABLE exchange (
  id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
  from_currency VARCHAR(3) NOT NULL,
  to_currency VARCHAR(3) NOT NULL,
  conversion_factor NUMERIC(10,6) NOT NULL
);
