package study;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 本課題では、代表的なコレクションフレームワークのArrayList及びHashMapを使い
 * くだものとその値段を管理するコードを記述します。
 */
public class Task2_21 {
    
    public static final String orange = "オレンジ";
    public static final String grape = "ぶどう";
    public static final String apple = "りんご";
    public static final String pear = "梨";

    public static void main(String[] args) {
        // ① ArrayList<String>型の変数fruitsArrayListを宣言し、値を格納
        ArrayList<String> fruitsArrayList = new ArrayList<>();
        fruitsArrayList.add(apple);
        fruitsArrayList.add(grape);
        fruitsArrayList.add(pear);
        fruitsArrayList.add(orange);

        // ② HashMap<String, Integer>型の変数fruitsHashMapを宣言し、値を格納
        HashMap<String, Integer> fruitsHashMap = new HashMap<>();
        fruitsHashMap.put(orange, 150);
        fruitsHashMap.put(grape, 120);
        fruitsHashMap.put(apple, 180);
        fruitsHashMap.put(pear, 140);

        // ③ オレンジの値段を200に上書き
        fruitsHashMap.put(orange, 200);

        // ④ 拡張for文を使って値を出力
        for (String fruit : fruitsArrayList) {
            int price = fruitsHashMap.get(fruit);
            System.out.println(fruit + "の値段は" + price + "です。");
        }
    }
}
