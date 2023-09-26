package api.plataforma_de_videos.domain.coordenador;

import api.plataforma_de_videos.domain.aluno.Aluno;
import api.plataforma_de_videos.domain.endereco.Endereco;

public record DadosListagemCoordenador(Long id, String nome, String email, Endereco endereco, Boolean ativo) {
    public DadosListagemCoordenador(Coordenador coordenador) {
        this(coordenador.getId(), coordenador.getNome(), coordenador.getEmail(), coordenador.getEndereco(), coordenador.getAtivo());
    }
}
