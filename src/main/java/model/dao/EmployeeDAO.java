package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.EmployeeBean;

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

	/**
	 * データベースからSELECT文で従業員一覧を取得
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @return 従業員一覧
	 */
	public List<EmployeeBean> getAllEmployees()
			throws ClassNotFoundException, SQLException {
		List<EmployeeBean> employees = new ArrayList<>();

		String sql = "SELECT employee_id,l_name,f_name,gender,birthday,phone_number,section_code,language_code,hire_date FROM m_employee ORDER BY employee_id";
		ResultSet resultSet = null;

		// try-with-resourcesを使用し、データベース接続確立とプリペアドステートメントを取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			//SELECTした結果の従業員データをresultSetに格納
			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				EmployeeBean employee = new EmployeeBean();
				employee.setEmployeeId(resultSet.getInt("employee_id"));
				employee.setLName(resultSet.getString("l_name"));
				employee.setFName(resultSet.getString("f_name"));
				employee.setGender(resultSet.getString("gender"));
				employee.setBirthday(resultSet.getString("birthday"));
				employee.setPhoneNumber(resultSet.getString("phone_number"));
				employee.setSectionCode(resultSet.getString("section_code"));
				employee.setLanguageCode(resultSet.getString("language_code"));
				employee.setHireDate(resultSet.getString("hire_date"));
				employees.add(employee);
			}
		}
		return employees;
	}
}