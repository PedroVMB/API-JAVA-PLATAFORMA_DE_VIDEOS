package api.plataforma_de_videos.controller;


import api.plataforma_de_videos.domain.video.*;
import api.plataforma_de_videos.repository.VideoRepository;
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
@RequestMapping("video")
@CrossOrigin(origins = "*",maxAge = 3600)
public class VideoController {

    @Autowired
    private VideoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroVideo dados, UriComponentsBuilder uriBuilder) {
        var video = new Video(dados);
        repository.save(video);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(video.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoVideo(video));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemVideo>> listar(@PageableDefault(size = 10, sort = {"titulo"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemVideo::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoVideo dados) {
        var video = repository.getReferenceById(dados.id());
        video.atualizarInformacoesVideo(dados);

        return ResponseEntity.ok(new DadosDetalhamentoVideo(video));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var video = repository.getReferenceById(id);
        video.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var video = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoVideo(video));
    }
}
