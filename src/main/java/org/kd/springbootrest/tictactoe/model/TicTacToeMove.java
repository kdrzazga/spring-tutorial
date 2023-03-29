package org.kd.springbootrest.tictactoe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicTacToeMove {

    private String x;
    private String y;
    private String userName;
}
