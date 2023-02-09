CREATE TABLE uzytkownicy (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  imie VARCHAR(255),
  nazwisko VARCHAR(255),
  adres VARCHAR(255),
  telefon VARCHAR(30),
  login VARCHAR(255),
  haslo VARCHAR(255),
  admin BOOLEAN
);

CREATE TABLE samochody (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  marka VARCHAR(255),
  model VARCHAR(255),
  rok_produkcji INTEGER,
  rodzaj_paliwa VARCHAR(255),
  pojemnosc_silnika DECIMAL(10,2),
  liczba_drzwi INTEGER,
  zdjecie VARCHAR(500),
  cena_za_dzien INTEGER,
  dostepnosc BOOLEAN
);

CREATE TABLE wypozyczenia (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  id_samochodu INTEGER,
  id_uzytkownika INTEGER,
  data_wypozyczenia DATE,
  data_zwrotu DATE,
  koszt DECIMAL(10,2),
  FOREIGN KEY (id_samochodu) REFERENCES samochody(id),
  FOREIGN KEY (id_uzytkownika) REFERENCES uzytkownicy(id)
);


--INSERT INTO uzytkownicy (id, imie, nazwisko, adres, telefon, login, haslo, admin) VALUES
--(1, 'Jan', 'Kowalski', 'ul. Polna 12, Warszawa', '123-456-789', 'jankowalski', 'haslo123', TRUE),
--(2, 'Anna', 'Nowak', 'ul. Sosnowa 7, Kraków', '987-654-321', 'annanowak', 'haslo456', FALSE),
--(3, 'Tomasz', 'Wiśniewski', 'ul. Brzozowa 15, Gdynia', '654-321-987', 'tomaszwisniewski', 'haslo789', FALSE),
--(4, 'Katarzyna', 'Wojciechowska', 'ul. Drzewna 25, Poznań', '321-654-987', 'katarzynawojciechowska', 'haslo123', FALSE),
--(5, 'Marcin', 'Kwiatkowski', 'ul. Lipowa 3, Wrocław', '456-789-123', 'marcinkwiatkowski', 'haslo456', FALSE),
--(6, 'Agnieszka', 'Dąbrowska', 'ul. Jesionowa 9, Szczecin', '789-123-456', 'agnieszkadabrowska', 'haslo789', FALSE),
--(7, 'Michał', 'Zieliński', 'ul. Błotna 13, Łódź', '123-987-654', 'michalzielinski', 'haslo123', FALSE),
--(8, 'Małgorzata', 'Szewczyk', 'ul. Topolowa 19, Bydgoszcz', '654-321-987', 'malgorzataszewczyk', 'haslo456', FALSE),
--(9, 'Piotr', 'Jankowski', 'ul. Kwiatowa 11, Gdańsk', '987-654-321', 'piotrjankowski', 'haslo789', FALSE),
--(10, 'Joanna', 'Mazur', 'ul. Jesienna 7, Kielce', '456-321-987', 'joannamazur', 'haslo123', FALSE);



