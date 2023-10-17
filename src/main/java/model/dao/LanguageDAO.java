package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.LanguageBean;

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

	/**
	 * データベースからSELECT文で言語一覧を取得
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @return 言語一覧
	 */
	public List<LanguageBean> getAllLanguages()
			throws ClassNotFoundException, SQLException {
		List<LanguageBean> languages = new ArrayList<>();

		String sql = "SELECT language_code, language_name FROM m_language ORDER BY language_code";
		ResultSet resultSet = null;

		// try-with-resourcesを使用し、データベース接続確立とプリペアドステートメントを取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			//SELECTした結果の部署名をresultSetに格納
			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				LanguageBean language = new LanguageBean();
				language.setLanguageCode(resultSet.getString("language_code"));
				language.setLanguageName(resultSet.getString("language_name"));
				languages.add(language);
			}
		}
		return languages;
	}
}