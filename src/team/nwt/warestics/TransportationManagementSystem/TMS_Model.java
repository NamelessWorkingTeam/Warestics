package team.nwt.warestics.TransportationManagementSystem;



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



public class TMS_Model extends AbstractTableModel {
	Vector RowData,ColumnNames;
    static String model_id="19951115";
    static String model_order_id;
    static String model_goods_id;
    static String model_goods_name;
    static String model_goods_number;
 
//    //通过传递的sql语句来获得数据模型
//    public TMS_Model(String sql)
//    {
//    	//建立表头  
//    	ColumnNames= new Vector();
//		ColumnNames.add("商品id");
//		ColumnNames.add("商品名称");
//		ColumnNames.add("商品数量");
//		RowData=new Vector(); 
//		sql = "SELECT * FROM tb_delivery";
//	    con = new MySQLConnect(sql);	 // 新建一个数据库连接						
//	    try {
//			result = con.pst.executeQuery();			// 执行sql语句，得到结果集		
//			while (result.next()) {
//	            Vector hang=new Vector();
//	        	hang.add(result.getInt(1));
//	        	hang.add(result.getString(2));
//	        	hang.add(result.getString(3));
//	        	RowData.add(hang);
//	        }
//	        result.close();		// 关闭执行的语句连接
//	        con.close();			// 关闭数据库连接
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    }
    
    //建立构造函数初始化数据模型
    public TMS_Model()
    {
    	

		ColumnNames= new Vector();
		ColumnNames.add("商品id");
		ColumnNames.add("商品数量");
//		ColumnNames.add("商品名称");
		

		String sql1 = "SELECT order_id FROM tb_transfer WHERE transfer_id='"+model_id+"'";
    	MySQLConnect con1 = new MySQLConnect(sql1);
    	try {
			ResultSet result1 = con1.pst.executeQuery();
			if(result1.next()){
				model_order_id=result1.getString("order_id");
				System.out.println(result1.getString("order_id"));			//测试order_id
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	
    	String sql2 = "SELECT goods_id,goods_number FROM tb_orderinformation WHERE order_id='"+model_order_id+"'";
    	MySQLConnect con2 = new MySQLConnect(sql2);
    	try {
			ResultSet result2 = con2.pst.executeQuery();
			while(result2.next()){
				
				System.out.println(result2.getString("goods_id"));			//测试goods_id
				System.out.println(result2.getString("goods_number"));		//测试goods_number
				
				Vector hang=new Vector();
	            hang.add(result2.getString("goods_id"));
	        	hang.add(result2.getString("goods_number"));
//	        	hang.add(result2.getString(3));
	        	RowData.add(hang);
	        }
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	

//		RowData=new Vector(); 
//		sql = "SELECT * FROM tb_delivery";						
//	    con = new MySQLConnect(sql);							
//	    try {
//			result = con.pst.executeQuery();					
//			while (result.next()) {
//	            Vector hang=new Vector();
//	            hang.add(result.getInt(1));
//	        	hang.add(result.getString(2));
//	        	hang.add(result.getString(3));
//	        	RowData.add(hang);
//	        }
//	        result.close();		
//	        con.close();			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }
    

	
  //得到共有多少列
  	public int getColumnCount() {
  		
  		// TODO 自动生成的方法存根
  		return this.ColumnNames.size();
  	}

  	//得到共有多少行
  	public int getRowCount() {
  		// TODO 自动生成的方法存根
  		return this.RowData.size();
  	}

  	@Override
  	public String getColumnName(int arg0) {
  		// TODO 自动生成的方法存根
  		return (String)this.ColumnNames.get(arg0);
  	}


  	//得到某行某列的数据
  	public Object getValueAt(int row, int column) {
  		// TODO 自动生成的方法存根
  		return ((Vector)this.RowData.get(row)).get(column);
  	}

  }