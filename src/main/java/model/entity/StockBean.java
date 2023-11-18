package model.entity;

import java.io.Serializable;

public class SectionBean implements Serializable {
	private String sectionCode; // 部署コード
	private String sectionName; // 部署名

	/**
	 * @return 部署コード
	 */
	public String getSectionCode() {
		return sectionCode;
	}

	/**
	 * @param sectionCode セットする部署コード
	 */
	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	/**
	 * @return 部署名
	 */
	public String getSectionName() {
		return sectionName;
	}

	/**
	 * @param sectionName セットする部署名
	 */
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
}