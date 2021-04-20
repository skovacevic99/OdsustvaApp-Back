INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');
              
INSERT INTO odeljenje(id, broj_slobodnih_dana, ime) VALUES (1, 10, "R12");
INSERT INTO odeljenje(id, broj_slobodnih_dana, ime) VALUES (2, 6, "E12");     
INSERT INTO odeljenje(id, broj_slobodnih_dana, ime) VALUES (3, 5, "P20");     
INSERT INTO odeljenje(id, broj_slobodnih_dana, ime) VALUES (4, 5, "G0");    

INSERT INTO radnik(id, email, godina_radnog_staza, imeiprezime, jmbg, slobodnih_dana, odeljenje_id) VALUES (1, "sasahardi@gmail.com", 5, "Aleksandar Hardi", "0206997800111", 21, 1);
INSERT INTO radnik(id, email, godina_radnog_staza, imeiprezime, jmbg, slobodnih_dana, odeljenje_id) VALUES (2, "petar@gmail.com", 25, "Petar Petrovic", "1306997800111", 25, 2);
INSERT INTO radnik(id, email, godina_radnog_staza, imeiprezime, jmbg, slobodnih_dana, odeljenje_id) VALUES (3, "marko@gmail.com", 15, "Marko Markovic", "0506997800111", 23, 2);
INSERT INTO radnik(id, email, godina_radnog_staza, imeiprezime, jmbg, slobodnih_dana, odeljenje_id) VALUES (4, "sanja@gmail.com", 15, "Sanja Trivunovic", "6206997800111", 23, 1);
INSERT INTO radnik(id, email, godina_radnog_staza, imeiprezime, jmbg, slobodnih_dana, odeljenje_id) VALUES (5, "darko@gmail.com", 20, "Darko Darkovic", "7206997800111", 24, 3);
INSERT INTO radnik(id, email, godina_radnog_staza, imeiprezime, jmbg, slobodnih_dana, odeljenje_id) VALUES (6, "marija@gmail.com", 30, "Marija Mitrovic", "90206997800111", 26, 4);

INSERT INTO odsustvo(id, datum_pocetka, radnih_dana, radnik_id) VALUES(1, "2020-01-01", 14, 1);
INSERT INTO odsustvo(id, datum_pocetka, radnih_dana, radnik_id) VALUES(2, "2020-01-01", 14, 2);
INSERT INTO odsustvo(id, datum_pocetka, radnih_dana, radnik_id) VALUES(3, "2020-01-01", 14, 3);
INSERT INTO odsustvo(id, datum_pocetka, radnih_dana, radnik_id) VALUES(4, "2020-01-01", 14, 4);
INSERT INTO odsustvo(id, datum_pocetka, radnih_dana, radnik_id) VALUES(5, "2020-01-01", 14, 1);