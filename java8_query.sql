use school1;

CREATE TABLE tbl_school (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name NVARCHAR(200),
    description TEXT
);

CREATE TABLE tbl_class (
	id INT AUTO_INCREMENT PRIMARY KEY,
    school_id INT,
    code VARCHAR(200),
    description TEXT,
    FOREIGN KEY (school_id)
        REFERENCES tbl_school (id)
    
);

CREATE TABLE tbl_student (
	id INT AUTO_INCREMENT PRIMARY KEY,
    class_id INT,
    name NVARCHAR(200),
    mobile VARCHAR(11),
	FOREIGN KEY (class_id)
        REFERENCES tbl_class (id)
    
);

CREATE TABLE tbl_subject (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name NVARCHAR(200),
    domain VARCHAR(200),
    description TEXT
);

CREATE TABLE tbl_student_subject_register (
	id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    subject_id INT,
    score DOUBLE,
    FOREIGN KEY (student_id)
        REFERENCES tbl_student (id),
	FOREIGN KEY (subject_id)
        REFERENCES tbl_subject (id)
);

