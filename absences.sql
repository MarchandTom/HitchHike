drop table absence;
drop table justificatif;
drop table personne;


create table personne(
	pno serial primary key,
	login varchar,
	mdp varchar,
	role integer
);

create table justificatif (
	jno serial primary key,
	datedeb date,
	datefin date,
	motif text,
	pnoetu integer,
	constraint fk_justificatif
	foreign key(pnoetu)
	references personne(pno)
	on update cascade
	on delete cascade
);


create table absence (
	ano serial primary key,
	dateabs date,
	hdeb integer,
	hfin integer,
	pnoetu integer,
	pnoprof integer,
	jno integer,
	constraint fk_asbence1
	foreign key (pnoetu)
	references personne (pno)
	on update cascade
	on delete cascade,
	constraint fk_asbence2
	foreign key (pnoprof)
	references personne (pno)
	on update cascade
	on delete cascade,
	constraint fk_asbence3
	foreign key (jno)
	references justificatif (jno)
	on update cascade
	on delete cascade,
	check (hdeb>=8),
	check (hdeb<=18),
	check (hfin>=9),
	check (hfin<=19),
	check (hdeb<hfin)
);

insert into personne (login, mdp, role) values ('marchant', 'moi', 1);
insert into personne (login, mdp, role) values ('bertins', 'moi', 2);
insert into personne (login, mdp, role) values ('bona', 'moi', 3);
insert into personne (login, mdp, role) values ('blondeaa', 'moi', 3);

insert into justificatif (datedeb, datefin, motif, pnoetu) values ('2017-01-31', '2017-02-02', 'flemme', 3);

 
insert into absence (dateabs, hdeb, hfin, pnoetu, pnoprof, jno) values ('2017-02-02', 8, 10, 3, 2, 1);
insert into absence (dateabs, hdeb, hfin, pnoetu, pnoprof) values ('2017-02-03', 8, 10, 3, 2);
insert into absence (dateabs, hdeb, hfin, pnoetu, pnoprof) values ('2017-02-01', 8, 10, 4, 2);
insert into absence (dateabs, hdeb, hfin, pnoetu, pnoprof) values ('2017-02-03', 8, 10, 4, 2);