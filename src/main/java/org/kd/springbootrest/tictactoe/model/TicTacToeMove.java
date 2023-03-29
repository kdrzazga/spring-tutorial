package org.kd.springbootrest.tictactoe.model;

public class TicTacToeMove {

    private String x;
    private String y;
    private String userName;

    public TicTacToeMove() {
    }

    public TicTacToeMove(String x, String y, String userName) {
        this.userName = userName;
        this.x = x;
        this.y = y;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
