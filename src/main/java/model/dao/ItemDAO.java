package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.ItemBean;

public class ItemDAO {
	/**
	 * 入力された商品情報をデータベースのm_itemテーブルに追加
	 * @param itemName 商品名
	 * @param makerName メーカー名
	 * @param price 値段
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void addItem(String itemName, String makerCode, int price)
			throws ClassNotFoundException, SQLException {

		String sql = "INSERT INTO m_item(item_name, maker_code, price) VALUES(?, ?, ?)";

		// try-with-resourcesを使用し、データベース接続確立とプリペアドステートメントを取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// プレースホルダに値をセット
			pstmt.setString(1, itemName);
			pstmt.setString(2, makerCode);
			pstmt.setInt(3, price);

			// SQL文の実行
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(); // エラーログを記録
			throw new RuntimeException("商品情報を追加できませんでした。", e);
		}
	}

	/**
	 * 入力された従業員情報をデータベースのm_itemテーブルで更新
	 * @param itemName 商品名
	 * @param makerName メーカー名
	 * @param price 値段
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void editItem(int itemId, String itemName, String makerCode, int price)
			throws ClassNotFoundException, SQLException {

		String sql = "UPDATE m_item SET item_name = ?, maker_code = ?, price = ? WHERE item_id = ?;";

		// try-with-resourcesを使用し、データベース接続確立とプリペアドステートメントを取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// プレースホルダに値をセット
			pstmt.setString(1, itemName);
			pstmt.setString(2, makerCode);
			pstmt.setInt(3, price);
			pstmt.setInt(4, itemId);

			// SQL文の実行
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(); // エラーログを記録
			throw new RuntimeException("商品情報を編集できませんでした。", e);
		}
	}

	/**
	 * 入力された従業員情報をデータベースのm_itemテーブルで削除
	 * @param itemId 商品ID
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void deleteItem(int itemId)
			throws ClassNotFoundException, SQLException {

		String sql = "DELETE FROM m_item WHERE item_id = ?";

		// try-with-resourcesを使用し、データベース接続確立とプリペアドステートメントを取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// プレースホルダに値をセット
			pstmt.setInt(1, itemId);

			// SQL文の実行
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(); // エラーログを記録
			throw new RuntimeException("商品を削除できませんでした。", e);
		}
	}

	/**
	 * データベースのm_itemテーブルからSELECT文で商品一覧を取得
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @return 商品一覧
	 */
	public List<ItemBean> getAllItems()
			throws ClassNotFoundException, SQLException {
		List<ItemBean> items = new ArrayList<>();

		String sql = "SELECT item_id,item_name,m.maker_name,price FROM m_item i "
				+ "INNER JOIN m_maker m  "
				+ "ON i.maker_code = m.maker_code "
				+ "ORDER BY item_id desc";
		ResultSet resultSet = null;

		// try-with-resourcesを使用し、データベース接続確立とプリペアドステートメントを取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			//SELECTした結果の従業員データをresultSetに格納
			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				ItemBean item = new ItemBean();
				item.setItemId(resultSet.getInt("item_id"));
				item.setItemName(resultSet.getString("item_name"));
				item.setMakerName(resultSet.getString("maker_name"));
				item.setPrice(resultSet.getInt("price"));
				items.add(item);
			}
		}
		return items;
	}

	/**
	 * データベースからSELECT文で選択された商品情報を取得
	 * @params 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @return　詳細な商品データ
	 */
	public List<ItemBean> getSelectedItems(int itemId)
			throws ClassNotFoundException, SQLException {
		List<ItemBean> items = new ArrayList<>();

		String sql = "SELECT i.item_id,i.item_name,m.maker_name,i.price,s.stock,i.insert_datetime,i.update_datetime FROM m_item i "
				+ "LEFT JOIN  t_stock s "
				+ "ON i.item_id = s.item_id "
				+ "LEFT JOIN m_maker m "
				+ "ON i.maker_code = m.maker_code "
				+ "WHERE i.item_id = ?";
		ResultSet resultSet = null;

		// try-with-resourcesを使用し、データベース接続確立とプリペアドステートメントを取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// プレースホルダーに従業員番号をセット
			pstmt.setInt(1, itemId);

			//SELECTした結果の従業員データをresultSetに格納
			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				ItemBean item = new ItemBean();
				item.setItemId(resultSet.getInt("item_id"));
				item.setItemName(resultSet.getString("item_name"));
				item.setMakerName(resultSet.getString("maker_name"));
				item.setPrice(resultSet.getInt("price"));
				item.setStock(resultSet.getInt("stock"));
				item.setInsertDatetime(resultSet.getString("insert_datetime"));
				item.setUpdateDatetime(resultSet.getString("update_datetime"));
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return items;
	}

	/**
	 * 検索された名前と一致する名前のデータだけをSELECT文で取得
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @return 商品一覧
	 */
	public List<ItemBean> getSearchedItems(String searchWord)
			throws ClassNotFoundException, SQLException {

		List<ItemBean> items = new ArrayList<>();

		String sql = "SELECT item_id,item_name,m.maker_name,price FROM m_item i "
				+ "INNER JOIN m_maker m  "
				+ "ON i.maker_code = m.maker_code "
				+ "WHERE item_name LIKE ? "
				+ "ORDER BY item_id";

		ResultSet resultSet = null;

		// try-with-resourcesを使用し、データベース接続確立とプリペアドステートメントを取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// プレースホルダーに検索ワードをセット
			pstmt.setString(1, "%" + searchWord + "%");

			//SELECTした結果の従業員データをresultSetに格納
			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				ItemBean item = new ItemBean();
				item.setItemId(resultSet.getInt("item_id"));
				item.setItemName(resultSet.getString("item_name"));
				item.setMakerName(resultSet.getString("maker_name"));
				item.setPrice(resultSet.getInt("price"));
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// ResultSetを閉じる
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return items;
	}
}