package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StockDAO {
	/**
	 * 入力された従業員情報をデータベースのt_stockテーブルで更新
	 * @param itemId 商品ID
	 * @param arrival 入荷
	 * @param shipping 出荷
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void ediStock(int itemId, int arrival, int shipping)
			throws ClassNotFoundException, SQLException {

		String sql = "UPDATE t_stock SET arrival = ?, shipping = ? WHERE item_id = ?;";

		// try-with-resourcesを使用し、データベース接続確立とプリペアドステートメントを取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// プレースホルダに値をセット
			pstmt.setInt(1, arrival);
			pstmt.setInt(2, shipping);
			pstmt.setInt(3, itemId);

			// SQL文の実行
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(); // エラーログを記録
			throw new RuntimeException("在庫情報を編集できませんでした。", e);
		}
	}
}