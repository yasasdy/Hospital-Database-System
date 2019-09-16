create table hospital(
	hos_id int NOT NULL,
	name varchar(30),
	address varchar(100),
	type varchar(30),
	constraint pk_hospital PRIMARY KEY (hos_id)
);
create table staff(
	sta_id int NOT NULL,
	type varchar(30),
	name varchar(30),
	age smallint,
	salary int,
	mobile varchar(15),
	gender char(6),
	hos_id int,
	constraint pk_staff PRIMARY KEY (sta_id)
);
create table doctor(
	doc_id int NOt NULL,
	dep_id int,
	type varchar(30),
	constraint pk_doctor PRIMARY KEY (doc_id)
);
create table surgeon(
	sur_id int NOT NULL,
	specialization varchar(50),
	constraint pk_surgeon PRIMARY KEY (sur_id)
);
create table operation(
	ope_id int NOT NULL,
	pat_id int,
	sur_id int,
	bill int,
	constraint pk_operation PRIMARY KEY (ope_id)
);
create table physician(
	phy_id int NOT NULL,
	type varchar(30),
	constraint pk_physician PRIMARY KEY (phy_id)
);
create table receptionist(
	rec_id int NOT NULL,
	constraint pk_receptionist PRIMARY KEY (rec_id)
);
create table nurse(
	nur_id int NOT NULL,
	constraint pk_nurse PRIMARY KEY (nur_id)
);
create table patient(
	pat_id int NOT NULL,
	name varchar(30),
	age smallint,
	gender char(6),
	address varchar(100),
	constraint pk_patient PRIMARY KEY (pat_id)
);
create table out_patient(
	out_pat_id int NOT NULL,
	constraint pk_out_patient PRIMARY KEY (out_pat_id)
);
create table in_patient(
	in_pat_id int NOT NULL,
	room_no char(10),
	constraint pk_out_patient PRIMARY KEY (in_pat_id)
);
create table consultation(
	con_id int NOT NULL,
	phy_id int,
	pat_id int NOT NULL,
	symptoms varchar(100),
	constraint pk_consultation PRIMARY KEY (con_id)
);
create table  prescription(
	pre_id int NOT NULL,
	con_id int NOT NULL,
	pres_date date,
	constraint pk_prescription PRIMARY KEY (pre_id)
);
create table medication(
	med_id int NOT NULL,
	pre_id int NOT NULL,
	med_name varchar(50),
	dosage varchar(50),
	constraint pk_medication PRIMARY KEY (med_id)
);
create table registration(
	reg_id int NOT NULL,
	reg_date date,
	pat_id int NOT NULL,
	constraint pk_registration PRIMARY KEY (reg_id)
);
create table visit(
	vis_id int NOT NULL,
	visit_date date,
	pat_id int,
	constraint pk_visit PRIMARY KEY (vis_id)
);
create table diagnosis(
	test_id int NOT NULL,
	test_name varchar(30),
	test_results varchar(100),
	vis_id int NOT NULL,
	constraint pk_diagnosis PRIMARY KEY (test_id)
);
create table department(
	dep_id int NOT NULL,
	name varchar(30),
	constraint pk_department PRIMARY KEY (dep_id)
);
create table reports(
	rep_id int NOT NULL,
	pat_id int,
	rec_id int,
	doc_id int,
	report varchar(30),
	constraint pk_reports PRIMARY KEY (rep_id)
);
create table room(
	room_no char(10) NOT NULL,
	no_of_beds int,
	nur_id int,
	constraint pk_room PRIMARY KEY (room_no)
);
create table bills(
	bil_id int NOT NULL,
	pat_id int,
	amount int,
	bill_date date,
	constraint pk_bill PRIMARY KEY (bil_id)
);
create table hos_pat(
	hos_pat_id int NOT NULL AUTO_INCREMENT,
	hos_id int,
	pat_id int,
	constraint pk_hos_pat PRIMARY KEY (hos_pat_id)
);
