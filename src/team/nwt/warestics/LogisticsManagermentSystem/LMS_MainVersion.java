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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1083, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
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
			}
		});
		button_4.setBounds(10, 147, 113, 34);
		panel.add(button_4);
		
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.EAST);
		
	    LMS_CarModel Dm2=new LMS_CarModel();
		this.setVisible(true);
		Dmjt2=new JTable(Dm2);
		Dmjsp2=new JScrollPane(Dmjt2);
		panel_2.add(Dmjsp2);
		
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
				panel_2.add(Dmjsp2);
				LMS_RouteSuccess newframe = new LMS_RouteSuccess();//页面跳转
				newframe.setVisible(true);
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
				LMS_FinalSuccess newframe = new LMS_FinalSuccess();//页面跳转
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
