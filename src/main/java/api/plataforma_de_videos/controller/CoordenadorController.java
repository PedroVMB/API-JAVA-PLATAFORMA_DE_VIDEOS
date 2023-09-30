package api.plataforma_de_videos.controller;


import api.plataforma_de_videos.domain.coordenador.*;
import api.plataforma_de_videos.repository.CoordenadorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("coordenador")
@CrossOrigin(origins = "*")
public class CoordenadorController {
    @Autowired
    private CoordenadorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCoordenador dados, UriComponentsBuilder uriBuilder) {
        var Coordenador = new Coordenador(dados);
        repository.save(Coordenador);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(Coordenador.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoCoordenador(Coordenador));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemCoordenador>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemCoordenador::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoCoordenador dados) {
        var Coordenador = repository.getReferenceById(dados.id());
        Coordenador.atualizaInformacoesCoordenador(dados);

        return ResponseEntity.ok(new DadosDetalhamentoCoordenador(Coordenador));
    }

    @DeleteMapping("/{id}")
    @org.springframework.transaction.annotation.Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var Coordenador = repository.getReferenceById(id);
        Coordenador.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var Coordenador = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoCoordenador(Coordenador));
    }
}
