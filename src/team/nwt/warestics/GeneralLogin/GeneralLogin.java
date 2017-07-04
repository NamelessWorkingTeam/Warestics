package team.nwt.warestics.GeneralLogin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
//import org.eclipse.wb.swing.FocusTraversalOnArray;

import team.nwt.warestics.MySQLConnect;
import team.nwt.warestics.DMSAdminSystem.DMSAdminSystem;
import team.nwt.warestics.LogisticsManagermentSystem.LMS_MainVersion;
import team.nwt.warestics.TransportationManagementSystem.TMS;
import team.nwt.warestics.rms.RuntimeManagementSystem;
import team.nwt.warestics.warehousemanagesystem.WarehouseManageGUI;

import java.awt.Component;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class GeneralLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneralLogin frame = new GeneralLogin();
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
	public GeneralLogin() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 316);
		// setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Warestics 统一登录");
		lblNewLabel.setBounds(142, 20, 275, 49);
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBounds(166, 74, 229, 73);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel_1.setBounds(0, 2, 72, 29);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		
		JLabel label = new JLabel("\u5BC6\u7801\uFF1A");
		label.setBounds(0, 40, 72, 29);
		panel.add(label);
		label.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		
		textField = new JTextField();
		textField.setBounds(83, 0, 146, 35);
		panel.add(textField);
		textField.setFont(new Font("微软雅黑", Font.PLAIN, 26));
		textField.setColumns(10);
		//contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel, lblNewLabel_1, label, textField, passwordField}));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(83, 38, 146, 35);
		panel.add(passwordField);
		passwordField.setFont(new Font("微软雅黑", Font.PLAIN, 26));
		passwordField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(176, 159, 207, 37);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton button = new JButton("\u767B\u5F55");
		button.setBounds(0, 0, 96, 37);
		panel_1.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String String_SQL_ACC_ID = "SELECT account_password, account_type FROM tb_account WHERE account_id = " + textField.getText() + "";
				MySQLConnect MySQLConnect_Connection = new MySQLConnect(String_SQL_ACC_ID);
				
				// START 判断输入是否为空
				int Int_IfEmptyField = 0;
				if(textField.getText().trim().compareTo("") == 0) {
					Int_IfEmptyField = Int_IfEmptyField + 1;
				}
				if(String.valueOf(passwordField.getPassword()).compareTo("") == 0) {
					Int_IfEmptyField = Int_IfEmptyField + 2;
				}
				
				String String_EmptyField = "";
				switch(Int_IfEmptyField) {
				case 1:
					String_EmptyField = "账号不能为空！";
					break;
				case 2:
					String_EmptyField = "密码不能为空！";
					break;
				case 3:
					String_EmptyField = "账号和密码不能为空！";
					break;
				}
				// END 判断输入是否为空
				
				if(Int_IfEmptyField == 0) {
					try {
						ResultSet ResultSet_PASSWORD = MySQLConnect_Connection.pst.executeQuery();
					
						if(ResultSet_PASSWORD.next()) {
							if(ResultSet_PASSWORD.getString("account_password").compareTo(String.valueOf(passwordField.getPassword())) == 0) {
								switch(ResultSet_PASSWORD.getInt("account_type")) {
								case 0:
									RuntimeManagementSystem RuntimeManagementSystem_NewFrame = new RuntimeManagementSystem(textField.getText());
									RuntimeManagementSystem_NewFrame.setResizable(false);
									RuntimeManagementSystem_NewFrame.setLocationRelativeTo(null);
									RuntimeManagementSystem_NewFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
									RuntimeManagementSystem_NewFrame.setVisible(true);
									dispose();
									break;
								case 1:
//									WarehouseManageGUI WarehouseManageGUI_NewFrame = new WarehouseManageGUI();
//									WarehouseManageGUI_NewFrame.setResizable(false);
//									WarehouseManageGUI_NewFrame.setLocationRelativeTo(null);
//									WarehouseManageGUI_NewFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//									WarehouseManageGUI_NewFrame.setVisible(true);
//									dispose();	
									break;
								case 2:
									DMSAdminSystem DMSAdminSystem_NewFrame = new DMSAdminSystem();
									DMSAdminSystem_NewFrame.setResizable(false);
									DMSAdminSystem_NewFrame.setLocationRelativeTo(null);
									DMSAdminSystem_NewFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
									DMSAdminSystem_NewFrame.setVisible(true);
									dispose();
									break;
								case 3:
									TMS TMS_NewFrame = new TMS();
									TMS_NewFrame.setResizable(false);
									TMS_NewFrame.setLocationRelativeTo(null);
									TMS_NewFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
									TMS_NewFrame.setVisible(true);
									dispose();
									break;
								case 4:
									LMS_MainVersion LMS_MainVersion_NewFrame = new LMS_MainVersion();
									LMS_MainVersion_NewFrame.setLocationRelativeTo(null);
									LMS_MainVersion_NewFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
									LMS_MainVersion_NewFrame.setVisible(true);
									dispose();
									break;
								}
							}
							else {
								JOptionPane.showMessageDialog(null, 
										"用户名或密码错误！", "系统信息", JOptionPane.WARNING_MESSAGE);
							}
						}
						else {
							JOptionPane.showMessageDialog(null, 
									"用户名或密码错误！", "系统信息", JOptionPane.WARNING_MESSAGE);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					// 提示输入为空
					JOptionPane.showMessageDialog(null, 
							String_EmptyField, "系统信息", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.setBounds(111, 0, 96, 37);
		panel_1.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 24));
	}
}
