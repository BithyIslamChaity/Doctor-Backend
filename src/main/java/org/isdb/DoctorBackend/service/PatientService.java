package org.isdb.DoctorBackend.service;

import java.util.List;
import java.util.Optional;

import org.isdb.DoctorBackend.model.PatientModel;
import org.isdb.DoctorBackend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	// Create a new patient
	public PatientModel createPatient(PatientModel patient) {

		return patientRepository.save(patient);
	}

	// Get all patients
	public List<PatientModel> getAllPatients() {
		return patientRepository.findAll();
	}

	// Get patient by ID
	public Optional<PatientModel> getPatientById(Long id) {
		return patientRepository.findById(id);
	}

	// Update patient details
	public Optional<PatientModel> updatePatient(Long id, PatientModel updatedPatient) {
		return patientRepository.findById(id).map(patient -> {
			patient.setName(updatedPatient.getName());
			patient.setEmail(updatedPatient.getEmail());
			patient.setAge(updatedPatient.getAge());
			patient.setMedicalHistory(updatedPatient.getMedicalHistory());

			return patientRepository.save(patient);
		});
	}

	// Delete patient by ID
	public boolean deletePatient(Long id) {
		if (patientRepository.existsById(id)) {
			patientRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
