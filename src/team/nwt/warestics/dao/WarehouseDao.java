package team.nwt.warestics.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

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
	//更新x仓库y物品z库存 若不存在,则直接添加记录
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
	//获取仓库记录 返回Vector<Vector<String>> vData类型做为盘点表的表格内容
	public Vector<Vector<String>> getInventoryInformation(){
		String sql="select `warehouse_id`,`tb_warehouse`.`goods_id`,`goods_name`,`goods_number` from `tb_warehouse`,`tb_goods` "
				+ "where `tb_warehouse`.`goods_id`=`tb_goods`.`goods_id` "
				+ "order by `warehouse_id`";
		try {
			PreparedStatement preparedStatement=getConnection().prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			Vector<Vector<String>> vData=new Vector<>();
			while(resultSet.next()){
				Vector<String> rowData=new Vector<>();
				rowData.add(""+resultSet.getInt("warehouse_id"));
				rowData.add(""+resultSet.getInt("goods_id"));
				rowData.add(resultSet.getString("goods_name"));
				rowData.add(""+resultSet.getDouble("goods_number"));
				
				vData.add(rowData);
				
			}
			preparedStatement.close();
			return vData;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
