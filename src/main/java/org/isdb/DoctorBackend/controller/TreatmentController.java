//package org.isdb.DoctorBackend.controller;
//
//import java.util.List;
//
//import org.isdb.DoctorBackend.dto.TreatmentDTO;
//import org.isdb.DoctorBackend.model.Treatment;
//import org.isdb.DoctorBackend.service.TreatmentService;
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
//@RequestMapping("/api/treatments")
//@CrossOrigin(origins = "*")
//public class TreatmentController {
//
//	@Autowired
//	private TreatmentService service;
//
//	@GetMapping
//	public List<Treatment> getAll() {
//		return service.getAll();
//	}
//
//	@GetMapping("/{id}")
//	public Treatment getById(@PathVariable Integer id) {
//		return service.getById(id).orElseThrow(() -> new RuntimeException("Treatment not found"));
//	}
//
//	@PostMapping
//	public Treatment create(@RequestBody TreatmentDTO dto) {
//		return service.create(dto);
//	}
//
//	@PutMapping("/{id}")
//	public Treatment update(@PathVariable Integer id, @RequestBody TreatmentDTO dto) {
//		return service.update(id, dto);
//	}
//
//	@DeleteMapping("/{id}")
//	public void delete(@PathVariable Integer id) {
//		service.delete(id);
//	}
//}
