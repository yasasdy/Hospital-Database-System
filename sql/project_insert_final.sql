insert into hospital(hos_id,name,address,type) VALUES
(1,'Apollo','731 Fondren, Houston, TX','Center Cancer '),
(2,'Narayana Hdrudhayalaya','638 Fondren, Houston, TX','Eye Care'),
(3,'Kims','3321 Fondren, Houston, TX','Children Hospital');

insert into staff(sta_id,type,name,age,salary,mobile,gender,hos_id) VALUES
  (99901,'Doctor','Smith',35,80000,9876543210,'M',3),
  (99902,'Doctor','Franklin',42,90000,9998887770,'M',2),
  (99903,'Doctor','Alicia',32,60000,9988776655,'F',1),
  (99971,'Receptionist','Wong',27,15000,8765432109,'F',1),
  (99972,'Receptionist','Zelaya',23,12000,9848282878,'F',2),
  (99973,'Receptionist','Ramesh',22,12000,9987879987,'M',3),
  (99951,'Nurse','Jennifer',21,9000,9987879980,'F',3),
  (99952,'Nurse','Wallace',27,17000,8979695949,'F',2),
  (99953,'Nurse','English',24,14000,8979695940,'F',1);

insert into patient(pat_id,name,age,gender,address) VALUES
  (1,'Yasasvi', 19 ,'M','IIIT-B Bengalore'),
  (2,'Jon Snow', 29 ,'M','Winterfell'),
  (3,'Jaime Lannister', 40 ,'M','Kings Landing'),
  (4,'Cersei Lannister', 38 ,'F','Kings Landing'),
  (5,'Denarys Targerian', 25 ,'F','Dragon Stone'),
  (6,'Arya Stark', 19 ,'F','Winterfell');

INSERT INTO receptionist(rec_id) VALUES
  (99971),
  (99972),
  (99973);

insert into nurse(nur_id)VALUES
  (99951),
  (99952),
  (99953);

insert into hos_pat(hos_id,pat_id) VALUES
  (1,1),
  (1,4),
  (2,2),
  (2,5),
  (3,3),
  (3,6);

insert into room(room_no,no_of_beds,nur_id)VALUES
  ('C301',5,99951),
  ('L302',3,99952),
  ('P303',1,99953);

insert into registration(reg_id,reg_date,pat_id)VALUES
  (1011,'2010-01-01',1),
  (1012,'2011-10-10',2),
  (1013,'2011-01-01',3),
  (1014,'2013-01-01',4),
  (1015,'2012-01-01',5),
  (1016,'2009-01-01',6);

insert into visit(vis_id,visit_date,pat_id)VALUES
  (54711,'2013-01-01',1),
  (54712,'2012-01-01',2),
  (54713,'2011-01-01',3),
  (54714,'2015-01-01',4),
  (54715,'2014-01-01',5),
  (54716,'2016-01-01',6);

insert into diagnosis(test_id,test_name,test_results,vis_id)VALUES
  (66391,'Blood Count','+ve',54711),
  (66392,'Bone Density Study','+ve',54712),
  (66393,'Electrocardiogram','-ve',54713),
  (66394,'CAT Scan','-ve',54714),
  (66395,'MRI','+ve',54715),
  (66396,'Sugar Test','+ve',54716);

insert into in_patient(in_pat_id,room_no) VALUES
  (1,'C301'),
  (2,'L302'),
  (3,'P303');

insert into out_patient(out_pat_id) VALUES
  (4),
  (5),
  (6);

INSERT INTO department(dep_id, name) VALUES
  (11, 'Heart'),
  (66, 'ENT'),
  (21, 'General');

INSERT INTO doctor(doc_id, dep_id, type) VALUES
  (99901, 11, 'Surgeon'),
  (99902, 66, 'Surgeon'),
  (99903, 21, 'Physician');

INSERT INTO physician(phy_id, type) VALUES
  (99903, 'General');

insert into surgeon(sur_id, specialization) VALUES
  (99901, 'Cardiologist'),
  (99902, 'Oral');
  
insert into operation(ope_id, pat_id, sur_id, bill) VALUES  
  (66601, 1, 99901, 77701),
  (66602, 2, 99902, 77702),
  (66603, 3, 99902, 77703);



insert into bills(bil_id, pat_id, amount, bill_date) VALUES
  (77701, 1, 2000, '2013-01-01'),
  (77710, 1, 2500, '2017-01-01'),
  (77702, 2, 3000, '2012-01-01'),
  (77703, 3, 60000, '2011-01-01'),
  (77704, 4, 4000, '2015-01-01'),
  (77705, 5, 50000, '2014-01-01'),
  (77706, 6, 1000, '2016-01-01');
 
insert into reports(rep_id, pat_id, rec_id, doc_id, report) VALUES
  (55551, 1, 99971, 99901,  'Spine and Muscular problem'),
  (55554, 1, 99971, 99904,  'Asthma'),
  (55552, 2, 99972, 99902, 'Rectal bowel problem'),
  (55553, 4, 99973, 99903, 'Child Birth');

INSERT INTO consultation(con_id, phy_id, pat_id, symptoms) VALUES
  (70001, 99903, 4, 'Fever'),
  (70002, 99903, 5, 'Cold'),
  (70003, 99903, 6, 'Cough');

INSERT INTO prescription(pre_id, con_id, pres_date) VALUES
  (80001, 70001, '1993-02-01'),
  (80002, 70002, '1995-05-04'),
  (80003, 70003, '1998-07-06');

INSERT INTO medication(med_id, pre_id, med_name, dosage) VALUES
  (90001, 80001, 'Paracetamol', '200 gm'),
  (90002, 80002, 'Citrigen', '200 mg'),
  (90003, 80003, 'Amoxylin', '300mg');

