# So-Lien-Lac-Dien-Tu
Đồ án Lập Trình Hướng Đối Tượng Java (Core Java, Swing, MySQL): Phần mềm sổ liên lạc điện tử

# Database
create database schoolsystem;
use schoolsystem;
set @@sql_mode='no_engine_substitution';
create table monhoc
(
	mamonhoc varchar(20) not null,
    tenmonhoc nvarchar(30) not null,
    ghichu nvarchar(255),
    malop varchar(20) not null,
    foreign key(malop) references lop(malop),
    constraint pk_monhoc primary key(mamonhoc, malop)
);

create table giaovien
(
	magiaovien varchar(20) not null primary key,
    ho nvarchar(30) not null,
    ten nvarchar(10) not null,
    gioitinh boolean,
    ngaysinh timestamp,
    password varchar(50)
);

create table lop
(
	malop varchar(20) not null primary key,
    tenlop nvarchar(20),
    khoa varchar(30),
    siso int,
    magiaovien varchar(20) not null,
    foreign key(magiaovien) references giaovien(magiaovien)
);

create table hocsinh
(
	mahocsinh varchar(20) not null primary key,
    ho nvarchar(30) not null,
    ten nvarchar(10) not null,
    ngaysinh timestamp,
    gioitinh boolean,
    password varchar(50),
    malop varchar(20) not null,
    foreign key(malop) references lop(malop)
);

create table diem
(
	diem float not null,
    mahocsinh varchar(20) not null,
    mamonhoc varchar(20) not null,
    loai int,
    foreign key(mahocsinh) references hocsinh(mahocsinh),
    foreign key(mamonhoc) references monhoc(mamonhoc),
    constraint pk_diem primary key(mahocsinh, mamonhoc, loai)
);

create table thongbaocanhan
(
	mathongbao varchar(20) not null primary key,
    noidung text(255) not null,
    ngay timestamp,
    magiaovien varchar(20) not null,
    mahocsinh varchar(20) not null,
    foreign key(magiaovien) references giaovien(magiaovien),
    foreign key(mahocsinh) references hocsinh(mahocsinh)
);

create table mailphuhuynh
(
    noidung text(255) not null,
    ngay timestamp,
    magiaovien varchar(20) not null,
    mahocsinh varchar(20) not null,
    foreign key(magiaovien) references giaovien(magiaovien),
    foreign key(mahocsinh) references hocsinh(mahocsinh),
    constraint pk_mail primary key(mahocsinh, ngay)
);

create table thongbaochung
(
	mathongbao varchar(20) not null primary key,
    noidung text(255) not null,
    ngay timestamp,
    magiaovien varchar(20) not null,
    malop varchar(20) not null,
    foreign key(magiaovien) references giaovien(magiaovien),
    foreign key(malop) references lop(malop)
);
