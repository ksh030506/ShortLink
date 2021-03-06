package kr.co.short_link.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class ShortLinkCreator {

    public String executor() {
        return RandomStringUtils.randomAlphanumeric(8) + System.currentTimeMillis();
    }

}
