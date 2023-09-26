package api.plataforma_de_videos.domain.video;

public record DadosDetalhamentoVideo(Long id, String titulo, String url, Boolean ativo) {
    public DadosDetalhamentoVideo(Video video){
        this(video.getId(), video.getTitulo(), video.getUrl(), video.getAtivo());
    }
}
