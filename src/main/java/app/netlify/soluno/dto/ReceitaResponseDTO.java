package app.netlify.soluno.dto;

import app.netlify.soluno.entity.Usuario;
import app.netlify.soluno.enumerator.Categoria;

import java.math.BigDecimal;
import java.util.Date;

public record ReceitaResponseDTO(
        Long id,
        Usuario idUsuario,
        String nome,
        String descricao,
        Date data,
        Categoria categoria,
        BigDecimal valor
) {
}

