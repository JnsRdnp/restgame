package com.game.restgame;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonGetter;
   

public class Game {
    private int balance=100;
    private int betAmount=10;
    private int currentNumber=0;
    private int dealerNumber=0;
    Random RandonNumber = new Random();


    public Game(int balance){
        this.balance = balance;
    }

    public void resetNumbers(){
        this.currentNumber = 0;
        this.dealerNumber = 0;
    }

    public int getPlayerNumber(){
        return this.currentNumber;
    }

    public String currentNumberStr(){
        return String.valueOf(this.currentNumber);
    }

    public int getDealerNumber() {
        return this.dealerNumber;
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

    public String hit(){
        if (currentNumber<21){
            currentNumber += RandonNumber.nextInt(11)+1;
            if(currentNumber==21) {
                return "You got 21!";
            }
            return currentNumberStr();
        }else{
            // this.balance -= this.betAmount;
            return "You went over 21 -> "+ currentNumberStr();
        }
    }

    public String stay(){
        for (; this.dealerNumber < 17; ) {
            this.dealerNumber += RandonNumber.nextInt(11) + 1;
        }
        if(this.dealerNumber<=21 && this.dealerNumber>this.currentNumber){
            return String.format("You: %d  Dealer: %d | Dealer won!", currentNumber, dealerNumber);
        } else{
            return String.format("You: %d  Dealer: %d | You won!", currentNumber, dealerNumber);
        }
    }

    // @JsonGetter("balance")
    // public String getTheName() {
    //     return String.valueOf(this.balance);
    // }


    // @Override
    // public String toString(){
    //     return String.valueOf(this.balance);
    // }
}
