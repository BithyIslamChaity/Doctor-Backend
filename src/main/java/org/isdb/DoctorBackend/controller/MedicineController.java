//package org.isdb.DoctorBackend.controller;
//
//import java.util.List;
//
//import org.isdb.DoctorBackend.dto.MedicineDTO;
//import org.isdb.DoctorBackend.model.Medicine;
//import org.isdb.DoctorBackend.service.MedicineService;
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
//@RequestMapping("/api/medicines")
//@CrossOrigin(origins = "*")
//public class MedicineController {
//
//	@Autowired
//	private MedicineService medicineService;
//
//	@GetMapping
//	public List<Medicine> getAll() {
//		return medicineService.getAll();
//	}
//
//	@GetMapping("/{id}")
//	public Medicine getById(@PathVariable Integer id) {
//		return medicineService.getById(id);
//	}
//
//	@PostMapping
//	public Medicine create(@RequestBody MedicineDTO dto) {
//		return medicineService.create(dto);
//	}
//
//	@PutMapping("/{id}")
//	public Medicine update(@PathVariable Integer id, @RequestBody MedicineDTO dto) {
//		return medicineService.update(id, dto);
//	}
//
//	@DeleteMapping("/{id}")
//	public void delete(@PathVariable Integer id) {
//		medicineService.delete(id);
//	}
//}