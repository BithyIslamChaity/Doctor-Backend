//package org.isdb.DoctorBackend.controller;
//
//import java.util.List;
//
//import org.isdb.DoctorBackend.model.Notification;
//import org.isdb.DoctorBackend.service.NotificationService;
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
//@RequestMapping("/api/notifications")
//@CrossOrigin(origins = "*")
//public class NotificationController {
//
//	@Autowired
//	private NotificationService service;
//
//	@GetMapping
//	public List<Notification> getAll() {
//		return service.getAll();
//	}
//
//	@GetMapping("/{id}")
//	public Notification getById(@PathVariable Long id) {
//		return service.getById(id).orElseThrow(() -> new RuntimeException("Notification not found"));
//	}
//
//	@PostMapping
//	public Notification create(@RequestBody Notification notification) {
//		return service.create(notification);
//	}
//
//	@PutMapping("/{id}")
//	public Notification update(@PathVariable Long id, @RequestBody Notification notification) {
//		return service.update(id, notification);
//	}
//
//	@DeleteMapping("/{id}")
//	public void delete(@PathVariable Long id) {
//		service.delete(id);
//	}
//}
