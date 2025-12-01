package co.empresa.producto_service.controllers;

import co.empresa.producto_service.exceptions.ValidationException; 
import co.empresa.producto_service.model.entities.Producto;
import co.empresa.producto_service.model.services.IProductoService;
import jakarta.validation.Valid;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/v1/producto-service")
public class ProductoRestController {

    private final IProductoService productoService;
    
    private static final String MENSAJE = "mensaje";
    private static final String PRODUCTO = "producto";
    private static final String PRODUCTOS = "productos";

    public ProductoRestController(IProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/producto/page/{page}")
    public ResponseEntity<Object> index(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 4);
        Page<Producto> productos = productoService.findAll(pageable);
        return ResponseEntity.ok(productos);
    }

    @PostMapping("/productos")
    public ResponseEntity<Map<String, Object>> save(@Valid @RequestBody Producto producto, BindingResult result) {
        if (result.hasErrors()) {
            throw new ValidationException(result);
        }

        Map<String, Object> response = new HashMap<>();
        Producto nuevoProducto = productoService.save(producto);
        response.put(MENSAJE, "El producto ha sido creado con éxito!");
        response.put(PRODUCTO, nuevoProducto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/productos")
    public void delete(@RequestBody Producto producto){
        productoService.delete(producto);
    }

    @PutMapping("/productos")
    public Producto update(@RequestBody Producto producto){
        return productoService.update(producto);
    }

    @GetMapping("/productos/{id}")
    public Producto findById(@PathVariable("id") Long id){
        return productoService.findById(id);
    }
}