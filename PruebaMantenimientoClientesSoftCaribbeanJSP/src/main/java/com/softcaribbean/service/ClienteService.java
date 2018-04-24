package com.softcaribbean.service;

import java.util.List;

import com.softcaribbean.bean.Cliente;

public interface ClienteService {

	public List<Cliente> getAllClientes();

	public Cliente getCliente(int id);

	public void addCliente(Cliente cliente);

	public void updateCliente(Cliente cliente);

	public void deleteCliente(int id);

}
