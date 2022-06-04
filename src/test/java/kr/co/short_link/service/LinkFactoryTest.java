package kr.co.short_link.service;

import kr.co.short_link.domain.Links;
import kr.co.short_link.message.ShortUrlRequest;
import kr.co.short_link.repository.LinksRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class LinkFactoryTest {

    final Long LINK_ID_1 = 1L;
    final String SHORT_LINK = "test1";
    final String ORIGINAL_LINK = "https://naver.com";

    @InjectMocks
    LinkFactory sut;

    @Mock
    ShortLinkCreator shortLinkCreator;
    @Mock
    LinksRepository linksRepository;
    @Mock
    ShortUrlRequest request;

    @Test
    void save_short_link_and_original_link() {
        Links links = Links.of(LINK_ID_1, SHORT_LINK, ORIGINAL_LINK);

        given(shortLinkCreator.executor()).willReturn("test1");
        given(request.toEntity("test1")).willReturn(links);
        given(linksRepository.save(links)).willReturn(links);

        sut.create(request);

        verify(shortLinkCreator).executor();
        verify(linksRepository).save(links);
    }
}