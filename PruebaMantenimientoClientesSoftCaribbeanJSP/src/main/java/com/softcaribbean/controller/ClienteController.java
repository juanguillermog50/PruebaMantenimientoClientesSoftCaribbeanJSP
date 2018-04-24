package com.softcaribbean.controller;

import org.springframework.ui.Model;

import com.softcaribbean.bean.Cliente;

public interface ClienteController {

	public String getClientes(Model model);
	
	public Cliente getClienteById(int id);
	
	public String addCliente(Cliente cliente);
	
	public String updateCliente(int id, Model model);
	
	public String deleteCliente(int id);
}
