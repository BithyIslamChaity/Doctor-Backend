//package org.isdb.DoctorBackend.service;
//
//import java.sql.Timestamp;
//import java.time.Instant;
//import java.util.List;
//import java.util.Optional;
//
//import org.isdb.DoctorBackend.dto.TreatmentDTO;
//import org.isdb.DoctorBackend.model.Treatment;
//import org.isdb.DoctorBackend.repository.TreatmentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class TreatmentService {
//
//	@Autowired
//	private TreatmentRepository treatmentRepository;
//
//	@Autowired
//	private PatientProfileRepository patientProfileRepository;
//
//	public List<Treatment> getAll() {
//		return treatmentRepository.findAll();
//	}
//
//	public Optional<Treatment> getById(Integer id) {
//		return treatmentRepository.findById(id);
//	}
//
//	public Treatment create(TreatmentDTO dto) {
//		Treatment treatment = new Treatment();
//		treatment.setPatientProfile(patientProfileRepository.findById(dto.getPatientProfileId())
//				.orElseThrow(() -> new RuntimeException("Patient profile not found")));
//		treatment.setTreatmentName(dto.getTreatmentName());
//		treatment.setStartDate(dto.getStartDate());
//		treatment.setEndDate(dto.getEndDate());
//		treatment.setTreatmentNotes(dto.getTreatmentNotes());
//		treatment.setCreatedAt(Timestamp.from(Instant.now()));
//		treatment.setUpdatedAt(Timestamp.from(Instant.now()));
//		return treatmentRepository.save(treatment);
//	}
//
//	public Treatment update(Integer id, TreatmentDTO dto) {
//		return treatmentRepository.findById(id).map(existing -> {
//			existing.setPatientProfile(patientProfileRepository.findById(dto.getPatientProfileId())
//					.orElseThrow(() -> new RuntimeException("Patient profile not found")));
//			existing.setTreatmentName(dto.getTreatmentName());
//			existing.setStartDate(dto.getStartDate());
//			existing.setEndDate(dto.getEndDate());
//			existing.setTreatmentNotes(dto.getTreatmentNotes());
//			existing.setUpdatedAt(Timestamp.from(Instant.now()));
//			return treatmentRepository.save(existing);
//		}).orElseThrow(() -> new RuntimeException("Treatment not found"));
//	}
//
//	public void delete(Integer id) {
//		treatmentRepository.deleteById(id);
//	}
//}
