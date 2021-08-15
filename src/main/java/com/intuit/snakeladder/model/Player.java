package com.intuit.snakeladder.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Player {
    private String name;
    private int position;
    private Boolean won;
    private String id;
}
