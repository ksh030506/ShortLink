package kr.co.short_link.message;

import lombok.Value;

import java.time.LocalDateTime;

@Value(staticConstructor = "of")
public class ShortUrlResponse {

     String url;
     String shortId;
     LocalDateTime createdAt;

}