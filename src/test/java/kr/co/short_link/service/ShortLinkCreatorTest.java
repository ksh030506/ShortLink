package kr.co.short_link.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ShortLinkCreatorTest {

    @InjectMocks
    ShortLinkCreator sut;

    @Test
    void create_short_link() {
        String result = sut.executor();
        assertThat(result).isNotEmpty();
    }
}