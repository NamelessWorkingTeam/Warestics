package team.nwt.warestics.TransportationManagementSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TMS extends JFrame {

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
		label.setFont(new Font("΢���ź�", Font.BOLD, 16));
		label.setBounds(166, 10, 105, 34);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8F93\u5165\u8F6C\u8FD0\u5355\u53F7\uFF1A");
		label_1.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		label_1.setBounds(46, 82, 105, 24);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(153, 84, 169, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u63D0\u4EA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TMS_MainVersion version = new TMS_MainVersion();
				version.setResizable(false);
				version.setLocationRelativeTo(null);
				version.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				version.setVisible(true);
				dispose();
				
				
			}
		});
		btnNewButton.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		btnNewButton.setBounds(153, 147, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\u9000\u51FA\u7CFB\u7EDF");
		button.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(311, 217, 93, 23);
		contentPane.add(button);
	}
}
