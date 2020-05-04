CREATE TABLE crews(
crew_id             INT(4) AUTO_INCREMENT,
crew_name			VARCHAR(10) NOT NULL,
total_members	 		INT(2) CHECK (total_members>=0) DEFAULT 0,
PRIMARY KEY (crew_id));
ALTER TABLE crews AUTO_INCREMENT=100;

INSERT INTO crews(crew_name) VALUES ("Alpha");
INSERT INTO crews(crew_name) VALUES ("Bravo");
INSERT INTO crews(crew_name) VALUES ("Charle");
INSERT INTO crews(crew_name) VALUES ("Delta");
INSERT INTO crews(crew_name) VALUES ("Echo");

CREATE TABLE employees(
employee_id		INT(4) AUTO_INCREMENT,
first_name 		VARCHAR(25) NOT NULL,
last_name 		VARCHAR(25) NOT NULL,
email 			VARCHAR(25),
phone_number	VARCHAR(12) NOT NULL UNIQUE,
manager_id 		INT(4),
street        	VARCHAR(50) NOT NULL,
city        	VARCHAR(50) NOT NULL,
state        	CHAR(2) NOT NULL,
zip_code    	INT(5) NOT NULL,
salary			DOUBLE(8, 2) CHECK (salary>0) NOT NULL,
PRIMARY KEY (employee_id),
FOREIGN KEY (manager_id) REFERENCES employees(employee_id));
ALTER TABLE employees AUTO_INCREMENT=100;

INSERT INTO employees(first_name, last_name, email, phone_number, street, city, state, zip_code, salary) VALUES ("Oscar", "Cordova", "ocordova", "703.989.7428", "6601 Dorset Dr.", "Alexandrai", "VA", 22310, 20000.00);
INSERT INTO employees(first_name, last_name, email, phone_number, street, city, state, zip_code, salary) VALUES ("Sam", "Cordova", "scordova", "703.989.7429", "6601 Dorset Dr.", "Alexandrai", "VA", 22310, 15000.00);
INSERT INTO employees(first_name, last_name, email, phone_number, street, city, state, zip_code, salary) VALUES ("Juan", "Mart", "jmart", "703.125.6673", "5874 Elm Dr.", "Alexandrai", "VA", 22310, 15200.00);
INSERT INTO employees(first_name, last_name, email, phone_number, street, city, state, zip_code, salary) VALUES ("Brian", "Cordova", "bcordova", "703.556.4658", "1212 Sacramento Rd.", "Alexandrai", "VA", 22308, 12000.00);
INSERT INTO employees(first_name, last_name, email, phone_number, street, city, state, zip_code, salary) VALUES ("John", "Doe", "jdoe", "703.111.5598", "5874 Elm Dr.", "Alexandrai", "VA", 22310, 19300.00);
INSERT INTO employees(first_name, last_name, email, phone_number, street, city, state, zip_code, salary) VALUES ("Steven", "Mart", "smart", "703.999.5646", "1212 Sacramento Rd.", "Alexandrai", "VA", 22310, 16500.00);
INSERT INTO employees(first_name, last_name, email, phone_number, street, city, state, zip_code, salary) VALUES ("Jack", "Hart", "jhart", "703.753.6983", "501 Read St.", "Alexandrai", "VA", 22310, 12230.00);
INSERT INTO employees(first_name, last_name, email, phone_number, street, city, state, zip_code, salary) VALUES ("Kevin", "Dias", "kdias", "703.113.3333", "501 Read St.", "Alexandrai", "VA", 22310, 20700.00);
INSERT INTO employees(first_name, last_name, email, phone_number, street, city, state, zip_code, salary) VALUES ("Larry", "knight", "lknight", "703.111.1111", "2466 kings Rd.", "Alexandrai", "VA", 22310, 15960.00);
INSERT INTO employees(first_name, last_name, email, phone_number, street, city, state, zip_code, salary) VALUES ("Jesus", "Smith", "jsmith", "703.259.7741", "1112 The Parkway", "Alexandrai", "VA", 22310, 14200.00);

