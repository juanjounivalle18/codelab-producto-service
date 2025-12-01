package co.empresa.producto_service.model.services;

import co.empresa.producto_service.model.entities.Producto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 * Interface que define los métodos que se pueden realizar sobre la entidad Producto
 */
public interface IProductoService {
    Producto save(Producto producto);
    void delete(Producto producto);
    Producto findById(Long id);
    Producto update(Producto producto);
    Page<Producto> findAll(Pageable pageable);
}