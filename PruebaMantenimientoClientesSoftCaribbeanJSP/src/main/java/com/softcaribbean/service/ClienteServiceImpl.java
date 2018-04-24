package com.softcaribbean.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softcaribbean.bean.Cliente;
import com.softcaribbean.dao.ClienteDAO;

@Service("clienteService")
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteDAO clienteDAO;

	@Override
	@Transactional
	public List<Cliente> getAllClientes() {
		return clienteDAO.getAllClientes();
	}

	@Override
	@Transactional
	public Cliente getCliente(int id) {
		Integer i = new Integer(id);
		return clienteDAO.getCliente(i);
	}

	@Override
	@Transactional
	public void addCliente(Cliente cliente) {
		clienteDAO.addCliente(cliente);
	}

	@Override
	@Transactional
	public void updateCliente(Cliente cliente) {
		clienteDAO.addCliente(cliente);

	}

	@Override
	@Transactional
	public void deleteCliente(int id) {
		clienteDAO.deleteCliente(id);
	}

}
