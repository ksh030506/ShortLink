package kr.co.ab180.repository;

import kr.co.ab180.domain.Links;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LinksRepository extends JpaRepository<Links, Long> {

    Optional<Links> findByOriginalLink(String url);
    Optional<Links> findByShortLink(String shortId);
}
