package com.api.productos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
@Id
@Column(name="idProducto")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idProducto;

@Column(name = "nombreProducto", nullable = false, length = 30)
private String nombreProducto;

@Column(name = "imagenProducto", nullable = false, length = 80)
private String imagenProducto;

@Column(name = "cantidadProducto", nullable = false,length = 30)
private Long cantidadProducto;

@Column(name = "idCategoriaProducto", nullable = false,length = 30)
private Long idCategoriaProducto;

public Long getIdProducto() {
	return idProducto;
}
public void setIdProducto(Long idProducto) {
	this.idProducto = idProducto;
}
public String getNombreProducto() {
	return nombreProducto;
}
public void setNombreProducto(String nombreProducto) {
	this.nombreProducto = nombreProducto;
}
public String getImagenProducto() {
	return imagenProducto;
}
public void setImagenProducto(String imagenProducto) {
	this.imagenProducto = imagenProducto;
}
public Long getCantidadProducto() {
	return cantidadProducto;
}
public void setCantidadProducto(Long cantidadProducto) {
	this.cantidadProducto = cantidadProducto;
}
public Long getIdCategoriaProducto() {
	return idCategoriaProducto;
}
public void setIdCategoriaProducto(Long idCategoriaProducto) {
	this.idCategoriaProducto = idCategoriaProducto;
}


}
