package kr.co.ab180.message;

import lombok.Value;

import java.time.LocalDateTime;

@Value(staticConstructor = "of")
public class FindByShortIdResponse {

    String shortId;
    String aliasName;
    LocalDateTime createdAt;

}
