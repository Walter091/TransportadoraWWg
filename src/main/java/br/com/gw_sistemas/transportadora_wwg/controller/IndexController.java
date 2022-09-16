package br.com.gw_sistemas.transportadora_wwg.controller;

import br.com.gw_sistemas.transportadora_wwg.model.UsuarioLog;
import br.com.gw_sistemas.transportadora_wwg.service.ServiceLogin;
import br.com.gw_sistemas.transportadora_wwg.service.ServiceUsuarioLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController()
public class IndexController {

    @Autowired
    private ServiceLogin serviceLogin;

    @Autowired
    private ServiceUsuarioLog serviceUsuarioLog;

    @GetMapping("/")
    public ModelAndView index() {
        return login();
    }

    @GetMapping("/Login")
    public ModelAndView login() {    
        return new ModelAndView("Login");
    }

    @GetMapping("/Opcoes")
    public ModelAndView opcoes() {
        return new ModelAndView("Opcoes");
    }

    @PostMapping("/entrar")
    public ModelAndView entrarNoHome(@RequestBody UsuarioLog obj) {
        if (serviceUsuarioLog.entrar(obj)) {
            return new ModelAndView("Opcoes");
        } else {
            return new ModelAndView("Login");   
        }
    }

}