UPDATE employees set manager_id = 100 WHERE employee_id IN (101,102,103);
UPDATE employees set manager_id = 104 WHERE employee_id IN (105,106);
UPDATE employees set manager_id = 107 WHERE employee_id = 108;

INSERT INTO employees(first_name, last_name, email, phone_number, street, city, state, zip_code, salary) VALUES ("Bob", "Johnson", "bjohnson", "703.608.7219", "4216 Dawn Dr.", "Alexandrai", "VA", 22310, 21000.00);
INSERT INTO employees(first_name, last_name, email, phone_number, street, city, state, zip_code, salary) VALUES ("Karen", "Cordova", "kcordova", "703.534.3682", "3905 Sing Dr.", "Alexandrai", "VA", 22310, 17000.00);
INSERT INTO employees(first_name, last_name, email, phone_number, street, city, state, zip_code, salary) VALUES ("James", "Brown", "jbrown", "703.938.5927", "8179 Red St.", "Alexandrai", "VA", 22310, 15500.00);
INSERT INTO employees(first_name, last_name, email, phone_number, street, city, state, zip_code, salary) VALUES ("Steven", "Miller", "smiller", "703.539.1350", "314 Oak Rd.", "Alexandrai", "VA", 22308, 13000.00);
INSERT INTO employees(first_name, last_name, email, phone_number, street, city, state, zip_code, salary) VALUES ("Jackie", "Escobar", "jescobar", "703.975.8933", "7679 View Dr.", "Alexandrai", "VA", 22310, 20200.00);
INSERT INTO employees(first_name, last_name, email, phone_number, street, city, state, zip_code, salary) VALUES ("Megan", "Wilson", "mwilson", "703.299.6518", "1442 Sacramento Rd.", "Alexandrai", "VA", 22310, 15500.00);
INSERT INTO employees(first_name, last_name, email, phone_number, street, city, state, zip_code, salary) VALUES ("Emaly", "Wilson", "ewilson", "703.430.3697", "494 Oak Rd.", "Alexandrai", "VA", 22310, 13030.00);
INSERT INTO employees(first_name, last_name, email, phone_number, street, city, state, zip_code, salary) VALUES ("Marven", "Dias", "mdias", "703.637.0012", "8564 Lake St.", "Alexandrai", "VA", 22310, 21000.00);
INSERT INTO employees(first_name, last_name, email, phone_number, street, city, state, zip_code, salary) VALUES ("Jose", "Davis", "jdavis", "703.243.0447", "5893 Lake Rd.", "Alexandrai", "VA", 22310, 19900.00);
INSERT INTO employees(first_name, last_name, email, phone_number, street, city, state, zip_code, salary) VALUES ("Frank", "Anderson", "fanderson", "703.371.0987", "4614 Hill St.", "Alexandrai", "VA", 22310, 15200.00);

UPDATE employees set manager_id = 110 WHERE employee_id IN (111,112,113);
UPDATE employees set manager_id = 114 WHERE employee_id IN (115,116,117);
UPDATE employees set manager_id = 118 WHERE employee_id = 119;

INSERT INTO employees(first_name, last_name, email, phone_number, street, city, state, zip_code, salary) VALUES ("Aron", "Peters", "apeters", "703.284.5776", "4915 Dawn Dr.", "Alexandrai", "VA", 22310, 21200.00);
INSERT INTO employees(first_name, last_name, email, phone_number, street, city, state, zip_code, salary) VALUES ("Asiyah", "Lawrence", "alawrence", "703.733.2575", "3184 Sing Dr.", "Alexandrai", "VA", 22310, 15900.00);
INSERT INTO employees(first_name, last_name, email, phone_number, street, city, state, zip_code, salary) VALUES ("Owen", "Wallace", "owallace", "703.778.8467", "8218 Red St.", "Alexandrai", "VA", 22310, 12250.00);
INSERT INTO employees(first_name, last_name, email, phone_number, street, city, state, zip_code, salary) VALUES ("Jordan", "Potter", "jpotter", "703.423.6639", "325 Oak Rd.", "Alexandrai", "VA", 22308, 14500.00);
INSERT INTO employees(first_name, last_name, email, phone_number, street, city, state, zip_code, salary) VALUES ("Kathryn", "Mckay", "kmcmay", "703.129.8194", "7078 View Dr.", "Alexandrai", "VA", 22310, 20000.00);

