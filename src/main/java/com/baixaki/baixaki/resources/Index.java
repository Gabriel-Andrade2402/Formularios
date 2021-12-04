package com.baixaki.baixaki.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping
public class Index {
	@GetMapping(value="/cadastrarClient")
	public ModelAndView cadastrarClient(){
		   return new ModelAndView("cadastrarClient");
	}
	@GetMapping(value="/cadastrarAgendamentos")
	public ModelAndView cadastrarAgendamentos(){
		   return new ModelAndView("cadastrarAgendamento");
	}
	@GetMapping(value="/cadastrarProdutos")
	public ModelAndView cadastrarProdutos(){
		   return new ModelAndView("cadastrarProdutos");
	}
	@GetMapping(value="/cadastrarFornecedor")
	public ModelAndView cadastrarFornecedor(){
		   return new ModelAndView("cadastrarFornecedor");
	}
	@GetMapping(value="/cadastrarMovimentacoes")
	public ModelAndView cadastrarMovimentacoes(){
		   return new ModelAndView("cadastrarMovimentacoes");
	}
}
