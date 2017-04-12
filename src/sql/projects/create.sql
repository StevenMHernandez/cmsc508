CREATE TABLE students (
  id int NOT NULL AUTO_INCREMENT,
  email varchar(64) NOT NULL,
	name VARCHAR(64) NOT NULL,
	oauth_user_id VARCHAR(255) NOT NULL,
	short_description text,
	github_url varchar(255),
	linkedin_url varchar(255),
	website_url varchar(255),
	created_at timestamp default current_timestamp,
	updated_at timestamp default current_timestamp,

  PRIMARY KEY (ID),
  UNIQUE (ID),
  UNIQUE (email)
);