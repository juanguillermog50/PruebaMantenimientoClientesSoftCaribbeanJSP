package com.softcaribbean.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "thom_cliente")
public class Cliente {

	@Id
	@Column(name = "nmcliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "cdcliente")
	String codigo;

	@Column(name = "dsnombre")
	String nombre;

	@Column(name = "dsdireccion")
	String direccion;

	@Column(name = "dsmail")
	String email;

	@Column(name = "feregistro")
	Date fechaRegistro;

	@Column(name = "febaja")
	Date fechaBaja;

	@Column(name = "cdusuario")
	String usuario;

	@Column(name = "snactivo")
	String activo;

	@Column(name = "cdtelefono")
	String telefono;

	@Column(name = "dscontacto")
	String contacto;

	@Column(name = "dslogo")
	String logo;

	public Cliente() {
		super();
	}

	public Cliente(String codigo, Date fechaBaja, String contacto, String logo, String nombre, String direccion, int id,
			Date fechaRegistro, String email, String telefono, String usuario, String activo) {
		super();
		this.codigo = codigo;
		this.fechaBaja = fechaBaja;
		this.contacto = contacto;
		this.logo = logo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.id = id;
		this.fechaRegistro = fechaRegistro;
		this.email = email;
		this.telefono = telefono;
		this.usuario = usuario;
		this.activo = activo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
}
