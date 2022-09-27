package br.com.gw_sistemas.transportadora_wwg.controller;

import br.com.gw_sistemas.transportadora_wwg.enums.StatusFormularioEnum;
import br.com.gw_sistemas.transportadora_wwg.model.Produto;
import br.com.gw_sistemas.transportadora_wwg.service.ServiceProduto;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.ui.Model;

@RestController()
class ProdutoController {

    @Autowired
    private ServiceProduto serviceProduto;
    
    private StatusFormularioEnum statusFormulario;

    @GetMapping("/transportadora-wwg/opcoes/produtos")
    public ModelAndView buscarTodos() {
        ModelAndView pgProdutos = new ModelAndView("Produtos");
        pgProdutos.addObject("listProdutos", serviceProduto.buscarListaProduto());
        
        return  pgProdutos;
    }

    @GetMapping("/transportadora-wwg/opcoes/produtos/{id}")
    public ModelAndView buscarTodosByID(@PathVariable("id") Long id) {
        ModelAndView pgProdutos = new ModelAndView("Produtos");
        pgProdutos.addObject("produtos",serviceProduto.buscarTodosByID(id));
        
        return  pgProdutos;
    }

    @GetMapping("/transportadora-wwg/opcoes/produtos/cadastrar")
    public ModelAndView formCadastro() {
        ModelAndView pgFormProduto = new ModelAndView("FormProdutos");
        pgFormProduto.addObject("produto", new Produto());
        if (statusFormulario == StatusFormularioEnum.EM_ERRO) {
            pgFormProduto.addObject("msgError", serviceProduto.getERRO());
        }
        return pgFormProduto;
    }

    @PostMapping("/transportadora-wwg/opcoes/produtos/cadastrar/salvar")
    public RedirectView salvar(@ModelAttribute("produto") Produto produto) {
        if (statusFormulario == StatusFormularioEnum.ALTERAR)  {
            serviceProduto.alterar(produto);
            return new RedirectView("/transportadora-wwg/opcoes/produtos");
        }
        else {
            if (serviceProduto.salvar(produto)) {
                return new RedirectView("/transportadora-wwg/opcoes/produtos");
            } else {
                statusFormulario = StatusFormularioEnum.EM_ERRO;
                return new RedirectView("/transportadora-wwg/opcoes/produtos/cadastrar");
            }
            
        }
        
    }

    @GetMapping("/transportadora-wwg/opcoes/produtos/editar/{id}")
    public ModelAndView alterar(@PathVariable("id") Long id, Model model) {
        statusFormulario = StatusFormularioEnum.ALTERAR;
        Optional<Produto> obj = serviceProduto.buscarPorId(id);

        ModelAndView pgProdutos = new ModelAndView("FormProdutos");
        pgProdutos.addObject("produto", obj.get());
        return pgProdutos;
    }

    @GetMapping("/transportadora-wwg/opcoes/produtos/delete/{id}")
    public RedirectView delete(@PathVariable("id") Long id) {
        Optional<Produto> obj = serviceProduto.buscarPorId(id);
        serviceProduto.deletar(obj.get(), obj.get().getId());
        return new RedirectView("/transportadora-wwg/opcoes/produtos");
    }
    
}
