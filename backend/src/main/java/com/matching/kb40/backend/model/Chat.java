package com.matching.kb40.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Chat {
    private Long chatId;           // auto_increment
    private Long matchId;
    private String userId;
    private String content;
    private String readFlag;
    private String createdDate;
}
