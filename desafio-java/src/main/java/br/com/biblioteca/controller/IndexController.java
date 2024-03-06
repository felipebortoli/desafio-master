package br.com.biblioteca.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class IndexController {

	@GetMapping("")
	public String home(Model model, HttpServletRequest httpServletRequest) {
		return "index";
	}
}
