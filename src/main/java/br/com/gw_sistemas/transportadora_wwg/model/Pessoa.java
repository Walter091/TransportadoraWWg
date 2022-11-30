package br.com.gw_sistemas.transportadora_wwg.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;

/**
 * @author walter
 *
 */		
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NOME")
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

    @Column(name = "IND_REG")
    private int indReg = 0;

    // -------------------------------------------------------------------------------------

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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}    

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getIndReg() {
		return indReg;
	}

	public void setIndReg(int indReg) {
		this.indReg = indReg;
	}
	
}
