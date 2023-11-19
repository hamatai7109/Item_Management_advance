package model.entity;

import java.io.Serializable;

public class MakerBean implements Serializable {
	/**
	 * メーカーCD
	 */
	private String makerCode;

	/**
	 * メーカー名
	 */
	private String makerName;

	/**
	 * デフォルトコンストラクタ
	 */
	public MakerBean() {

	}

	/**
	 * @return makerCode
	 */
	public String getMakerCode() {
		return makerCode;
	}

	/**
	 * @param makerCode セットする 
	 */
	public void setMakerCode(String makerCode) {
		this.makerCode = makerCode;
	}

	/**
	 * @return makerName
	 */
	public String getMakerName() {
		return makerName;
	}

	/**
	 * @param makerName セットする 
	 */
	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}
}