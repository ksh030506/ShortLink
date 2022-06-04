package kr.co.ab180.message;

import lombok.Value;

import java.time.LocalDateTime;

@Value(staticConstructor = "of")
public class ShortUrlResponse {

     String url;
     String shortId;
     LocalDateTime createdAt;

}