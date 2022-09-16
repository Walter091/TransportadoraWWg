package br.com.gw_sistemas.transportadora_wwg.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USUARIO")
    private UsuarioLog usuarioLog;

    @Column(nullable = false, name = "NOME")
    private String nome;

    @Column(unique = true, name = "CNPJ")
    private String cnpj;

    @Column(unique = true, name = "CPF")
    private String cpf;

    @Column(name = "RAZAO_SOCIAL")
    private String razaoSocial;

    @Column(nullable = false, name = "CIDADE")
    private String cidade;

    @Column(nullable = false, name = "UF")
    private String uf;

    @Column(nullable = false, name = "BAIRRO")
    private String bairro;

    @Column(nullable = false, name = "RUA")
    private String rua;

    @Column(nullable = false, name = "NUMERO")
    private int numero;

    @Column(nullable = false, name = "IND_REG")
    private int indReg;

}
