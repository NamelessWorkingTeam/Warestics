package team.nwt.warestics.LogisticsManagermentSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import team.nwt.warestics.LogisticsManagermentSystem.*;
import team.nwt.warestics.MySQLConnect;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import team.nwt.warestics.MySQLConnect;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LMS_MainVersion extends JFrame {
	
	private JPanel contentPane;
    JTable Dmjt=null;
    JScrollPane Dmjsp=null;
    JTable Dmjt2=null;
    JScrollPane Dmjsp2=null;
    JTable Dmjt3=null;
    JScrollPane Dmjsp3=null;
    JTable Dmjt4=null;
    JScrollPane Dmjsp4=null;
    JTable Dmjt5=null;
    JScrollPane Dmjsp5=null;
    JTable Dmjt6=null;
    JScrollPane Dmjsp6=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LMS_Task1 t =new LMS_Task1();
					t.main(args);
					LMS_MainVersion frame = new LMS_MainVersion();
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
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
	public LMS_MainVersion() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("物流管理系统");
		setBounds(100, 100, 1125, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.EAST);
		LMS_CarModelNull Dm2=new LMS_CarModelNull();
		this.setVisible(true);
		Dmjt2=new JTable(Dm2);
		Dmjsp2=new JScrollPane(Dmjt2);
		panel_2.add(Dmjsp2);
//		panel_2.setVisible(false);
		
		JButton btnNewButton_2 = new JButton("装车");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarAlarm();
				String sql="update tb_car set car_status=1 where tb_car.car_bourn = (select order_enduseraddress from tb_order)";
				MySQLConnect MySQLConnect_Connection_UPDATE_STATE = new MySQLConnect(sql);
				try {
					MySQLConnect_Connection_UPDATE_STATE.pst.executeUpdate();
					MySQLConnect_Connection_UPDATE_STATE.pst.close();
					MySQLConnect_Connection_UPDATE_STATE.close();
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				LMS_CarPackSuccess newframe = new LMS_CarPackSuccess();//页面跳转
				newframe.setLocationRelativeTo(null);
				newframe.setResizable(false);
				newframe.setVisible(true);
				panel_2.setVisible(false);
				JPanel panel_3 = new JPanel();
				contentPane.add(panel_3, BorderLayout.EAST);
				LMS_CarModelCar Dm3=new LMS_CarModelCar();
				Dmjt3=new JTable(Dm3);
				Dmjsp3=new JScrollPane(Dmjt3);
				panel_3.add(Dmjsp3);
			}
		});
		btnNewButton_2.setBounds(30, 36, 113, 34);
		panel.add(btnNewButton_2);
		
		JButton button_4 = new JButton("分配司机");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String String_CheckStorgesql = null;   
			    MySQLConnect db = null;  
			    ResultSet Result_Storge = null;  
		    	String_CheckStorgesql= "SELECT car_status FROM tb_car where tb_car.car_bourn = (select order_enduseraddress from tb_order)";	
		       db = new MySQLConnect(String_CheckStorgesql);							
		       try {
		       	Result_Storge = db.pst.executeQuery();					
					while (Result_Storge.next()) {
//		               String String_CheckName = Result_Storge.getString("car_id");
		               int Int_CheckStorge = Result_Storge.getInt("car_status");
		               switch (Int_CheckStorge){
		               case 1:
		            	   				CarAlarm();
				String sql="update tb_car set car_status=2 where tb_car.car_bourn = (select order_enduseraddress from tb_order)";
				MySQLConnect MySQLConnect_Connection_UPDATE_STATE = new MySQLConnect(sql);
				try {
					MySQLConnect_Connection_UPDATE_STATE.pst.executeUpdate();
					MySQLConnect_Connection_UPDATE_STATE.pst.close();
					MySQLConnect_Connection_UPDATE_STATE.close();
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				LMS_DriverSuccess newframe = new LMS_DriverSuccess();//页面跳转
				newframe.setLocationRelativeTo(null);
				newframe.setResizable(false);
				newframe.setVisible(true);
				JPanel panel_3 = new JPanel();
				contentPane.add(panel_3, BorderLayout.EAST);
				panel_3.setVisible(false);
				JPanel panel_4 = new JPanel();
				contentPane.add(panel_4, BorderLayout.EAST);
				LMS_CarModelDriver Dm4=new LMS_CarModelDriver();
				Dmjt4=new JTable(Dm4);
				Dmjsp4=new JScrollPane(Dmjt4);
				panel_4.add(Dmjsp4);
		               break;
		               case 0:
		            	   JOptionPane.showMessageDialog(null,"系统还未完成装车！", "警告", JOptionPane.ERROR_MESSAGE); //弹窗警告
		               break;
					}}
					Result_Storge.close();		
			        db.close();			
				} 
		       catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				
				
				
				
				
				
				
				
				
				
//				CarAlarm();
//				String sql="update tb_car set car_status=2 where tb_car.car_bourn = (select order_enduseraddress from tb_order)";
//				MySQLConnect MySQLConnect_Connection_UPDATE_STATE = new MySQLConnect(sql);
//				try {
//					MySQLConnect_Connection_UPDATE_STATE.pst.executeUpdate();
//					MySQLConnect_Connection_UPDATE_STATE.pst.close();
//					MySQLConnect_Connection_UPDATE_STATE.close();
//				} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				LMS_DriverSuccess newframe = new LMS_DriverSuccess();//页面跳转
//				newframe.setLocationRelativeTo(null);
//				newframe.setResizable(false);
//				newframe.setVisible(true);
//				JPanel panel_3 = new JPanel();
//				contentPane.add(panel_3, BorderLayout.EAST);
//				panel_3.setVisible(false);
//				JPanel panel_4 = new JPanel();
//				contentPane.add(panel_4, BorderLayout.EAST);
//				LMS_CarModelDriver Dm4=new LMS_CarModelDriver();
//				Dmjt4=new JTable(Dm4);
//				Dmjsp4=new JScrollPane(Dmjt4);
//				panel_4.add(Dmjsp4);
				
			}
		}});
		button_4.setBounds(30, 80, 113, 34);
		panel.add(button_4);
		
		

		
		
		JButton button_5 = new JButton("分配路线");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				CarAlarm();
				String String_CheckStorgesql = null;   
			    MySQLConnect db = null;  
			    ResultSet Result_Storge = null;  
		    	String_CheckStorgesql= "SELECT car_status FROM tb_car where tb_car.car_bourn = (select order_enduseraddress from tb_order)";	
		       db = new MySQLConnect(String_CheckStorgesql);							
		       try {
		       	Result_Storge = db.pst.executeQuery();					
					while (Result_Storge.next()) {
//		               String String_CheckName = Result_Storge.getString("car_id");
		               int Int_CheckStorge = Result_Storge.getInt("car_status");
		               switch (Int_CheckStorge){
		               case 2:
		            	   String sql="update tb_car set car_status=3 where tb_car.car_bourn = (select order_enduseraddress from tb_order)";
		   				MySQLConnect MySQLConnect_Connection_UPDATE_STATE = new MySQLConnect(sql);
		   				try {
		   					MySQLConnect_Connection_UPDATE_STATE.pst.executeUpdate();
		   					MySQLConnect_Connection_UPDATE_STATE.pst.close();
		   					MySQLConnect_Connection_UPDATE_STATE.close();
		   				} catch (SQLException e1) {
		   				// TODO Auto-generated catch block
		   					e1.printStackTrace();
		   				}
//		   				Dm2.fireTableDataChanged();
//		   				panel_2.add(Dmjsp2);
		   				LMS_RouteSuccess newframe = new LMS_RouteSuccess();//页面跳转
		   				newframe.setLocationRelativeTo(null);
		   				newframe.setResizable(false);
		   				newframe.setVisible(true);
		   				JPanel panel_4 = new JPanel();
		   				contentPane.add(panel_4, BorderLayout.EAST);
		   				panel_4.setVisible(false);
		   				JPanel panel_5 = new JPanel();
		   				contentPane.add(panel_5, BorderLayout.EAST);
		   				LMS_CarModelRoute Dm5=new LMS_CarModelRoute();
		   				Dmjt5=new JTable(Dm5);
		   				Dmjsp5=new JScrollPane(Dmjt5);
		   				panel_5.add(Dmjsp5);
		   			
		               break;
		               case 1:
		            	   JOptionPane.showMessageDialog(null,"系统还未完成司机分配！", "警告", JOptionPane.ERROR_MESSAGE); //弹窗警告
		               break;
		               case 0:
		            	   JOptionPane.showMessageDialog(null,"系统还未完成装车！", "警告", JOptionPane.ERROR_MESSAGE); //弹窗警告
		               break;
					}}
					Result_Storge.close();		
			        db.close();			
				} 
		       catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			}  
			}});	
				
				
				
		
		button_5.setBounds(30, 124, 113, 34);
		panel.add(button_5);
		
		JButton button_6 = new JButton("发车");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				CarAlarm();
