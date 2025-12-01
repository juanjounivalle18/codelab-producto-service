package co.empresa.producto_service.exceptions;

public class ProductoNoEncontradoException extends RuntimeException {
    
    public ProductoNoEncontradoException(Long id) {
        super("Producto con ID " + id + " no encontrado");
    }
}