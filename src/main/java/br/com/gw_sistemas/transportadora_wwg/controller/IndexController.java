package br.com.gw_sistemas.transportadora_wwg.controller;

import br.com.gw_sistemas.transportadora_wwg.model.UsuarioLog;
import br.com.gw_sistemas.transportadora_wwg.service.ServiceUsuarioLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {

    @Autowired
    private ServiceUsuarioLog serviceUsuarioLog;

    @GetMapping(value = {"/transportadora-wwg", "/transportadora-wwg/login"})
    public ModelAndView index() {
        return new ModelAndView("Login");
    }

    @GetMapping("/transportadora-wwg/opcoes")
    public ModelAndView opcoes() {
        return new ModelAndView("Opcoes");
    }

    @PostMapping("/transportadora-wwg/login/entrar")
    public ModelAndView entrarNoHome(@RequestBody UsuarioLog usuarioLog) {
        if (serviceUsuarioLog.entrar(usuarioLog)) {
            return new ModelAndView("Opcoes");
        } else {
            return new ModelAndView("Login");
        }
    }

}
