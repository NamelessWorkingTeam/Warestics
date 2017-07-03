package team.nwt.warestics.dao;

import java.io.Serializable;

public class Warehouse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int warehouse_id;
	int area_id;
	int position_id;
	double allocation;
	public int getWarehouse_id() {
		return warehouse_id;
	}
	public void setWarehouse_id(int warehouse_id) {
		this.warehouse_id = warehouse_id;
	}
	public int getArea_id() {
		return area_id;
	}
	public void setArea_id(int area_id) {
		this.area_id = area_id;
	}
	public int getPosition_id() {
		return position_id;
	}
	public void setPosition_id(int position_id) {
		this.position_id = position_id;
	}
	public double getAllocation() {
		return allocation;
	}
	public void setAllocation(double allocation) {
		this.allocation = allocation;
	}

	
	
}
