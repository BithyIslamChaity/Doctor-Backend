//package org.isdb.DoctorBackend.controller;
//
//import java.util.List;
//
//import org.isdb.DoctorBackend.dto.MedicationDTO;
//import org.isdb.DoctorBackend.model.Medication;
//import org.isdb.DoctorBackend.service.MedicationService;
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
//@RequestMapping("/api/medications")
//@CrossOrigin(origins = "*")
//public class MedicationController {
//
//	@Autowired
//	private MedicationService medicationService;
//
//	@GetMapping
//	public List<Medication> getAll() {
//		return medicationService.getAll();
//	}
//
//	@GetMapping("/{id}")
//	public Medication getById(@PathVariable Integer id) {
//		return medicationService.getById(id);
//	}
//
//	@PostMapping
//	public Medication create(@RequestBody MedicationDTO dto) {
//		return medicationService.create(dto);
//	}
//
//	@PutMapping("/{id}")
//	public Medication update(@PathVariable Integer id, @RequestBody MedicationDTO dto) {
//		return medicationService.update(id, dto);
//	}
//
//	@DeleteMapping("/{id}")
//	public void delete(@PathVariable Integer id) {
//		medicationService.delete(id);
//	}
//}