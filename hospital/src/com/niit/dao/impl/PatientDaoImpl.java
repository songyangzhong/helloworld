package com.niit.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.niit.dao.IPatientDao;
import com.niit.model.Patient;
import com.niit.model.Patient_Inspect;
import com.niit.web.form.PatientForm;

@Repository
public class PatientDaoImpl extends BaseDaoImpl<Patient> implements IPatientDao {

	@Override
	public Patient login(PatientForm patientForm) {
		String patientName = patientForm.getPatientName();
		String queryString = "from " + super.getClassName() + " p where p.patientName=?";
		Object[] objects = new Object[] { patientName };
		List<Patient> patients = (List<Patient>) ht.find(queryString, objects);
		Patient patient = null;
		if (!patients.isEmpty()) {
			patient = patients.get(0);
		}
		return patient;
	}

	@Override
	public List<Object[]> findInspectByPatientId(final int patientId) {
		final String sql = "SELECT" + "	pi.inspectId as inspectId,pi.patientId as patientId,p.PatientName as PatientName,i.InspectName as InspectName,pi.result AS result " + "FROM" + "	patient_inspect pi "
				+ "JOIN t_patient p ON pi.patientId = p.PatientId " + "JOIN t_inspect i ON pi.inspectId = i.InspectId "
				+ "AND pi.patientId = ?";
		List<Object[]> list = (List<Object[]>) ht.execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createSQLQuery(sql);
				query.setParameter(0, patientId);
				return query.list();
			}

		});
		return list;
	}

}
