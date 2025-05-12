//package org.isdb.DoctorBackend.service;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import org.isdb.DoctorBackend.dto.MedicationDTO;
//import org.isdb.DoctorBackend.model.Medication;
//import org.isdb.DoctorBackend.repository.MedicationRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MedicationService {
//
//	@Autowired
//	private MedicationRepository medicationRepository;
//
//	public List<Medication> getAll() {
//		return medicationRepository.findAll();
//	}
//
//	public Medication getById(Integer id) {
//		return medicationRepository.findById(id).orElse(null);
//	}
//
//	public Medication create(MedicationDTO dto) {
//		PatientProfile profile = patientProfileRepository.findById(dto.getPatientProfileId())
//				.orElseThrow(() -> new RuntimeException("Patient profile not found"));
//
//		Medication medication = new Medication();
//		medication.setPatientProfile(profile);
//		medication.setMedicationName(dto.getMedicationName());
//		medication.setDosage(dto.getDosage());
//		medication.setStartDate(LocalDate.parse(dto.getStartDate()));
//		medication.setEndDate(LocalDate.parse(dto.getEndDate()));
//
//		return medicationRepository.save(medication);
//	}
//
//	public Medication update(Integer id, MedicationDTO dto) {
//		Medication medication = medicationRepository.findById(id)
//				.orElseThrow(() -> new RuntimeException("Medication not found"));
//
//		medication.setMedicationName(dto.getMedicationName());
//		medication.setDosage(dto.getDosage());
//		medication.setStartDate(LocalDate.parse(dto.getStartDate()));
//		medication.setEndDate(LocalDate.parse(dto.getEndDate()));
//
//		return medicationRepository.save(medication);
//	}
//
//	public void delete(Integer id) {
//		medicationRepository.deleteById(id);
//	}
//}
