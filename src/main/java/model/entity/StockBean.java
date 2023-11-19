package model.entity;

import java.io.Serializable;

public class StockBean implements Serializable {
	/**
	 * 在庫ID
	 */
	private int stockId;
	/**
	 * 商品ID
	 */
	private int itemId;
	/**
	 * 入荷
	 */
	private int arrival;
	/**
	 *出荷
	 */
	private int shipping;
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
	 * @return 在庫ID
	 */
	public int getStockId() {
		return stockId;
	}

	/**
	 * @param stockId セットする
	 */
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	/**
	 * @return 商品ID
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * @param itemId セットする
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return 到着
	 */
	public int getArrival() {
		return arrival;
	}

	/**
	 * @param sectionCode セットする
	 */
	public void setArrival(int arrival) {
		this.arrival = arrival;
	}

	/**
	 * @return 運送
	 */
	public int getShipping() {
		return shipping;
	}

	/**
	 * @param sectionCode セットする
	 */
	public void setShipping(int shipping) {
		this.shipping = shipping;
	}

	/**
	 * @return 在庫数
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * @param stock セットする
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * @return 登録日
	 */
	public String getInsertDatetime() {
		return insertDatetime;
	}

	/**
	 * @param insertDatetime セットする
	 */
	public void setInsertDatetime(String insertDatetime) {
		this.insertDatetime = insertDatetime;
	}

	/**
	 * @return 更新日
	 */
	public String getUpdateDatetime() {
		return updateDatetime;
	}

	/**
	 * @param updateDatetime セットする
	 */
	public void setUpdateDatetime(String updateDatetime) {
		this.updateDatetime = updateDatetime;
	}
}