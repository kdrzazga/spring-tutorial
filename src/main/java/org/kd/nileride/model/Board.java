package org.kd.nileride.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {

    private Vehicle vehicle;
    private Vehicle enemy;
    private Track track;
    private BoardKeyListener boardKeyListener;

    public final static int WIDTH = 500;
    public final static int HEIGHT = 500;

    public Board() {
        track = new Track();
    }

    public void move() {
        track.move(vehicle.getSpeed());

        moveEnemy();
    }

    public boolean checkCollision(){
        return track.getLeftBank().get(0) > vehicle.getX() - vehicle.getWIDTH()/2
                || track.getRightBank().get(0) < vehicle.getX() + vehicle.getWIDTH()/2;
    }

    private void moveEnemy() {
        //TODO
    }

}
