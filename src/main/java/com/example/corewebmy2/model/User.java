package com.example.corewebmy2.model;


import com.example.corewebmy2.config.Constants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder(builderMethodName = "of", buildMethodName = "create")
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(exclude = {"id", "password", "hashedPassword"})
@EqualsAndHashCode(exclude = {"id", "password", "hashedPassword"})
public class User {
    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "userName")
    @Pattern(regexp = Constants.NAME_PASS, message = "wrong UserName")
    private String userName;

    @JsonProperty(value = "firstName")
    @Pattern(regexp = Constants.NAME_PASS, message = "wrong UserName")
    private String firstName;

    @NotNull
    @JsonProperty(value = "lastName")
    private String lastName;

    @NotNull
    @JsonProperty(value = "password")
    @Size(min = 4, max = 9, message = "change size")
    @Pattern(regexp = Constants.NAME_PASS, message = "wrong UserName")
    private String password;

    private String hashedPassword;
}
