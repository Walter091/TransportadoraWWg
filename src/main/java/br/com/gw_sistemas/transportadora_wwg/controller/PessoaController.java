package br.com.gw_sistemas.transportadora_wwg.controller;

import br.com.gw_sistemas.transportadora_wwg.enums.StatusFormularioEnum;
import br.com.gw_sistemas.transportadora_wwg.model.Pessoa;
import br.com.gw_sistemas.transportadora_wwg.service.ServicePessoa;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.RedirectView;

@RestController()
public class PessoaController {

    @Autowired
    private ServicePessoa servicoPessoa;

    private StatusFormularioEnum statusFormulario;

    @GetMapping("/transportadora-wwg/opcoes/clientes")
    public ModelAndView buscar() {
        ModelAndView pgClientes = new ModelAndView("Clientes");
        pgClientes.addObject("listClients", servicoPessoa.buscarListaPessoa());
        
        return pgClientes;
    }
    
    @GetMapping("/transportadora-wwg/opcoes/clientesCadastrados")
    public Iterable<Pessoa> buscarClients() {
        return servicoPessoa.buscarTodos();
    }

    @GetMapping("/transportadora-wwg/opcoes/clientes/{id}")
    public ModelAndView buscarTodosByID(@PathVariable("id") Long id) {
        ModelAndView pgClientes = new ModelAndView("Clientes");
        pgClientes.addObject("clientes", servicoPessoa.buscarTodosByID(id));
        
        return pgClientes;
    }

    @GetMapping("/transportadora-wwg/opcoes/clientes/cadastrar")
    public ModelAndView formCadastro() {
        statusFormulario = StatusFormularioEnum.SALVAR;
        ModelAndView pgFormClientes = new ModelAndView("FormClientes");
        pgFormClientes.addObject("pessoa", new Pessoa());
        
        return pgFormClientes;
    }
    
    @PostMapping("/transportadora-wwg/opcoes/clientes/cadastrar/salvar")
    public RedirectView salvar(@ModelAttribute("pessoa") Pessoa pessoa) {
        if (statusFormulario == StatusFormularioEnum.SALVAR)  servicoPessoa.salvar(pessoa);
        else if (statusFormulario == StatusFormularioEnum.ALTERAR) servicoPessoa.alterar(pessoa);
        
        return new RedirectView("/transportadora-wwg/opcoes/clientes");
    }
    
    @GetMapping("/transportadora-wwg/opcoes/Clientes/Editar/{id}")
    public ModelAndView alterar(@PathVariable("id") Long id, Model model) {
        statusFormulario = StatusFormularioEnum.ALTERAR;
        Optional<Pessoa> obj = servicoPessoa.buscarPorId(id);
        
        ModelAndView pgFormClientes = new ModelAndView("FormClientes");
        pgFormClientes.addObject("pessoa", obj.get());
        return pgFormClientes;
    }

    @GetMapping("/transportadora-wwg/opcoes/Clientes/Delete/{id}")
    public RedirectView delete(@PathVariable("id") Long id) {
        Optional<Pessoa> obj = servicoPessoa.buscarPorId(id);
        servicoPessoa.deletar(obj.get(), obj.get().getId());
        return new RedirectView("/transportadora-wwg/opcoes/clientes");
    }
    
}
