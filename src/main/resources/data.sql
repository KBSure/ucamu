INSERT INTO SITUATION(id, state) VALUES(1, 'NORMAL');
INSERT INTO SITUATION(id, state) VALUES(2, 'DROPOUT');
INSERT INTO SITUATION(id, state) VALUES(3, 'SUSPENSION');

INSERT INTO USER(id, id_name, password, nickname, name, email, phone, reg_date, up_date, SITUATION_id) VALUES(1, 'kbs', '{noop}1234', '케이비에스', '김병수', 'test1@gmail.com', '010-1234-5678', current_timestamp, current_timestamp, 1);

INSERT INTO CATEGORY(id, name) VALUES(1, 'free');
INSERT INTO CATEGORY(id, name) VALUES(2, 'picture');
INSERT INTO CATEGORY(id, name) VALUES(3, 'issue');

INSERT INTO BOARD(id, title, content_who, content_when, content_where, content_what, content_how, content_why, reg_date, up_date, view, great, USER_id, CATEGORY_id) VALUES(1, '간단하게 작성하고 있다', '내가', '지금', '유카뮤에서', '게시글을', '간단하게 작성하고 있다.', '당신이 작성 방법을 모를까봐', current_timestamp, current_timestamp, 2196, 17, 1, 1);