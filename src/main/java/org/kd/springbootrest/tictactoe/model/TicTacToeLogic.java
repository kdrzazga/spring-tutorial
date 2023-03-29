package org.kd.springbootrest.tictactoe.model;

public class TicTacToeLogic {

    private TicTacToeTable table = new TicTacToeTable();

    public TicTacToeTable getTable() {
        table.putX(1, 2);
        table.putO(0, 2);
        return table;
    }

}
