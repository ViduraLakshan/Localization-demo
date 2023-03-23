package com.example.demo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @ApiModelProperty(notes = "Name for User", example = "jone")
    private String name;
    @ApiModelProperty(notes = "enter message", example = "hi how are you")
    private String message;

}
