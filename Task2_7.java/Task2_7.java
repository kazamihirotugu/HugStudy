/**
* Task2-7 : 課題内容
*
* 本課題では、配列の使い方を学んでいきましょう。
* 問①から問⑥まであります。
* 指定された値と変数名を守って記述して下さい。
*
* 問⑤,⑥については、コメントを入れて下さい。
*
*/
public class Task2_7 {

    public static void main(String[] args) {
       // ① 「JAPAN」、「AMERICA」、「KOREA」、「ENGLAND」を要素の値（初期値）とする配列 countryを作成しなさい。
       String[] country = {"JAPAN", "AMERICA", "KOREA", "ENGLAND"};

       // ② ①で作成した配列の要素数を出力して下さい。
       System.out.println(country.length);

        /* ③ 下記の値を保持した、要素数3のStringクラスの配列strArrayを作成しなさい。
        *   1番目（先頭）の要素に 「りんご」 を代入
        *   2番目の要素に 「もも」 を代入
        *   3番目の要素に 「ぶどう」 を代入
        */
       String[] strArray = {"りんご", "もも", "ぶどう"};

       // ④ ③で作成した配列の3番目の要素を出力しなさい。
       System.out.println(strArray[2]);

        /* ⑤ 下記の処理について、何をしているのかコメントを記入して下さい。
        *  int型の配列intArrayを初期化、5つの要素にそれぞれ「10, 20, 30, 40, 50」を代入
        */
        int[] intArray = { 10, 20, 30, 40, 50 };

       // ⑥ 下記の処理について、何をしているのかコメントを記入して下さい。
       // 配列intArrayの1番目の要素（値10）と5番目の要素（値50）を加算、結果（値60）を出力
        System.out.println(intArray[0] + intArray[4]);
    }
}