INSERT INTO samochody (id, marka, model, rok_produkcji, rodzaj_paliwa, pojemnosc_silnika, liczba_drzwi, zdjecie, cena_za_dzien, dostepnosc) VALUES
(1, 'Toyota', 'Camry', 2018, 'benzyna', 3.5, 4, 'https://kong-proxy-aws.toyota-europe.com/c1-images/resize/ccis/680x680/zip/pl/configurationtype/visual-for-grade-selector/product-token/2cc528c2-2ba2-4e59-9890-a568dd5d1e56/grade/52b56f7e-2e27-494a-bf31-c882d1b1c9f7/body/74469257-47ae-46eb-859d-2c693e6726ca/fallback/true/padding/50,50,50,50/image-quality/70/day-exterior-4_218.png', 400, TRUE),
(2, 'BMW', 'X5', 2019, 'diesel', 3.0, 5, 'https://m.autokult.pl/174bd9cf-bmw-could-force-24c5379.jpg', 700, TRUE),
(3, 'Mercedes', 'S-Class', 2020, 'benzyna', 4.0, 4, 'https://www.tuningblog.eu/wp-content/uploads/2021/05/2021-Cupra-Born-Seat-Tuning-Elektro-Header.jpg', 1000, TRUE),
(4, 'Audi', 'A7', 2017, 'diesel', 3.0, 4, 'https://rentdreamcar.pl/wp-content/uploads/2021/02/A7-S-Line-01.jpg', 700, TRUE),
(5, 'Tesla', 'Model S', 2021, 'elektryczny', NULL, 4, 'https://autazusa.pl/wp-content/uploads/2021/10/640x331xZrzut-ekranu-2021-10-15-162159-1024x530.jpg.pagespeed.ic.CGnt1DWHnU.jpg', 800, TRUE),
(6, 'Nissan', 'Leaf', 2022, 'elektryczny', NULL, 4, 'https://masterlease.pl/wp-content/uploads/2021/06/nissan-leaf-white.jpg', 400, TRUE),
(7, 'Ford', 'Mustang', 2019, 'benzyna', 5.0, 2, 'https://api.pgd.pl/uploads_ford/cars%20icon/mustang_icon.png', 1000, TRUE),
(8, 'Fiat', '500', 2018, 'benzyna', 1.4, 2, 'https://www.autocentrum.pl/ac-file/car-version/5a3d40b4c74b355cb73b3b97/fiat-500-ii.jpg', 200, TRUE),
(9, 'Jeep', 'Grand Cherokee', 2020, 'diesel', 3.0, 5, 'https://pepecars.pl/wp-content/uploads/2020/11/jeep-mini.jpg', 500, TRUE),
(10, 'Volkswagen', 'Golf', 2017, 'benzyna', 1.4, 5, 'https://www.autocentrum.pl/ac-file/article/5db1f9b5c74b355f7f336dd3/nowy-volkswagen-golf-to-juz-ostatni-w-historii.jpg', 250, TRUE),
(11, 'Porsche', '911', 2021, 'benzyna', 3.0, 2, 'https://imgd.aeplcdn.com/664x374/cw/ec/39232/Porsche-992-911-Right-Front-Three-Quarter-154380.jpg?wm=0&q=75', 1100, TRUE),
(12, 'Mazda', 'CX-5', 2020, 'benzyna', 2.5, 5, 'https://ireland.apollo.olxcdn.com/v1/files/eyJmbiI6InFhYW5qdzd1cThjaTEtT1RPTU9UT1BMIiwidyI6W3siZm4iOiJ3ZzRnbnFwNnkxZi1PVE9NT1RPUEwiLCJzIjoiMTYiLCJwIjoiMTAsLTEwIiwiYSI6IjAifV19._ADVicxw3Yk0fwhesl4HT9bV2rZXiCv3vSc3XFvfO_k/image;s=1080x720', 600, TRUE),
(13, 'Hyundai', 'Sonata', 2019, 'benzyna', 2.4, 4, 'https://tdrresearch.azureedge.net/photos/chrome/Expanded/White/2019HYC030001/2019HYC03000101.jpg', 300, TRUE),
(14, 'Kia', 'Optima', 2018, 'benzyna', 2.0, 4, 'https://a.allegroimg.com/original/118efd/e50aef47439bb23e211f7d5fc876/KIA-OPTIMA-Prospekt-2018-PL-NOWY', 300, TRUE),
(15, 'Chevrolet', 'Impala', 2017, 'benzyna', 3.6, 4, 'https://cars.usnews.com/static/images/Auto/izmo/i2320553/2017_chevrolet_impala_angularfront.jpg', 350, TRUE),
(16, 'Subaru', 'Outback', 2020, 'benzyna', 2.5, 5, 'https://www.instrukcjaobslugipdf.pl/thumbs/products/l/1138127-subaru-outback-2020.jpg', 400, TRUE),
(17, 'Honda', 'Accord', 2019, 'benzyna', 1.5, 4, 'https://www.cars.com/i/large/in/v2/stock_photos/36f04758-5aab-42bc-912c-8e3420db060d/d5c9cc6a-43e6-4128-9154-17ff7f67955b.png', 200, TRUE),
(18, 'Lincoln', 'Navigator', 2018, 'benzyna', 3.5, 5, 'https://cars.usnews.com/static/images/Auto/izmo/i110536475/2018_lincoln_navigator_l_angularfront.jpg', 1200, TRUE),
(19, 'Dodge', 'Charger', 2017, 'benzyna', 5.7, 4, 'https://cars.usnews.com/static/images/Auto/izmo/i98655498/2017_dodge_charger_angularfront.jpg', 900, TRUE),
(20, 'Chrysler', '300', 2020, 'benzyna', 3.6, 4, 'https://www.cars.com/i/large/in/v2/stock_photos/0c1157df-379f-42ca-8aa3-3f711b3fe99a/7f1adf79-4dfc-4817-99ca-18665ccc0489.png', 800, TRUE);
