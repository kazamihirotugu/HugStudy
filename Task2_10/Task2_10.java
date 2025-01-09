/**
* Task2-10 : 課題内容
*
* 本課題では、ループ文に記述に慣れていきましょう。
* 問①〜問④まであります。
* for文・while文の仕組みを意識しながらコーディングしていきましょう！
*/
public class Task2_10 {

    public static void main(String[] args) {

        // ① 「みかん」、「りんご」、「ぶどう」、「メロン」の値を設定した配列 fruits を作成してください。
        String[] fruits = {"みかん", "りんご", "ぶどう", "メロン"};

        // ② for文を使って①で作成した配列を出力しなさい。
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // ③ 以下のwhile文の処理について、何をしているのかコメントを記入してください。
        /*
        * 1から50までの整数を連続して出力。
        * その後、改行を入れる。
        */
        int i = 1;
        while (i <= 50) {
            System.out.print(i);
            i++;
        }
        System.out.println(); // 改行

        /* ④ 行の最初に「段数」と「||」を追加したものを表示させるプログラムを作成しなさい。
        * 5 || 5 | 10 | 15 | 20 | 25 | 30 | 35 | 40 | 45 |
        * 6 || 6 | 12 | 18 | 24 | 30 | 36 | 42 | 48 | 54 |
        * 7 || 7 | 14 | 21 | 28 | 35 | 42 | 49 | 56 | 63 |
        * 8 || 8 | 16 | 24 | 32 | 40 | 48 | 56 | 64 | 72 |
        * 9 || 9 | 18 | 27 | 36 | 45 | 54 | 63 | 72 | 81 |
        */
        for (int dan = 5; dan <= 9; dan++) {
            System.out.print(dan + " ||"); 
            for (int j = 1; j <= 9; j++) {
                System.out.print(" " + (dan * j) + " |"); 
            }
            System.out.println();
        }
    }
}