UPDATE employees set manager_id = 120 WHERE employee_id IN (121,122,123);


CREATE TABLE field_staff(
employee_id		INT(4),
crew_id			INT(4) NOT NULL DEFAULT 100,
PRIMARY KEY (employee_id),
FOREIGN KEY (employee_id) REFERENCES employees(employee_id) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (crew_id) REFERENCES crews(crew_id) ON UPDATE CASCADE ON DELETE SET DEFAULT);

INSERT INTO field_staff(employee_id, crew_id) VALUES (100, 100);
INSERT INTO field_staff(employee_id, crew_id) VALUES (101, 100);
INSERT INTO field_staff(employee_id, crew_id) VALUES (102, 100);
INSERT INTO field_staff(employee_id, crew_id) VALUES (103, 100);
INSERT INTO field_staff(employee_id, crew_id) VALUES (104, 101);
INSERT INTO field_staff(employee_id, crew_id) VALUES (105, 101);
INSERT INTO field_staff(employee_id, crew_id) VALUES (106, 101);
INSERT INTO field_staff(employee_id, crew_id) VALUES (107, 102);
INSERT INTO field_staff(employee_id, crew_id) VALUES (108, 102);
INSERT INTO field_staff(employee_id, crew_id) VALUES (109, 103);


CREATE TABLE office_staff(
employee_id		INT(4),
office_number	INT(4)  NOT NULL UNIQUE,
PRIMARY KEY (employee_id),
FOREIGN KEY (employee_id) REFERENCES employees(employee_id) ON UPDATE CASCADE ON DELETE CASCADE);

INSERT INTO office_staff(employee_id, office_number) VALUES (110, 1000);
INSERT INTO office_staff(employee_id, office_number) VALUES (111, 1001);
INSERT INTO office_staff(employee_id, office_number) VALUES (112, 1002);
INSERT INTO office_staff(employee_id, office_number) VALUES (113, 1003);
INSERT INTO office_staff(employee_id, office_number) VALUES (114, 1004);
INSERT INTO office_staff(employee_id, office_number) VALUES (115, 1005);
INSERT INTO office_staff(employee_id, office_number) VALUES (116, 1006);
INSERT INTO office_staff(employee_id, office_number) VALUES (117, 1007);
INSERT INTO office_staff(employee_id, office_number) VALUES (118, 1008);
INSERT INTO office_staff(employee_id, office_number) VALUES (119, 1009);


CREATE TABLE mechanics(
employee_id		INT(4),
PRIMARY KEY (employee_id),
FOREIGN KEY (employee_id) REFERENCES employees(employee_id) ON UPDATE CASCADE ON DELETE CASCADE);

INSERT INTO mechanics(employee_id) VALUES (120);
INSERT INTO mechanics(employee_id) VALUES (121);
INSERT INTO mechanics(employee_id) VALUES (122);
INSERT INTO mechanics(employee_id) VALUES (123);
INSERT INTO mechanics(employee_id) VALUES (124);


CREATE TABLE equipment(
equipment_id		INT(4) AUTO_INCREMENT, 
serial_number       VARCHAR(25) NOT NULL,
manufacturer        VARCHAR(25) NOT NULL,
price               DOUBLE(8,2) CHECK (price>0) NOT NULL,
purchase_date       DATE NOT NULL,
PRIMARY KEY (equipment_id));

