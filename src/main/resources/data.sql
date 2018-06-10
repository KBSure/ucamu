INSERT INTO SITUATION(id, state) VALUES(1, 'NORMAL');
INSERT INTO SITUATION(id, state) VALUES(2, 'DROPOUT');
INSERT INTO SITUATION(id, state) VALUES(3, 'SUSPENSION');

INSERT INTO USER(id, id_name, password, nickname, name, email, phone, reg_date, up_date, SITUATION_id) VALUES(1, 'kbs', '{noop}1234', '케이비에스', '김병수', 'test1@gmail.com', '010-1234-5678', current_timestamp, current_timestamp, 1);

INSERT INTO CATEGORY(id, name) VALUES(1, 'free');
INSERT INTO CATEGORY(id, name) VALUES(2, 'picture');
INSERT INTO CATEGORY(id, name) VALUES(3, 'issue');
