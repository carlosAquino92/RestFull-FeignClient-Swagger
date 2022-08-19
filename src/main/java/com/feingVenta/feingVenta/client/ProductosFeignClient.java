package com.feingVenta.feingVenta.client;

import java.nio.file.Path;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.feingVenta.feingVenta.config.FeignClientConfig;
import com.feingVenta.feingVenta.dto.ProductosDTO;

@FeignClient(name="PRODUCTOS-MOCK-API",url="${external.mock.api.base-url}",configuration = FeignClientConfig.class)
public interface ProductosFeignClient {
	
	@GetMapping(value="/productos", consumes = MediaType.APPLICATION_JSON_VALUE)
	List<ProductosDTO> getProductos();
	
	@PostMapping(value="/productos", consumes = MediaType.APPLICATION_JSON_VALUE)
	ProductosDTO saveProducto(@RequestBody ProductosDTO producto);
	
	
	@PutMapping(value="/productos/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	ProductosDTO updateProductos(@PathVariable("id")Integer id,@RequestBody ProductosDTO producto);
	
	@DeleteMapping(value="/productos/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	ProductosDTO deleteProducto(@PathVariable("id") Integer id);
}