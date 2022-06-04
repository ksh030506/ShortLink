package kr.co.short_link.service;

import kr.co.short_link.domain.Links;
import kr.co.short_link.exception.datanotfound.DataNotFoundException;
import kr.co.short_link.exception.datanotfound.DataNotFoundType;
import kr.co.short_link.message.FindByShortIdResponse;
import kr.co.short_link.repository.LinksRepository;
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
