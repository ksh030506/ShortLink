package kr.co.ab180.service;

import kr.co.ab180.domain.Links;
import kr.co.ab180.message.ShortUrlRequest;
import kr.co.ab180.message.ShortUrlResponse;
import kr.co.ab180.repository.LinksRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class LinkFactoryTest {

    final Long LINK_ID_1 = 1L;
    final Long LINK_ID_2 = 2L;
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
    void create_short_link() {
        sut.create(any());

        verify(shortLinkCreator).executor();
    }

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

    @Test // TODO
    void save_short_link_duplicated() {
        Links links_1 = Links.of(LINK_ID_1, SHORT_LINK, ORIGINAL_LINK);
        Links links_2 = Links.of(LINK_ID_2, SHORT_LINK, ORIGINAL_LINK);

        given(shortLinkCreator.executor()).willReturn(SHORT_LINK);
        given(request.toEntity(SHORT_LINK)).willReturn(links_1);
        given(linksRepository.save(links_1)).willReturn(links_1);

        ShortUrlResponse shortUrlResponse = sut.create(request);

        given(shortLinkCreator.executor()).willReturn(SHORT_LINK);
        given(request.toEntity(SHORT_LINK)).willReturn(links_2);
        given(linksRepository.save(links_2)).willReturn(links_2);

        sut.create(request);
        assertThatThrownBy(() -> linksRepository.save(links_2));
    }

    @Test // TODO
    void duplicated_original_link() {



    }
}