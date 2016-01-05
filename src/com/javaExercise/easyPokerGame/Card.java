package com.javaExercise.easyPokerGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuanyin on 16/1/4.
 * 扑克牌类
 */
public class Card implements Comparable<Card> {
    public static final String[] COLORS = {"黑桃", "红桃", "梅花", "方片"};
    public static final String[] NUMBERS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private String color;
    private String number;

    public Card(String color, String number) {
        this.color = color;
        this.number = number;
    }

    @Override
    public int compareTo(Card o) {
        List<String> colorList = new ArrayList<String>();
        List<String> numberList = new ArrayList<String>();
        colorList.addAll(Arrays.asList(COLORS));
        numberList.addAll(Arrays.asList(NUMBERS));
        if (numberList.indexOf(number) == numberList.indexOf(o.number)) {
            return colorList.indexOf(o.color) - colorList.indexOf(color);
        } else {
            return numberList.indexOf(number) - numberList.indexOf(o.number);
        }
    }

    @Override
    public String toString() {
        return color + number ;
    }
}
