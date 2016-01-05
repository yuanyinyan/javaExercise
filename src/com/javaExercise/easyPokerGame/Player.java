package com.javaExercise.easyPokerGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuanyin on 16/1/4.
 * 玩家类
 */
public class Player {
    private int ID;
    private String name;
    private List<Card> handCards;

    public Player(int ID, String name) {
        this.ID = ID;
        this.name = name;
        handCards = new ArrayList<Card>();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getHandCards() {
        return handCards;
    }

    public void setHandCards(List<Card> handCards) {
        this.handCards = handCards;
    }


}
