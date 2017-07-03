package team.nwt.warestics.dao;

import java.io.Serializable;

public class Goods implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int goods_id;
	private String goods_name;
	private double goods_number;
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
