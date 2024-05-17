CREATE TABLE IF NOT EXISTS account_details
(
    account_name VARCHAR(255) PRIMARY KEY,
    description  VARCHAR(500),
    followers    INT,
    following    INT,
    posts_count  INT
);

INSERT INTO account_details (account_name, description, followers, following, posts_count)
VALUES ('juris_lavs',
        '''Welcome to my world of captured moments! 📸 As a passionate photography enthusiast and avid traveler, I''m constantly on the lookout for the next breathtaking vista or hidden gem to immortalize through my lens. Join me on my journey as I explore the beauty of landscapes, cultures, and the simple joys of life. Let''s wander together and discover the extraordinary in the ordinary. ✈️ #AdventureAwaits''',
        413, 255, 0);


CREATE TABLE IF NOT EXISTS post
(
    id       SERIAL PRIMARY KEY,
    filename VARCHAR(255),
    alt_name VARCHAR(255),
    file     BYTEA
);
