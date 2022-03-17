drop table if exists users CASCADE; 
CREATE table users (
    id bigint AUTO_INCREMENT,
    age integer not null,
    email varchar(255),
    firstname varchar(255), 
    mailing_list boolean, 
    password varchar(255), 
	surname varchar(255), 
    username varchar(255), 
	primary key (id)
);