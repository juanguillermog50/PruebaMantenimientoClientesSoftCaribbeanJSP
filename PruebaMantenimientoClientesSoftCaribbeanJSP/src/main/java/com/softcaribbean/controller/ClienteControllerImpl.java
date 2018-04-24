package com.softcaribbean.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softcaribbean.bean.Cliente;
import com.softcaribbean.service.ClienteService;

@Controller
public class ClienteControllerImpl implements ClienteController {

	@Autowired
	ClienteService clienteService;

	@RequestMapping(value = "/getAllClientes", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getClientes(Model model) {
		List<Cliente> listOfClientes = clienteService.getAllClientes();
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("listOfClientes", listOfClientes);
		return "clienteDetails";
	}

	@RequestMapping(value = "/getCliente/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Cliente getClienteById(@PathVariable int id) {
		return clienteService.getCliente(id);
	}

	@RequestMapping(value = "/addCliente", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addCliente(@ModelAttribute("cliente") Cliente cliente) {
		if (cliente.getId() == 0) {
			clienteService.addCliente(cliente);
		} else {
			clienteService.updateCliente(cliente);
		}
		return "redirect:/getAllClientes";
	}

	@RequestMapping(value = "/updateCliente/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateCliente(@PathVariable("id") int id, Model model) {
		model.addAttribute("cliente", this.clienteService.getCliente(id));
		model.addAttribute("listOfClientes", this.clienteService.getAllClientes());
		return "clienteDetails";
	}

	@RequestMapping(value = "/deleteCliente/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteCliente(@PathVariable("id") int id) {
		clienteService.deleteCliente(id);
		return "redirect:/getAllClientes";
	}

}
