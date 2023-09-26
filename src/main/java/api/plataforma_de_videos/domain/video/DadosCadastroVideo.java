package api.plataforma_de_videos.domain.video;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroVideo(
        @NotBlank
        String titulo,

        @NotBlank
        @NotNull
        String url
) {
}
