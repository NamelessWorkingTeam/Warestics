package team.nwt.warestics.DMSAdminSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import team.nwt.warestics.MySQLConnect;
import team.nwt.warestics.TransportationManagementSystem.TMS;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DMSPack extends JFrame {

	private JPanel contentPane;

	static String search_id1=DMSPackSearch.text;  //订单id
	static String search_id2;                    //发货id
	static String search_goods_name;             //商品名称
	static String search_number;                 //商品数量
	static String search_volume;			     //商品体积
	static String search_weight;			     //商品质量
	
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
		        
		       //查询商品名称
				String sql_goods_name = "SELECT tb_goods.goods_name"
						+ " FROM tb_goods join tb_orderinformation on  "
						+ " tb_goods.goods_id=tb_orderinformation.goods_id"
						//+ " WHERE tb_orderinformation.order_id='"+search_id1+"'";            
				    + " WHERE tb_orderinformation.order_id="+Integer.parseInt(search_id1);
				MySQLConnect con_goods_name = new MySQLConnect(sql_goods_name);
				try {
					ResultSet result_goods_name = con_goods_name.pst.executeQuery();
					
					if(result_goods_name.next()){
						search_goods_name = result_goods_name.getString("goods_name");
						
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//查询商品数量
				String sql_number = "SELECT goods_number"
						+ " FROM  tb_orderinformation"
						+ " WHERE order_id="+Integer.parseInt(search_id1);         
				    MySQLConnect con_number = new MySQLConnect(sql_number);
				try {
					ResultSet result_number = con_number.pst.executeQuery();
					
					if(result_number.next()){
						search_number = result_number.getString("goods_number");
						
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//查询商品体积
				String sql_volume = "SELECT tb_goods.goods_volume"
						+ " FROM tb_goods join tb_orderinformation on  "
						+ " tb_goods.goods_id=tb_orderinformation.goods_id"
						//+ " WHERE tb_orderinformation.order_id='"+search_id1+"'";            
				    + " WHERE tb_orderinformation.order_id="+Integer.parseInt(search_id1);       
				    MySQLConnect con_volume = new MySQLConnect(sql_volume);
				try {
					ResultSet result_volume = con_volume.pst.executeQuery();
					
					if(result_volume.next()){
						search_volume = result_volume.getString("goods_volume");
						
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//查询商品质量
				String sql_weight = "SELECT tb_goods.goods_weight"
						+ " FROM tb_goods join tb_orderinformation on  "
						+ " tb_goods.goods_id=tb_orderinformation.goods_id"
						//+ " WHERE tb_orderinformation.order_id='"+search_id1+"'";            
				    + " WHERE tb_orderinformation.order_id="+Integer.parseInt(search_id1);       
				    MySQLConnect con_weight = new MySQLConnect(sql_weight);
				try {
					ResultSet result_weight = con_weight.pst.executeQuery();
					
					if(result_weight.next()){
						search_weight = result_weight.getString("goods_weight");
						
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
	    setTitle("订单信息详情");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabe_id1 = new JLabel("订单id：");
		lblNewLabe_id1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabe_id1.setBounds(44, 38, 80, 18);
		contentPane.add(lblNewLabe_id1);
		
		JLabel lblNewLabel_id2 = new JLabel("发货id：");
		lblNewLabel_id2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_id2.setBounds(44, 76, 80, 18);
		contentPane.add(lblNewLabel_id2);
		
		JLabel lblNewLabel_goodsname = new JLabel("商品名称：");
		lblNewLabel_goodsname.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_goodsname.setBounds(44, 114, 80, 18);
		contentPane.add(lblNewLabel_goodsname);
		
		JLabel lblNewLabel_number = new JLabel("商品数量：");
		lblNewLabel_number.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_number.setBounds(44, 152, 80, 18);
		contentPane.add(lblNewLabel_number);
		
		JLabel lblNewLabel_volume = new JLabel("商品体积：");
		lblNewLabel_volume.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_volume.setBounds(44, 190, 80, 18);
		contentPane.add(lblNewLabel_volume);
		
		JLabel lblNewLabel_weight = new JLabel("商品质量：");
		lblNewLabel_weight.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_weight.setBounds(44, 228, 80, 18);
		contentPane.add(lblNewLabel_weight);
		
		JLabel lblNewLabel = new JLabel("推荐打包方案：");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel.setBounds(44, 266, 110, 18);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("保存打包方案");
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton.setBounds(253, 335, 136, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabe_id11 = new JLabel("");
		lblNewLabe_id11.setBounds(220, 38, 72, 18);
		contentPane.add(lblNewLabe_id11);
		lblNewLabe_id11.setText(search_id1);
		
		JLabel lblNewLabe_id21 = new JLabel("");
		lblNewLabe_id21.setBounds(220, 76, 72, 18);
		contentPane.add( lblNewLabe_id21);
		lblNewLabe_id21.setText(search_id2);
		
		JLabel lblNewLabel_goodsname1 = new JLabel("");
		lblNewLabel_goodsname1.setBounds(220, 114, 72, 18);
		contentPane.add(lblNewLabel_goodsname1);
		lblNewLabel_goodsname1.setText(search_goods_name);
		
		JLabel lblNewLabel_number1 = new JLabel("");
		lblNewLabel_number1.setBounds(220, 152, 72, 18);
		contentPane.add(lblNewLabel_number1);
		lblNewLabel_number1.setText(search_number);
		
		JLabel lblNewLabel_volume1 = new JLabel("");
		lblNewLabel_volume1.setBounds(220, 190, 72, 18);
		contentPane.add(lblNewLabel_volume1);
		lblNewLabel_volume1.setText(search_volume);
		
	
		JLabel lblNewLabel_weight1 = new JLabel("");
		lblNewLabel_weight1.setBounds(220, 228, 72, 18);
		contentPane.add(lblNewLabel_weight1);
		lblNewLabel_weight1.setText(search_weight);
	}

}
