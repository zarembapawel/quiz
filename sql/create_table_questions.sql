CREATE TABLE IF NOT EXISTS quiz.questions(
    id VARCHAR(100) PRIMARY KEY,
    category VARCHAR(100),
    question VARCHAR(2500),
    answers VARCHAR(5000),
    correct_answer VARCHAR(1000),
    difficulty VARCHAR(100),
    date_add DATETIME,
    date_update DATETIME,
    is_active boolean
);