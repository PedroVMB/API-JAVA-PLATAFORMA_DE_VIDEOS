package api.plataforma_de_videos.domain.video;

public record DadosListagemVideo(Long id, String titulo, String url, Boolean ativo) {
    public DadosListagemVideo(Video video){
        this(video.getId(), video.getTitulo(), video.getUrl(), video.getAtivo());
    }
}
