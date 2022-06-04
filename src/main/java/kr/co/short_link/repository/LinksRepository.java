package kr.co.short_link.repository;

import kr.co.short_link.domain.Links;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LinksRepository extends JpaRepository<Links, Long> {

    Optional<Links> findByOriginalLink(String url);
    Optional<Links> findByShortLink(String shortId);
}
