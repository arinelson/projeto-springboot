package com.algworks.gestaofesta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConvidadosController{

    @Autowired
    private Convidados convidados;

    @GetMapping("/convidados")
    public ModelAndView listar(){

        final ModelAndView modelAndView = new ModelAndView("ListaConvidados");
        
        modelAndView.addObject("convidados", convidados.findAll());
        modelAndView.addObject("convidado", new Convidado());

        return modelAndView;

        
    }

    @PostMapping("/convidados")
    public String salvar(Convidado convidado){
        this.convidados.save(convidado);
        return "redirect:/convidados";

    }

}