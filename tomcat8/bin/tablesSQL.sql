drop table Users;
drop table Routes;
/*drop table AskValidations;*/
drop table Validations;

create table Users (
	login text PRIMARY KEY not null,
	mdp text not null,
	nom text not null,
	prenom text not null,
	tel text not null,
	jourNaissance integer DEFAULT 0,
	moisNaissance integer DEFAULT 0,
	anneeNaissance integer DEFAULT 0
);

insert into Users values ("marchant", "1385369528", "marchand", "tom", "+33 6 36 66 33 40", 26, 11, 1998);
insert into Users values ("bona", "115246", "Bon", "Antoine", "+33 7 82 08 41 75", 29, 01, 1998);
insert into Users values ("boudonm", "115246", "Boudon", "Malaury", "+33 6 95 60 15 81", 5, 11, 1998);

create table Routes(
	rno INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	login text not null,
	origin text not null,
	coordXOrigin double DEFAULT 0,
	coordYOrigin double DEFAULT 0,
	destination text,
	coordXDest double DEFAULT 0,
	coordYDest double DEFAULT 0,
	dureeTxt text,
	dureeSec integer DEFAULT 0,
	distanceTxt text,
	distanceM integer DEFAULT 0,
	nbrPers integer DEFAULT 1,
	foreign key (login) references Users(login)
);

insert into Routes (rno, login, origin, coordXOrigin, coordYOrigin, destination, coordXDest, coordYDest, dureeTxt, dureeSec, distanceTxt, distanceM, nbrPers) values(
	1,
	"marchant", 
	"93 Rue des Martyrs, 59113 Seclin, France",
	50.5547733,
	3.0174664,
	"81B Rue Jean Jaurès, 59263 Houplin-Ancoisne, France",
	50.5736453,
	2.9882669,
	"7 mins",
	421,
	"3.4 km",
	3441,
	1);

insert into Routes (rno, login, origin, coordXOrigin, coordYOrigin, destination, coordXDest, coordYDest, dureeTxt, dureeSec, distanceTxt, distanceM, nbrPers) values(
	2, "boudonm", "Seclin, France", 50.545332, 3.026566, "Marseille, France", 43.296482, 5.36978, "8 hours 57 mins", 32215, "992 km", 992080, 2);

insert into Routes (rno, login, origin, coordXOrigin, coordYOrigin, destination, coordXDest, coordYDest, dureeTxt, dureeSec, distanceTxt, distanceM, nbrPers) values(
	3, "boudonm", "02000 Laon, France", 49.564133, 3.61989, "02200 Soissons, France", 49.376636, 3.32342, "34 mins", 2047, "39.7 km", 39672, 2);

insert into Routes (rno, login, origin, coordXOrigin, coordYOrigin, destination, coordXDest, coordYDest, dureeTxt, dureeSec, distanceTxt, distanceM) values(
	4, "bona", "Glasgow, UK", 55.864237, -4.251806, "London, UK", 51.5073509, -0.1277583, "6 hours 54 mins", 24846, "650 km", 649522);

create table Validations(
	vno INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	accepted INTEGER,/*2: attente, 1: accepted, 0: declined*/
	loginDriver text not null,
	rno integer not null default 0,
	origin text,
	destination text,
	foreign key (loginDriver) references Users(login),
	foreign key (rno) references Routes(rno)
);

insert into Validations (accepted, loginDriver, rno, origin, destination) values (2, "marchant", 2, "Lille, France", "Marseille, France");


/*create table Validations(
	vno INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	loginDriver text not null,
	rno INTEGER not null,
	foreign key (loginDriver) references Users(login),
	foreign key (rno) references Routes(rno)
);

insert into Validations (loginDriver, rno) values ("bona", 1);*/