package com.softcaribbean.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softcaribbean.bean.Cliente;
import com.softcaribbean.repository.ClienteRepository;

@Repository
public class ClienteDAOImpl implements ClienteDAO {
	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public List<Cliente> getAllClientes() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		Iterable<Cliente> clientesIterable = clienteRepository.findAll();
		Iterator<Cliente> clientesIterator = clientesIterable.iterator();
		while (clientesIterator.hasNext()) {
			clientes.add(clientesIterator.next());
		}
		return clientes;
	}

	@Override
	public Cliente getCliente(Integer id) {
		return clienteRepository.findById(id).get();
	}

	@Override
	public void addCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	@Override
	public void updateCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	@Override
	public void deleteCliente(int id) {
		clienteRepository.deleteById(id);

	}

}
