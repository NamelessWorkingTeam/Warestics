package team.nwt.warestics.warehousemanagesystem;

import java.util.ArrayList;

import team.nwt.warestics.dao.Goods;
import team.nwt.warestics.dao.Stock;
import team.nwt.warestics.dao.StockDao;
import team.nwt.warestics.dao.Warehouse;
import team.nwt.warestics.dao.WarehouseDao;
import team.nwt.warestics.dao.WarehouseInformationDao;

public class WarehouseManageUtil {
	/**
	 * 入库操作
	 */
	public boolean stock(Stock stock){
		WarehouseDao warehouseDao=new WarehouseDao();
		ArrayList<Warehouse> warehouses=warehouseDao.getWarehouse();
		ArrayList<Goods> goodss=stock.getGoodss();
		int stock_id=stock.getStock_id();
		//入库单每个物品都进行一次入库操作
		for(Goods goods:goodss){
			for(Warehouse warehouse:warehouses){
				if(warehouse.getAllocation()>=goods.getGoods_number()){
					WarehouseInformationDao warehouseInformationDao=new WarehouseInformationDao();
					int warehouse_id=warehouse.getWarehouse_id();
					int area_id=warehouse.getArea_id();
					int position_id=warehouse.getPosition_id();
					int goods_id=goods.getGoods_id();
					int stock_amount=(int) goods.getGoods_number();
					if(warehouseInformationDao.updateWarehouseInformation(warehouse_id, area_id, position_id, goods_id, stock_amount)){
						StockDao stockDao=new StockDao();
						stockDao.updateStockState(stock_id);
						System.out.println("入库成功");
						break;
					}else{
						System.out.println("入库失败,入库终止");
						
						return false;
					}
				}
			}
		}
		return true;
	}
}
