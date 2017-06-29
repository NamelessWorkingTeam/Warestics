package team.nwt.warestics.TransportationManagementSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TMS_Search extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 335);
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
		label_2.setBounds(87, 125, 75, 24);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("目的地：");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_3.setBounds(87, 175, 75, 24);
		contentPane.add(label_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(178, 76, 114, 21);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(178, 128, 114, 21);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(178, 178, 114, 21);
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
		button.setBounds(319, 262, 105, 24);
		contentPane.add(button);
	}

}
