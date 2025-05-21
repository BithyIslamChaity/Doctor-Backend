package org.isdb.DoctorBackend.controller;

import java.util.List;

import org.isdb.DoctorBackend.dto.PrescriptionDTO;
import org.isdb.DoctorBackend.model.Prescription;
import org.isdb.DoctorBackend.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

	@Autowired
	private PrescriptionService prescriptionService;

	@PostMapping
	public ResponseEntity<Prescription> createPrescription(@RequestBody PrescriptionDTO prescriptionDTO) {
		Prescription created = prescriptionService.createPrescription(prescriptionDTO);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Prescription>> getAllPrescriptions() {
		return ResponseEntity.ok(prescriptionService.getAllPrescriptions());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Prescription> getPrescriptionById(@PathVariable Long id) {
		return prescriptionService.getPrescriptionById(id).map(ResponseEntity::ok)
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Prescription> updatePrescription(@PathVariable Long id,
			@RequestBody PrescriptionDTO prescriptionDTO) {
		try {
			Prescription updated = prescriptionService.updatePrescription(id, prescriptionDTO);
			return ResponseEntity.ok(updated);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePrescription(@PathVariable Long id) {
		try {
			prescriptionService.deletePrescription(id);
			return ResponseEntity.noContent().build();
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}