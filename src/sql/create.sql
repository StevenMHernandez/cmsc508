CREATE TABLE students (
  id INT(10) NOT NULL AUTO_INCREMENT,
  email VARCHAR(64) NOT NULL,
	name VARCHAR(64) NOT NULL,
	oauth_user_id VARCHAR(255) NOT NULL UNIQUE,
	short_description text,
	github_url VARCHAR(255),
	linkedin_url VARCHAR(255),
	website_url VARCHAR(255),
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

  PRIMARY KEY (ID),
  UNIQUE (ID),
  UNIQUE (email)
);

CREATE TABLE projects (
  id INT(10) NOT NULL AUTO_INCREMENT,
  studentId INT(10) NOT NULL,
	name VARCHAR(64) NOT NULL,
	description TEXT NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

  PRIMARY KEY (ID),
  UNIQUE (ID),
  FOREIGN KEY (studentId) REFERENCES students(id)
);

CREATE TABLE departments (
  id VARCHAR(8) NOT NULL,
  fullname VARCHAR(64) NOT NULL,

  PRIMARY KEY (ID),
  UNIQUE (ID)
);

CREATE TABLE instructors (
  id INT(10) NOT NULL AUTO_INCREMENT,
  instructorName VARCHAR(64) NOT NULL,

  PRIMARY KEY (ID),
  UNIQUE (ID)
);

CREATE TABLE courses (
  id INT(10) NOT NULL AUTO_INCREMENT,
  departmentId VARCHAR(8) NOT NULL,
  courseNumber INT(10) NOT NULL,
  instructorId INT(10) NOT NULL,

  PRIMARY KEY (ID),
  UNIQUE (ID),
  FOREIGN KEY (departmentId) REFERENCES departments(id),
  FOREIGN KEY (instructorId) REFERENCES instructors(id)
);

CREATE TABLE course_available (
  id INT(10) NOT NULL AUTO_INCREMENT,
  courseId INT(10) NOT NULL,
  semester ENUM('Fall', 'Spring', 'Summer') NOT NULL,
  year INT(4) NOT NULL,

  PRIMARY KEY (ID),
  UNIQUE (ID),
  FOREIGN KEY (courseId) REFERENCES courses(id)
);

CREATE TABLE course_student (
  id INT(10) NOT NULL AUTO_INCREMENT,
  courseId INT(10) NOT NULL,
  studentId INT(10) NOT NULL,
  semester ENUM('Fall', 'Spring', 'Summer') NOT NULL,

  PRIMARY KEY (id),
  FOREIGN KEY (courseId) REFERENCES courses(id),
  FOREIGN KEY (studentId) REFERENCES students(id)
);

CREATE TABLE stars (
  studentId INT(10) NOT NULL,
  projectId INT(10) NOT NULL,

  PRIMARY KEY (studentId, projectId),
  FOREIGN KEY (studentId) REFERENCES students(id),
  FOREIGN KEY (projectId) REFERENCES projects(id) ON DELETE CASCADE
);

CREATE TABLE comments (
  id INT(10) NOT NULL AUTO_INCREMENT,
  studentId INT(10) NOT NULL,
  type INT(10) NOT NULL,
  targetId INT(10) NOT NULL,
  body TEXT NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

  PRIMARY KEY (id),
  UNIQUE (ID),
  FOREIGN KEY (studentId) REFERENCES students(id)
);

CREATE TABLE replies (
  id INT(10) NOT NULL AUTO_INCREMENT,
  studentId INT(10) NOT NULL,
  commentId INT(10) NOT NULL,
  body TEXT NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

  PRIMARY KEY (id),
  UNIQUE (ID),
  FOREIGN KEY (studentId) REFERENCES students(id),
  FOREIGN KEY (commentId) REFERENCES comments(id)
);

CREATE TABLE activities (
  id INT(10) NOT NULL AUTO_INCREMENT,
  studentId INT(10) NOT NULL,
  type VARCHAR(20) NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

  PRIMARY KEY (id),
  UNIQUE (ID),
  FOREIGN KEY (studentId) REFERENCES students(id)
);

CREATE TABLE activity_feed_items (
  id INT(10) NOT NULL AUTO_INCREMENT,
  studentId INT(10) NOT NULL,
  activityId INT(10) NOT NULL,

  PRIMARY KEY (id),
  FOREIGN KEY (studentId) REFERENCES students(id),
  FOREIGN KEY (activityId) REFERENCES activities(id) ON DELETE CASCADE
);

CREATE TABLE enrolled_activities (
  id INT(10) NOT NULL,
  courseId INT(10) NOT NULL,
  studentId INT(10) NOT NULL,

  PRIMARY KEY (id),
  UNIQUE (ID),
  FOREIGN KEY (id) REFERENCES activities(id) ON DELETE CASCADE,
  FOREIGN KEY (courseId) REFERENCES courses(id),
  FOREIGN KEY (studentId) REFERENCES students(id)
);

CREATE TABLE project_added_activities (
  id INT(10) NOT NULL,
  projectId INT(10) NOT NULL,

  PRIMARY KEY (id),
  UNIQUE (ID),
  FOREIGN KEY (id) REFERENCES activities(id) ON DELETE CASCADE,
  FOREIGN KEY (projectId) REFERENCES projects(id) ON DELETE CASCADE
);

CREATE TABLE project_updated_activities (
  id INT(10) NOT NULL,
  projectId INT(10) NOT NULL,

  PRIMARY KEY (id),
  UNIQUE (ID),
  FOREIGN KEY (id) REFERENCES activities(id) ON DELETE CASCADE,
  FOREIGN KEY (projectId) REFERENCES projects(id) ON DELETE CASCADE
);

CREATE TABLE comment_activities (
  id INT(10) NOT NULL,
  commentId INT(10) NOT NULL,

  PRIMARY KEY (id),
  UNIQUE (ID),
  FOREIGN KEY (id) REFERENCES activities(id) ON DELETE CASCADE,
  FOREIGN KEY (commentId) REFERENCES comments(id)
);