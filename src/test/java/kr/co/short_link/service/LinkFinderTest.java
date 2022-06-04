package kr.co.short_link.service;

import kr.co.short_link.domain.Links;
import kr.co.short_link.exception.datanotfound.DataNotFoundException;
import kr.co.short_link.message.FindByShortIdResponse;
import kr.co.short_link.repository.LinksRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class LinkFinderTest {

    final Long LINK_ID_1 = 1L;
    final String SHORT_LINK = "test1";
    final String ORIGINAL_LINK = "https://naver.com";

    @InjectMocks
    LinkFinder sut;

    @Mock
    LinksRepository linksRepository;

    @Test
    void find_link() {
        Links links = Links.of(LINK_ID_1, SHORT_LINK, ORIGINAL_LINK);
        given(linksRepository.findByShortLink(SHORT_LINK)).willReturn(Optional.of(links));

        FindByShortIdResponse result = sut.findBy(SHORT_LINK);
        assertThat(result).isNotNull();
    }

    @Test
    void not_find_link() {
        given(linksRepository.findByShortLink("not")).willThrow(DataNotFoundException.class);
        assertThatThrownBy(() -> sut.findBy("not")).isInstanceOf(DataNotFoundException.class);
    }
}