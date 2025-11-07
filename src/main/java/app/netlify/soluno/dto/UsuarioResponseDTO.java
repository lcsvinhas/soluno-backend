package app.netlify.soluno.dto;

import app.netlify.soluno.entity.Despesa;
import app.netlify.soluno.entity.Receita;

import java.util.List;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String sobrenome,
        String email,
        String telefone,
        String senha,
        List<Receita> receitas,
        List<Despesa> despesas
) {
}
