INSERT INTO user (username, register_date) VALUES ('user1', NOW());
INSERT INTO user (username, register_date) VALUES ('user2', NOW());
INSERT INTO user (username, register_date) VALUES ('user3', NOW());
INSERT INTO user (username, register_date) VALUES ('user4', NOW());
INSERT INTO user (username, register_date) VALUES ('user5', NOW());
INSERT INTO user (username, register_date) VALUES ('user6', NOW());
INSERT INTO user (username, register_date) VALUES ('user7', NOW());
INSERT INTO user (username, register_date) VALUES ('user8', NOW());
INSERT INTO user (username, register_date) VALUES ('user9', NOW());
INSERT INTO user (username, register_date) VALUES ('user10', NOW());

INSERT INTO member (member_id, category, income, house_area, residents, premium_member) VALUES (1, 1, 50000.00, 1000, 3, TRUE);
INSERT INTO member (member_id, category, income, house_area, residents, premium_member) VALUES (2, 2, 70000.00, 1200, 4, FALSE);
INSERT INTO member (member_id, category, income, house_area, residents, premium_member) VALUES (3, 1, 45000.00, 800, 2, TRUE);
INSERT INTO member (member_id, category, income, house_area, residents, premium_member) VALUES (4, 3, 60000.00, 1100, 2, FALSE);
INSERT INTO member (member_id, category, income, house_area, residents, premium_member) VALUES (5, 2, 55000.00, 900, 3, TRUE);
INSERT INTO member (member_id, category, income, house_area, residents, premium_member) VALUES (6, 1, 40000.00, 700, 1, FALSE);
INSERT INTO member (member_id, category, income, house_area, residents, premium_member) VALUES (7, 2, 65000.00, 1000, 2, TRUE);
INSERT INTO member (member_id, category, income, house_area, residents, premium_member) VALUES (8, 3, 55000.00, 950, 4, FALSE);
INSERT INTO member (member_id, category, income, house_area, residents, premium_member) VALUES (9, 1, 48000.00, 850, 2, TRUE);
INSERT INTO member (member_id, category, income, house_area, residents, premium_member) VALUES (10, 2, 52000.00, 950, 3, FALSE);

INSERT INTO chat (chat_id) VALUES (1);
INSERT INTO chat (chat_id) VALUES (2);
INSERT INTO chat (chat_id) VALUES (3);
INSERT INTO chat (chat_id) VALUES (4);
INSERT INTO chat (chat_id) VALUES (5);
INSERT INTO chat (chat_id) VALUES (6);
INSERT INTO chat (chat_id) VALUES (7);
INSERT INTO chat (chat_id) VALUES (8);
INSERT INTO chat (chat_id) VALUES (9);
INSERT INTO chat (chat_id) VALUES (10);

INSERT INTO messages (chat_id, body, receiver_id, sender_id, sent_on) VALUES (1, 'Hello, how are you?', 2, 1, NOW());
INSERT INTO messages (chat_id, body, receiver_id, sender_id, sent_on) VALUES (2, 'Hey there!', 3, 4, NOW());
INSERT INTO messages (chat_id, body, receiver_id, sender_id, sent_on) VALUES (3,'Hi, I need your help.', 5, 6, NOW());
INSERT INTO messages (chat_id, body, receiver_id, sender_id, sent_on) VALUES (4, 'Sure, what do you need?', 8, 7, NOW());
INSERT INTO messages (chat_id, body, receiver_id, sender_id, sent_on) VALUES (5, 'Have you seen the latest movie?', 9, 10, NOW());
INSERT INTO messages (chat_id, body, receiver_id, sender_id, sent_on) VALUES (6, 'No, not yet. Is it good?', 2, 3, NOW());
INSERT INTO messages (chat_id, body, receiver_id, sender_id, sent_on) VALUES (7, 'Are you free this weekend?', 5, 4, NOW());
INSERT INTO messages (chat_id, body, receiver_id, sender_id, sent_on) VALUES (8, 'Yes, I am. Lets meet up.', 7, 6, NOW());
INSERT INTO messages (chat_id, body, receiver_id, sender_id, sent_on) VALUES (9, 'Can you pick up some groceries on your way home?', 8, 9, NOW());
INSERT INTO messages (chat_id, body, receiver_id, sender_id, sent_on) VALUES (10, 'Sure, Ill do that.', 1, 10, NOW());

INSERT INTO friendships (member1_id, member2_id, friends_since, chat_id, sharing_level_to1, sharing_level_to2) VALUES (1, 2, '2023-01-01', 1, 2, 2);
INSERT INTO friendships (member1_id, member2_id, friends_since, chat_id, sharing_level_to1, sharing_level_to2) VALUES (3, 4, '2023-02-01', 2, 1, 1);
INSERT INTO friendships (member1_id, member2_id, friends_since, chat_id, sharing_level_to1, sharing_level_to2) VALUES (5, 6, '2023-03-01', 3, 2, 1);
INSERT INTO friendships (member1_id, member2_id, friends_since, chat_id, sharing_level_to1, sharing_level_to2) VALUES (7, 8, '2023-04-01', 4, 1, 2);
INSERT INTO friendships (member1_id, member2_id, friends_since, chat_id, sharing_level_to1, sharing_level_to2) VALUES (9, 10, '2023-05-01', 5, 2, 2);
INSERT INTO friendships (member1_id, member2_id, friends_since, chat_id, sharing_level_to1, sharing_level_to2) VALUES (2, 3, '2023-06-01', 6, 1, 1);
INSERT INTO friendships (member1_id, member2_id, friends_since, chat_id, sharing_level_to1, sharing_level_to2) VALUES (4, 5, '2023-07-01', 7, 2, 1);
INSERT INTO friendships (member1_id, member2_id, friends_since, chat_id, sharing_level_to1, sharing_level_to2) VALUES (6, 7, '2023-08-01', 8, 1, 2);
INSERT INTO friendships (member1_id, member2_id, friends_since, chat_id, sharing_level_to1, sharing_level_to2) VALUES (8, 9, '2023-09-01', 9, 2, 2);
INSERT INTO friendships (member1_id, member2_id, friends_since, chat_id, sharing_level_to1, sharing_level_to2) VALUES (10, 1, '2023-10-01', 10, 1, 1);

