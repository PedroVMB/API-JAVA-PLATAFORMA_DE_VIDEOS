package api.plataforma_de_videos.domain.professor;

import api.plataforma_de_videos.domain.endereco.Endereco;

public record DadosListagemProfessor(Long id, String nome, String email, Endereco endereco, Boolean ativo) {
    public DadosListagemProfessor(Professor professor){
        this(professor.getId(), professor.getNome(), professor.getEmail(), professor.getEndereco(), professor.getAtivo());
    }
}
