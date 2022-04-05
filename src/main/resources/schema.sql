CREATE TABLE dictionaries(
  id BIGSERIAL PRIMARY KEY,
  entries VARCHAR(MAX),
  is_case_sensitive BOOLEAN NOT NULL
 
);

CREATE TABLE users(
  user_id BIGSERIAL PRIMARY KEY,
  username VARCHAR(16) NOT NULL UNIQUE,
  password VARCHAR(150) NOT NULL ,
  role VARCHAR(16) NOT NULL,
account_non_expired BOOLEAN NOT NULL,
account_non_locked BOOLEAN NOT NULL,
credentials_non_expired BOOLEAN NOT NULL,
enabled BOOLEAN NOT NULL
);

