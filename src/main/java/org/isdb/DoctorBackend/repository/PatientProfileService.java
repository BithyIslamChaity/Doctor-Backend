//package org.isdb.DoctorBackend.repository;
//
//import java.util.List;
//
//import org.isdb.DoctorBackend.dto.PatientProfileDTO;
//import org.isdb.DoctorBackend.model.PatientProfile;
//import org.isdb.DoctorBackend.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PatientProfileService {
//
//	@Autowired
//	private PatientProfileRepository repository;
//
//	@Autowired
//	private UserRepository userRepository;
//
//	public List<PatientProfile> getAllProfiles() {
//		return repository.findAll();
//	}
//
//	public PatientProfile getProfileById(Integer id) {
//		return repository.findById(id).orElse(null);
//	}
//
//	public PatientProfile createProfile(PatientProfileDTO dto) {
//		User patient = userRepository.findById(dto.getPatientId())
//				.orElseThrow(() -> new RuntimeException("User not found"));
//
//		PatientProfile profile = new PatientProfile();
//		profile.setPatient(patient);
//		profile.setFullName(dto.getFullName());
//		profile.setDateOfBirth(dto.getDateOfBirth());
//		profile.setGender(dto.getGender());
//		profile.setPhoneNumber(dto.getPhoneNumber());
//		profile.setAddress(dto.getAddress());
//
//		return repository.save(profile);
//	}
//
//	public PatientProfile updateProfile(Integer id, PatientProfileDTO dto) {
//		PatientProfile existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Profile not found"));
//
//		existing.setFullName(dto.getFullName());
//		existing.setDateOfBirth(dto.getDateOfBirth());
//		existing.setGender(dto.getGender());
//		existing.setPhoneNumber(dto.getPhoneNumber());
//		existing.setAddress(dto.getAddress());
//
//		return repository.save(existing);
//	}
//
//	public void deleteProfile(Integer id) {
//		repository.deleteById(id);
//	}
//}
