package kr.co.ab180.service;

import kr.co.ab180.domain.Links;
import kr.co.ab180.exception.datanotfound.DataNotFoundException;
import kr.co.ab180.exception.datanotfound.DataNotFoundType;
import kr.co.ab180.message.FindByShortIdResponse;
import kr.co.ab180.repository.LinksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LinkFinder {

    private final LinksRepository linksRepository;

    public FindByShortIdResponse findBy(String short_id) {
        Links links = linksRepository.findByShortLink(short_id)
                .orElseThrow(() -> new DataNotFoundException(DataNotFoundType.NOT_FOUND_LINK));

        return FindByShortIdResponse.of(links.getShortLink(), createAlias(links.getShortLink()), links.getCreatedDate());
    }

    private String createAlias(String shortLink) {
        return "alias_" + shortLink.substring(0, 3);
    }
}
