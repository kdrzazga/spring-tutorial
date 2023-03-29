package org.kd.nileride.model;

import lombok.Getter;
import lombok.Setter;

public class Vehicle {
    @Getter
    @Setter
    private int x, y, speed;
    private final int MIN_SPEED = 0;
    private final int MAX_SPEED = 3;

    @Getter
    private final double WIDTH = 1.5;

    @Getter
    private final double HEIGHT = 2.5;

    public void accelerate() {
        if (speed < MAX_SPEED) {
            speed++;
        }
    }

    public void slowDown() {
        if (speed > MIN_SPEED)
            speed--;
    }

}