INSERT INTO equipment (serial_number, manufacturer, price, purchase_date) VALUES ("T495140698", "Echo", 250.00, '2018-04-20');
INSERT INTO equipment (serial_number, manufacturer, price, purchase_date) VALUES ("T495140698", "Echo", 255.00, '2018-01-12');
INSERT INTO equipment (serial_number, manufacturer, price, purchase_date) VALUES ("T495140698", "Echo", 200.00, '2017-05-18');
INSERT INTO equipment (serial_number, manufacturer, price, purchase_date) VALUES ("K9000160", "Scag", 1550.99, '2015-10-02');
INSERT INTO equipment (serial_number, manufacturer, price, purchase_date) VALUES ("K9000160", "Scag", 1750.99, '2016-10-16');
INSERT INTO equipment (serial_number, manufacturer, price, purchase_date) VALUES ("316621246", "Exmart", 2100.00, '2020-4-10');
INSERT INTO equipment (serial_number, manufacturer, price, purchase_date) VALUES ("316621246", "Exmart", 1890.00, '2018-07-15');
INSERT INTO equipment (serial_number, manufacturer, price, purchase_date) VALUES ("316002234", "Exmart", 669.99, '2016-11-09');
INSERT INTO equipment (serial_number, manufacturer, price, purchase_date) VALUES ("316002234", "Exmart", 724.99, '2016-03-19');
INSERT INTO equipment (serial_number, manufacturer, price, purchase_date) VALUES ("316002234", "Exmart", 549.99, '2017-07-01');
INSERT INTO equipment (serial_number, manufacturer, price, purchase_date) VALUES ("T 21713", "Merry Tiller", 999.99, '2020-4-10');


CREATE TABLE repairs(
mechanic_id 	INT(4) NOT NULL,
equipment_id 	INT(4) NOT NULL,
repair_date 	DATE NOT NULL,
PRIMARY KEY (mechanic_id, equipment_id, repair_date),
FOREIGN KEY (mechanic_id) REFERENCES mechanics(employee_id) ON UPDATE CASCADE ON DELETE SET NULL,
FOREIGN KEY (equipment_id) REFERENCES equipment(equipment_id) ON UPDATE CASCADE ON DELETE CASCADE);


CREATE TABLE subcontractors(
contractor_id     	INT(4) AUTO_INCREMENT,
first_name        	VARCHAR(25) NOT NULL,
last_name        	VARCHAR(25) NOT NULL,
email        		VARCHAR(25),
phone_number		VARCHAR(12) NOT NULL,
street        		VARCHAR(50) NOT NULL,
city        		VARCHAR(50) NOT NULL,
state        		CHAR(2) NOT NULL,
zip_code    		INT(5) NOT NULL,
salary 				DOUBLE(8,2) CHECK (salary>0) NOT NULL,
PRIMARY KEY (contractor_id));

ALTER TABLE subcontractors AUTO_INCREMENT=100;

INSERT INTO subcontractors(salary, first_name, last_name, email, phone_number, street, city, state, zip_code) VALUES (5200.00, "Eduard", "Mendoza", "emendoza", "703.073.6980", "3233 Second St.", "Alexandrai", "VA", 22310);
INSERT INTO subcontractors(salary, first_name, last_name, email, phone_number, street, city, state, zip_code) VALUES (5900.00, "Clifford", "Rodrigues", "crodrigues", "703.227.1218", "8042 Maple Dr.", "Alexandrai", "VA", 22310);
INSERT INTO subcontractors(salary, first_name, last_name, email, phone_number, street, city, state, zip_code) VALUES (6250.00, "Chelsie", "Bond", "cbond", "703.209.7504", "8208 Red St.", "Alexandrai", "VA", 22310);
INSERT INTO subcontractors(salary, first_name, last_name, email, phone_number, street, city, state, zip_code) VALUES (4500.00, "Gladys", "Timms", "gtimms", "703.800.9031", "6084 Washington Rd.", "Alexandrai", "VA", 22310);
INSERT INTO subcontractors(salary, first_name, last_name, email, phone_number, street, city, state, zip_code) VALUES (6000.00, "Lewys", "Glenn", "lglenn", "703.611.8044", "7422 View Dr.", "Alexandrai", "VA", 22310);


