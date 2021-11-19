use kiemtra;
drop table card;
create table card(
    idCard int primary key auto_increment,
    idBook int,
    idStudent int,
    status tinyint(1),
    borrowDate varchar(20),
    returnDate varchar(20),
    foreign key (idBook) references book(idBook),
    foreign key (idStudent) references student(idStudent)
);