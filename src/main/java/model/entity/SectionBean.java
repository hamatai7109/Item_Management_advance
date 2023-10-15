package model.entity;

import java.io.Serializable;

public class SectionBean implements Serializable {
	/**
	 * section_code
	 */
	private String sectionCode;

	/**
	 * section_name
	 */
	private String sectionName;

	/**
	 * デフォルトコンストラクタ
	 */
	public SectionBean() {

	}

	/**
	 * @return sectionCode
	 */
	public String getSectionCode() {
		return sectionCode;
	}

	/**
	 * @param sectionCode セットする sectionCode
	 */
	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	/**
	 * @return sectionName
	 */
	public String getSectionName() {
		return sectionName;
	}

	/**
	 * @param sectionName セットする sectionName
	 */
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
}