package com.game.restgame;

public class Game {
    private int balance=100;
    private int betAmount=10;
    private int[] possibleNumbers= {1,2,3,4,5,6,7,8,9,10,11};

    public Game(int balance){
        this.balance = balance;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBetAmount() {
        return this.betAmount;
    }

    public void setBetAmount(int betAmount) {
        this.betAmount = betAmount;
    }

    @Override
    public String toString(){
        return String.valueOf(this.balance);
    }
}
