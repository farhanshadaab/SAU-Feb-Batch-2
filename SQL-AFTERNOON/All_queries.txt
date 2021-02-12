CREATE DATABASE AUTRAINING;
use AUTRAINING;

CREATE TABLE Category(
CatergoryID int,
CatergoryName varchar(20)
);

ALTER TABLE Category ADD primary key(CatergoryID);

CREATE TABLE Product(
ProductID int,
ProductName varchar(30),
UnitPrice decimal(10,2)
);

ALTER TABLE Product ADD primary key(ProductID);
ALTER TABLE Product ADD CatergoryID int;
ALTER Table Product ADD foreign key(CatergoryID) references Category(CatergoryID);

create table SaleExecutive(
SalesExecutiveID int,
EmpName varchar(50),
DOB date,
gender enum("Male","Female","Other") not null,
phone bigint
);

ALTER TABLE SaleExecutive ADD primary key(SalesExecutiveID);


CREATE TABLE Location(
LocationID int,
LocationName varchar(20),
primary key(LocationID)
);


create table Customer(
CustomerID int,
CusName varchar(50),
DOB date,
gender enum("Male","Female","Other") not null,
phone bigint,
LocationID int,
primary key(CustomerID),
foreign key(LocationID) references Location(LocationID)
);

create table Purchase(
CustomerID int,
SalesExecutiveID int,
ProductID int,
DateofPurchase date,
Units int,
primary key(CustomerID,SalesExecutiveID,ProductID)
);

ALTER Table Purchase ADD foreign key(CustomerID) references Customer(CustomerID);
ALTER Table Purchase ADD foreign key(SalesExecutiveID) references SaleExecutive(SalesExecutiveID);
ALTER Table Purchase ADD foreign key(ProductID) references Product(ProductID);


insert into Category(CatergoryID, CatergoryName) 
values (100,'Grocery'),(101,'Fashion'),(102,'Clothing'),(103,'Electronic');

insert into Product 
values (50,'Oil',150.34,100),(51,'Shampoo',90,100),(60,'glasses',400,101),(61,'Sneakers',900.55,101),
(70,'Shirts',1000.01,102),(71,'Pants',1000.34,102),(80,'Mobile',15000.34,103),(81,'Watch',450.98,103);

insert into Location
values (518001,'Kurnool'),(500032,'Gachibowli'),(500492,'London'),(500476,'UK');

insert into SaleExecutive
values (202,'Sujith','1999-3-21','Male',9783232323),(203,'Prasad','1999-4-11','Male',9784232323),(204,'Deepa','1994-8-28','Female',9786232323);

insert into Customer
values (301,'Charan','1998-3-21','Male',9783242323,500476),(302,'Satya','1989-4-11','Male',9784233323,500492),
(303,'Meghana','2000-8-28','Female',8786232323,500032),(304,'Dinesh','1988-3-21','Male',9883242323,518001),
(305,'Srujana','1999-7-21','Female',9783242326,518001);

insert into Purchase
values
(301,201,61,'2021-02-12',10),(305,204,50,'2021-02-11',12),(302,202,51,'2021-02-10',200),(303,201,70,'2021-02-9',16),
(301,203,71,'2021-02-08',44),(303,203,51,'2021-02-07',70),(304,202,61,'2021-02-04',4),(305,203,70,'2021-02-12',12),
(302,204,71,'2021-02-10',10);

select sum(Units),DateofPurchase from Purchase
where DateofPurchase >= '2021-02-05'
group by(DateofPurchase) order by(DateofPurchase) desc;

select sum(Units) as 'Units Sold', SaleExecutive.* from Purchase 
inner join 	SaleExecutive on Purchase.SalesExecutiveID = SaleExecutive.SalesExecutiveID
group by(SalesExecutiveID);