//package org.isdb.DoctorBackend.controller;
//
//import java.util.List;
//
//import org.isdb.DoctorBackend.dto.PatientProfileDTO;
//import org.isdb.DoctorBackend.model.PatientProfile;
//import org.isdb.DoctorBackend.repository.PatientProfileService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/patient-profiles")
//@CrossOrigin(origins = "*")
//public class PatientProfileController {
//
//	@Autowired
//	private PatientProfileService service;
//
//	@GetMapping
//	public List<PatientProfile> getAll() {
//		return service.getAllProfiles();
//	}
//
//	@GetMapping("/{id}")
//	public PatientProfile getById(@PathVariable Integer id) {
//		return service.getProfileById(id);
//	}
//
//	@PostMapping
//	public PatientProfile create(@RequestBody PatientProfileDTO dto) {
//		return service.createProfile(dto);
//	}
//
//	@PutMapping("/{id}")
//	public PatientProfile update(@PathVariable Integer id, @RequestBody PatientProfileDTO dto) {
//		return service.updateProfile(id, dto);
//	}
//
//	@DeleteMapping("/{id}")
//	public void delete(@PathVariable Integer id) {
//		service.deleteProfile(id);
//	}
//}