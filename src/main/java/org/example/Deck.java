package org.example;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class Deck extends Card implements Iterable<Deck> {

    private final static int DECK36 = 36;
    private final static int DECK54 = 54;
    private final static int INDEX36START = 4;
    private final static int INDEX36FINISH = 13;
    private final static int INDEX54START = 0;
    Card[] deck;

    public Deck(int deckNumber) {
        this.deck = new Card[0];
        if (deckNumber == DECK36) {
            addCard(INDEX36START, INDEX36FINISH);
        }
        if (deckNumber == DECK54) {
            addCard(INDEX54START, INDEX36FINISH);
        } else {
            System.err.println("Incorrect enter");
        }
    }

    public Deck() {
        deck = new Card[0];
        addCard(INDEX36START, INDEX36FINISH);
    }

    private final String[] dignityArr = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace", "Joker"};
    private final int[] levelArr = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

    //можливо метод addCard можна написати простіше та елегантніше (мені не подобається) з використанням проміжних методів, можливо пізніше перепишу
    public void addCard(int startIndex, int finishIndex) {
        // Чому би не зробити вкладений цикл по значенням перерахування Suite?
        for (int i = startIndex; i < finishIndex; i++) {
            deck = Arrays.copyOf(deck, deck.length + 1);
            deck[deck.length - 1] = new Card(dignityArr[i], levelArr[i], Suite.DIAMONDS);
        }
        for (int i = startIndex; i < finishIndex; i++) {
            deck = Arrays.copyOf(deck, deck.length + 1);
            deck[deck.length - 1] = new Card(dignityArr[i], levelArr[i], Suite.CLUBS);
        }
        for (int i = startIndex; i < finishIndex; i++) {
            deck = Arrays.copyOf(deck, deck.length + 1);
            deck[deck.length - 1] = new Card(dignityArr[i], levelArr[i], Suite.HEARTS);
        }
        for (int i = startIndex; i < finishIndex; i++) {
            deck = Arrays.copyOf(deck, deck.length + 1);
            deck[deck.length - 1] = new Card(dignityArr[i], levelArr[i], Suite.SPADES);
        }
        if (startIndex == INDEX54START) {
            deck = Arrays.copyOf(deck, deck.length + 2);
            deck[deck.length - 2] = new Card(dignityArr[INDEX36FINISH], levelArr[INDEX36FINISH], Suite.JOKER);
            deck[deck.length - 1] = new Card(dignityArr[INDEX36FINISH], levelArr[INDEX36FINISH], Suite.JOKER);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(deck);
    }

    public void shuffle() {
        Random random = new Random(); // екземпляр цього класу краще зропити змінною класу (полем)
        for (int i = 0; i < deck.length; i++) {
            Card tmp = deck[i];
            int rnd = random.nextInt(0, deck.length);
            deck[i] = deck[rnd];
            deck[rnd] = tmp;
        }
    }

    public void sort() {
        Arrays.sort(deck);
    }

    @Override
    public Iterator<Deck> iterator() {
        return new DeckIterator(deck);
    }
}
