package team.nwt.warestics.warehousemanagesystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.*;

import team.nwt.warestics.MySQLConnect;
import team.nwt.warestics.dao.StockDao;

public class StockTableModel extends AbstractTableModel {
	static Vector rowName;
	static Vector vData;

    //通过传递的sql语句来获得数据模型
    public StockTableModel(int stock_id)
    {
    	//建立表头
    	rowName= new Vector();
    	rowName.add("物品ID");
    	rowName.add("物品名");
    	rowName.add("物品数量");
    	//数据库连接
    	StockDao stockDao=new StockDao();
    	//获得数据
    	vData=stockDao.selectStock(stock_id);
    	//关闭数据库连接
    	stockDao.close();
	   
    }


	//得到共有多少列
	public int getColumnCount() {
		
		// TODO 自动生成的方法存根
		return this.rowName.size();
	}

	//得到共有多少行
	public int getRowCount() {
		// TODO 自动生成的方法存根
		return this.vData.size();
	}

	@Override
	public String getColumnName(int arg0) {
		// TODO 自动生成的方法存根
		return (String)this.rowName.get(arg0);
	}


	//得到某行某列的数据
	public Object getValueAt(int row, int column) {
		// TODO 自动生成的方法存根
		return ((Vector)this.vData.get(row)).get(column);
	}

}
