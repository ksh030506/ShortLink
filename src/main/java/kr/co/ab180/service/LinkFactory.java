package kr.co.ab180.service;

import kr.co.ab180.domain.Links;
import kr.co.ab180.message.ShortUrlRequest;
import kr.co.ab180.message.ShortUrlResponse;
import kr.co.ab180.repository.LinksRepository;
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
