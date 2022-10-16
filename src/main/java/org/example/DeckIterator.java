package org.example;

import java.util.Iterator;

public class DeckIterator implements Iterator {
    private final Card[] deck;
    private int index;

    public DeckIterator(Card[] deck) {
        this.deck = deck;
        this.index = -1;
    }

    @Override
    public boolean hasNext() {
        return ++index < deck.length;
    }

    @Override
    public Object next() {
        return deck[index];
    }
}
