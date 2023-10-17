package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAO {
	/**
	 * 入力された従業員情報をデータベースのm_employeeテーブルに追加
	 * @param lastName 氏名（姓）
	 * @param firstName 氏名（名）
	 * @param gender 性別
	 * @param birthday 生年月日
	 * @param phoneNumber 電話番号
	 * @param sectionCode 部署
	 * @param languageCode 言語
	 * @param hireDate 入社日
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void addEmployee(String lastName, String firstName, String gender, String birthday, String phoneNumber,
			String sectionCode, String languageCode, String hireDate)
			throws ClassNotFoundException, SQLException {

		String sql = "INSERT INTO m_employee(l_name, f_name, gender, birthday, phone_number, section_code, language_code, hire_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

		// try-with-resourcesを使用し、データベース接続確立とプリペアドステートメントを取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// プレースホルダに値をセット
			pstmt.setString(1, lastName);
			pstmt.setString(2, firstName);
			pstmt.setString(3, gender);
			pstmt.setString(4, birthday);
			pstmt.setString(5, phoneNumber);
			pstmt.setString(6, sectionCode);
			pstmt.setString(7, languageCode);
			pstmt.setString(8, hireDate);

			// SQL文の実行
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(); // エラーログを記録
			throw new RuntimeException("従業員情報を追加できませんでした。", e);
		}
	}
}