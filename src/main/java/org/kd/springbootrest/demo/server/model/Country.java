package org.kd.springbootrest.demo.server.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Country {
    private String name;
    private Capital capital;

    private Country() {
    }
}