CREATE TABLE customers(
customer_id		INT(4) AUTO_INCREMENT,
first_name      VARCHAR(25) NOT NULL,
last_name       VARCHAR(25) NOT NULL,
email        	VARCHAR(25) NOT NULL,
phone_number	VARCHAR(12) NOT NULL,
street        	VARCHAR(50) NOT NULL,
city        	VARCHAR(50) NOT NULL,
state        	CHAR(2) NOT NULL, 
zip_code    	INT(5) NOT NULL,
PRIMARY KEY (customer_id));

ALTER TABLE customers AUTO_INCREMENT=100;

INSERT INTO customers(first_name, last_name, email, phone_number, street, city, state, zip_code) VALUES ("Ceara", "Warren", "cwarren", "703.632.8631", "2413 Dawn Sr.", "Alexandrai", "VA", 22310);
INSERT INTO customers(first_name, last_name, email, phone_number, street, city, state, zip_code) VALUES ("Kiefer", "Monaghan", "kmoaghan", "703.292.6899", "3843 Sing Rd.", "Alexandrai", "VA", 22310);
INSERT INTO customers(first_name, last_name, email, phone_number, street, city, state, zip_code) VALUES ("Glenn", "Peel", "gpeel", "703.353.0241", "3433 Red Dr.", "Alexandrai", "VA", 22310);
INSERT INTO customers(first_name, last_name, email, phone_number, street, city, state, zip_code) VALUES ("Zhane", "Vance", "zvance", "703.145.3588", "0498 Oak Dr.", "Alexandrai", "VA", 22308);
INSERT INTO customers(first_name, last_name, email, phone_number, street, city, state, zip_code) VALUES ("Reanne", "Talley", "rtalley", "703.320.8885", "5600 View St.", "Alexandrai", "VA", 22310);
INSERT INTO customers(first_name, last_name, email, phone_number, street, city, state, zip_code) VALUES ("Konnor", "Joyner", "kjyner", "703.663.1214", "4935 Sacramento Dr.", "Alexandrai", "VA", 22310);
INSERT INTO customers(first_name, last_name, email, phone_number, street, city, state, zip_code) VALUES ("Tahmid", "Gunn", "tgunn", "703.389.9956", "5509 Oak St.", "Alexandrai", "VA", 22310);
INSERT INTO customers(first_name, last_name, email, phone_number, street, city, state, zip_code) VALUES ("Jawad", "York", "jyork", "703.796.5221", "4348 Lake Rd.", "Alexandrai", "VA", 22310);
INSERT INTO customers(first_name, last_name, email, phone_number, street, city, state, zip_code) VALUES ("Ana", "Hines", "ahines", "703.626.2496", "0959 Lake Dr.", "Alexandrai", "VA", 22310);
INSERT INTO customers(first_name, last_name, email, phone_number, street, city, state, zip_code) VALUES ("Keeley", "Mills", "kmills", "703.951.2110", "2661 Hill Dr.", "Alexandrai", "VA", 22310);
INSERT INTO customers(first_name, last_name, email, phone_number, street, city, state, zip_code) VALUES ("Kenan", "Churchill", "kchurchill", "703.051.8274", "9506 Dawn Rd.", "Alexandrai", "VA", 22310);
INSERT INTO customers(first_name, last_name, email, phone_number, street, city, state, zip_code) VALUES ("Rheanna", "Ahmed", "rahmed", "703.536.4812", "2122 Sing St.", "Alexandrai", "VA", 22310);
INSERT INTO customers(first_name, last_name, email, phone_number, street, city, state, zip_code) VALUES ("Violet", "Clegg", "vclegg", "703.839.8975", "8301 Red Ave.", "Alexandrai", "VA", 22310);
INSERT INTO customers(first_name, last_name, email, phone_number, street, city, state, zip_code) VALUES ("Kieran", "Savage", "ksavage", "703.484.5862", "5684 Oak Ave.", "Alexandrai", "VA", 22308);
INSERT INTO customers(first_name, last_name, email, phone_number, street, city, state, zip_code) VALUES ("Marcia", "Meyers", "mkeyers", "703.459.0077", "9854 View Ave.", "Alexandrai", "VA", 22310);
INSERT INTO customers(first_name, last_name, email, phone_number, street, city, state, zip_code) VALUES ("Clarke", "Liu", "cliu", "703.819.7739", "3318 Sacramento St.", "Alexandrai", "VA", 22310);
INSERT INTO customers(first_name, last_name, email, phone_number, street, city, state, zip_code) VALUES ("Evelyn", "Marsh", "emarsh", "703.650.5803", "1461 Oak St.", "Alexandrai", "VA", 22310);
INSERT INTO customers(first_name, last_name, email, phone_number, street, city, state, zip_code) VALUES ("Jayden", "Lee", "jlee", "703.831.3587", "4029 Lake Dr.", "Alexandrai", "VA", 22310);
INSERT INTO customers(first_name, last_name, email, phone_number, street, city, state, zip_code) VALUES ("Kaidan", "Brooks", "kbrooks", "703.007.1429", "6298 Lake Dr.", "Alexandrai", "VA", 22310);
INSERT INTO customers(first_name, last_name, email, phone_number, street, city, state, zip_code) VALUES ("Ellen", "Donnelly", "donnelly", "703.192.4074", "7836 Hill Ave.", "Alexandrai", "VA", 22310);


