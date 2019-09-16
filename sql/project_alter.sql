alter table registration
	add constraint fk_red_pat_id FOREIGN KEY (pat_id)
REFERENCES patient(pat_id) ON DELETE CASCADE;

alter table in_patient
	add constraint fk_in_pat_id FOREIGN KEY (in_pat_id)
REFERENCES patient(pat_id) ON DELETE CASCADE;

alter table out_patient
	add constraint fk_out_pat_id FOREIGN KEY (out_pat_id)
REFERENCES patient(pat_id) ON DELETE CASCADE;

alter table visit
	add constraint fk_vis_pat_id FOREIGN KEY (pat_id)
REFERENCES patient(pat_id);

alter table in_patient
	add constraint fk_room_no FOREIGN KEY (room_no)
REFERENCES room(room_no);

alter table staff
	add constraint fk_sta_hos_id FOREIGN KEY (hos_id)
REFERENCES hospital(hos_id) ON DELETE SET NULL;

alter table receptionist
	add constraint fk_rec_id FOREIGN KEY (rec_id)
REFERENCES staff(sta_id) ON DELETE CASCADE;

alter table nurse
	add constraint fk_nur_id FOREIGN KEY (nur_id)
REFERENCES staff(sta_id) ON DELETE CASCADE;

alter table doctor
	add constraint fk_doc_id FOREIGN KEY (doc_id)
REFERENCES staff(sta_id) ON DELETE CASCADE;

alter table doctor
	add constraint fk_doc_dept_id FOREIGN KEY (dep_id)
REFERENCES department(dep_id) ON DELETE SET NULL;

alter table room
	add constraint fk_room_nur_id FOREIGN KEY (nur_id)
REFERENCES nurse(nur_id);

alter table diagnosis
	add constraint fk_diag_id FOREIGN KEY (vis_id)
REFERENCES visit(vis_id) ON DELETE CASCADE;

alter table physician
	add constraint fk_phy_id FOREIGN KEY (phy_id)
REFERENCES doctor(doc_id) ON DELETE CASCADE;

alter table surgeon
	add constraint fk_sur_id FOREIGN KEY (sur_id)
REFERENCES doctor(doc_id) ON DELETE CASCADE;

alter table consultation
	add constraint fk_con_phy_id FOREIGN KEY (phy_id)
REFERENCES physician(phy_id);

alter table consultation
	add constraint fk_con_pat_id FOREIGN KEY (pat_id)
REFERENCES out_patient(out_pat_id) ON DELETE CASCADE;

alter table prescription
	add constraint fk_pres_id FOREIGN KEY (con_id)
REFERENCES consultation(con_id) ON DELETE CASCADE;

alter table medication
	add constraint fk_med_id FOREIGN KEY (pre_id)
REFERENCES prescription(pre_id) ON DELETE CASCADE;

alter table operation
	add constraint fk_op_pat_id FOREIGN KEY (pat_id)
REFERENCES in_patient(in_pat_id);

alter table operation
	add constraint fk_op_sur_id FOREIGN KEY (sur_id)
REFERENCES surgeon(sur_id);

alter table reports
	add constraint fk_pat_rep_id FOREIGN KEY (pat_id)
REFERENCES patient(pat_id);

alter table reports
	add constraint fk_doc_rep_id FOREIGN KEY (doc_id)
REFERENCES doctor(doc_id);

alter table reports
	add constraint fk_rec_rep_id FOREIGN KEY (rec_id)
REFERENCES receptionist(rec_id);

alter table bills
	add constraint fk_pat_bil_id FOREIGN KEY (pat_id)
REFERENCES patient(pat_id);

alter table hos_pat
	add constraint fk_pat_id FOREIGN KEY (pat_id)
REFERENCES patient(pat_id);

alter table hos_pat
	add constraint fk_hos_id FOREIGN KEY (hos_id)
REFERENCES hospital(hos_id);
