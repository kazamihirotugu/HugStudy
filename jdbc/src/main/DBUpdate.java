package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ■ データベースに接続するプログラム
 * データベースに接続し、テーブルの内容を変更する処理。
 */

public class DBUpdate {

    /** ドライバーのクラス名 */
    private static final String POSTGRES_DRIVER = "org.postgresql.Driver";
    /** JDBC接続先情報（問①） */
    private static final String JDBC_CONNECTION = "jdbc:postgresql://localhost:5433/jdbc_db";
    /** ユーザー名（問②） */
    private static final String USER = "postgres";
    /** パスワード（問③） */
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

            // SHOHIN_ID='020' の SHOHIN_NAME を '商品20' に変更（問⑤）
            String SQL = "UPDATE SHOHIN_TB SET SHOHIN_NAME = '商品20' WHERE SHOHIN_ID = '020'";

            // SQL を実行（問⑥）
            int updateCount = statement.executeUpdate(SQL);
            System.out.println(updateCount + "件のデータを更新しました。");

            // 更新後のデータを一覧表示
            String SQLselect = "SELECT * FROM SHOHIN_TB";
            resultSet = statement.executeQuery(SQLselect);

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
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("リソースのクローズ時にエラーが発生しました。");
                e.printStackTrace();
            }
        }
    }
}
