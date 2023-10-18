package model.entity;

import java.io.Serializable;

public class EmployeeBean implements Serializable {
	/**
	 * 従業員ID
	 */
	private int employeeId;

	/**
	 * 氏名（姓）
	 */
	private String lName;

	/**
	 * 氏名（名）
	 */
	private String fName;

	/**
	 * 性別
	 */
	private String gender;

	/**
	 * 生年月日
	 */
	private String birthday;

	/**
	 * 電話番号
	 */
	private String phoneNumber;

	/**
	 * 部署
	 */
	private String sectionCode;

	/**
	 * 経験言語
	 */
	private String languageCode;

	/**
	 * 入社日
	 */
	private String hireDate;

	/**
	 * デフォルトコンストラクタ
	 */
	public EmployeeBean() {

	}

	/**
	 * @return employee_id
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employee_id　を セットする
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return lName
	 */
	public String getLName() {
		return lName;
	}

	/**
	 * @param lName　を セットする
	 */
	public void setLName(String lName) {
		this.lName = lName;
	}

	/**
	 * @return fName
	 */
	public String getFName() {
		return fName;
	}

	/**
	 * @param fName　を セットする
	 */
	public void setFName(String fName) {
		this.fName = fName;
	}

	/**
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender　を セットする
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday　を セットする
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber　を セットする
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return sectionCode
	 */
	public String getSectionCode() {
		return sectionCode;
	}

	/**
	 * @param sectionCode　を セットする
	 */
	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	/**
	 * @return languageCode
	 */
	public String getLanguageCode() {
		return languageCode;
	}

	/**
	 * @param languageCode　を セットする
	 */
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	/**
	 * @return hireDate
	 */
	public String getHireDate() {
		return hireDate;
	}

	/**
	 * @param hireDate　を セットする
	 */
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

}