package team.nwt.warestics.DMSAdminSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import team.nwt.warestics.MySQLConnect;
import team.nwt.warestics.TransportationManagementSystem.TMS;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DMSPack extends JFrame {

	private static final String String = null;

	private JPanel contentPane;

	static String search_id1=DMSPackSearch.text;  //订单id
	static String search_id2;                    //发货id
	static String search_goods_name;             //商品名称
	static float search_number;                 //商品数量
	static float search_volume;			     //商品体积
	static float search_weight;			     //商品质量
	static String pack_plan;
	
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DMSPack frame = new DMSPack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DMSPack() {
		 
			//查询订单di
				String sql_id2 = "SELECT delivery_id"
				+ " FROM tb_delivery "
				+ " WHERE order_id="+Integer.parseInt(search_id1); 
				           
		  
				MySQLConnect con_id2 = new MySQLConnect(sql_id2);
				try {
					ResultSet result_id2 = con_id2.pst.executeQuery();
			
					if(result_id2.next()){
						search_id2 = result_id2.getString("delivery_id");
						//System.out.println(search_goods_name);
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        
//		       //查询商品名称
//				String sql_goods_name = "SELECT tb_goods.goods_name"
//						+ " FROM tb_goods join tb_orderinformation on  "
//						+ " tb_goods.goods_id=tb_orderinformation.goods_id"
//						//+ " WHERE tb_orderinformation.order_id='"+search_id1+"'";            
//				    + " WHERE tb_orderinformation.order_id="+Integer.parseInt(search_id1);
//				MySQLConnect con_goods_name = new MySQLConnect(sql_goods_name);
//				try {
//					ResultSet result_goods_name = con_goods_name.pst.executeQuery();
//					
//					if(result_goods_name.next()){
//						search_goods_name = result_goods_name.getString("goods_name");
//						
//					}
//
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				
//				//查询商品数量
//				String sql_number = "SELECT goods_number"
//						+ " FROM  tb_orderinformation"
//						+ " WHERE order_id="+Integer.parseInt(search_id1);         
//				    MySQLConnect con_number = new MySQLConnect(sql_number);
//				try {
//					ResultSet result_number = con_number.pst.executeQuery();
//					
//					if(result_number.next()){
//						search_number = result_number.getFloat("goods_number");
//						
//					}
//
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				
//				//查询商品体积
//				String sql_volume = "SELECT tb_goods.goods_volume"
//						+ " FROM tb_goods join tb_orderinformation on  "
//						+ " tb_goods.goods_id=tb_orderinformation.goods_id"
//						//+ " WHERE tb_orderinformation.order_id='"+search_id1+"'";            
//				    + " WHERE tb_orderinformation.order_id="+Integer.parseInt(search_id1);       
//				    MySQLConnect con_volume = new MySQLConnect(sql_volume);
//				try {
//					ResultSet result_volume = con_volume.pst.executeQuery();
//					
//					if(result_volume.next()){
//						search_volume = result_volume.getFloat("goods_volume");
//						
//					}
//
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				
//				//查询商品质量
//				String sql_weight = "SELECT tb_goods.goods_weight"
//						+ " FROM tb_goods join tb_orderinformation on  "
//						+ " tb_goods.goods_id=tb_orderinformation.goods_id"
//						//+ " WHERE tb_orderinformation.order_id='"+search_id1+"'";            
//				    + " WHERE tb_orderinformation.order_id="+Integer.parseInt(search_id1);       
//				    MySQLConnect con_weight = new MySQLConnect(sql_weight);
//				try {
//					ResultSet result_weight = con_weight.pst.executeQuery();
//					
//					if(result_weight.next()){
//						search_weight = result_weight.getFloat("goods_weight");
//						
//					}
//
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				
	    setTitle("打包方案详情");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 982, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabe_id1 = new JLabel("订单id：");
		lblNewLabe_id1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabe_id1.setBounds(44, 49, 80, 18);
		contentPane.add(lblNewLabe_id1);
		
		JLabel lblNewLabel_id2 = new JLabel("发货id：");
		lblNewLabel_id2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_id2.setBounds(44, 93, 80, 18);
		contentPane.add(lblNewLabel_id2);
		
//		JLabel lblNewLabel_goodsname = new JLabel("商品名称：");
//		lblNewLabel_goodsname.setFont(new Font("微软雅黑", Font.PLAIN, 15));
//		lblNewLabel_goodsname.setBounds(44, 114, 80, 18);
//		contentPane.add(lblNewLabel_goodsname);
//		
//		JLabel lblNewLabel_number = new JLabel("商品数量：");
//		lblNewLabel_number.setFont(new Font("微软雅黑", Font.PLAIN, 15));
//		lblNewLabel_number.setBounds(44, 152, 80, 18);
//		contentPane.add(lblNewLabel_number);
//		
//		JLabel lblNewLabel_volume = new JLabel("商品体积：");
//		lblNewLabel_volume.setFont(new Font("微软雅黑", Font.PLAIN, 15));
//		lblNewLabel_volume.setBounds(44, 190, 80, 18);
//		contentPane.add(lblNewLabel_volume);
//		
//		JLabel lblNewLabel_weight = new JLabel("商品质量：");
//		lblNewLabel_weight.setFont(new Font("微软雅黑", Font.PLAIN, 15));
//		lblNewLabel_weight.setBounds(44, 228, 80, 18);
//		contentPane.add(lblNewLabel_weight);
		
		JLabel lblNewLabel = new JLabel("推荐打包方案：");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel.setBounds(44, 136, 110, 18);
		contentPane.add(lblNewLabel);
		
		
		
		JLabel lblNewLabe_id11 = new JLabel("");
		lblNewLabe_id11.setBounds(170, 49, 72, 18);
		contentPane.add(lblNewLabe_id11);
		lblNewLabe_id11.setText(search_id1);
		
		JLabel lblNewLabe_id21 = new JLabel("");
		lblNewLabe_id21.setBounds(170, 93, 72, 18);
		contentPane.add( lblNewLabe_id21);
		lblNewLabe_id21.setText(search_id2);
		
//		JLabel lblNewLabel_goodsname1 = new JLabel("");
//		lblNewLabel_goodsname1.setBounds(220, 114, 72, 18);
//		contentPane.add(lblNewLabel_goodsname1);
//		lblNewLabel_goodsname1.setText(search_goods_name);
//		
//		
//		JLabel lblNewLabel_number1 = new JLabel("");
//		lblNewLabel_number1.setBounds(220, 152, 72, 18);
//		String y=String.valueOf(search_number);
//		lblNewLabel_number1.setText(y);
//		contentPane.add(lblNewLabel_number1);
//		
//		JLabel lblNewLabel_volume1 = new JLabel("");
//		lblNewLabel_volume1.setBounds(220, 190, 72, 18);
//		contentPane.add(lblNewLabel_volume1);
//		String s=String.valueOf(search_volume);
//		lblNewLabel_volume1.setText(s);
//		
//	
//		JLabel lblNewLabel_weight1 = new JLabel("");
//		lblNewLabel_weight1.setBounds(220, 228, 72, 18);
//		contentPane.add(lblNewLabel_weight1);
//		String w=String.valueOf(search_weight);
//		lblNewLabel_weight1.setText(w);
		
		//打包方案判断
//		if(search_goods_name.equals("酒精"))
//			pack_plan="特殊方案";
		//else
//			if(search_volume<100&&search_weight<100)
//			pack_plan="方案888";
//			else
//				if(search_volume<100&&search_weight<1000&&100<search_weight)
//				pack_plan="方案2";
//				else
//					if(search_volume<100&&1000<search_weight)
//					pack_plan="方案3";
//					else
//						if(search_volume<1000&&100<search_volume&&search_weight<100)
//						pack_plan="方案4";
//						else
//							if(search_volume<1000&&100<search_volume&&100<search_weight&&search_weight<1000)
//							pack_plan="方案5";
//							else
//								if(search_volume<1000&&100<search_volume&&1000<search_weight)
//								pack_plan="方案6";
//								else
//									if(1000<search_volume&&search_weight<100)
//									pack_plan="方案7";
//									else
//										if(1000<search_volume&&100<search_weight&&search_weight<1000)
//										pack_plan="方案8";
//										else
//											if(1000<search_volume&&search_weight>1000)
//											pack_plan="方案9";
		
		String aa=search_id1;
		int n=1;
		String b=aa.substring(aa.length()-n,aa.length());
		pack_plan=b+1;
		int number = new Random().nextInt(10) + 1;;
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(170, 137, 136, 18);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setText("方案"+number);
		
		System.out.println(pack_plan);
		
		JButton btnNewButton = new JButton("保存打包方案");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

                //添加判断,如果数据库中打包已有数据,生成方案会失败.
		    	String r="";
			    String sql2="select delivery_pack"
			    		+ " from tb_delivery"
			    		+ " where order_id="+Integer.parseInt(search_id1);
			    MySQLConnect con2=new MySQLConnect(sql2);
			    try {
					ResultSet result=con2.pst.executeQuery();
				    if(result.next()) {
				    	r=result.getString(1);
				    	if(!r.equals(""))
				    	JOptionPane.showMessageDialog(null, "此订单已生成打包方案"); 
				    }
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				 if(r.equals("")) { 
					 String sql1="UPDATE tb_delivery SET delivery_pack ='"+number+"' WHERE order_id='"+search_id1+"'";
					
				    MySQLConnect con1=new MySQLConnect(sql1);
				    try {
						con1.pst.executeUpdate();
						 JOptionPane.showMessageDialog(null, "保存成功");  
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					 }
			    
//                  String sql1="UPDATE tb_delivery SET delivery_pack ='"+number+"' WHERE order_id='"+search_id1+"'";
//				
//			    MySQLConnect con1=new MySQLConnect(sql1);
//			    try {
//					con1.pst.executeUpdate();
//					 JOptionPane.showMessageDialog(null, "保存成功");  
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton.setBounds(44, 192, 136, 27);
		contentPane.add(btnNewButton);
		
		
		
		
		/**
		 * @author HYL
		 * rowName为table列名
		 * vData为数据
		 */
		Vector<String> rowName=new Vector();
		Vector<Vector<String>> vData=new Vector();
		rowName.add("物品ID");
		rowName.add("物品名称");
		rowName.add("物品数量");
		rowName.add("物品体积");
		rowName.add("物品重量");
		
		Vector<String>rowData_1=new Vector();
		
		//查询订单di
		String sql_all_goods = "SELECT `tb_orderinformation`.`goods_id`,`goods_name`,`goods_number`,`goods_volume`,`goods_weight` "
		+ " FROM `tb_orderinformation` ,`tb_goods` "
		+ " WHERE `order_id`="+Integer.parseInt(search_id1) +" and `tb_goods`.`goods_id`=`tb_orderinformation`.`goods_id`"; 
		           
  
		MySQLConnect mycon = new MySQLConnect(sql_all_goods);
		try {
			ResultSet resultSet = mycon.pst.executeQuery();
	
			while(resultSet.next()){
				Vector<String>rowData=new Vector();
				rowData.add(""+resultSet.getInt("goods_id"));
				rowData.add(resultSet.getString("goods_name"));
				rowData.add(""+resultSet.getDouble("goods_number"));
				rowData.add(""+resultSet.getDouble("goods_volume"));
				rowData.add(""+resultSet.getDouble("goods_weight"));
				vData.add(rowData);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		vData.add(rowData_1);
		DefaultTableModel DTM=new DefaultTableModel(vData, rowName);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(416, 51, 473, 347);
		contentPane.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.setModel(DTM);
		
		JLabel lblNewLabel_2 = new JLabel("发货物品详情:");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(306, 49, 96, 18);
		contentPane.add(lblNewLabel_2);
	}
}
