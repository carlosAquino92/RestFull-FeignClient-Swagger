package com.feingVenta.feingVenta.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.feingVenta.feingVenta.dto.ProductosDTO;
import com.feingVenta.feingVenta.service.ProductosService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductosController {

	private final ProductosService productosService;
	
	@GetMapping
	public ResponseEntity<List<ProductosDTO>> getAll(){
		return  new ResponseEntity<>(productosService.getProductos() , HttpStatus.OK);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void saveProduct(@RequestBody ProductosDTO producto) {
		productosService.saveProducto(producto);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateProduct(@PathVariable("id") Integer id,@RequestBody ProductosDTO producto){
		productosService.updateProducto(id,producto);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProducto(@PathVariable("id") Integer id) {
		productosService.deleteProducto(id);
	}
	
}
