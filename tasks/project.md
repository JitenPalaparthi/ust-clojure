Project Outline: “Blog API”

The basic entities could be:

	1.	Users
	•	id (UUID or Integer, Primary Key)
	•	username (String)
	•	email (String)
	•	created_at (Timestamp)
	2.	Posts
	•	id (UUID or Integer, Primary Key)
	•	title (String)
	•	content (Text)
	•	author_id (Foreign Key to Users)
	•	created_at (Timestamp)

Required Features

	•	CRUD operations for Users:
	•	Create, Read, Update, Delete Users.
	•	CRUD operations for Posts:
	•	Create, Read, Update, Delete Posts.
	•	Database: PostgreSQL to store the data.
	•	API endpoints: Using Ring, Compojure, and next.jdbc to perform operations.
    •   Database: It is of your choice , Postgres/Mysql
    •   Logger: use a logger with a debug loglevel
    