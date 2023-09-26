package api.plataforma_de_videos.domain.aluno;

import api.plataforma_de_videos.domain.endereco.Endereco;
import api.plataforma_de_videos.domain.professor.DadosAtualizacaoProfessor;
import api.plataforma_de_videos.domain.professor.DadosCadastroProfessor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "alunos")
@Entity(name = "Aluno")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Aluno(DadosCadastroAluno dados){
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualiasInformacoesAluno(DadosAtualizacaoAluno dados){
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.email() != null){
            this.email = dados.email();
        }
        if(dados.senha() != null){
            this.senha = dados.senha();
        }
        if(dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }

}
