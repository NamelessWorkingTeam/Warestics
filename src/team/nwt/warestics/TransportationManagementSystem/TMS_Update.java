package team.nwt.warestics.TransportationManagementSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import team.nwt.warestics.MySQLConnect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TMS_Update extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	static String update_id = TMS.text;
	static String update_start;
	static String update_end;
	static String text_end;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TMS_Update frame = new TMS_Update();
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
	public TMS_Update() {
		
		//查询始发地
				String sql_start = "SELECT transfer_start FROM tb_transfer WHERE transfer_id='"+update_id+"'";
				MySQLConnect con_start = new MySQLConnect(sql_start);
				try {
					ResultSet result_start = con_start.pst.executeQuery();
					
					if(result_start.next()){
						update_start = result_start.getString("transfer_start");
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("转运管理系统(更新目的地)");
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		label.setBounds(108, 10, 215, 34);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("转运单号：");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_1.setBounds(87, 73, 75, 24);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("始发地：");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_2.setBounds(87, 125, 75, 24);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("目的地：");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_3.setBounds(87, 175, 75, 24);
		contentPane.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		textField_2.setColumns(10);
		textField_2.setBounds(174, 176, 118, 24);
		contentPane.add(textField_2);
		
		JButton button = new JButton("返回上一级");
		button.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TMS_MainVersion version = new TMS_MainVersion();
				version.setResizable(false);
				version.setLocationRelativeTo(null);
				version.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				version.setVisible(true);
				dispose();
				
			}
		});
		button.setBounds(323, 324, 105, 24);
		contentPane.add(button);
		
		JLabel label_id = new JLabel((String) null);
		label_id.setBounds(174, 73, 118, 24);
		contentPane.add(label_id);
		label_id.setText(update_id);
		
		JLabel label_start = new JLabel((String) null);
		label_start.setBounds(174, 125, 118, 24);
		contentPane.add(label_start);
		label_start.setText(update_start);
		
		JButton button_1 = new JButton("更新");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				text_end=textField_2.getText();
				String sql = "UPDATE tb_transfer SET transfer_end='"+text_end+"' WHERE transfer_id='"+update_id+"'";
				MySQLConnect con = new MySQLConnect(sql);
				try {
					con.pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "更新成功！", "提示",JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "更新失败！", "提示", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				
			}
		});
		button_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		button_1.setBounds(323, 177, 105, 24);
		contentPane.add(button_1);
	}
}