//				JOptionPane.showConfirmDialog(null, "请确认是否发车", "choose one", JOptionPane.YES_NO_OPTION); 
				
				
				String String_CheckStorgesql = null;   
			    MySQLConnect db = null;  
			    ResultSet Result_Storge = null;  
		    	String_CheckStorgesql= "SELECT car_status FROM tb_car where tb_car.car_bourn = (select order_enduseraddress from tb_order)";	
		       db = new MySQLConnect(String_CheckStorgesql);							
		       try {
		       	Result_Storge = db.pst.executeQuery();					
					while (Result_Storge.next()) {
//		               String String_CheckName = Result_Storge.getString("car_id");
		               int Int_CheckStorge = Result_Storge.getInt("car_status");
		               switch (Int_CheckStorge){
		               case 4: 
		               //System.out.println(String_CheckName);
		               //System.out.println(Result_Storge.getInt("MED_STORGE"));
//		            JOptionPane.showMessageDialog(null,"编号："+ String_CheckName+"货车出现异常！", "警告", JOptionPane.ERROR_MESSAGE); //弹窗警告
		            	   int n=JOptionPane.showConfirmDialog(null, "请确认是否发车","注意",JOptionPane.YES_NO_OPTION);
		   				if (n == 0){				
		   				String sql="update tb_car set car_status=5 where tb_car.car_bourn = (select order_enduseraddress from tb_order)";
		   				MySQLConnect MySQLConnect_Connection_UPDATE_STATE = new MySQLConnect(sql);
		   						   				try {
		   					MySQLConnect_Connection_UPDATE_STATE.pst.executeUpdate();
		   					MySQLConnect_Connection_UPDATE_STATE.pst.close();
		   					MySQLConnect_Connection_UPDATE_STATE.close();
		   				} catch (SQLException e1) {
		   				// TODO Auto-generated catch block
		   					e1.printStackTrace();
		   				}
		   				String sql1="update tb_delivery set delivery_depart='发车' where tb_delivery.order_id = (select order_id from tb_order)";
		   				MySQLConnect MySQLConnect_Connection_UPDATE_STATE1 = new MySQLConnect(sql1);		   				
		   				try {
		   					MySQLConnect_Connection_UPDATE_STATE1.pst.executeUpdate();
		   					MySQLConnect_Connection_UPDATE_STATE1.pst.close();
		   					MySQLConnect_Connection_UPDATE_STATE1.close();
		   				} catch (SQLException e1) {
		   				// TODO Auto-generated catch block
		   					e1.printStackTrace();
		   				}	   			
		   				
		   				
		   				JPanel panel_4 = new JPanel();
		   				contentPane.add(panel_4, BorderLayout.WEST);
		   				panel_4.setVisible(false);
		   				JPanel panel_2 = new JPanel();
		   				contentPane.add(panel_2, BorderLayout.WEST);
		   				LMS_DeliveryModel Dm3=new LMS_DeliveryModel();
		   				Dmjt3=new JTable(Dm3);
		   				Dmjsp3=new JScrollPane(Dmjt3);
		   				panel_2.add(Dmjsp3);
		   				
		   				
		   				
		   				JPanel panel_5 = new JPanel();
		   				contentPane.add(panel_5, BorderLayout.EAST);
		   				panel_5.setVisible(false);
		   				JPanel panel_6 = new JPanel();
		   				contentPane.add(panel_6, BorderLayout.EAST);
		   				LMS_CarModel Dm6=new LMS_CarModel();
		   				Dmjt6=new JTable(Dm6);
		   				Dmjsp6=new JScrollPane(Dmjt6);
		   				panel_6.add(Dmjsp6);
//		   				LMS_FinalSuccess newframe = new LMS_FinalSuccess();//页面跳转
//		   				newframe.setVisible(true);
		   			} else {
		   				JPanel panel_5 = new JPanel();
		   				contentPane.add(panel_5, BorderLayout.EAST);
		   				panel_5.setVisible(false);
		   				JPanel panel_6 = new JPanel();
		   				contentPane.add(panel_6, BorderLayout.EAST);
		   				LMS_CarModel Dm6=new LMS_CarModel();
		   				Dmjt6=new JTable(Dm6);
		   				Dmjsp6=new JScrollPane(Dmjt6);
		   				panel_6.add(Dmjsp6);	
		   			}	
		   				
		               ;
		               break;
		               case 3:
		            	   JOptionPane.showMessageDialog(null,"司机还未确认发车！", "警告", JOptionPane.ERROR_MESSAGE);//弹窗警告
		               break;
		               case 2:
		            	   JOptionPane.showMessageDialog(null,"系统还未完成行驶线路确认！", "警告", JOptionPane.ERROR_MESSAGE);//弹窗警告
		               break;
		               case 1:
		            	   JOptionPane.showMessageDialog(null,"系统还未完成司机分配！", "警告", JOptionPane.ERROR_MESSAGE); //弹窗警告
		               break;
		               case 0:
		            	   JOptionPane.showMessageDialog(null,"系统还未完成装车！", "警告", JOptionPane.ERROR_MESSAGE); //弹窗警告
		               break;
					}}
					Result_Storge.close();		
			        db.close();			
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}  
			}
			});	
				
				
				
				
