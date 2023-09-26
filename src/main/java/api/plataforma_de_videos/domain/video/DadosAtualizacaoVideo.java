package api.plataforma_de_videos.domain.video;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoVideo(
        @NotNull
        Long id,
        String titulo,
        String url,
        Boolean ativo
) {
}
