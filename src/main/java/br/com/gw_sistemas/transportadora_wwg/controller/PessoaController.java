package br.com.gw_sistemas.transportadora_wwg.controller;

import br.com.gw_sistemas.transportadora_wwg.model.Pessoa;
import br.com.gw_sistemas.transportadora_wwg.service.ServicePessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

@RestController()
public class PessoaController {

    @Autowired
    private ServicePessoa servicoPessoa;

    @GetMapping("/transportadora-wwg/opcoes/clientes")
    public ModelAndView buscar() {
        ModelAndView pgClientes = new ModelAndView("Clientes");
        pgClientes.addObject("listClients", servicoPessoa.buscarTodos());
        
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
        ModelAndView pgFormClientes = new ModelAndView("FormClientes");
        pgFormClientes.addObject("pessoa", new Pessoa());
        
        return pgFormClientes;
    }

    @PostMapping("/transportadora-wwg/opcoes/clientes/cadastrar/salvar")
    public void salvar(@ModelAttribute("pessoa") Pessoa pessoa) {
        servicoPessoa.salvar(pessoa);
    }

    @PutMapping("/transportadora-wwg/opcoes/Clientes/Editar/{id}")
    public ModelAndView alterar(@PathVariable("id") Long id, Model model) {
        Pessoa obj = servicoPessoa.buscarTodosByID(id);
        servicoPessoa.alterar(obj);
        ModelAndView pgClientes = new ModelAndView("FormClientes");
        return pgClientes;
    }

    @DeleteMapping("/transportadora-wwg/opcoes/Clientes/Delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        Pessoa obj = servicoPessoa.buscarTodosByID(id);
        servicoPessoa.deletar(obj, obj.getId());
        ModelAndView pgClientes = new ModelAndView("clientes");
        return pgClientes;
    }
}
