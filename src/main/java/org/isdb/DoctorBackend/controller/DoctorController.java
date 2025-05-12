package org.isdb.DoctorBackend.controller;

import java.util.List;

import org.isdb.DoctorBackend.model.DoctorModel;
import org.isdb.DoctorBackend.service.DoctorService;
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
@RequestMapping("/api/doctors")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@PostMapping
	public ResponseEntity<DoctorModel> createDoctor(@RequestBody DoctorModel doctor) {
		return ResponseEntity.ok(doctorService.createDoctor(doctor));
	}

	@GetMapping
	public ResponseEntity<List<DoctorModel>> getAllDoctors() {
		return ResponseEntity.ok(doctorService.getAllDoctors());
	}

	@GetMapping("/{id}")
	public ResponseEntity<DoctorModel> getDoctorById(@PathVariable Integer id) {
		return doctorService.getDoctorById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<DoctorModel> updateDoctor(@PathVariable Integer id, @RequestBody DoctorModel doctor) {
		return doctorService.updateDoctor(id, doctor).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDoctor(@PathVariable Integer id) {
		boolean deleted = doctorService.deleteDoctor(id);
		return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	}
}
