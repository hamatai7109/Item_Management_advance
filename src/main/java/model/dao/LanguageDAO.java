package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LanguageDAO {
	/**
	 * 入力されたlanguageCode、languageNameをデータベースのm_languageテーブルに追加
	 * @param languageCode 言語コード
	 * @param languageName 言語名
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void addLanguage(String languageCode, String languageName)
			throws ClassNotFoundException, SQLException {

		String sql = "INSERT INTO m_language VALUES(?, ?)";

		// try-with-resourcesを使用し、データベース接続確立とプリペアドステートメントを取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// プレースホルダに値をセット
			pstmt.setString(1, languageCode);
			pstmt.setString(2, languageName);

			// SQL文の実行
			pstmt.executeUpdate();
		}
	}
}