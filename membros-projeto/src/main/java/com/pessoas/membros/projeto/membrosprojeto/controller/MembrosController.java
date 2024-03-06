package com.pessoas.membros.projeto.membrosprojeto.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pessoas.membros.projeto.membrosprojeto.dto.MembrosRequest;
import com.pessoas.membros.projeto.membrosprojeto.services.MembrosService;
import com.pessoas.membros.projeto.membrosprojeto.utils.AppResponse;
import org.springframework.http.HttpStatus;



@RestController
@RequestMapping("/membros")
public class MembrosController {
	
	@Autowired
	private MembrosService service;
	

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Object createMembro(@RequestBody @Valid MembrosRequest membrosRequest) {
		try {
			
			return AppResponse.success(service.cadastrarMembro(membrosRequest));
		} catch (Exception e) {
			return AppResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("/listfunc")
	public Object listFuncionarios(@RequestParam(value="idProjeto", required=true) Long idProjeto) {
		try {
			return AppResponse.success(service.getListMembrosFuncioanrios(idProjeto));
		} catch (Exception e) {
			return AppResponse.error(e.getMessage());
		}
	}

}
