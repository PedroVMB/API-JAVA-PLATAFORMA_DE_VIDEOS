package api.plataforma_de_videos.domain.aluno;

import api.plataforma_de_videos.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroAluno(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String senha,

        @NotNull
        @Valid
        DadosEndereco endereco
) {
}
