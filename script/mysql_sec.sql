
-- ----------------------------
-- Table structure for sec_menu
-- ----------------------------

CREATE TABLE IF NOT EXISTS sec_menu (
id varchar(32) NOT NULL,
url varchar(64) DEFAULT NULL,
path varchar(64) DEFAULT NULL,
component varchar(64) DEFAULT NULL,
name varchar(64) DEFAULT NULL,
icon_cls varchar(64) DEFAULT NULL,
keepalive int(1),
require_auth int(1),
parent_id varchar(32) DEFAULT NULL,
enabled int(1) DEFAULT 1,
create_time timestamp(6),
create_user varchar(32),
update_time timestamp(6),
update_user varchar(32),
PRIMARY KEY (id),
CONSTRAINT FK_MENU_1 FOREIGN KEY(parent_id) REFERENCES sec_menu(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO sec_menu VALUES ('1', '/', null, null, '所有', null, null, null, null, '1', null, null, null, null);
INSERT INTO sec_menu VALUES ('2', '/', '/home', 'Home', '组织管理', 'fa fa-user-circle-o', null, '1', '1', '1', null, null, null, null);
INSERT INTO sec_menu VALUES ('3', '/', '/home', 'Home', '安全管理', 'fa fa-address-card-o', null, '1', '1', '1', null, null, null, null);
INSERT INTO sec_menu VALUES ('4', '/', '/home', 'Home', '基础资料', 'fa fa-money', null, '1', '1', '1', null, null, null, null);
INSERT INTO sec_menu VALUES ('5', '/', '/home', 'Home', '业务管理', 'fa fa-bar-chart', null, '1', '1', '1', null, null, null, null);
INSERT INTO sec_menu VALUES ('6', '/', '/home', 'Home', '分析报表', 'fa fa-windows', null, '1', '1', '1', null, null, null, null);

-- ----------------------------
-- Table structure for sec_role
-- ----------------------------
CREATE TABLE IF NOT EXISTS  sec_role (
id varchar(32) NOT NULL,
name varchar(64) DEFAULT NULL,
name_zh varchar(64) DEFAULT NULL,
create_time timestamp(6),
create_user varchar(32),
update_time timestamp(6),
update_user varchar(32),
PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO sec_role VALUES ('0000000000000000000000000000000', 'ROLE_administrator', '系统管理员', null, null, null, null);


-- ----------------------------
-- Table structure for sec_menu_role
-- ----------------------------
CREATE TABLE IF NOT EXISTS  sec_menu_role (
id varchar(32) NOT NULL,
mid varchar(32) DEFAULT NULL,
rid varchar(32) DEFAULT NULL,
create_time timestamp(6),
create_user varchar(32),
update_time timestamp(6),
update_user varchar(32),
PRIMARY KEY (id),
CONSTRAINT FK_MENU_ROLE_1 FOREIGN KEY(mid) REFERENCES sec_menu(id),
CONSTRAINT FK_MENU_ROLE_2 FOREIGN KEY(rid) REFERENCES sec_role(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu_role
-- ----------------------------
INSERT INTO sec_menu_role VALUES ('0000000000000000000000000000000', '1', '0000000000000000000000000000000', null, null, null, null);


-- ----------------------------
-- Table structure for sec_user
-- ----------------------------
CREATE TABLE IF NOT EXISTS  sec_user (
id varchar(32) NOT NULL,
ref_id varchar(32) DEFAULT NULL,
ref_name varchar(32) DEFAULT NULL,
telephone varchar(20) DEFAULT NULL,
address varchar(64) DEFAULT NULL,
enabled int(1) DEFAULT 1,
username varchar(32) DEFAULT NULL,
password varchar(64) DEFAULT NULL,
remark varchar(255) DEFAULT NULL,
user_face varchar(255) DEFAULT NULL,
create_time timestamp(6),
create_user varchar(32),
update_time timestamp(6),
update_user varchar(32),
PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO sec_user VALUES ('0000000000000000000000000000000', null, '系统管理员', '18568887789', '深圳坂田', '1', 'admin', '$2a$10$DL.Pkc.DzwpFp49WgC71Luo4iq8oPaVnqlKr9Bq9YHIZxqt0kcyQa', null, 'http://bpic.588ku.com/element_pic/01/40/00/64573ce2edc0728.jpg', '2018-06-07 10:58:17', 'admin', null, null);

-- ----------------------------
-- Table structure for sec_user_role
-- ----------------------------
CREATE TABLE IF NOT EXISTS  sec_user_role (
id varchar(32) NOT NULL,
hrid varchar(32) NOT NULL,
rid varchar(32) NOT NULL,
create_time timestamp(6),
create_user varchar(32),
update_time timestamp(6),
update_user varchar(32),
PRIMARY KEY (id),
CONSTRAINT FK_USER_ROLE_1 FOREIGN KEY(hrid) REFERENCES sec_user(id),
CONSTRAINT FK_USER_ROLE_2 FOREIGN KEY(rid) REFERENCES sec_role(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO sec_user_role VALUES ('0000000000000000000000000000000', '0000000000000000000000000000000', '0000000000000000000000000000000', null, null, null, null);

