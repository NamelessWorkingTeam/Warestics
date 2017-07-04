package team.nwt.warestics.DMSAdminSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;

//import team.nwsh.nwshospital.AdminSystem.AdminSystemShowMEDInfo;
//import team.nwsh.nwshospital.DirectorSystem.MedicineModel;
import team.nwt.warestics.MySQLConnect;
import team.nwt.warestics.DMSAdminSystem.DMSDeliveryModel;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

//import javax.swing.border.EmptyBorder;
//import javax.swing.table.DefaultTableModel;
import team.nwt.warestics.MySQLConnect;

public class DMSAdminSystemDemandManage extends JFrame implements ActionListener  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
    JTable jt=null;
    JScrollPane jsp=null;
	JButton BtnNewButton = new JButton("查询");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DMSAdminSystemDemandManage frame = new DMSAdminSystemDemandManage();
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
	public DMSAdminSystemDemandManage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("请输入发货id：");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		BtnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		BtnNewButton.addActionListener(this);
		panel.add(BtnNewButton);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton_3 = new JButton("发送需求");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				AdminSystemMEDChange newframe = new AdminSystemMEDChange();
//				newframe.setVisible(true);
				
			}
		});
		btnNewButton_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel_1.add(btnNewButton_3);
		JButton btnNewButton_4 = new JButton("打包");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DMSPackSearch newframe = new DMSPackSearch();
				newframe.setLocationRelativeTo(null);			// 将新窗口放置于屏幕正中心
				newframe.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel_1.add(btnNewButton_4);
		JButton btnNewButton_2 = new JButton("\u8FD4\u56DE");
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DMSAdminSystem newframe = new DMSAdminSystem();
				newframe.setLocationRelativeTo(null);			// 将新窗口放置于屏幕正中心
				newframe.setVisible(true);
				
				dispose();
				//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		panel_1.add(btnNewButton_2);

		
		
		setTitle("发货管理");

        DMSDeliveryModel x=new DMSDeliveryModel();
        jt=new JTable(x);
		jsp=new JScrollPane(jt);
		getContentPane().add(jsp);
		this.setBounds(12, 76, 380, 560);
		this.setVisible(true);

		}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成的方法存根
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if(arg0.getSource()==BtnNewButton)//检查
		{
			String name=this.textField.getText().trim();//获取textfield信息
			//String sql="select * from MEDICINE where MED_NAME='"+name+"'";//实现模糊查询
			String sql="select * from tb_delivery where delivery_id like'%"+name+"%'";
			DMSDeliveryModel x=new DMSDeliveryModel(sql);
			jt.setModel(x);
		}
	}
}
