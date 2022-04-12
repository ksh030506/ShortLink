package kr.co.ab180.message;

import lombok.*;

import java.time.LocalDateTime;

@Value(staticConstructor = "of")
public class FindByShortIdResponse {

    String shortId;
    String aliasName;
    LocalDateTime createdAt;

}
