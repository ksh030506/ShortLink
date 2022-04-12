package kr.co.ab180.repository;

import kr.co.ab180.domain.Links;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LinksRepository extends JpaRepository<Links, Long> {

    Optional<Links> findByOriginalLink(String url);

}
