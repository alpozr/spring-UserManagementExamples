package com.alp.apitutorial;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "My User DTO",description = "User")
public class UserDto {
    @ApiModelProperty(value = "User's id field")
    private int id ;
    @ApiModelProperty(value = "User's username field")
    private String username;
    @ApiModelProperty(value = "User's pass field")
    private int password;
}
