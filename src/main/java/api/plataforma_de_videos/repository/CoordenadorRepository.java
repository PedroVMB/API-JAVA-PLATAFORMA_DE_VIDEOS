package api.plataforma_de_videos.repository;


import api.plataforma_de_videos.domain.coordenador.Coordenador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordenadorRepository extends JpaRepository<Coordenador, Long> {
    Page<Coordenador> findAllByAtivoTrue(Pageable paginacao);
}
