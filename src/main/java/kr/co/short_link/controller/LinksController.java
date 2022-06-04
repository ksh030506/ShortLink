package kr.co.short_link.controller;

import kr.co.short_link.domain.SingleResult;
import kr.co.short_link.message.FindByShortIdResponse;
import kr.co.short_link.message.ShortUrlRequest;
import kr.co.short_link.message.ShortUrlResponse;
import kr.co.short_link.service.LinkFactory;
import kr.co.short_link.service.LinkFinder;
import kr.co.short_link.service.LinkRedirect;
import kr.co.short_link.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class LinksController {

    private final ResponseService response;
    private final LinkFactory linkFactory;
    private final LinkFinder linkFinder;
    private final LinkRedirect linkRedirect;

    @PostMapping("/short-links")
    public SingleResult<ShortUrlResponse> createLinks(@Valid @RequestBody ShortUrlRequest request) {
        return response.getSingleResult(linkFactory.create(request));
    }

    @GetMapping("/short-links/{short_id}")
    public SingleResult<FindByShortIdResponse> findBy(@PathVariable String short_id) {
        return response.getSingleResult(linkFinder.findBy(short_id));
    }

    @GetMapping("/r/{short_id}")
    public void redirectUrl(HttpServletResponse response, @PathVariable String short_id) {
        linkRedirect.execute(response, short_id);
    }
}
