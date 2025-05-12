//package org.isdb.DoctorBackend.service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//
//import org.isdb.DoctorBackend.model.Notification;
//import org.isdb.DoctorBackend.repository.NotificationRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class NotificationService {
//
//	@Autowired
//	private NotificationRepository repository;
//
//	public List<Notification> getAll() {
//		return repository.findAll();
//	}
//
//	public Optional<Notification> getById(Long id) {
//		return repository.findById(id);
//	}
//
//	public Notification create(Notification notification) {
//		notification.setCreatedAt(LocalDateTime.now());
//		notification.setUpdatedAt(LocalDateTime.now());
//		return repository.save(notification);
//	}
//
//	public Notification update(Long id, Notification updated) {
//		return repository.findById(id).map(existing -> {
//			existing.setMessage(updated.getMessage());
//			existing.setType(updated.getType());
//			existing.setStatus(updated.getStatus());
//			existing.setAppointmentId(updated.getAppointmentId());
//			existing.setUserId(updated.getUserId());
//			existing.setUpdatedAt(LocalDateTime.now());
//			return repository.save(existing);
//		}).orElseThrow(() -> new RuntimeException("Notification not found"));
//	}
//
//	public void delete(Long id) {
//		repository.deleteById(id);
//	}
//}
