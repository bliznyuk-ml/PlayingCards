package org.example;

public class Card implements Comparable<Card> {
    private String dignity;
    private int level;
    Suite card;


    public Card(String dignity, int level, Suite card) {
        this.dignity = dignity;
        this.level = level;
        this.card = card;
    }

    public Card() {
    }

    public String getDignity() {
        return dignity;
    }

    public int getLevel() {
        return level;
    }

    public Suite getCard() {
        return card;
    }

    @Override
    public String toString() {
        return "\n Card{" +
                "dignity='" + dignity + '\'' +
                ", suite" + card + ", level " +
                '\'' + level + '\'' + '}';
    }

    @Override
    public int compareTo(Card o) {
        int result = this.card.compareTo(o.card);
        if (result == 0) {
            result = level - o.level;
        }
        return result;
    }
}
