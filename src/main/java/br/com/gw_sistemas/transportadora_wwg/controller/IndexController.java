package br.com.gw_sistemas.transportadora_wwg.controller;

import br.com.gw_sistemas.transportadora_wwg.model.UsuarioLog;
import br.com.gw_sistemas.transportadora_wwg.service.ServiceUsuarioLog;
import br.com.gw_sistemas.transportadorawwg.nucleo.base.RetornoRequisicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

@RestController
public class IndexController {

    @Autowired
    private ServiceUsuarioLog serviceUsuarioLog;

    @GetMapping(value = {"/transportadora-wwg", "/transportadora-wwg/login"})
    public ModelAndView index(@ModelAttribute("usuarioLog") UsuarioLog usuarioLog) {
        return new ModelAndView("Login");
    }

    @GetMapping("/transportadora-wwg/opcoes")
    public ModelAndView opcoes() {
        return new ModelAndView("Opcoes");
    }

    @GetMapping("/transportadora-wwg/login/entrar")
    public ModelAndView entrarNoHome(@ModelAttribute("usuarioLog") UsuarioLog usuarioLog, Model model) {
        if (serviceUsuarioLog.entrar(usuarioLog)) return new ModelAndView("Opcoes");
        else {
            String msgErro = serviceUsuarioLog.getERRO();
            model.addAttribute("msgError", msgErro);
            return new ModelAndView("Login");
        }
        
    }

    @PostMapping("/transportadora-wwg/usuario/salvar")
    public RetornoRequisicao salvarUsuario(@RequestBody UsuarioLog usuarioLog) {
        return serviceUsuarioLog.salvar(usuarioLog);
    }
    
}
