package com.algaworks.algafood.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificacao.NivelUrgencia;
import com.algaworks.algafood.di.notificacao.Notificador;
import com.algaworks.algafood.di.notificacao.TipoDoNotificador;

@Component
public class AtivacaoClienteService {

//	@Autowired(required = false)
//	private List<Notificador> notificadores;

//	for (Notificador notificador : notificadores) {
//		notificador.notificar(cliente, "Seu cadastro esta ativo");
//	}

//	@Qualifier("urgente")
	@TipoDoNotificador(NivelUrgencia.NORMAL)
	@Autowired(required = false)
	private Notificador notificador;

	public void ativar(Cliente cliente) {
		cliente.ativar();

		if (notificador != null) {
			notificador.notificar(cliente, "Seu cadastro esta ativo");
		} else {
			System.out.println("Não existe notificador, mas o cliente foi ativado");
		}
	}
}
