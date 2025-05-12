package org.isdb.DoctorBackend.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.isdb.DoctorBackend.model.DoctorModel;
import org.isdb.DoctorBackend.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	// Create a new doctor
	public DoctorModel createDoctor(DoctorModel doctor) {
		doctor.setCreatedAt(LocalDateTime.now());
		doctor.setUpdatedAt(LocalDateTime.now());
		return doctorRepository.save(doctor);
	}

	// Get all doctors
	public List<DoctorModel> getAllDoctors() {
		return doctorRepository.findAll();
	}

	// Get doctor by ID
	public Optional<DoctorModel> getDoctorById(Integer id) {
		return doctorRepository.findById(id);
	}

	// Update doctor
	public Optional<DoctorModel> updateDoctor(Integer id, DoctorModel updatedDoctor) {
		return doctorRepository.findById(id).map(doctor -> {
			doctor.setName(updatedDoctor.getName());
			doctor.setEmail(updatedDoctor.getEmail());
			doctor.setPhone(updatedDoctor.getPhone());
			doctor.setAddress(updatedDoctor.getAddress());
			doctor.setSpecialty(updatedDoctor.getSpecialty());
			doctor.setYearsOfExperience(updatedDoctor.getYearsOfExperience());
			doctor.setUpdatedAt(LocalDateTime.now());
			return doctorRepository.save(doctor);
		});
	}

	// Delete doctor
	public boolean deleteDoctor(Integer id) {
		if (doctorRepository.existsById(id)) {
			doctorRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
