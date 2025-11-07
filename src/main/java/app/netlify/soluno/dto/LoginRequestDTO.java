package app.netlify.soluno.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDTO {
    @NotBlank(message = "Email não pode ser vazio")
    @Email(message = "Formato de email incorreto")
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    private String senha;
}