CREATE TABLE jobs(
job_id              INT(5) AUTO_INCREMENT,
price               DOUBLE(8,2) CHECK (price>0),
crew_id            	INT(4) NOT NULL DEFAULT 100,
customer_id			INT(4) NOT NULL,
contractor_id		INT(4),
PRIMARY KEY (job_id),
FOREIGN KEY (crew_id) REFERENCES crews(crew_id) ON UPDATE CASCADE ON DELETE SET DEFAULT,
FOREIGN KEY (customer_id) REFERENCES customers(customer_id) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (contractor_id) REFERENCES subcontractors(contractor_id) ON UPDATE CASCADE ON DELETE SET NULL);


CREATE TABLE inventory(
inventory_id            INT(5) AUTO_INCREMENT,
name                 	VARCHAR(25) NOT NULL,
price                	DOUBLE(8,2) CHECK (price > 0) NOT NULL,
quantity            	INT(3) CHECK (quantity>0) NOT NULL,
expiration_date        	DATE,
PRIMARY KEY (inventory_id));

INSERT INTO inventory (name, price, quantity, expiration_date) VALUES ("Round-up", 15.00, 50, '2021-03-20');
INSERT INTO inventory (name, price, quantity, expiration_date) VALUES ("Mulch", 50.00, 100, NULL);
INSERT INTO inventory (name, price, quantity, expiration_date) VALUES ("Matchine oil", 10.00, 100, '2025-04-12');
INSERT INTO inventory (name, price, quantity, expiration_date) VALUES ("Gas", 2.00, 50, NULL);
INSERT INTO inventory (name, price, quantity, expiration_date) VALUES ("Grass seeds", 70.00, 50, '2022-02-02');
INSERT INTO inventory (name, price, quantity, expiration_date) VALUES ("Lawn mower belts", 25.00, 5, NULL);
INSERT INTO inventory (name, price, quantity, expiration_date) VALUES ("Lawn mower tires", 15.00, 12, NULL);
INSERT INTO inventory (name, price, quantity, expiration_date) VALUES ("Weed wacker string", 30.00, 25, NULL);
INSERT INTO inventory (name, price, quantity, expiration_date) VALUES ("Heavy duty weed killer", 30, 20, '2026-03-30');
INSERT INTO inventory (name, price, quantity, expiration_date) VALUES ("Gloves", 25, 20, NULL);
INSERT INTO inventory (name, price, quantity, expiration_date) VALUES ("Lawn fetilizer", 50, 60, '2022-06-09');
INSERT INTO inventory (name, price, quantity, expiration_date) VALUES ("Garden fetilizer", 50, 50, '2021-10-10');


