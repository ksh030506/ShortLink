package kr.co.ab180.controller;

import kr.co.ab180.message.ShortUrlRequest;
import kr.co.ab180.response.domain.SingleResult;
import kr.co.ab180.response.service.ResponseService;
import kr.co.ab180.service.LinkFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class LinksController {

    private final ResponseService response;
    private final LinkFactory linkFactory;

    @PostMapping("/short-links")
    public SingleResult<Object> healthCheck(@Valid @RequestBody ShortUrlRequest request) {
        return response.getSingleResult(linkFactory.create(request));
    }

}
