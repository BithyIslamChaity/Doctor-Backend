//package org.isdb.DoctorBackend.controller;
//
//import java.util.List;
//
//import org.isdb.DoctorBackend.dto.ConditionDTO;
//import org.isdb.DoctorBackend.model.Condition;
//import org.isdb.DoctorBackend.service.ConditionService;
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
//@RequestMapping("/api/conditions")
//@CrossOrigin(origins = "*")
//public class ConditionController {
//
//	@Autowired
//	private ConditionService conditionService;
//
//	@GetMapping
//	public List<Condition> getAll() {
//		return conditionService.getAll();
//	}
//
//	@GetMapping("/{id}")
//	public Condition getById(@PathVariable Integer id) {
//		return conditionService.getById(id);
//	}
//
//	@PostMapping
//	public Condition create(@RequestBody ConditionDTO dto) {
//		return conditionService.create(dto);
//	}
//
//	@PutMapping("/{id}")
//	public Condition update(@PathVariable Integer id, @RequestBody ConditionDTO dto) {
//		return conditionService.update(id, dto);
//	}
//
//	@DeleteMapping("/{id}")
//	public void delete(@PathVariable Integer id) {
//		conditionService.delete(id);
//	}
//}