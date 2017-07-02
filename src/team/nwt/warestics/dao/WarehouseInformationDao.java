package team.nwt.warestics.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class WarehouseInformationDao extends BaseDao {
	/**
	 * 删除x仓库y区域z货架的物品id为α的记录
	 */
	public boolean deleteWarehoueInformation(int warehosue_id,int area_id,int position_id,int goods_id){
		String sql="delete from `tb_warehouseinformation` "
				+ "where `warehouse_id`=? and `area_id`=? and `position_id`=? and `goods_id`=?";
		
		try {
			PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, warehosue_id);
			preparedStatement.setInt(2, area_id);
			preparedStatement.setInt(3, position_id);
			preparedStatement.setInt(4, goods_id);
			preparedStatement.execute();
			
			preparedStatement.close();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	/**
	 * 2017/7/2 tb_warehouse更新后暂时未更新该方法
	 * 更新x仓库y物品z库存 若不存在,则直接添加记录
	 */
	public boolean updateWarehouseInformation(int warehose_id,int area_id,int position_id,int goods_id,double number){
		String insertSql="insert into `tb_warehouseinformation`(`warehouse_id`,`area_id`,`position_id`,`goods_id`,`goods_number`) values(?,?,?,?,?) "
				+ "on duplicate key update `goods_number`=`goods_number`+?";
		PreparedStatement preparedStatement;		

		try {
			preparedStatement=connection.prepareStatement(insertSql);
			preparedStatement.setInt(1, warehose_id);
			preparedStatement.setInt(2, area_id);
			preparedStatement.setInt(3, position_id);
			preparedStatement.setInt(4, goods_id);
			preparedStatement.setDouble(5, number);
			preparedStatement.setDouble(6, number);
			preparedStatement.execute();

			preparedStatement.close();
			return true;
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	
	}
	/**
	 * 获取仓库记录 返回Vector<Vector<String>> vData类型做为盘点表的表格内容
	 */
	public Vector<Vector<String>> getInventoryInformation(){
		String sql="select `warehouse_id`,`area_id`,`position_id`,`tb_warehouse`.`goods_id`,`goods_name`,`goods_number` "
				+ "from `tb_warehouseinformation`,`tb_goods` "
				+ "where `tb_warehouseinformation`.`goods_id`=`tb_goods`.`goods_id` "
				+ "order by `warehouse_id`";
		try {
			PreparedStatement preparedStatement=getConnection().prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			Vector<Vector<String>> vData=new Vector<>();
			while(resultSet.next()){
				Vector<String> rowData=new Vector<>();
				rowData.add(""+resultSet.getInt("warehouse_id"));
				rowData.add(""+resultSet.getInt("area_id"));
				rowData.add(""+resultSet.getInt("position_id"));
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
	/**
	 * 获取仓库记录 返回List<Warehouse> 类型做为盘点表的打印数据内容
	 */
	public List<WarehouseInformation> getInventoryInformationForPDF(){
		String sql="select `warehouse_id`,`area_id`,`position_id`,`tb_warehouse`.`goods_id`,`goods_name`,`goods_number` "
				+ "from `tb_warehouseinformation`,`tb_goods` "
				+ "where `tb_warehouseinformation`.`goods_id`=`tb_goods`.`goods_id` "
				+ "order by `warehouse_id`";
		List<WarehouseInformation> warehouseInformations=new ArrayList<WarehouseInformation>();
		try {
			PreparedStatement preparedStatement=getConnection().prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()){
				WarehouseInformation warehouseInformation=new WarehouseInformation();
				warehouseInformation.setWarehouse_id(resultSet.getInt("warehouse_id"));
				warehouseInformation.setArea_id(resultSet.getInt("area_id"));
				warehouseInformation.setPosition_id(resultSet.getInt("position_id"));
				warehouseInformation.setGoods_id(resultSet.getInt("goods_id"));
				warehouseInformation.setGoods_name(resultSet.getString("goods_name"));
				warehouseInformation.setGoods_number(resultSet.getDouble("goods_number"));
				
				
				warehouseInformations.add(warehouseInformation);				
			}
			preparedStatement.close();
			return warehouseInformations;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * 获取仓库记录 返回Vector<Vector<String>> 类型作为质检表的表格内容
	 */
	public Vector<Vector<String>> getQualityInformation(){
		String sql="select `tb_goods`.`goods_id`,`goods_name`,"
				+ "`goods_productiondate`,`goods_shelflife`,`warehouse_id`,`area_id`,`position_id`,`goods_number` "
				+ "from `tb_goods`,`tb_warehouseinformation` "
				+ "where `tb_goods`.`goods_id`=`tb_warehouseinformation`.`goods_id`";//查询语句
		try {
			PreparedStatement preparedStatement=getConnection().prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			Vector<Vector<String>> vData=new Vector<>();
			while(resultSet.next()){
				Vector<String> rowData=new Vector<>();
				rowData.add(""+resultSet.getInt("goods_id"));
				rowData.add(resultSet.getString("goods_name"));
				rowData.add(""+resultSet.getInt("goods_productiondate"));
				rowData.add(""+resultSet.getInt("goods_shelflife"));
				rowData.add(""+resultSet.getInt("warehouse_id"));
				rowData.add(""+resultSet.getInt("area_id"));
				rowData.add(""+resultSet.getInt("position_id"));
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
	/**
	 * 获取x仓库y区域z货架的商品类别总数
	 */
	public int getCountofGoodsId(int warehouse_id,int area_id,int position_id){
		String sql="select count(`goods_id`) as `number` from `tb_warehouseinformation` "
				+ "where `warehouse_id`=? and `area_id`=? and `position_id`=?";
		int count=0;
		try {
			PreparedStatement preparedStatement=getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, warehouse_id);
			preparedStatement.setInt(2, area_id);
			preparedStatement.setInt(3, position_id);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				count=resultSet.getInt("number");				
			}
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
		
	}
	/**
	 * 获取x仓库y区域z货架的结果集
	 */
	public ResultSet getResultSetofGoodsId(int warehouse_id,int area_id,int position_id){
		String sql="select `tb_goods`.`goods_id`,`goods_name`,`goods_number` "
				+ "from `tb_goods`,`tb_warehouseinformation`  "
				+ "where `tb_goods`.`goods_id`=`tb_warehouseinformation`.`goods_id` "
				+ "and `warehouse_id`=? and `area_id`=? and `position_id`=?";
		ResultSet resultSet=null;
		try {
			PreparedStatement preparedStatement=getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, warehouse_id);
			preparedStatement.setInt(2, area_id);
			preparedStatement.setInt(3, position_id);
			resultSet=preparedStatement.executeQuery();
			
			//preparedStatement.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}
}
