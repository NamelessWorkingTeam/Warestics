package team.nwt.warestics.dao;

import java.io.Serializable;

public class Warehouse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int warehouse_id;
	private int goods_id;
	private String goods_name;
	private double goods_number;
	public int getWarehouse_id() {
		return warehouse_id;
	}
	public void setWarehouse_id(int warehouse_id) {
		this.warehouse_id = warehouse_id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public double getGoods_number() {
		return goods_number;
	}
	public void setGoods_number(double goods_number) {
		this.goods_number = goods_number;
	}
	
	
}
