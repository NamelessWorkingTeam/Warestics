package team.nwt.warestics.TransportationManagementSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import team.nwt.warestics.MySQLConnect;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

/**
 * 
 * @author liuhao
 *本系统所调用数据库中的tb_transfer表中的transfe_state属性
 *其中N为待转运，Y为已转运，T为已退单
 *Warning:transfer_state中只有N/Y/T三个状态，其他数据会导致数据库出错！！
 */

public class TMS extends JFrame {

	static String text;
	
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TMS frame = new TMS();
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
	public TMS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8F6C\u8FD0\u7BA1\u7406\u7CFB\u7EDF");
		label.setFont(new Font("转运管理系统", Font.BOLD, 16));
		label.setBounds(166, 10, 105, 34);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8F93\u5165\u8F6C\u8FD0\u5355\u53F7\uFF1A");
		label_1.setFont(new Font("输入物流单号", Font.PLAIN, 14));
		label_1.setBounds(46, 82, 105, 24);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(153, 84, 169, 21);
		contentPane.add(textField);
		textField.setColumns(10);
//		text=textField.getText();				//获取输入的值
		
		JButton btnNewButton = new JButton("\u63D0\u4EA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				text=textField.getText();
				
				String sql="SELECT transfer_id FROM tb_transfer WHERE transfer_id = '"+text+"'";
				MySQLConnect con=new MySQLConnect(sql);
				
				try {
					ResultSet result=con.pst.executeQuery();
					if(result.next()){									//如果存在这个id跳转下一个页面
						TMS_MainVersion version = new TMS_MainVersion();
						version.setResizable(false);
						version.setLocationRelativeTo(null);
						version.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
						version.setVisible(true);
						dispose();
					}
					else JOptionPane.showMessageDialog(null, "物流单号错误，请重新输入", "提示",JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnNewButton.setBounds(153, 147, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("退出登录");
		button.setFont(new Font("Dialog", Font.PLAIN, 13));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button.setBounds(311, 217, 93, 23);
		contentPane.add(button);
	}
}
