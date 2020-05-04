package com.algaworks.algafood;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.service.AtivacaoClienteService;

@Controller
public class PrimeiroController {

	private AtivacaoClienteService ativacaoClienteService;

	public PrimeiroController(AtivacaoClienteService ativacaoClienteService) {
		this.ativacaoClienteService = ativacaoClienteService;
	}

	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		Cliente cliente = new Cliente("Anderson", "anderson@gmail.com", "83 991580658");
		
		ativacaoClienteService.ativar(cliente);
		return "hello";
	}

}
