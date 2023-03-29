package org.kd.springbootrest.tictactoe.repository;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class TicTacToeLoginRepository {

    public UserDetails getPlayerX() {
        return User.withDefaultPasswordEncoder()
                .username("playerx")
                .password("pass")
                .roles("PLAYER")
                .build();
    }

    public UserDetails getPlayerO() {
        return User.withDefaultPasswordEncoder()
                .username("playero")
                .password("pass")
                .roles("PLAYER")
                .build();
    }
}
