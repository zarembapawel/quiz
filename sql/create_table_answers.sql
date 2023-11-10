CREATE TABLE IF NOT EXISTS quiz.answers(
    question_id VARCHAR(100),
    profile_id INTEGER,
    is_correct boolean,
    date DATETIME
);