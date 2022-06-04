package kr.co.short_link.service;

import kr.co.short_link.domain.Links;
import kr.co.short_link.message.ShortUrlRequest;
import kr.co.short_link.message.ShortUrlResponse;
import kr.co.short_link.repository.LinksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class LinkFactory {

    private final ShortLinkCreator shortLinkCreator;
    private final LinksRepository linksRepository;

    @Transactional
    public ShortUrlResponse create(ShortUrlRequest request) {
        String shortId = shortLinkCreator.executor();
        Links links = linksRepository.save(request.toEntity(shortId));

        return ShortUrlResponse.of(request.getUrl(), shortId, links.getCreatedDate());
    }
}
