package com.api.sexshop.services;

import com.api.sexshop.repositories.ProductosRepository;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.List;
import java.util.Optional;

import com.api.sexshop.entities.ProductoEntity;

@Service
public class ProductoService {
    private ProductosRepository productosRepository;

    public ProductoService() {

    }

    //(GET) {READ - ALL}
    public List<ProductoEntity> getAllProductos(){
        List<ProductoEntity> productos = productosRepository.findAll();
        return productos;
    }

    //(GET) {READ - ID}
    public Optional<ProductoEntity> getProductoById(UUID id){
        Optional<ProductoEntity> productoFound = productosRepository.findById(id);
        if(productoFound.isPresent()) {
            return productoFound;
        }else{
            return Optional.empty();
        }
    }

    //(POST) {CREATE}
    public String createProducto(ProductoEntity producto){
        producto.setId(UUID.randomUUID());
        if (productosRepository.existsById(producto.getId())) {
            return "El producto ya existe";
        }else {
            productosRepository.save(producto);
            return "Producto creado con exito";
        }
    }

    //(PUT){UPDATE}
    public String updateProductoById(UUID id, ProductoEntity producto) {
        Optional<ProductoEntity> productoFound = getProductoById(id);
        if(productoFound.isPresent()) {
            productosRepository.save(producto);
            return "Producto actualizado con exito";
        }else {
            return "Producto no encontrado";
        }
    }

    //(DELETE){DELETE}
    public String deleteProductoById(UUID id) {
        Optional<ProductoEntity> productoFound = getProductoById(id);
        if(productoFound.isPresent()) {
            productosRepository.delete(productoFound.get());
            return "Producto eliminado con exito";
        }else{
            return "Producto no encontrado";
        }
    }
}
