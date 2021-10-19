package tech.tonilr.managerempleados.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.tonilr.managerempleados.entitys.Empleado;

@Repository
public interface EmpleadoRepo extends JpaRepository<Empleado, Long> {

	void deleteEmpleadoById(Long id);

	Optional<Empleado>  findEmpleadoById(Long id);

}
