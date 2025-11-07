package app.netlify.soluno.entity;

import app.netlify.soluno.enumerator.Categoria;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "despesas")
@Getter
@Setter
public class Despesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;

    @NotBlank
    private String nome;

    private String descricao;

    @NotNull
    @PastOrPresent
    private Date data;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @NotNull
    private BigDecimal valor;
}
