-- Insert users with verified BCrypt-hashed passwords
INSERT INTO users (username, password) VALUES
    ('user1', '$2a$10$nFEIfgQXV5WZPdvxFzwCrOqdL4N2S7DHkCRo/ZfOE/TjvBinDJqiO'),  -- password1
    ('user2', '$2a$10$nFEIfgQXV5WZPdvxFzwCrO1DcebVksCHnT0QYvAcgi96WMxcFhe7S'),  -- password2
    ('user3', '$2a$10$nFEIfgQXV5WZPdvxFzwCrO3w455cHJ/VEjAMUxeZUUF5sNxlaQ14.'),  -- password3
    ('user4', '$2a$10$nFEIfgQXV5WZPdvxFzwCrO2kBV0.X3sW1mZHOY21pOFmDWXmTxSs6'),  -- password4
    ('user5', '$2a$10$nFEIfgQXV5WZPdvxFzwCrOYwFXEC2a3sIzFLyk57wgpOSypZrkZxe'),  -- password5
    ('user6', '$2a$10$nFEIfgQXV5WZPdvxFzwCrOAcZYd6Nvoxy0sZZi71n4iUa4nPh7272'),  -- password6
    ('user7', '$2a$10$nFEIfgQXV5WZPdvxFzwCrOGwOa8q8uLZQcmIdBUxgMGtpKl76255a'),  -- password7
    ('user8', '$2a$10$nFEIfgQXV5WZPdvxFzwCrOLb5fxth3Oc4Tu6peF6Wc7twGEYUa0dq'),  -- password8
    ('user9', '$2a$10$nFEIfgQXV5WZPdvxFzwCrOmRg0Yjg7HrAt21mUJ.2dUl583w7Ivni'),  -- password9
    ('user10', '$2a$10$nFEIfgQXV5WZPdvxFzwCrOmAEOQcwSilILPvl30/V97OOTl6MDpba'); -- password10

-- Insert todos and link each todo to a user using user_id as the foreign key
-- Each user will have two todos
INSERT INTO todos (title, description, user_id) VALUES
    ('Todo 1', 'Description for todo 1', 1),  -- For user1
    ('Todo 2', 'Description for todo 2', 1),  -- For user1
    ('Todo 3', 'Description for todo 3', 2),  -- For user2
    ('Todo 4', 'Description for todo 4', 2),  -- For user2
    ('Todo 5', 'Description for todo 5', 3),  -- For user3
    ('Todo 6', 'Description for todo 6', 3),  -- For user3
    ('Todo 7', 'Description for todo 7', 4),  -- For user4
    ('Todo 8', 'Description for todo 8', 4),  -- For user4
    ('Todo 9', 'Description for todo 9', 5),  -- For user5
    ('Todo 10', 'Description for todo 10', 5),  -- For user5
    ('Todo 11', 'Description for todo 11', 6),  -- For user6
    ('Todo 12', 'Description for todo 12', 6),  -- For user6
    ('Todo 13', 'Description for todo 13', 7),  -- For user7
    ('Todo 14', 'Description for todo 14', 7),  -- For user7
    ('Todo 15', 'Description for todo 15', 8),  -- For user8
    ('Todo 16', 'Description for todo 16', 8),  -- For user8
    ('Todo 17', 'Description for todo 17', 9),  -- For user9
    ('Todo 18', 'Description for todo 18', 9),  -- For user9
    ('Todo 19', 'Description for todo 19', 10), -- For user10
    ('Todo 20', 'Description for todo 20', 10); -- For user10
