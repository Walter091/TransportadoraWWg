package br.com.gw_sistemas.transportadora_wwg.controller;

import br.com.gw_sistemas.transportadora_wwg.model.UsuarioLog;
import br.com.gw_sistemas.transportadora_wwg.service.ServiceUsuarioLog;
import br.com.gw_sistemas.transportadorawwg.nucleo.base.Requisicao;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class IndexController {

    @Autowired
    private ServiceUsuarioLog serviceUsuarioLog;

    private Requisicao requisicao;
    private final boolean isErroLogin = false;

    @GetMapping(value = {"/transportadora-wwg", "/transportadora-wwg/login"})
    public ModelAndView index() {
        requisicao = new Requisicao();
        requisicao.setStatus(isErroLogin);
        
        ModelAndView pgLogin = new ModelAndView("Login");
        pgLogin.addObject("usuarioLog", new UsuarioLog());
        pgLogin.addObject("requisicao", requisicao);
        
        return pgLogin;
    }

    @GetMapping("/transportadora-wwg/opcoes")
    public ModelAndView opcoes() {
        return new ModelAndView("Opcoes");
    }

    @PostMapping("/transportadora-wwg/login/entrar")
    public RedirectView entrarNoHome(@ModelAttribute("usuarioLog") UsuarioLog usuarioLog, Model model) {
        if (serviceUsuarioLog.entrar(usuarioLog)) {

            requisicao.setMensagem("");
            requisicao.setStatus(false);

            return new RedirectView("/transportadora-wwg/opcoes");
        } else {

            requisicao.setMensagem(serviceUsuarioLog.getERRO());
            requisicao.setStatus(true);

            return new RedirectView("/transportadora-wwg/login");
        }
    }

    @PostMapping("/transportadora-wwg/usuario/salvar")
    public Requisicao salvarUsuario(@RequestBody UsuarioLog usuarioLog) {
        return serviceUsuarioLog.salvar(usuarioLog);
    }

}
