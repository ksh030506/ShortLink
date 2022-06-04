package kr.co.short_link.service;

import kr.co.short_link.exception.datanotfound.DataNotFoundException;
import kr.co.short_link.exception.datanotfound.DataNotFoundType;
import kr.co.short_link.repository.LinksRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class LinkRedirect {
    private final LinksRepository linksRepository;

    public void execute(HttpServletResponse response, String short_id) {
        String originalLink = linksRepository.findByShortLink(short_id)
                .orElseThrow(() -> new DataNotFoundException(DataNotFoundType.NOT_FOUND_LINK))
                .getOriginalLink();

        try {
            response.sendRedirect(originalLink);
        } catch (IOException e) {
            log.error(String.valueOf(e));
        }
    }
}
