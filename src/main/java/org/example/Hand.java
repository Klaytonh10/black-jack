package org.example;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cards;
    private String name;
    private boolean busts;
    private boolean wins;

    public Hand(String name) {
        this.name = name;
        cards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setBusts(boolean busts) {
        this.busts = busts;
    }
    public boolean getBusts() {
        return this.busts;
    }

    // A Card is dealt to the Hand and the Hand is responsible
    // to store the card
    public void deal(Card card) {
        cards.add(card);
    }

    public int getSize() {
        return cards.size();
    }

    // The Hand uses the methods of each card to determine
    // the value of each card - and adds up all values
    public int getValue() {
        int value = 0;
        for (Card card : cards) {
            card.flip(); // turn the card over to see the value
            value += card.getPointValue();
            card.flip(); // hide the card again
        }
        return value;
    }
}
