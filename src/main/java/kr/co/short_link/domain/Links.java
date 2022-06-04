package kr.co.short_link.domain;

import lombok.*;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE, onConstructor_ = @PersistenceConstructor)
@Builder
public class Links extends BaseEntity {

    // TODO : uuid 변경
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long linksIdx;

    @Column(nullable = false, unique = true)
    private String shortLink;

    @Column(nullable = false)
    private String originalLink;

    public static Links of(Long id, String shortLink, String originalLink) {
        return new Links(id, shortLink, originalLink);
    }

    public void updateShortLink(String shortLink) {
        this.shortLink = shortLink;
    }
}
