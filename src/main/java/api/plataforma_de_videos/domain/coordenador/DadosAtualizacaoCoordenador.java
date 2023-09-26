package api.plataforma_de_videos.domain.coordenador;

import api.plataforma_de_videos.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCoordenador(
        @NotNull
        Long id,
        String nome,
        String email,
        String senha,
        DadosEndereco endereco
) {
}
