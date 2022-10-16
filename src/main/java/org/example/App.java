package org.example;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        Deck deck = new Deck(54);
        System.out.println(deck);

        deck.shuffle();
        System.out.println(deck);

        deck.sort();
        System.out.println(deck);

        for (Card c : deck) {
            System.out.println(c.getDignity() + c.card);
        }

        Deck deck1 = new Deck();
        System.out.println(deck1);
    }
}
