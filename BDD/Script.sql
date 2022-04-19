
/**1.2**/
SHOW tables;

/**1.3**/
describe t_articles;

/**1.4**/
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Ecouteurs', 'Pomme', 6500);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Souris Ergonomique', 'Logitech', 109); 

/**1.5**/
UPDATE t_articles SET UnitaryPrice = 65 WHERE description = "Ecouteurs";

/**1.6**/
DELETE FROM t_articles WHERE IdArticle = 9 ;

/**1.7**/
SELECT * FROM t_articles WHERE unitaryprice > 100;

/**1.8**/
SELECT * FROM t_articles WHERE unitaryprice BETWEEN 50 AND 150;

/**1.9**/
SELECT * FROM t_articles ORDER BY unitaryprice ASC;

/**1.10**/
SELECT description FROM t_articles;

/**1.11**/
SELECT * FROM t_articles ORDER BY unitaryprice ASC;

/**1.12**/
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Clé USB-C', 'CETME', 500);
/**affiche les article de la marque CETME, où le prix unitaire est >= 99
limit 0, 2 : 0 commence à l'indice 0 des requetes, 2 affiche les 2 premiers resultats
si limit 1 : affiche 1 seul résultat et arrête la requête**/
SELECT * FROM t_articles WHERE brand = "CETME" and unitaryprice >= 99;
SELECT * FROM t_articles WHERE brand = "CETME" and unitaryprice >= 99 LIMIT 1;
SELECT * FROM t_articles WHERE brand = "CETME" and unitaryprice >= 99 LIMIT 0, 2;

/**1.12**/
CREATE TABLE Category(
	IdCat INT(4) PRIMARY KEY AUTO_INCREMENT,
	CatName VARCHAR(50) NOT NULL,
	Description VARCHAR(100) NOT NULL
);

INSERT INTO category (CatName, Description) VALUES ('Materiel info', 'Indispensable à un pc'); 
INSERT INTO category (CatName, Description) VALUES ('Logiciel', 'SE, antivirus, IDE, ...');
INSERT INTO category (CatName, Description) VALUES ('PC', 'Laptop et micro ordi');

alter table t_articles ADD column IdCat INT(3); /**la clé étrangère ne peut être reliée si j'ajoute not null**/
ALTER TABLE t_articles ADD FOREIGN KEY (IdCat) REFERENCES category(IdCat); /**ADD constraint fk_CatName**/

UPDATE t_articles SET IdCat = 1 WHERE IdArticle > 6;

SELECT t.IdArticle, t.description, t.brand, t.unitaryprice, category.CatName from t_articles AS t 
inner join category where t.idcat = category.idcat ORDER BY unitaryprice ASC;

SELECT t.idArticle, t.description, t.brand, t.unitaryprice, category.CatName from t_articles AS t 
inner join category where t.idcat = category.idcat AND t.idArticle = 11;

/**select tables**/
SELECT * FROM t_articles;
SELECT * FROM category;