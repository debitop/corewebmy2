package com.example.corewebmy2.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder(buildMethodName = "create", builderMethodName = "of")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserAlreadyExistResponse {

    @JsonProperty(value = "error")
    private String error;

    @JsonProperty
    private String errorDescription;

    @JsonProperty(value = "httpStatus")
    private HttpStatus httpStatus;

    private final long versionUID=-1234567890L;


}
