package api.plataforma_de_videos.repository;

import api.plataforma_de_videos.domain.aluno.Aluno;
import api.plataforma_de_videos.domain.professor.Professor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Page<Aluno> findAllByAtivoTrue(Pageable paginacao);
}
