package study;

// ① Parent（親クラス）を継承して下さい
public class Child extends Parent {

    // ② 親クラスのnameメソッドを呼び出すcallNameメソッドを作成して下さい
    public void callName() {
        super.name(); // 親クラスのnameメソッドを呼び出します
    }

    // ③ 親クラスのupdateメソッドをオーバーライドして、updateメソッドが呼び出された際に、
    // 「上書きされました。」と表示されるようにして下さい
    @Override
    public void update() {
        System.out.println("上書きされました。");
    }
}
