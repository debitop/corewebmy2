package com.example.corewebmy2.dto;

import com.example.corewebmy2.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder(buildMethodName = "create", builderMethodName = "of")
public class UserDto {
    @JsonProperty(value = "id")
    private long id;

    @JsonProperty(value = "userName")
    private String userName;

    @JsonProperty(value = "firstName")
    private String firstName;

    @JsonProperty(value = "lastName")
    private String lastName;

    public interface UserDtoInterface {
        static UserDto toUserDto(User user) {
            return UserDto.of()
                    .id(user.getId())
                    .userName(user.getUserName())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .create();
        }
    }

}
