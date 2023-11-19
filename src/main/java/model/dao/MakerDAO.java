package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.MakerBean;

public class MakerDAO {
	/**
	 * データベースからSELECT文で言語一覧を取得
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @return 	メーカー一覧
	 */
	public List<MakerBean> getAllMakers()
			throws ClassNotFoundException, SQLException {
		List<MakerBean> makers = new ArrayList<>();

		String sql = "SELECT maker_code, maker_name FROM m_maker ORDER BY maker_code";
		ResultSet resultSet = null;

		// try-with-resourcesを使用し、データベース接続確立とプリペアドステートメントを取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			//SELECTした結果の部署名をresultSetに格納
			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				MakerBean maker = new MakerBean();
				maker.setMakerCode(resultSet.getString("maker_code"));
				maker.setMakerName(resultSet.getString("maker_name"));
				makers.add(maker);
			}
		}
		return makers;
	}
}