package api.plataforma_de_videos.domain.coordenador;

import api.plataforma_de_videos.domain.aluno.Aluno;
import api.plataforma_de_videos.domain.endereco.Endereco;

public record DadosDetalhamentoCoordenador(Long id, String nome, String email, String senha, Endereco endereco, Boolean ativo) {
    public DadosDetalhamentoCoordenador(Coordenador coordenador){
        this(coordenador.getId(), coordenador.getNome(), coordenador.getEmail(), coordenador.getSenha(), coordenador.getEndereco(), coordenador.getAtivo());
    }
}
