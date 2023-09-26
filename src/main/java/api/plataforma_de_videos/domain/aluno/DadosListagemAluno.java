package api.plataforma_de_videos.domain.aluno;

import api.plataforma_de_videos.domain.endereco.Endereco;
import api.plataforma_de_videos.domain.professor.Professor;

public record DadosListagemAluno(Long id, String nome, String email, Endereco endereco, Boolean ativo) {
    public DadosListagemAluno(Aluno aluno) {
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getEndereco(), aluno.getAtivo());
    }
}
