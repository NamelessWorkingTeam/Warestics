package team.nwt.warestics.DMSAdminSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import team.nwt.warestics.MySQLConnect;
import team.nwt.warestics.TransportationManagementSystem.TMS_MainVersion;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DMSPackSearch extends JFrame {
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
					DMSPackSearch frame = new DMSPackSearch();
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
	public DMSPackSearch() {
		setTitle("发货订单查询");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("发货信息详情查询");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel.setBounds(153, 26, 130, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("输入订单号：");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(78, 104, 91, 18);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(201, 102, 157, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                text=textField.getText();
				
				String sql="SELECT order_id FROM tb_orderinformation WHERE order_id = '"+text+"'";
				MySQLConnect con=new MySQLConnect(sql);
				try {
					ResultSet result=con.pst.executeQuery();
					if(result.next()){									//单号正确跳转页面
						DMSPack version = new DMSPack();
						version.setResizable(false);
						version.setLocationRelativeTo(null);
						version.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
						version.setVisible(true);
						dispose();
					}
					else JOptionPane.showMessageDialog(null, "单号为空或错误，请重新输入", "提示",JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(75, 177, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("退出");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				DMSAdminSystemDemandManage newframe = new DMSAdminSystemDemandManage();
//				newframe.setLocationRelativeTo(null);			// 将新窗口放置于屏幕正中心
//				newframe.setVisible(true);
				
				dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton_1.setBounds(248, 177, 113, 27);
		contentPane.add(btnNewButton_1);
	}
}
