package com.example.quizmillionaire.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlayerAnswerRequest {
    private Long answerId;
    private Long questionId;
    private String languageAbbrev;
    private String language;
}
