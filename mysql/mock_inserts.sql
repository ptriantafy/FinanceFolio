INSERT INTO user (username, register_date)
VALUES ('john_doe', NOW()),
       ('jane_smith', NOW()),
       ('mike_johnson', NOW()),
       ('amy_wilson', NOW()),
       ('peter_davis', NOW()),
       ('lisa_lee', NOW()),
       ('tom_brown', NOW()),
       ('sarah_walker', NOW()),
       ('mark_roberts', NOW()),
       ('emily_wright', NOW());


INSERT INTO member (member_id, category, income, house_area, residents, premium_user)
VALUES (1, 2, 5000.00, 1500, 3, TRUE),
       (2, 1, 3000.00, 1000, 2, FALSE),
       (3, 3, 7000.00, 2000, 4, TRUE),
       (4, 2, 4000.00, 1200, 2, FALSE),
       (5, 1, 3500.00, 1100, 3, FALSE),
       (6, 1, 2500.00, 900, 1, FALSE),
       (7, 3, 6000.00, 1800, 2, TRUE),
       (8, 2, 4500.00, 1300, 4, FALSE),
       (9, 1, 2800.00, 950, 2, FALSE),
       (10, 2, 3800.00, 1400, 3, FALSE);


INSERT INTO chat (chat_id)
VALUES (1),
       (2),
       (3),
       (4),
       (5),
       (6),
       (7),
       (8),
       (9),
       (10);


INSERT INTO messages (chat_id, body, receiver_id, sender_id, sent_on)
VALUES (1, 'Hello there!', 2, 1, NOW()),
       (2, 'How are you?', 3, 1, NOW()),
       (3, 'Nice to meet you!', 1, 2, NOW()),
       (4, 'What are your plans?', 4, 2, NOW()),
       (5, 'I need your help.', 5, 3, NOW()),
       (6, 'Lets catch up tomorrow.', 3, 4, NOW()),
       (7, 'Have a great day!', 1, 4, NOW()),
       (8, 'Did you watch the game?', 2, 5, NOW()),
       (9, 'I have a question for you.', 1, 6, NOW()),
       (10, 'Lets go shopping!', 4, 6, NOW());


INSERT INTO friendships (member1_id, member2_id, friends_since, chat_id, sharing_level_to1, sharing_level_to2)
VALUES (1, 2, '2023-05-27', 1, 2, 3),
       (2, 3, '2023-05-27', 2, 1, 2),
       (3, 4, '2023-05-27', 3, 1, 1),
       (4, 5, '2023-05-27', 4, 2, 3),
       (5, 6, '2023-05-27', 5, 3, 1),
       (6, 7, '2023-05-27', 6, 2, 2),
       (7, 8, '2023-05-27', 7, 1, 3),
       (8, 9, '2023-05-27', 8, 3, 2),
       (9, 10, '2023-05-27', 9, 1, 1),
       (10, 1, '2023-05-27', 10, 2, 3);


INSERT INTO friend_requests (sender_id, receiver_id, sender_sharing_level, sent_on)
VALUES (1, 3, 2, NOW()),
       (4, 6, 1, NOW()),
       (8, 2, 3, NOW()),
       (9, 5, 2, NOW()),
       (7, 10, 1, NOW()),
       (2, 4, 3, NOW()),
       (3, 1, 1, NOW()),
       (6, 8, 2, NOW()),
       (10, 9, 3, NOW()),
       (5, 7, 1, NOW());


INSERT INTO points (member_id, amount, date)
VALUES (1, 10, '2023-05-27'),
       (2, 5, '2023-05-27'),
       (3, 8, '2023-05-27'),
       (4, 3, '2023-05-27'),
       (5, 12, '2023-05-27'),
       (6, 6, '2023-05-27'),
       (7, 9, '2023-05-27'),
       (8, 15, '2023-05-27'),
       (9, 7, '2023-05-27'),
       (10, 11, '2023-05-27');
