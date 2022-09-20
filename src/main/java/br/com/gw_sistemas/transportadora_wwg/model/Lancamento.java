package br.com.gw_sistemas.transportadora_wwg.model;

import br.com.gw_sistemas.transportadora_wwg.enums.StatusEnum;
import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "lancamento")
public class Lancamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DATA_SAIDA")
    private LocalDate dataSaida;

    @Column(name = "DATA_ENTREGA")
    private LocalDate dataEntrega;

    @Column(nullable = false, name = "STATUS")
    private StatusEnum status;

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

}
