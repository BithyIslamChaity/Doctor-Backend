//package org.isdb.DoctorBackend.service;
//
//import java.util.List;
//
//import org.isdb.DoctorBackend.dto.MedicineDTO;
//import org.isdb.DoctorBackend.model.Medicine;
//import org.isdb.DoctorBackend.repository.MedicineRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MedicineService {
//
//	@Autowired
//	private MedicineRepository medicineRepository;
//
//	public List<Medicine> getAll() {
//		return medicineRepository.findAll();
//	}
//
//	public Medicine getById(Integer id) {
//		return medicineRepository.findById(id).orElse(null);
//	}
//
//	public Medicine create(MedicineDTO dto) {
//		Medicine medicine = new Medicine();
//		medicine.setName(dto.getName());
//		medicine.setStrength(dto.getStrength());
//		medicine.setGeneric(dto.getGeneric());
//		medicine.setType(dto.getType());
//		medicine.setCompany(dto.getCompany());
//		medicine.setSNumber(dto.getSNumber());
//		return medicineRepository.save(medicine);
//	}
//
//	public Medicine update(Integer id, MedicineDTO dto) {
//		Medicine medicine = medicineRepository.findById(id)
//				.orElseThrow(() -> new RuntimeException("Medicine not found"));
//
//		medicine.setName(dto.getName());
//		medicine.setStrength(dto.getStrength());
//		medicine.setGeneric(dto.getGeneric());
//		medicine.setType(dto.getType());
//		medicine.setCompany(dto.getCompany());
//		medicine.setSNumber(dto.getSNumber());
//		return medicineRepository.save(medicine);
//	}
//
//	public void delete(Integer id) {
//		medicineRepository.deleteById(id);
//	}
//}