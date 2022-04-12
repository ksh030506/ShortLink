package kr.co.ab180.service;

import kr.co.ab180.domain.Links;
import kr.co.ab180.exception.datanotfound.DataNotFoundException;
import kr.co.ab180.repository.LinksRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class LinkRedirectTest {

    final Long LINK_ID_1 = 1L;
    final String SHORT_LINK = "test1";
    final String ORIGINAL_LINK = "https://naver.com";

    @InjectMocks
    LinkRedirect sut;

    @Mock
    LinksRepository linksRepository;
    @Mock
    HttpServletResponse response;

    @Test
    void not_find_link() {
        given(linksRepository.findByShortLink(SHORT_LINK)).willThrow(DataNotFoundException.class);
        assertThatThrownBy(() -> sut.execute(response, SHORT_LINK)).isInstanceOf(DataNotFoundException.class);
    }

    @Test
    void send_redirect() throws IOException {
        Links links = Links.of(LINK_ID_1, SHORT_LINK, ORIGINAL_LINK);
        given(linksRepository.findByShortLink(SHORT_LINK)).willReturn(Optional.of(links));

        sut.execute(response, SHORT_LINK);

        verify(response).sendRedirect(any());
    }
}