package team.nwt.warestics.TransportationManagementSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import team.nwt.warestics.MySQLConnect;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TMS_Search extends JFrame {

	private JPanel contentPane;
	static String search_id=TMS.text;
	static String search_start;
	static String search_mid;
	static String search_end;
	static String search_check;			//审核的数据库结果
	static String check_state;			//审核状态（中文结果）
	static String search_time;
	static String search_state;			//转运状态
	static String state_now;			//转运状态（中文）

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TMS_Search frame = new TMS_Search();
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
	public TMS_Search() {
		
//*****************************初始查询开始****************************************
		
		//查询始发地
		String sql_start = "SELECT transfer_start FROM tb_transfer WHERE transfer_id='"+search_id+"'";
		MySQLConnect con_start = new MySQLConnect(sql_start);
		try {
			ResultSet result_start = con_start.pst.executeQuery();
			
			if(result_start.next()){
				search_start = result_start.getString("transfer_start");
//				System.out.println(search_start);							//测试输出
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//查询中转站
		String sql_mid = "SELECT transfer_mid FROM tb_transfer WHERE transfer_id='"+search_id+"'";
		MySQLConnect con_mid = new MySQLConnect(sql_mid);
		try {
			ResultSet result_mid = con_mid.pst.executeQuery();
			
			if(result_mid.next()){
				search_mid = result_mid.getString("transfer_mid");
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//查询终点站
		String sql_end = "SELECT transfer_end FROM tb_transfer WHERE transfer_id='"+search_id+"'";
		MySQLConnect con_end = new MySQLConnect(sql_end);
		try {
			ResultSet result_end = con_end.pst.executeQuery();
			
			if(result_end.next()){
				search_end = result_end.getString("transfer_end");
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//查询审核情况
		String sql_check = "SELECT transfer_check FROM tb_transfer WHERE transfer_id='"+search_id+"'";
		MySQLConnect con_check = new MySQLConnect(sql_check);
		try {
			ResultSet result_check = con_check.pst.executeQuery();
			
			if(result_check.next()){
				search_check = result_check.getString("transfer_check");
				if(search_check.compareTo("Y")==0){
					check_state="合格";
//					System.out.println(check_state);
				}
				else check_state="不合格";
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//查询转运时间
				String sql_time = "SELECT transfer_time FROM tb_transfer WHERE transfer_id='"+search_id+"'";
				MySQLConnect con_time = new MySQLConnect(sql_time);
				try {
					ResultSet result_time = con_time.pst.executeQuery();
					
					if(result_time.next()){
						search_time = result_time.getString("transfer_time");
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		//查询转运状态
				String sql_state = "SELECT transfer_state FROM tb_transfer WHERE transfer_id='"+search_id+"'";
				MySQLConnect con_state = new MySQLConnect(sql_state);
				try {
					ResultSet result_state = con_state.pst.executeQuery();
					
					if(result_state.next()){
						search_state = result_state.getString("transfer_state");
						if(search_state.compareTo("Y")==0){
							state_now="已转运";
						}
						else state_now="未转运";
						
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		
//*****************************初始查询结束****************************************	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("转运管理系统(查询)");
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		label.setBounds(139, 10, 153, 34);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8F6C\u8FD0\u5355\u53F7\uFF1A");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_1.setBounds(87, 73, 75, 24);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("始发地：");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_2.setBounds(87, 114, 75, 24);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("中转站：");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_3.setBounds(87, 150, 75, 24);
		contentPane.add(label_3);
		
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
		button.setBounds(322, 346, 105, 24);
		contentPane.add(button);
		
		JLabel Label_id = new JLabel("transfer_id");
		Label_id.setBounds(174, 74, 114, 24);
		contentPane.add(Label_id);
		Label_id.setText(search_id);
		
		JLabel label_4 = new JLabel("目的地：");
		label_4.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_4.setBounds(87, 186, 75, 24);
		contentPane.add(label_4);
		
		JLabel Label_start = new JLabel("transfer_start");
		Label_start.setBounds(174, 115, 114, 24);
		contentPane.add(Label_start);
		Label_start.setText(search_start);			//打印始发地信息
		
		JLabel Label_mid = new JLabel("transfer_mid");
		Label_mid.setBounds(174, 151, 114, 24);
		contentPane.add(Label_mid);
		Label_mid.setText(search_mid);				//打印中转站
		
		JLabel Label_end = new JLabel("transfer_end");
		Label_end.setBounds(174, 187, 114, 24);
		contentPane.add(Label_end);
		Label_end.setText(search_end);				//打印目的地
		
		JLabel label_5 = new JLabel("审核情况：");
		label_5.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_5.setBounds(87, 222, 75, 24);
		contentPane.add(label_5);
	
		
		JLabel Label_check = new JLabel("transfer_check");
		Label_check.setBounds(174, 223, 114, 24);
		contentPane.add(Label_check);
		Label_check.setText(check_state);
		
		JLabel label_6 = new JLabel("转运时间：");
		label_6.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_6.setBounds(87, 258, 75, 24);
		contentPane.add(label_6);
		
		JLabel Label_time = new JLabel((String) null);
		Label_time.setBounds(174, 259, 170, 24);
		contentPane.add(Label_time);
		Label_time.setText(search_time);
		
		JLabel label_7 = new JLabel("转运状态：");
		label_7.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_7.setBounds(87, 294, 75, 24);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel((String) null);
		label_8.setBounds(174, 295, 114, 24);
		contentPane.add(label_8);
		label_8.setText(state_now);
	}
}
