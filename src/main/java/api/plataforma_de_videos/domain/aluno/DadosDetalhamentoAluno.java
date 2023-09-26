package api.plataforma_de_videos.domain.aluno;

import api.plataforma_de_videos.domain.endereco.Endereco;

public record DadosDetalhamentoAluno(Long id, String nome, String email, String senha, Endereco endereco, Boolean ativo) {
    public DadosDetalhamentoAluno(Aluno aluno){
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getSenha(), aluno.getEndereco(), aluno.getAtivo());
    }
}
