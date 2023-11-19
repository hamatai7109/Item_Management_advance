package model.entity;

import java.io.Serializable;

public class ItemBean implements Serializable {
	/**
	 * 商品ID
	 */
	private int itemId;

	/**
	 * 商品名
	 */
	private String itemName;

	/**
	 * メーカーCD
	 */
	private String makerCode;

	/**
	 * メーカー名
	 */
	private String makerName;

	/**
	 * 値段
	 */
	private int price;

	/**
	 * 在庫数
	 */
	private int stock;

	/**
	 * 登録日
	 */
	private String insertDatetime;

	/**
	 * 更新日
	 */
	private String updateDatetime;

	/**
	 * デフォルトコンストラクタ
	 */
	public ItemBean() {

	}

	/**
	 * @return item_id
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * @param item_id　を セットする
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName　を セットする
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return makerCode
	 */
	public String getMakerCode() {
		return makerCode;
	}

	/**
	 * @param makerCode　を セットする
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
	 * @param makerName　を セットする
	 */
	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}

	/**
	 * @return price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price　を セットする
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * @param stock　を セットする
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * @return insertDatetime
	 */
	public String getInsertDatetime() {
		return insertDatetime;
	}

	/**
	 * @param insert_datetime　を セットする
	 */
	public void setInsertDatetime(String insertDatetime) {
		this.insertDatetime = insertDatetime;
	}

	/**
	 * @return updateDatetime
	 */
	public String getUpdateDatetime() {
		return updateDatetime;
	}

	/**
	 * @param update_datetime　を セットする
	 */
	public void setUpdateDatetime(String updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

}