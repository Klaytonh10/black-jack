package org.example;

import java.util.Scanner;

public class Card {

    private String suit;
    private String rank;
    private int pointValue;
    private boolean isFaceUp;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
        this.pointValue = getPointValue();
        this.isFaceUp = false;
    }
    public String getSuit(){
        // only return the suit if the card is face up
        if(isFaceUp){
            return suit;
        } else {
            return null;
        }
    }
    public String getRank(){
    // only return the value if the card is face up
        if(isFaceUp){
        // this is the string value of the card
        // i.e. A, K, Q, J, 10, 9 ...
            return rank;
        } else {
            return null;
        }
    }
    public int getPointValue(){
        // only return the value if the card is face up
        int pointValue;
        if(this.isFaceUp){
            switch (this.rank) {
                case "2":
                    return 2;
                case "3":
                    return 3;
                case "4":
                    return 4;
                case "5":
                    return 5;
                case "6":
                    return 6;
                case "7":
                    return 7;
                case "8":
                    return 8;
                case "9":
                    return 9;
                case "10":
                    return 10;
                case "J", "Q", "K":
                    return 10;
                case "A":
                    return 11;
                default:
                    try {
                        return Integer.parseInt(this.rank);
                    } catch (NumberFormatException e) {
                        System.out.println(e);
                    }
            }
            // TODO: fix this
        // determine point value and return it
        // A = 11
        // K, Q, J = 10
        // all numeric cards are equal to their face value
        }
        return this.pointValue;
    }
    public boolean isFaceUp(){
        return isFaceUp;
    }
    public void flip(){
        isFaceUp = !isFaceUp;
    }
}
