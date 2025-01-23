package study;

public class Task2_20 {

    public static void main(String[] args) {
        // ④ 子クラスを元にしたインスタンスを作成して下さい。(インスタンス名：child)
        Child child = new Child();

        // ⑤ インスタンスchildでcallNameメソッドを呼び出して下さい。
        child.callName();

        // ⑥ インスタンスchildでupdateメソッドを呼び出して下さい。
        child.update();

        // ⑦ オーバーロードされたargumentメソッドを呼び出し解答画像になるように出力して下さい。
        child.argument();
        child.argument(1);
        child.argument(1, 1);
    }
}
