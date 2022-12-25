use hibernate_mappings; 
drop table if exists instructor_detail;
create table instructor_detail(
	id int auto_increment not null,
    youtube_channel varchar(128) default null,
    hobby varchar(45) default null,
    
    primary key (id) 
);

drop table if exists instructor;
create table instructor(
	id int auto_increment not null,
    first_name varchar(45) default null,
    last_name varchar(45) default null,
    email varchar(45) default null,
    instructor_detail_id int default null,
    
    key fk_detail_idx (instructor_detail_id),
    foreign key (instructor_detail_id) 
    references instructor_detail (id), 
    primary key (id) 
);




