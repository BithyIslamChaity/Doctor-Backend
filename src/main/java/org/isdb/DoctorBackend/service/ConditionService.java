//package org.isdb.DoctorBackend.service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import org.isdb.DoctorBackend.dto.ConditionDTO;
//import org.isdb.DoctorBackend.model.Condition;
//import org.isdb.DoctorBackend.model.PatientProfile;
//import org.isdb.DoctorBackend.repository.ConditionRepository;
//import org.isdb.DoctorBackend.repository.PatientProfileRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ConditionService {
//
//	@Autowired
//	private ConditionRepository conditionRepository;
//
//	@Autowired
//	private PatientProfileRepository patientProfileRepository;
//
//	public List<Condition> getAll() {
//		return conditionRepository.findAll();
//	}
//
//	public Condition getById(Integer id) {
//		return conditionRepository.findById(id).orElse(null);
//	}
//
//	public Condition create(ConditionDTO dto) {
//		PatientProfile patientProfile = patientProfileRepository.findById(dto.getPatientProfileId())
//				.orElseThrow(() -> new RuntimeException("Patient profile not found"));
//
//		Condition condition = new Condition();
//		condition.setPatientProfile(patientProfile);
//		condition.setConditionName(dto.getConditionName());
//		condition.setStatus(dto.getStatus());
//		condition.setDiagnosisDate(LocalDateTime.parse(dto.getDiagnosisDate()));
//		return conditionRepository.save(condition);
//	}
//
//	public Condition update(Integer id, ConditionDTO dto) {
//		Condition condition = conditionRepository.findById(id)
//				.orElseThrow(() -> new RuntimeException("Condition not found"));
//
//		condition.setConditionName(dto.getConditionName());
//		condition.setStatus(dto.getStatus());
//		condition.setDiagnosisDate(LocalDateTime.parse(dto.getDiagnosisDate()));
//		return conditionRepository.save(condition);
//	}
//
//	public void delete(Integer id) {
//		conditionRepository.deleteById(id);
//	}
//}
