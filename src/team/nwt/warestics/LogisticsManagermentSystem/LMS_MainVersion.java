package team.nwt.warestics.LogisticsManagermentSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import java.awt.Font;

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
			}
		});
		btnNewButton_2.setBounds(10, 78, 113, 34);
		panel.add(btnNewButton_2);
		
		JButton button_4 = new JButton("分配司机");
		button_4.setBounds(10, 147, 113, 34);
		panel.add(button_4);
		
		JButton button_5 = new JButton("分配路线");
		button_5.setBounds(10, 216, 113, 34);
		panel.add(button_5);
		
		JButton button_6 = new JButton("发车");
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
		
	
		
		
	
		
		
		LMS_CarModel Dm2=new LMS_CarModel();
		this.setVisible(true);
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.EAST);
		Dmjt2=new JTable(Dm2);
		Dmjsp2=new JScrollPane(Dmjt2);
		panel_2.add(Dmjsp2);
		
		
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
		panel_4.add(button_2);
		
		JButton button = new JButton("退出");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					setVisible(false);
					dispose();
					//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
		panel_4.add(button);
	}
}
