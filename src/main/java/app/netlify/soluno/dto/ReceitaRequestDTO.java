package app.netlify.soluno.dto;

import app.netlify.soluno.enumerator.Categoria;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class ReceitaRequestDTO {
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
