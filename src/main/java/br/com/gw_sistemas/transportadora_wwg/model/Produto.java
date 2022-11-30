package br.com.gw_sistemas.transportadora_wwg.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;

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

    // -----------------------------------------------------------------------------
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getIndReg() {
		return indReg;
	}

	public void setIndReg(int indReg) {
		this.indReg = indReg;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}
    
    
}