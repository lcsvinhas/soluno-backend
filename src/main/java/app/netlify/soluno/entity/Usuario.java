package app.netlify.soluno.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String telefone;

    @NotBlank
    private String senha;

    @OneToMany(mappedBy = "idUsuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Receita> receitas;

    @OneToMany(mappedBy = "idUsuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Despesa> despesas;
}
