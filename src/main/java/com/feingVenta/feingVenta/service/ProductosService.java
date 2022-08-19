package com.feingVenta.feingVenta.service;
import com.feingVenta.feingVenta.client.ProductosFeignClient;
import com.feingVenta.feingVenta.dto.ProductosDTO;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductosService {

	private final ProductosFeignClient productosFeignClient;
	
	public List<ProductosDTO> getProductos(){
		return productosFeignClient.getProductos();
	}
	
	public void saveProducto(ProductosDTO produto) {
		productosFeignClient.saveProducto(produto);
	}
	
	
	public void updateProducto(Integer id,ProductosDTO producto) {
		productosFeignClient.updateProductos(id, producto);
	}
	public void deleteProducto(Integer id) {
		productosFeignClient.deleteProducto(id);
	}
	
	
}
