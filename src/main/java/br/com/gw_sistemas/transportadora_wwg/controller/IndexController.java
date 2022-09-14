package br.com.gw_sistemas.transportadora_wwg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IndexController {
    
    @GetMapping("/index")
    public String index(){
        return "/index";
    }
    
    @GetMapping("/home")
    public String entrarTelaHome(){
        // Criar a pagina html e retornar o caminho aqui...
        return null;
    }
    
    @GetMapping("/cadastro")
    public String entrarTelaCadastro(){
        // Criar a pagina html e retornar o caminho aqui...
        return null;
    }

    @GetMapping("/relatorios")
    public String entrarTelaRelatorios(){
        // Criar a pagina html e retornar o caminho aqui...
        return null;
    }

}
