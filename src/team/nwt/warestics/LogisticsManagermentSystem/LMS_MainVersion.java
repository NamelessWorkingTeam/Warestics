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
					LMS_MainVersion frame = new LMS_MainVersion();
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
		setBounds(100, 100, 1083, 597);
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
		btnNewButton_2.setBounds(10, 78, 113, 34);
		panel.add(btnNewButton_2);
		
		JButton button_4 = new JButton("分配司机");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				
			}
		});
		button_4.setBounds(10, 147, 113, 34);
		panel.add(button_4);
		
		

		
		
		JButton button_5 = new JButton("分配路线");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
//				Dm2.fireTableDataChanged();
//				panel_2.add(Dmjsp2);
				LMS_RouteSuccess newframe = new LMS_RouteSuccess();//页面跳转
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
			}
		});
		button_5.setBounds(10, 216, 113, 34);
		panel.add(button_5);
		
		JButton button_6 = new JButton("发车");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showConfirmDialog(null, "请确认是否发车", "choose one", JOptionPane.YES_NO_OPTION); 
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
//				LMS_FinalSuccess newframe = new LMS_FinalSuccess();//页面跳转
//				newframe.setVisible(true);
			}
		});
		button_6.setBounds(10, 286, 113, 34);
		panel.add(button_6);
		
		JButton button_7 = new JButton("人工介入");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_7.setBounds(10, 360, 113, 34);
		panel.add(button_7);
		
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
		
		JButton button_1 = new JButton("监控界面");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_4.add(button_1);
		
		JButton button_2 = new JButton("信息管理");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LMS_CarManagement newframe = new LMS_CarManagement();//页面跳转
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
	}
	
	
}
