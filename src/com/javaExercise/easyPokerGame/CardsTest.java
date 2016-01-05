package com.javaExercise.easyPokerGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yuanyin on 16/1/4.
 * <p/>
 * 简易扑克牌游戏
 * 1.创建一副扑克牌，不考虑大小王
 * 2.创建两名玩家，玩家至少要有ID、姓名、手牌等属性，手牌为扑克牌的集合
 * 3.洗牌，将之前创建的扑克牌顺序打乱
 * 4.发牌，将洗牌之后的扑克牌集合，从第一张开始，发给两名玩家，按照一人一张的方式，每人发两张
 * 5.开始游戏，比大小，大小相同比花色(黑红梅方)
 */
public class CardsTest {
    private List<Card> cardList = new ArrayList<Card>();
    private List<Player> playerList = new ArrayList<Player>();

    public static void main(String[] args) {
        System.out.println("简易扑克牌游戏!");
        CardsTest cardsTest = new CardsTest();
        int playerNumber = 4;//玩家人数
        int handNumber = 7;//每人应得的手牌张数
        cardsTest.createCards();
        cardsTest.shuffle();
        cardsTest.createPlayer(playerNumber);
        cardsTest.deliverCards(handNumber);
        cardsTest.gameBegin();
    }

    /**
     * 1.创建一副扑克牌，不考虑大小王
     */
    public void createCards() {
        System.out.println("-----------创建扑克牌...-------------");
        for (int i = 0; i < Card.COLORS.length; i++) {
            for (int j = 0; j < Card.NUMBERS.length; j++) {
                Card card = new Card(Card.COLORS[i], Card.NUMBERS[j]);
                cardList.add(card);
            }
        }
        System.out.println("----------扑克牌创建成功!------------");
        System.out.println("为:" + cardList.toString());
    }

    /**
     * 3.洗牌，将之前创建的扑克牌顺序打乱
     */
    public void shuffle() {
        System.out.println("-----------开始洗牌...-------------");
        Collections.shuffle(cardList);
        System.out.println("-----------洗牌结束!-------------");
    }

    /**
     * 2.创建两名玩家，玩家至少要有ID、姓名、手牌等属性，手牌为扑克牌的集合
     *
     * @param playerNumber 玩家人数
     */
    public void createPlayer(int playerNumber) {
        System.out.println("-----------创建玩家...-------------");
        for (int i = 0; i < playerNumber; i++) {
            System.out.println("请输入第" + (i + 1) + "玩家的ID和姓名:");
            int ID = getId();
            System.out.println("输入姓名:");
            String name = new Scanner(System.in).next();
            playerList.add(new Player(ID, name));
        }
        for (Player player : playerList) {
            System.out.println("----欢迎玩家:" + player.getName());
        }
    }

    /**
     * 获取玩家ID
     */
    public int getId() {
        System.out.println("输入ID:");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            System.out.println("输入格式错误! 请输入正整数ID:");
            return getId();
        }
    }

    /**
     * 4.发牌，将洗牌之后的扑克牌集合，从第一张开始，发给两名玩家，按照一人一张的方式，每人发两张
     *
     * @param handNumber 每人应得的手牌张数
     */
    public void deliverCards(int handNumber) {
        System.out.println("-----------开始发牌...-------------");
        int playerNumber = playerList.size();
        for (int i = 0; i < playerNumber * handNumber; i = i + playerNumber) {
            for (int j = 0; j < playerNumber; j++) {
                Player player = playerList.get(j);
                player.getHandCards().add(cardList.get(i + j));
                System.out.println("----玩家:" + player.getName() + "-拿牌");
            }
        }
        System.out.println("-----------发牌结束-------------");
    }

    /**
     * 5.开始游戏，比大小，大小相同比花色(黑红梅方)
     */
    public void gameBegin() {
        System.out.println("-----------开始游戏...-------------");
        List<Card> maxCardList = new ArrayList<Card>();
        for (int i = 0; i < playerList.size(); i++) {
            List<Card> handCards = playerList.get(i).getHandCards();
            maxCardList.add(Collections.max(handCards));
            System.out.println("玩家:" + playerList.get(i).getName() + "最大的手牌为:" + maxCardList.get(i).toString());
        }
        Card maxCard = Collections.max(maxCardList);
        System.out.println("---------玩家:" + playerList.get(maxCardList.indexOf(maxCard)).getName() + "获胜!----------");
        System.out.println("玩家各自的手牌为:");
        for (Player player : playerList) {
            System.out.println(player.getName() + ":" + player.getHandCards().toString());
        }
    }

}
