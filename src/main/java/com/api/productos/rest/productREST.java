package com.api.productos.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.productos.dao.ProductsDAO;
import com.api.productos.entity.Product;

@RestController
//da acceso a la ruta localhost:4200
@CrossOrigin(origins ="http://localhost:4200")
//muestra información en la ruta http://localhost:8080/products
@RequestMapping("products")
public class productREST {
	
	@Autowired
	private ProductsDAO productDAO;
	
	
	@GetMapping //muestra todos los productos
	public ResponseEntity<List<Product>> getProduct(){
		List<Product> products = productDAO.findAll();
		return ResponseEntity.ok(products);
	}
	
	@RequestMapping(value="{productId}") //busca producto por id
	public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId){
		Optional<Product> optProduct = productDAO.findById(productId);
		if(!optProduct.isPresent()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(optProduct.get());
		}
		
	}
	
	
	@PostMapping //agregar producto
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		Product newProduct = productDAO.save(product);
		return ResponseEntity.ok(newProduct);
	}
	
	@DeleteMapping(value ="{productId}") //elimina un producto por id
	public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Long productId){
		productDAO.deleteById(productId);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping
	public ResponseEntity<Product> updateProduct(@RequestBody Product product){
		Optional<Product> optProduct = productDAO.findById(product.getIdProducto());
		if(!optProduct.isPresent()) {
			return ResponseEntity.notFound().build();
		}else {
			Product updateProduct = optProduct.get();
			updateProduct.setNombreProducto(product.getNombreProducto());
			updateProduct.setImagenProducto(product.getImagenProducto());
			updateProduct.setCantidadProducto(product.getCantidadProducto());
			updateProduct.setIdCategoriaProducto(product.getIdCategoriaProducto());
			productDAO.save(updateProduct);
			return ResponseEntity.ok(updateProduct);
		}
	}
}
