package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        deck.shuffle();

        System.out.print("Enter player 1 name: ");
        String p1Name = scanner.nextLine();
        System.out.print("Enter player 2 name: ");
        String p2Name = scanner.nextLine();
        System.out.println();

        Hand p1 = new Hand(p1Name);
        Hand p2 = new Hand(p2Name);

        p1.deal(deck.deal());
        p2.deal(deck.deal());
        p1.deal(deck.deal());
        p2.deal(deck.deal());

        if(p1.getValue() > 21) {
            System.out.println(p1.getName() + " Bustsn\n");
            p1.setBusts(true);
        } else {
            System.out.println(p1.getName() + "'s hand is " + p1.getValue() + "\n");
        }

        if(p2.getValue() > 21) {
            System.out.println(p2.getName() + " Busts\n");
            p2.setBusts(true);
        } else {
            System.out.println(p2.getName() + "'s hand is " + p2.getValue() + "\n");
        }

        if(p1.getBusts() && p2.getBusts()) {
            System.out.println("NO WINNER");
        } else if(p1.getBusts() && !p2.getBusts()) {
            System.out.println(p2.getName().toUpperCase() + " WINS");
        } else if(!p1.getBusts() && p2.getBusts()) {
            System.out.println(p1.getName().toUpperCase() + " WINS");
        } else if(p1.getValue() == p2.getValue()) {
            System.out.println("TIE");
        } else if(p1.getValue() > p1.getValue()) {
            System.out.println(p1.getName().toUpperCase() + " WINS");
        } else if (p2.getValue() > p1.getValue()) {
            System.out.println(p2.getName().toUpperCase() + " WINS");
        }
    }
}