//				int n=JOptionPane.showConfirmDialog(null, "请确认是否发车","注意",JOptionPane.YES_NO_OPTION);
//				
//				if (n == 0){				
//				String sql="update tb_car set car_status=5 where tb_car.car_bourn = (select order_enduseraddress from tb_order)";
//				MySQLConnect MySQLConnect_Connection_UPDATE_STATE = new MySQLConnect(sql);
//				try {
//					MySQLConnect_Connection_UPDATE_STATE.pst.executeUpdate();
//					MySQLConnect_Connection_UPDATE_STATE.pst.close();
//					MySQLConnect_Connection_UPDATE_STATE.close();
//				} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				JPanel panel_5 = new JPanel();
//				contentPane.add(panel_5, BorderLayout.EAST);
//				panel_5.setVisible(false);
//				JPanel panel_6 = new JPanel();
//				contentPane.add(panel_6, BorderLayout.EAST);
//				LMS_CarModel Dm6=new LMS_CarModel();
//				Dmjt6=new JTable(Dm6);
//				Dmjsp6=new JScrollPane(Dmjt6);
//				panel_6.add(Dmjsp6);
////				LMS_FinalSuccess newframe = new LMS_FinalSuccess();//页面跳转
////				newframe.setVisible(true);
//			} else {
//				JPanel panel_5 = new JPanel();
//				contentPane.add(panel_5, BorderLayout.EAST);
//				panel_5.setVisible(false);
//				JPanel panel_6 = new JPanel();
//				contentPane.add(panel_6, BorderLayout.EAST);
//				LMS_CarModel Dm6=new LMS_CarModel();
//				Dmjt6=new JTable(Dm6);
//				Dmjsp6=new JScrollPane(Dmjt6);
//				panel_6.add(Dmjsp6);	
//			}
		
		button_6.setBounds(30, 168, 113, 34);
		panel.add(button_6);
		
		JButton button_7 = new JButton("人工介入");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//				Component frame = null;
