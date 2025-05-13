package org.isdb.DoctorBackend.controller;

import java.util.List;

import org.isdb.DoctorBackend.model.Medicine;
import org.isdb.DoctorBackend.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/medicines")
@CrossOrigin(origins = "*") // Allow frontend access
public class MedicineController {

	@Autowired
	private MedicineService medicineService;

	@PostMapping
	public Medicine createMedicine(@RequestBody Medicine medicine) {
		return medicineService.createMedicine(medicine);
	}

	@GetMapping
	public List<Medicine> getAllMedicines() {
		return medicineService.getAllMedicines();
	}

	@GetMapping("/{id}")
	public Medicine getMedicineById(@PathVariable Long id) {
		return medicineService.getMedicineById(id);
	}

	@PutMapping("/{id}")
	public Medicine updateMedicine(@PathVariable Long id, @RequestBody Medicine medicine) {
		return medicineService.updateMedicine(id, medicine);
	}

	@DeleteMapping("/{id}")
	public void deleteMedicine(@PathVariable Long id) {
		medicineService.deleteMedicine(id);
	}
}
