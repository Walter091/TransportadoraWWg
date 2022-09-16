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
@Table(name = "usuarioLog")
public class UsuarioLog implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name = "NOME_USUARIO")
    private String nomeDeUsuario;

    @Column(nullable = false, name = "EMAIL")
    private String email;

    @Column(nullable = false, name = "SENHA")
    private String senha;
    
}
