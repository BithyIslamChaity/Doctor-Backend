package org.isdb.DoctorBackend.service;

import java.util.List;
import java.util.Optional;

import org.isdb.DoctorBackend.dto.PrescriptionDTO;
import org.isdb.DoctorBackend.model.Prescription;
import org.isdb.DoctorBackend.model.User;
import org.isdb.DoctorBackend.repository.PrescriptionRepository;
import org.isdb.DoctorBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionService {
	@Autowired
	private PrescriptionRepository prescriptionRepository;

	@Autowired
	private UserRepository userRepository;

	public Prescription createPrescription(PrescriptionDTO prescriptionDTO) {
		User doctor = userRepository.findById(prescriptionDTO.getDoctorId())
				.orElseThrow(() -> new RuntimeException("Doctor not found"));
		User patient = userRepository.findById(prescriptionDTO.getPatientId())
				.orElseThrow(() -> new RuntimeException("Patient not found"));

		Prescription prescription = new Prescription();
		prescription.setDoctorId(doctor);
		prescription.setPatientId(patient);
		prescription.setMedicineName(prescriptionDTO.getMedicineName());
		prescription.setMedicineDosage(prescriptionDTO.getMedicineDosage());
		prescription.setDuration(prescriptionDTO.getDuration());

		return prescriptionRepository.save(prescription);
	}

	public List<Prescription> getAllPrescriptions() {
		return prescriptionRepository.findAll();
	}

	public Optional<Prescription> getPrescriptionById(Long id) {
		return prescriptionRepository.findById(id);
	}

	public Prescription updatePrescription(Long id, PrescriptionDTO dto) {
		Prescription existing = prescriptionRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Prescription not found"));

		User doctor = userRepository.findById(dto.getDoctorId())
				.orElseThrow(() -> new RuntimeException("Doctor not found"));
		User patient = userRepository.findById(dto.getPatientId())
				.orElseThrow(() -> new RuntimeException("Patient not found"));

		existing.setDoctorId(doctor);
		existing.setPatientId(patient);
		existing.setMedicineName(dto.getMedicineName());
		existing.setMedicineDosage(dto.getMedicineDosage());
		existing.setDuration(dto.getDuration());

		return prescriptionRepository.save(existing);
	}

	public void deletePrescription(Long id) {
		if (!prescriptionRepository.existsById(id)) {
			throw new RuntimeException("Prescription not found");
		}
		prescriptionRepository.deleteById(id);
	}
}
