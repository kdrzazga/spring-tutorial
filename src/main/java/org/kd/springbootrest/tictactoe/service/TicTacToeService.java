package org.kd.springbootrest.tictactoe.service;

import org.kd.springbootrest.tictactoe.model.TicTacToeTable;

public class TicTacToeService {

    private TicTacToeTable table = new TicTacToeTable();

    public TicTacToeTable getTable() {
        table.putX(1, 2);
        table.putO(0, 2);
        return table;
    }

}