INSERT INTO friend_requests (sender_id, receiver_id, sender_sharing_level, sent_on) VALUES (1, 3, 1, NOW());
INSERT INTO friend_requests (sender_id, receiver_id, sender_sharing_level, sent_on) VALUES (1, 6, 1, NOW());
INSERT INTO friend_requests (sender_id, receiver_id, sender_sharing_level, sent_on) VALUES (1, 4, 1, NOW());
INSERT INTO friend_requests (sender_id, receiver_id, sender_sharing_level, sent_on) VALUES (1, 5, 1, NOW());
INSERT INTO friend_requests (sender_id, receiver_id, sender_sharing_level, sent_on) VALUES (2, 4, 1, NOW());
INSERT INTO friend_requests (sender_id, receiver_id, sender_sharing_level, sent_on) VALUES (2, 6, 1, NOW());
INSERT INTO friend_requests (sender_id, receiver_id, sender_sharing_level, sent_on) VALUES (2, 5, 1, NOW());
INSERT INTO friend_requests (sender_id, receiver_id, sender_sharing_level, sent_on) VALUES (3, 7, 1, NOW());
INSERT INTO friend_requests (sender_id, receiver_id, sender_sharing_level, sent_on) VALUES (3, 5, 1, NOW());
INSERT INTO friend_requests (sender_id, receiver_id, sender_sharing_level, sent_on) VALUES (4, 8, 1, NOW());


INSERT INTO points (member_id, amount, reason, timestamp) VALUES (1, 50, 'Completed a task', NOW());
INSERT INTO points (member_id, amount, reason, timestamp) VALUES (1, 100, 'Saved $1000', NOW());
INSERT INTO points (member_id, amount, reason, timestamp) VALUES (1, 75, 'Answered 50 questions', NOW());
INSERT INTO points (member_id, amount, reason, timestamp) VALUES (4, 25, 'Completed 5 reviews', NOW());
INSERT INTO points (member_id, amount, reason, timestamp) VALUES (5, 30, 'Asked 20 questions', NOW());
INSERT INTO points (member_id, amount, reason, timestamp) VALUES (6, 40, 'Set 3 goals', NOW());
INSERT INTO points (member_id, amount, reason, timestamp) VALUES (7, 50, 'Completed a task', NOW());
INSERT INTO points (member_id, amount, reason, timestamp) VALUES (8, 100, 'Saved $1000', NOW());
INSERT INTO points (member_id, amount, reason, timestamp) VALUES (9, 75, 'Answered 50 questions', NOW());
INSERT INTO points (member_id, amount, reason, timestamp) VALUES (10, 25, 'Completed 5 reviews', NOW());

INSERT INTO premium_features (cost, description) VALUES (10, 'Feature 1');
INSERT INTO premium_features (cost, description) VALUES (20, 'Feature 2');
INSERT INTO premium_features (cost, description) VALUES (30, 'Feature 3');
INSERT INTO premium_features (cost, description) VALUES (40, 'Feature 4');
INSERT INTO premium_features (cost, description) VALUES (50, 'Feature 5');
INSERT INTO premium_features (cost, description) VALUES (60, 'Feature 6');
INSERT INTO premium_features (cost, description) VALUES (70, 'Feature 7');
INSERT INTO premium_features (cost, description) VALUES (80, 'Feature 8');
INSERT INTO premium_features (cost, description) VALUES (90, 'Feature 9');
INSERT INTO premium_features (cost, description) VALUES (100, 'Feature 10');

INSERT INTO premium_feature_tokens (received_on, member_id, feature_id) VALUES ('2023-01-01', 1, 1);
INSERT INTO premium_feature_tokens (received_on, member_id, feature_id) VALUES ('2023-02-01', 1, 2);
INSERT INTO premium_feature_tokens (received_on, member_id, feature_id) VALUES ('2023-03-01', 1, 3);
INSERT INTO premium_feature_tokens (received_on, member_id, feature_id) VALUES ('2023-04-01', 4, 4);
INSERT INTO premium_feature_tokens (received_on, member_id, feature_id) VALUES ('2023-05-01', 5, 5);
INSERT INTO premium_feature_tokens (received_on, member_id, feature_id) VALUES ('2023-06-01', 6, 6);
INSERT INTO premium_feature_tokens (received_on, member_id, feature_id) VALUES ('2023-07-01', 7, 7);
INSERT INTO premium_feature_tokens (received_on, member_id, feature_id) VALUES ('2023-08-01', 8, 8);
INSERT INTO premium_feature_tokens (received_on, member_id, feature_id) VALUES ('2023-09-01', 9, 9);
INSERT INTO premium_feature_tokens (received_on, member_id, feature_id) VALUES ('2023-10-01', 10, 10);