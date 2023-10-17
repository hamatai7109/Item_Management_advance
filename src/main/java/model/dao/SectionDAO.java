package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.SectionBean;

public class SectionDAO {
	/**
	 * データベースからSELECT文で部署一覧を取得
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @return 部署一覧
	 */
	public List<SectionBean> getAllSections()
			throws ClassNotFoundException, SQLException {
		List<SectionBean> sections = new ArrayList<>();

		String sql = "SELECT section_code, section_name FROM m_section ORDER BY section_code";
		ResultSet resultSet = null;

		// try-with-resourcesを使用し、データベース接続確立とプリペアドステートメントを取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			//SELECTした結果の部署名をresultSetに格納
			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				SectionBean section = new SectionBean();
				section.setSectionCode(resultSet.getString("section_code"));
				section.setSectionName(resultSet.getString("section_name"));
				sections.add(section);
			}
		}
		return sections;
	}
}