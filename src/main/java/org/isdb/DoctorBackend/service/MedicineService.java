package org.isdb.DoctorBackend.service;

import java.util.List;

import org.isdb.DoctorBackend.model.Medicine;
import org.isdb.DoctorBackend.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineService {

	@Autowired
	private MedicineRepository medicineRepository;

	public Medicine createMedicine(Medicine medicine) {
		return medicineRepository.save(medicine);
	}

	public List<Medicine> getAllMedicines() {
		return medicineRepository.findAll();
	}

	public Medicine getMedicineById(Long id) {
		return medicineRepository.findById(id).orElseThrow(() -> new RuntimeException("Medicine not found"));
	}

	public Medicine updateMedicine(Long id, Medicine updatedMedicine) {
		Medicine medicine = medicineRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Medicine not found"));

		medicine.setName(updatedMedicine.getName());
		medicine.setStrength(updatedMedicine.getStrength());
		medicine.setGeneric(updatedMedicine.getGeneric());
		medicine.setType(updatedMedicine.getType());
		medicine.setCompany(updatedMedicine.getCompany());

		return medicineRepository.save(medicine);
	}

	public void deleteMedicine(Long id) {
		if (!medicineRepository.existsById(id)) {
			throw new RuntimeException("Medicine not found");
		}
		medicineRepository.deleteById(id);
	}
}
