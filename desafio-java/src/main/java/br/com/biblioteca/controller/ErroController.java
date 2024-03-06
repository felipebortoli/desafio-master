package br.com.biblioteca.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErroController {
	

    @ExceptionHandler(Exception.class)
    public String handleException(Model model, Exception ex) {
     

        model.addAttribute("exception", ex.getLocalizedMessage());
        //model.addAttribute("url", request.getRequestURL());

       
        return "common/error";
    }


}
