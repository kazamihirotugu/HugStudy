package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ■ データベースに接続するプログラム
 * データベースへ接続し、指定(任意)の値を取得し、表示させる処理。
 * 問①〜⑤の回答をお願いします。
 *
 * 実行結果の提出に関しては、
 * いつも通りソースをコミットしていただきますが、
 * 今回は実行結果のスクリーンショットも合わせて提出していただきます。
 * 画像名はDBPrepared.pngとして、3-18フォルダの中に入れ、これまでと同様に提出して下さい。
 *
 */

public class DBPrepared {

	 /** ドライバーのクラス名 */
    private static final String POSTGRES_DRIVER = "org.postgresql.Driver";
    /** ・JDMC接続先情報 */
    // 問① データベースのホスト名・データベース名を定数にしなさい。
    private static final String JDBC_CONNECTION = "jdbc:postgresql://localhost:5433/jdbc_db";
    /** ・ユーザー名 */
    // 問② データベースのユーザー名を定数にしなさい
    private static final String USER = "postgres";
    /** ・パスワード */
    // 問③ データベースのパスワードを定数にしなさい。
    private static final String PASS = "jyon0506";

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(POSTGRES_DRIVER);

            // データベースに接続（問④）
            connection = DriverManager.getConnection(JDBC_CONNECTION, USER, PASS);

            // SQL 文の準備（問⑤）
            String SQL = "SELECT * FROM SHOHIN_TB WHERE SHOHIN_ID = ? OR SHOHIN_ID = ?";
            preparedStatement = connection.prepareStatement(SQL);

            // プレースホルダーに値をセット（問⑤）
            preparedStatement.setString(1, "001");
            preparedStatement.setString(2, "020");

            // SQL 実行
            resultSet = preparedStatement.executeQuery();

            // 結果を表示
            while (resultSet.next()) {
                String column1 = resultSet.getString("SHOHIN_ID");
                String column2 = resultSet.getString("SHOHIN_NAME");
                int column3 = resultSet.getInt("TANKA");

                System.out.print(column1 + ",");
                System.out.print(column2 + ",");
                System.out.println(column3);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("JDBCドライバが見つかりません。");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("データベース操作中にエラーが発生しました。");
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("リソースのクローズ時にエラーが発生しました。");
                e.printStackTrace();
            }
        }
    }
}
