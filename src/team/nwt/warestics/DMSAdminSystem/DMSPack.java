package team.nwt.warestics.DMSAdminSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import team.nwt.warestics.MySQLConnect;
import team.nwt.warestics.TransportationManagementSystem.TMS;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DMSPack extends JFrame {

	private JPanel contentPane;

	static String search_id1=DMSPackSearch.text;  //订单id
	static String search_id2;                    //发货id
	static String search_goods_name;             //商品名称
	static float search_number;                 //商品数量
	static float search_volume;			     //商品体积
	static float search_weight;			     //商品质量
	static String pack_plan;
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
						search_number = result_number.getFloat("goods_number");
						
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
						search_volume = result_volume.getFloat("goods_volume");
						
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
						search_weight = result_weight.getFloat("goods_weight");
						
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
	    setTitle("打包方案详情");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 759);
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
		String y=String.valueOf(search_number);
		lblNewLabel_number1.setText(y);
		contentPane.add(lblNewLabel_number1);
		
		JLabel lblNewLabel_volume1 = new JLabel("");
		lblNewLabel_volume1.setBounds(220, 190, 72, 18);
		contentPane.add(lblNewLabel_volume1);
		String s=String.valueOf(search_volume);
		lblNewLabel_volume1.setText(s);
		
	
		JLabel lblNewLabel_weight1 = new JLabel("");
		lblNewLabel_weight1.setBounds(220, 228, 72, 18);
		contentPane.add(lblNewLabel_weight1);
		String w=String.valueOf(search_weight);
		lblNewLabel_weight1.setText(w);
		
		//打包方案判断
		if(search_goods_name.equals("酒精"))
			pack_plan="特殊方案";
		else
			if(search_volume<100&&search_weight<100)
			pack_plan="方案1";
			else
				if(search_volume<100&&search_weight<1000&&100<search_weight)
				pack_plan="方案2";
				else
					if(search_volume<100&&1000<search_weight)
					pack_plan="方案3";
					else
						if(search_volume<1000&&100<search_volume&&search_weight<100)
						pack_plan="方案4";
						else
							if(search_volume<1000&&100<search_volume&&100<search_weight&&search_weight<1000)
							pack_plan="方案5";
							else
								if(search_volume<1000&&100<search_volume&&1000<search_weight)
								pack_plan="方案6";
								else
									if(1000<search_volume&&search_weight<100)
									pack_plan="方案7";
									else
										if(1000<search_volume&&100<search_weight&&search_weight<1000)
										pack_plan="方案8";
										else
											if(1000<search_volume&&search_weight>1000)
											pack_plan="方案9";
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(220, 267, 136, 18);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setText(pack_plan);
		
		System.out.println(pack_plan);
		JButton btnNewButton = new JButton("保存打包方案");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				try {
//				    int a = Integer.parseInt(search_id2);
//				} catch (NumberFormatException e) {
//				    e.printStackTrace();
//				}
				String sql1="UPDATE tb_delivery SET delivery_pack ='"+pack_plan+"' WHERE order_id='"+search_id1+"'";
				
			    MySQLConnect con1=new MySQLConnect(sql1);
			    try {
					con1.pst.executeUpdate();
					 JOptionPane.showMessageDialog(null, "保存成功");  
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			   
				
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton.setBounds(255, 644, 136, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("打包方案说明：");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(44, 302, 110, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("方案1:体积<=100,质量<=100");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(44, 330, 336, 27);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("方案2:体积<=100,100<质量<=1000");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(44, 355, 336, 27);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("方案3:体积<=100,质量>1000");
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(44, 380, 336, 27);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("方案4:100<体积<=1000,质量<=100");
		lblNewLabel_6.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(44, 405, 336, 27);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("方案5:100<体积<=1000,100<质量<=1000");
		lblNewLabel_7.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(44, 430, 336, 27);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("方案6:100<体积<=1000,质量>1000");
		lblNewLabel_8.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(44, 455, 336, 27);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("方案7:体积>1000,质量<=100");
		lblNewLabel_9.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(44, 480, 336, 27);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("方案8:体积>1000,100<质量<=1000");
		lblNewLabel_10.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(44, 505, 336, 27);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("方案9:体积>1000,质量>1000");
		lblNewLabel_11.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_11.setBounds(44, 530, 336, 27);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("特殊方案:如药品,化工产品等。");
		lblNewLabel_12.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_12.setBounds(44, 555, 336, 27);
		contentPane.add(lblNewLabel_12);
	}
}
