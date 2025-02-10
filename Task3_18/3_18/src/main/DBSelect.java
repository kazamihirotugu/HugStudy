package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ■ データベースに接続するプログラム
 * データベースに接続し、任意のカラムを表示させる処理。
 *
 * 問①〜問⑥までの回答をお願いします。
 *
 * 実行結果の提出に関しては、
 * いつも通りソースをコミットしていただきますが、
 * 今回は実行結果のスクリーンショットも合わせて提出していただきます。
 * 画像名はDBSelect.pngとして、3-18フォルダの中に入れ、これまでと同様に提出して下さい。
 *
 */

public class DBSelect {

	 /** ドライバーのクラス名 */
    private static final String POSTGRES_DRIVER = "org.postgresql.Driver";
    /** ・JDBC接続先情報 */
    // 問① データベースのホスト名・データベース名を定数にしなさい。
    private static final String JDBC_CONNECTION = "jdbc:postgresql://localhost:5433/jdbc_db";
    /** ・ユーザー名 */
    // 問② データベースのユーザー名を定数にしなさい。
    private static final String USER = "postgres"; /** ・パスワード */
    // 問③ データベースのパスワードを定数にしなさい。  /** パスワード（問③） */
    private static final String PASS = "jyon0506";

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(POSTGRES_DRIVER);

            // データベースに接続（問④）
            connection = DriverManager.getConnection(JDBC_CONNECTION, USER, PASS);
            statement = connection.createStatement();

            // SQL文：SHOHIN_ID が '001' または '020' のデータを取得（問⑤）
            String SQL = "SELECT SHOHIN_ID, SHOHIN_NAME, TANKA FROM SHOHIN_TB WHERE SHOHIN_ID IN ('001', '020')";
            resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                // カラム名を指定してデータ取得（問⑥）
                String column1 = resultSet.getString("SHOHIN_ID");   // 商品ID
                String column2 = resultSet.getString("SHOHIN_NAME"); // 商品名
                int column3 = resultSet.getInt("TANKA");             // 単価

                System.out.print(column1 + ",");
                System.out.print(column2 + ",");
                System.out.println(column3);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("JDBCドライバが見つかりません。");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("データベース接続に失敗しました。");
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("リソースのクローズ時にエラーが発生しました。");
                e.printStackTrace();
            }
        }
    }
}
