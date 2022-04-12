package kr.co.ab180.message;

import kr.co.ab180.domain.Links;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
public class ShortUrlRequest {

    @URL(message = "올바른 URL이어야 합니다.")
    String url;

    public Links toEntity(String shortId) {
        return Links.builder()
                .shortLink(shortId)
                .originalLink(url)
                .build();
    }
}
