package com.matching.kb40.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
    private String userId;
    private String mydataId;
    private String job;
    private String mbtiMind;
    private String mbtiRecog;
    private String mbtiJudge;
    private String mbtiTactics;
    private String profileOriname;
    private String profileFilename;
    private String profileUrl;
    private Integer userPoint;
    private String petPrefer;
    private String nickname;
    private String agreeFlag;
}
