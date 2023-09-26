package api.plataforma_de_videos.domain.professor;

import api.plataforma_de_videos.domain.endereco.Endereco;

public record DadosDetalhamentoProfessor(Long id, String nome, String email, String senha, Endereco endereco, Boolean ativo) {
    public DadosDetalhamentoProfessor(Professor professor){
        this(professor.getId(), professor.getNome(), professor.getEmail(), professor.getSenha(), professor.getEndereco(), professor.getAtivo());
    }
}