//				JOptionPane.showInternalMessageDialog(null, "information","information", JOptionPane.INFORMATION_MESSAGE); 
				JOptionPane.showMessageDialog(null, "人工介入成功，状态切换至正常行驶！", "警告", JOptionPane.ERROR_MESSAGE);
//				int n= JOptionPane.showConfirmDialog(temporaryLostComponent, anchor);
				String sql="update tb_car set car_status=5 where tb_car.car_bourn = (select order_enduseraddress from tb_order)";
				MySQLConnect MySQLConnect_Connection_UPDATE_STATE = new MySQLConnect(sql);
				try {
					MySQLConnect_Connection_UPDATE_STATE.pst.executeUpdate();
					MySQLConnect_Connection_UPDATE_STATE.pst.close();
					MySQLConnect_Connection_UPDATE_STATE.close();
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JPanel panel_5 = new JPanel();
				contentPane.add(panel_5, BorderLayout.EAST);
				panel_5.setVisible(false);
				JPanel panel_6 = new JPanel();
				contentPane.add(panel_6, BorderLayout.EAST);
				LMS_CarModel Dm6=new LMS_CarModel();
				Dmjt6=new JTable(Dm6);
				Dmjsp6=new JScrollPane(Dmjt6);
				panel_6.add(Dmjsp6);
			}
		});
		button_7.setBounds(30, 212, 113, 34);
		panel.add(button_7);
		
		JLabel lblNewLabel = new JLabel("2代表司机分配就绪。");
		lblNewLabel.setBounds(10, 345, 133, 24);
		panel.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("3代表分配行驶路线就绪。");
		label_1.setBounds(10, 365, 155, 24);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("4代表司机确认，准备发车。");
		label_2.setBounds(10, 385, 165, 24);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("5代表正常行驶状态。");
		label_3.setBounds(10, 405, 133, 24);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("1代表装车就绪。");
		label_4.setBounds(10, 325, 113, 24);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("\t0代表车辆空闲\r\n");
		label_5.setBounds(10, 305, 113, 24);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("6代表手机端求救。");
		label_6.setBounds(10, 425, 120, 24);
		panel.add(label_6);
		
		LMS_DeliveryModel Dm=new LMS_DeliveryModel();
		this.setVisible(true);
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		Dmjt=new JTable(Dm);
		Dmjsp=new JScrollPane(Dmjt);
		panel_1.add(Dmjsp);
		
	
		

		

		
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.NORTH);
		
		JLabel label = new JLabel("物流管理系统");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		panel_3.add(label);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.SOUTH);
		
		JButton button_2 = new JButton("信息管理");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LMS_CarManagement newframe = new LMS_CarManagement();//页面跳转
				newframe.setLocationRelativeTo(null);
				newframe.setResizable(false);
				newframe.setVisible(true);
			}
		});
		panel_4.add(button_2);
		
		JButton button = new JButton("退出");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					setVisible(false);
					dispose();
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
		panel_4.add(button);
//		CarAlarm();
		

	}
	static private void CarAlarm(){
	    String String_CheckStorgesql = null;   
	    MySQLConnect db = null;  
	    ResultSet Result_Storge = null;  
    	String_CheckStorgesql= "SELECT car_id,car_status FROM tb_car";	
       db = new MySQLConnect(String_CheckStorgesql);							// 新建一个数据库连接
       try {
       	Result_Storge = db.pst.executeQuery();					// 执行sql语句，得到结果集
			while (Result_Storge.next()) {
               String String_CheckName = Result_Storge.getString("car_id");
               int Int_CheckStorge = Result_Storge.getInt("car_status");// 获取执行sql语句后结果集中列名为ACC_NAME的一个值	
               if (Int_CheckStorge>=6)//判断药品库存不足20时提醒
               { 
               //System.out.println(String_CheckName);
               //System.out.println(Result_Storge.getInt("MED_STORGE"));//控制台输出
               JOptionPane.showMessageDialog(null,"编号："+ String_CheckName+"货车出现异常！", "警告", JOptionPane.ERROR_MESSAGE); //弹窗警告
               	}
               }
			Result_Storge.close();		// 关闭执行的语句连接
	        db.close();			// 关闭数据库连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}	

