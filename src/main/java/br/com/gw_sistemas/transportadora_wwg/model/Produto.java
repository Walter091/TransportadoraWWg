package br.com.gw_sistemas.transportadora_wwg.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name = "NOME")
    private String nome;

    @Column(nullable = false, name = "DESCRICAO")
    private String descricao;

    @Column(nullable = false, name = "PRECO")
    private double preco;

    @Column(nullable = false, name = "PESO")
    private double peso;

    @Column(nullable = false, name = "VOLUME")
    private double volume;

    @Column(nullable = false, name = "IND_REG")
    private int indReg;

}
