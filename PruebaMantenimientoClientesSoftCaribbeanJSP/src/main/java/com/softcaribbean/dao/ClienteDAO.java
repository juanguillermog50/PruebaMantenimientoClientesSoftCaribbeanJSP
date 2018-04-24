package com.softcaribbean.dao;

import java.util.List;

import com.softcaribbean.bean.Cliente;

public interface ClienteDAO {

	public List<Cliente> getAllClientes();

	public Cliente getCliente(Integer id);

	public void addCliente(Cliente cliente);

	public void updateCliente(Cliente cliente);

	public void deleteCliente(int id);
}
