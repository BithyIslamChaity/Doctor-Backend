package org.isdb.DoctorBackend.repository;

import java.util.List;
import java.util.Optional;

import javax.management.relation.Role;

import org.isdb.DoctorBackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

	boolean existsByEmail(String email);

	List<User> findByRole(Role role);
}