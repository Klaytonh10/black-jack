package org.example;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();

        deck.shuffle();

        Hand john = new Hand();
        Hand greg = new Hand();

        john.getValue();
    }
}