package br.com.biblioteca.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.biblioteca.dto.MembrosDTO;
import br.com.biblioteca.dto.ProjectDTO;
import br.com.biblioteca.dto.response.ProjetoResponse;

import br.com.biblioteca.service.IProjectService;
import lombok.experimental.var;

@Controller
@RequestMapping("/project/")
public class ProjectController {
	
	@Autowired
	IProjectService service;

	
	@GetMapping("list")
	public String list(Model model, HttpServletRequest httpServletRequest) {
		List<ProjetoResponse> list = service.list();
		
		model.addAttribute("projects", list);
		return "project-list";
	}
	
	@GetMapping("add")
	public String add(Model model, HttpServletRequest httpServletRequest) {
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setGerentes(service.listGerentes());
	    model.addAttribute("project", projectDTO);
		
		return "project-add";
	}
	
	 @RequestMapping(value = "/add", method = RequestMethod.POST)
	 public String editProject(Model model, @Valid ProjectDTO project, BindingResult result) throws Exception {
		 
		 if (result.hasErrors()) {
			 return "project-add";
		 }
		 service.save(project);
	
	    return "redirect:/project/list";
	 }
	 
	 @RequestMapping(value = "/update", method = RequestMethod.GET)
	 public String showUpdate(@RequestParam long id, Model model) {
		 ProjectDTO projectDTO = service.getProjectById(id);
		 model.addAttribute("project", projectDTO);
		 return "project-add";
	 }
	 
	 @RequestMapping(value = "/update", method = RequestMethod.POST)
	 public String updateProjeto(Model model, @Valid ProjectDTO project, BindingResult result) throws Exception {
		 
		 if (result.hasErrors()) {
			 return "project-add";
		 }
	        
		 service.update(project);
		 return "redirect:/project/list";
	 }
	 
	 @RequestMapping(value = "/delete", method = RequestMethod.GET)
	 public String deleteProjeto(@RequestParam long id) throws Exception {
		 service.delete(id);
		 return "redirect:/project/list";
	 }
	 
	 @RequestMapping(value = "/cadastro_membros", method = RequestMethod.GET)
	 public String showCadastroMembros(@RequestParam long id, Model model) throws Exception {
		 List<MembrosDTO> membros = service.getMembrosToAddProjeto(id);
		 model.addAttribute("idProjeto", id);
		 model.addAttribute("membros", membros);
		 model.addAttribute("membroProjeto", new MembrosDTO());
		 return "membros-add";
	 }
	 
	 @RequestMapping(value = "/cadastro_membros", method = RequestMethod.POST)
	 public String cadastroMembros(Model model,@Valid MembrosDTO membroProjeto, BindingResult result) throws Exception {
		 service.saveMembro(membroProjeto);
		 return "redirect:/project/cadastro_membros?id="+membroProjeto.getIdProjeto();
	 }
	 
//	 @RequestMapping(value = "/cadastro_membros-add", method = RequestMethod.GET)
//	 public String cadastroMembros(@RequestParam long idProjeto,@RequestParam long idPessoa,@RequestParam String cargo, Model model,HttpServletRequest request) {
//		 var teste = request.getParameter("cargo");
//		 return "redirect:/project/cadastro_membros?id="+idProjeto;
//	 }
	 
	 
}
