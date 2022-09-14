package br.com.gw_sistemas.transportadora_wwg.model;

import br.com.gw_sistemas.transportadora_wwg.enums.StatusEnum;
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
public class Lancamento {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DATA_SAIDA")
    private String dataSaida;

    @Column(name = "DATA_ENTREGA")
    private String dataEntrega;

    @Column(name = "STATUS")
    private StatusEnum status;

    @ManyToOne
    @JoinColumn(name = "REMETENTE")
    private Transportado remetente;

    @ManyToOne
    @JoinColumn(name = "DESTINATARIO")
    private Pessoa destinatario;

    @ManyToOne
    @JoinColumn(name = "PRODUTO")
    private Produto produto;

    @Column(name = "IND_REG")
    private int indReg;

}
