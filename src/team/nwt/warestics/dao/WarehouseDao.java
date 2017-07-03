package team.nwt.warestics.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.itextpdf.text.List;



public class WarehouseDao extends BaseDao {
	/**
	 * 获取仓库当前状态
	 */
	public ArrayList<Warehouse> getWarehouse(){
		String sql="select `warehouse_id`,`area_id`,`position_id`,`allocation` from `tb_warehouse`";
		try {
			PreparedStatement preparedStatement=getConnection().prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			ArrayList<Warehouse> warehouses=new ArrayList<>();
			while(resultSet.next()){
				Warehouse warehouse=new Warehouse();
				warehouse.setWarehouse_id(resultSet.getInt("warehouse_id"));
				warehouse.setArea_id(resultSet.getInt("area_id"));
				warehouse.setPosition_id(resultSet.getInt("position_id"));
				warehouse.setAllocation(resultSet.getDouble("allocation"));
				warehouses.add(warehouse);
			}
			preparedStatement.close();
			return warehouses;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
		
	}
}
