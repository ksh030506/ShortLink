package kr.co.ab180.repository;

import kr.co.ab180.domain.Links;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LinksRepositoryTest {

    final Long LINK_ID_1 = 1L;
    final Long LINK_ID_2 = 2L;
    final String SHORT_LINK = "test1";
    final String ORIGINAL_LINK = "https://naver.com";

    @Autowired
    LinksRepository sut;

    @Test
    void save_short_link_duplicated() {
        Links links_1 = Links.of(LINK_ID_1, SHORT_LINK, ORIGINAL_LINK);
        sut.save(links_1);

        Links links_2 = Links.of(LINK_ID_1, SHORT_LINK, ORIGINAL_LINK);
        sut.save(links_2);
    }
}