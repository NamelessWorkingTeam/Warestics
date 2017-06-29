package team.nwt.warestics.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WarehouseDao extends BaseDao {
	//根据物品id删除仓库记录
	public boolean deleteByGoodsId(int goods_id){
		String sql="delete from `tb_warehouse` where goods_id=?";
		
		try {
			PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, goods_id);
			preparedStatement.execute();
			
			preparedStatement.close();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	//更新x仓库y物品z库存 若不存在,则直接添加记�?
	public boolean updateGoods(int warehose_id,int goods_id,double number){
		String insertSql="insert into `tb_warehouse`(`warehouse_id`,`goods_id`,`goods_number`) values(?,?,?) "
				+ "on duplicate key update `goods_number`=`goods_number`+?";
		PreparedStatement preparedStatement;		

		try {
			preparedStatement=connection.prepareStatement(insertSql);
			preparedStatement.setInt(1, warehose_id);
			preparedStatement.setInt(2, goods_id);
			preparedStatement.setDouble(3, number);
			preparedStatement.setDouble(4, number);
			preparedStatement.execute();

			preparedStatement.close();
			return true;
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	
	}
}
