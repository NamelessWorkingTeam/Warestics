package team.nwt.warestics.dao;

import java.io.Serializable;
import java.util.ArrayList;

public class Stock implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int stock_id;
	private ArrayList<Goods> goodss=new ArrayList();

	public int getStock_id() {
		return stock_id;
	}
	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}
	public ArrayList<Goods> getGoodss() {
		return goodss;
	}
	public void setGoodss(ArrayList<Goods> goodss) {
		this.goodss = goodss;
	}

	
	
}
