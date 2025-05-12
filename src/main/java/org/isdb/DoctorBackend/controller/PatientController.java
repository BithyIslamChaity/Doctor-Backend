package org.isdb.DoctorBackend.controller;

import java.util.List;

import org.isdb.DoctorBackend.model.PatientModel;
import org.isdb.DoctorBackend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

	@Autowired
	private PatientService patientService;

	// Create a new patient
	@PostMapping
	public ResponseEntity<PatientModel> createPatient(@RequestBody PatientModel patient) {
		PatientModel createdPatient = patientService.createPatient(patient);
		return ResponseEntity.status(201).body(createdPatient); // Return status 201 for created resource
	}

	// Get all patients
	@GetMapping
	public ResponseEntity<List<PatientModel>> getAllPatients() {
		List<PatientModel> patients = patientService.getAllPatients();
		return ResponseEntity.ok(patients);
	}

	// Get patient by ID
	@GetMapping("/{id}")
	public ResponseEntity<PatientModel> getPatientById(@PathVariable Long id) {
		return patientService.getPatientById(id).map(ResponseEntity::ok) // If found, return 200 OK
				.orElse(ResponseEntity.notFound().build()); // If not found, return 404
	}

	// Update patient by ID
	@PutMapping("/{id}")
	public ResponseEntity<PatientModel> updatePatient(@PathVariable Long id, @RequestBody PatientModel patient) {
		return patientService.updatePatient(id, patient).map(ResponseEntity::ok) // If updated, return 200 OK
				.orElse(ResponseEntity.notFound().build()); // If not found, return 404
	}

	// Delete patient by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
		return patientService.deletePatient(id) ? ResponseEntity.noContent().build() : // If deleted, return 204 No
																						// Content
				ResponseEntity.notFound().build(); // If not found, return 404
	}
}
