package api.plataforma_de_videos.repository;

import api.plataforma_de_videos.domain.video.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
    Page<Video> findAllByAtivoTrue(Pageable paginacao);
}
