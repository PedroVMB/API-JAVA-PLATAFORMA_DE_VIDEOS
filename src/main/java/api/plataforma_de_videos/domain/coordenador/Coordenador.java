package api.plataforma_de_videos.domain.coordenador;

import api.plataforma_de_videos.domain.aluno.DadosAtualizacaoAluno;
import api.plataforma_de_videos.domain.aluno.DadosCadastroAluno;
import api.plataforma_de_videos.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "coordenadores")
@Entity(name = "Coordenador")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Coordenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Coordenador(DadosCadastroCoordenador dados){
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizaInformacoesCoordenador(DadosAtualizacaoCoordenador dados){
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
