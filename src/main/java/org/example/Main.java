package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        deck.shuffle();

        ArrayList<Hand> hands = new ArrayList<>();
        ArrayList<Hand> handsHolding = new ArrayList<>();

        System.out.print("How many players: ");
        String playerAmount = scanner.nextLine();

        for (int i = 1; i <= Integer.parseInt(playerAmount); i++) {
            System.out.print("Enter player " + i + " name: ");
            String name = scanner.nextLine();
            Hand hand = new Hand(name);
            hands.add(hand);
            System.out.println(hand.getName() + " added to the game\n");
        }
        for (Hand hand : hands) {
            System.out.println(hand.getName() + " has 2 cards");
            hand.deal(deck.deal());
            hand.deal(deck.deal());
        }
        System.out.println();

        Hand winningHand = new Hand("winning hand");

        for (Hand hand : hands) {
            deck.shuffle();
            while (hand.getValue() < 21) {
                System.out.println(hand.getName() + "'s turn");
                System.out.println("Hand value: " + hand.getValue() + "\nHit(z) or hold(x)");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("z")) {
                    hand.deal(deck.deal());
                } else if (input.equalsIgnoreCase("x")) {
                    hand.setIsHolding(true);
                    handsHolding.add(hand);
                    break;
                } else {
                    System.out.println("Improper input, please try again");
                }
                System.out.println();
            }
            if (hand.getValue() > 21) {
                System.out.println(hand.getName() + " BUSTS with " + hand.getValue() + "\n");
            } else if (hand.getValue() == 21 && hand.getValue() != winningHand.getValue()) {
                handsHolding.add(hand);
                winningHand = hand;
            } else if (hand.getValue() == 21 && hand.getValue() == winningHand.getValue()) {
                handsHolding.add(hand);
                System.out.println("TIE");
            } else if(hand.getValue() > 21) {
                handsHolding.add(hand);
            }
        }

        int highestValue = 0;

        for (Hand hand : handsHolding) {
            if(hand.getValue() > highestValue) {
                highestValue = hand.getValue();
                winningHand = hand;
            } else {
                break;
            }
        }
        String winningMessage = winningHand.getName() + " is the winner with " + winningHand.getValue() + " points";
        System.out.println(winningMessage);
    }
}