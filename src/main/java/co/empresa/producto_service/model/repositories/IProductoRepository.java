package co.empresa.producto_service.model.repositories;

import co.empresa.producto_service.model.entities.Producto;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface que hereda de CrudRepository para realizar las
 * operaciones de CRUD sobre la entidad Producto
 */
public interface IProductoRepository extends JpaRepository<Producto, Long> {
}