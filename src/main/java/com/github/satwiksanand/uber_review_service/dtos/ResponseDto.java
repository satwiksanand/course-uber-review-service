package com.github.satwiksanand.uber_review_service.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto {
    private String message;

    public ResponseDto(String message) {
        this.message = message;
    }
}
