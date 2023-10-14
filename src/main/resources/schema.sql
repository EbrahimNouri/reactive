CREATE TABLE IF NOT EXISTS person
(
    person_id SERIAL PRIMARY KEY,
    name      VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS course
(
    course_id SERIAL PRIMARY KEY,
    name      VARCHAR(255),
    capacity      bigint
);
CREATE TABLE IF NOT EXISTS person_course
(
--     person_course_id SERIAL PRIMARY KEY,
    person_id SERIAL REFERENCES course (course_id),
    course_id SERIAL REFERENCES person (person_id)
--     PRIMARY KEY (person_id, course_id)

);