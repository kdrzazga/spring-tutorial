package org.kd.nileride.model;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BoardKeyListener implements EventHandler<KeyEvent> {

    private Board board;

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case UP:
                board.getVehicle().slowDown();
                break;

            case DOWN:
                board.getVehicle().accelerate();
                break;

            case LEFT:
                board.getTrack().moveBanks(1);
                break;

            case RIGHT:
                board.getTrack().moveBanks(-1);
                break;
        }
    }

}
