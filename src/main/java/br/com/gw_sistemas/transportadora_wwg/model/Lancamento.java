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

@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DATA_SAIDA")
    private String dataSaida;

    @Column(name = "DATA_ENTREGA")
    private String dataEntrega;

    @Column(nullable = false, name = "STATUS")
    private String status;

    @ManyToOne
    @JoinColumn(name = "REMETENTE")
    private Pessoa remetente;

    @ManyToOne
    @JoinColumn(name = "DESTINATARIO")
    private Pessoa destinatario;

    @ManyToOne
    @JoinColumn(name = "PRODUTO")
    private Produto produto;

    @Column(name = "IND_REG")
    private int indReg;

    // ----------------------------------------------------------------------------
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Pessoa getRemetente() {
		return remetente;
	}

	public void setRemetente(Pessoa remetente) {
		this.remetente = remetente;
	}

	public Pessoa getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Pessoa destinatario) {
		this.destinatario = destinatario;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getIndReg() {
		return indReg;
	}

	public void setIndReg(int indReg) {
		this.indReg = indReg;
	}
	
}