CREATE TABLE job_materials(
job_id                    	INT(5),
inventory_id                INT(5),
PRIMARY KEY (job_id, inventory_id),
FOREIGN KEY(job_id) REFERENCES jobs(job_id)ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY(inventory_id) REFERENCES inventory(inventory_id) ON UPDATE CASCADE ON DELETE CASCADE);


CREATE TABLE licenses(
title               VARCHAR(50),
contractor_id		INT(4),
acquired_date		DATE NOT NULL,
expiration_date		DATE NOT NULL,
PRIMARY KEY (title, contractor_id),
FOREIGN KEY (contractor_id) REFERENCES subcontractors(contractor_id) ON UPDATE CASCADE ON DELETE CASCADE);

INSERT INTO licenses (title, contractor_id, acquired_date, expiration_date) VALUES ("Irrigation specialist", 100, '2018-01-10', '2023-01-10');
INSERT INTO licenses (title, contractor_id, acquired_date, expiration_date) VALUES ("Irrigation specialist", 102, '2016-03-22', '2021-03-22');
INSERT INTO licenses (title, contractor_id, acquired_date, expiration_date) VALUES ("Pest control specialist", 101, '2015-02-17', '2021-02-17');
INSERT INTO licenses (title, contractor_id, acquired_date, expiration_date) VALUES ("Pest control specialist", 102, '2016-03-23', '2022-03-23');
INSERT INTO licenses (title, contractor_id, acquired_date, expiration_date) VALUES ("Pest control specialist", 100, '2014-09-01', '2020-09-01');
INSERT INTO licenses (title, contractor_id, acquired_date, expiration_date) VALUES ("Hazerdest Chemical specialist", 103, '2018-11-22', '2020-11-22');
INSERT INTO licenses (title, contractor_id, acquired_date, expiration_date) VALUES ("Hazerdest Chemical specialist", 104, '2019-02-28', '2021-02-28');


UPDATE crews SET total_members =(SELECT count(*) FROM field_staff WHERE field_staff.crew_id = 100) WHERE crew_id = 100;
UPDATE crews SET total_members =(SELECT count(*) FROM field_staff WHERE field_staff.crew_id = 101) WHERE crew_id = 101;
UPDATE crews SET total_members =(SELECT count(*) FROM field_staff WHERE field_staff.crew_id = 102) WHERE crew_id = 102;
UPDATE crews SET total_members =(SELECT count(*) FROM field_staff WHERE field_staff.crew_id = 103) WHERE crew_id = 103;
UPDATE crews SET total_members =(SELECT count(*) FROM field_staff WHERE field_staff.crew_id = 104) WHERE crew_id = 104;

DELIMITER //
CREATE TRIGGER sum_crew_members_delete
AFTER DELETE ON field_staff
FOR EACH ROW
BEGIN 
    UPDATE crews SET total_members = total_members-1 WHERE crew_id = old.crew_id;
END//
DELIMITER ;

DELIMITER //
CREATE TRIGGER sum_crew_members_insert
AFTER INSERT ON field_staff
FOR EACH ROW
BEGIN 
    UPDATE crews SET total_members = total_members+1 WHERE crew_id = new.crew_id;
END//
DELIMITER ;

DELIMITER //
CREATE TRIGGER sum_crew_members_update
AFTER UPDATE ON field_staff
FOR EACH ROW
BEGIN 
	IF(old.crew_id <> new.crew_id) THEN
    	UPDATE crews SET total_members = total_members-1 WHERE crew_id = old.crew_id;
        UPDATE crews SET total_members = total_members+1 WHERE crew_id = new.crew_id;
    END IF;
END//
DELIMITER ;