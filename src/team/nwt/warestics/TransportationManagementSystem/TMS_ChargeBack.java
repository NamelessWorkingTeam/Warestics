package team.nwt.warestics.TransportationManagementSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;  
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.CMYKColor;

import team.nwt.warestics.MySQLConnect;
import team.nwt.warestics.DMSAdminSystem.DMSDeliveryModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.Map;
import java.awt.event.ActionEvent;

import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JTable;

public class TMS_ChargeBack extends JFrame {

	private JPanel contentPane;
	static String report_id=TMS.text;
	static String report_start;
	static String report_mid;
	static String report_end;
	static String report_check;
	static String check_state;
	static String report_time;
	static String report_state;			//转运状态（数据库）
	static String state_now;			//转运状态（中文）
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TMS_ChargeBack frame = new TMS_ChargeBack();
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
	public TMS_ChargeBack() {
		
//*****************************初始查询开始****************************************
		
		//查询始发地
		String sql_start = "SELECT transfer_start FROM tb_transfer WHERE transfer_id='"+report_id+"'";
		MySQLConnect con_start = new MySQLConnect(sql_start);
		try {
			ResultSet result_start = con_start.pst.executeQuery();
			
			if(result_start.next()){
				report_start = result_start.getString("transfer_start");
//				System.out.println(report_start);							//测试输出
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//查询中转站
		String sql_mid = "SELECT transfer_mid FROM tb_transfer WHERE transfer_id='"+report_id+"'";
		MySQLConnect con_mid = new MySQLConnect(sql_mid);
		try {
			ResultSet result_mid = con_mid.pst.executeQuery();
			
			if(result_mid.next()){
				report_mid = result_mid.getString("transfer_mid");
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//查询终点站
		String sql_end = "SELECT transfer_end FROM tb_transfer WHERE transfer_id='"+report_id+"'";
		MySQLConnect con_end = new MySQLConnect(sql_end);
		try {
			ResultSet result_end = con_end.pst.executeQuery();
			
			if(result_end.next()){
				report_end = result_end.getString("transfer_end");
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//查询审核情况
		String sql_check = "SELECT transfer_check FROM tb_transfer WHERE transfer_id='"+report_id+"'";
		MySQLConnect con_check = new MySQLConnect(sql_check);
		try {
			ResultSet result_check = con_check.pst.executeQuery();
			
			if(result_check.next()){
				report_check = result_check.getString("transfer_check");
				if(report_check.compareTo("Y")==0){
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
		String sql_time = "SELECT transfer_time FROM tb_transfer WHERE transfer_id='"+report_id+"'";
		MySQLConnect con_time = new MySQLConnect(sql_time);
		try {
			ResultSet result_time = con_time.pst.executeQuery();
			
			if(result_time.next()){
				report_time = result_time.getString("transfer_time");
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
//*****************************初始查询结束****************************************	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("退单确认");
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		label.setBounds(174, 6, 153, 34);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8F6C\u8FD0\u5355\u53F7\uFF1A");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_1.setBounds(74, 77, 75, 24);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("始发地：");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_2.setBounds(74, 118, 75, 24);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("中转站：");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_3.setBounds(74, 154, 75, 24);
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
		button.setBounds(294, 389, 105, 24);
		contentPane.add(button);
		
		JLabel Label_id = new JLabel("transfer_id");
		Label_id.setBounds(161, 78, 114, 24);
		contentPane.add(Label_id);
		Label_id.setText(report_id);
		
		JLabel label_4 = new JLabel("目的地：");
		label_4.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_4.setBounds(74, 190, 75, 24);
		contentPane.add(label_4);
		
		JLabel Label_start = new JLabel("transfer_start");
		Label_start.setBounds(161, 119, 114, 24);
		contentPane.add(Label_start);
		Label_start.setText(report_start);			//打印始发地信息
		
		JLabel Label_mid = new JLabel("transfer_mid");
		Label_mid.setBounds(161, 155, 114, 24);
		contentPane.add(Label_mid);
		Label_mid.setText(report_mid);				//打印中转站
		
		JLabel Label_end = new JLabel("transfer_end");
		Label_end.setBounds(161, 191, 114, 24);
		contentPane.add(Label_end);
		Label_end.setText(report_end);				//打印目的地
		
		JLabel label_5 = new JLabel("审核情况：");
		label_5.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_5.setBounds(74, 226, 75, 24);
		contentPane.add(label_5);
	
		
		JLabel Label_check = new JLabel("transfer_check");
		Label_check.setBounds(161, 227, 114, 24);
		contentPane.add(Label_check);
		Label_check.setText(check_state);
		
		JButton button_1 = new JButton("确定退单");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
		//查询转运状态
				String sql_state = "SELECT transfer_state FROM tb_transfer WHERE transfer_id='"+report_id+"'";
				MySQLConnect con_state = new MySQLConnect(sql_state);
				try {
					ResultSet result_state = con_state.pst.executeQuery();
					
					if(result_state.next()){
						report_state = result_state.getString("transfer_state");
						if(report_state.compareTo("Y")==0){
							state_now="已转运";
						}
						else if (report_state.compareTo("N")==0) state_now="待转运";
						else if (report_state.compareTo("T")==0) state_now="已退单";
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		button_1.setBounds(222, 285, 105, 24);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("查看商品明细");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TMS_GoodsList TMS_GoodsList = new TMS_GoodsList();
				TMS_GoodsList.setResizable(false);
				TMS_GoodsList.setLocationRelativeTo(null);
				TMS_GoodsList.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				TMS_GoodsList.setVisible(true);
				dispose();
				
			}
		});
		button_2.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		button_2.setBounds(62, 285, 105, 24);
		contentPane.add(button_2);
		
		
		

		






//		this.setVisible(true);
		
	}
}
