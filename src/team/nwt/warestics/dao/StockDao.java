package team.nwt.warestics.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class StockDao extends BaseDao {
	/**
	 * 获取x入库单号的入库信息,以Vector<Vector<String>>类型返回
	 */
	public Vector<Vector<String>> selectStock(int stock_id){
		String sql="select `tb_stock`.`goods_id`,`goods_name`,`stock_amount` "
				+ "from `tb_stock`,`tb_goods`"
				+ "where `tb_stock`.`goods_id`=`tb_goods`.`goods_id` "
				+ "and `stock_id`=?";
		try {
			PreparedStatement preparedStatement=getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, stock_id);
			ResultSet resultSet=preparedStatement.executeQuery();
			Vector<Vector<String>> vData=new Vector<>();
			while(resultSet.next()){
				Vector<String> rowData=new Vector<>();
				rowData.add(""+resultSet.getInt("goods_id"));
				rowData.add(resultSet.getString("goods_name"));
				rowData.add(""+resultSet.getInt("stock_amount"));
				
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
	 * 获取x入库单号的入库信息,以stock类型返回
	 */
	public Stock getStockInformation(int stock_id){
		String sql="select `tb_stock`.`goods_id`,`goods_name`,`stock_amount` "
				+ "from `tb_stock`,`tb_goods`"
				+ "where `tb_stock`.`goods_id`=`tb_goods`.`goods_id` "
				+ "and `stock_id`=?";
		try {
			PreparedStatement preparedStatement=getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, stock_id);
			ResultSet resultSet=preparedStatement.executeQuery();
			Stock stock=new Stock();
			stock.setStock_id(stock_id);
			while(resultSet.next()){
				Goods goods=new Goods();
				goods.setGoods_id(resultSet.getInt("goods_id"));
				goods.setGoods_name(resultSet.getString("goods_name"));
				goods.setGoods_number(resultSet.getInt("stock_amount"));
				
				stock.getGoodss().add(goods);
				
			}
			preparedStatement.close();
			return stock;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	/**
	 * 按审核状态获取所有符合条件的入库单号
	 * @param stock_state -N :待审核 -S:审核成功待入库 -E:审核失败 -Y:审核成功并成功入库
	 * @return 以Vector<Vector<String>>类型返回
	 */
	public Vector<Vector<String>> selectStockId(String stock_state){
		String sql="select `stock_id` "
				+ "from `tb_stock` "
				+ "where `stock_state`=?";

		try {
			PreparedStatement preparedStatement=getConnection().prepareStatement(sql);
			preparedStatement.setString(1, stock_state);
			ResultSet resultSet=preparedStatement.executeQuery();
			Vector<Vector<String>> vData=new Vector<>();
			while(resultSet.next()){
				Vector<String> rowData=new Vector<>();
				rowData.add(""+resultSet.getInt("stock_id"));
			
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
	 * 入库成功后,更新入库单的状态信息
	 * 
	 */
	public boolean updateStockState(int stock_id){
		String sql="update `tb_stock` set `stock_state`='Y' where `stock_id`=?";
		try {
			PreparedStatement preparedStatement=getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, stock_id);
			preparedStatement.execute();
			preparedStatement.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
}
