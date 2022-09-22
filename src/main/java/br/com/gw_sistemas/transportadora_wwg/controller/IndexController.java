package br.com.gw_sistemas.transportadora_wwg.controller;

import br.com.gw_sistemas.transportadora_wwg.enums.StatusFormularioEnum;
import br.com.gw_sistemas.transportadora_wwg.model.UsuarioLog;
import br.com.gw_sistemas.transportadora_wwg.nucleo.base.ServicoBase;
import br.com.gw_sistemas.transportadora_wwg.service.ServiceUsuarioLog;
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

    private StatusFormularioEnum statusFormulario;
            
    @GetMapping("/transportadora-wwg")
    public ModelAndView index() {

        return new ModelAndView("Home");
    }

    @GetMapping("/transportadora-wwg/login")
    public ModelAndView home() {
        ModelAndView pgLogin = new ModelAndView("Login");
        pgLogin.addObject("usuarioLog", new UsuarioLog());
        if (statusFormulario == StatusFormularioEnum.EM_ERRO){
            pgLogin.addObject("msgError", serviceUsuarioLog.getERRO());
            
        }
    
        return pgLogin;
    }

    @GetMapping("/transportadora-wwg/opcoes")
    public ModelAndView opcoes() {
        return new ModelAndView("Opcoes");
    }

    @PostMapping("/transportadora-wwg/login/entrar")
    public RedirectView entrarNoHome(@ModelAttribute("usuarioLog") UsuarioLog usuarioLog, Model model) {
        if (serviceUsuarioLog.entrar(usuarioLog)) {
            return new RedirectView("/transportadora-wwg");
        } else {            
            statusFormulario = StatusFormularioEnum.EM_ERRO;
            return new RedirectView("/transportadora-wwg/login");
        }
    }

    @PostMapping("/transportadora-wwg/usuario/salvar")
    public boolean salvarUsuario(@RequestBody UsuarioLog usuarioLog) {
        return serviceUsuarioLog.salvar(usuarioLog);
    }

}
