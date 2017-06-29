package team.nwt.warestics.TransportationManagementSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class TMS_MainVersion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TMS_MainVersion frame = new TMS_MainVersion();
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
	public TMS_MainVersion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8F6C\u8FD0\u7BA1\u7406\u7CFB\u7EDF");
		label.setFont(new Font("΢���ź�", Font.BOLD, 16));
		label.setBounds(165, 22, 105, 34);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 113, 414, 81);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("\u8D28\u91CF\u5BA1\u6838\uFF1A");
		label_1.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		label_1.setBounds(10, 10, 75, 24);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u6570\u91CF\u5BA1\u6838\uFF1A");
		label_2.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		label_2.setBounds(10, 44, 75, 24);
		panel.add(label_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\u5408\u683C");
		chckbxNewCheckBox.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		chckbxNewCheckBox.setBounds(112, 11, 80, 24);
		panel.add(chckbxNewCheckBox);
		
		JCheckBox checkBox = new JCheckBox("\u4E0D\u5408\u683C");
		checkBox.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		checkBox.setBounds(194, 11, 80, 24);
		panel.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("\u5408\u683C");
		checkBox_1.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		checkBox_1.setBounds(112, 45, 80, 24);
		panel.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("\u4E0D\u5408\u683C");
		checkBox_2.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		checkBox_2.setBounds(194, 45, 80, 24);
		panel.add(checkBox_2);
		
		JButton btnNewButton = new JButton("\u63D0\u4EA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(280, 29, 105, 24);
		panel.add(btnNewButton);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TMS_Search search = new TMS_Search();
				search.setResizable(false);
				search.setLocationRelativeTo(null);
				search.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				search.setVisible(true);
				dispose();
				
			}
		});
		button.setBounds(10, 220, 105, 24);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u9000\u5355\u5165\u5E93");
		button_1.setBounds(153, 220, 105, 24);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u66F4\u65B0\u76EE\u7684\u5730");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TMS_Update update = new TMS_Update();
				update.setResizable(false);
				update.setLocationRelativeTo(null);
				update.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				update.setVisible(true);
				dispose();
				
			}
		});
		button_2.setBounds(291, 220, 105, 24);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\u63D0\u4EA4\u8F6C\u8FD0");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TMS_Report report = new TMS_Report();
				report.setResizable(false);
				report.setLocationRelativeTo(null);
				report.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				report.setVisible(true);
				dispose();
				
			}
		});
		button_3.setBounds(153, 262, 105, 24);
		contentPane.add(button_3);
		
		JLabel label_3 = new JLabel("\u8F6C\u8FD0\u5355\u53F7\uFF1A");
		label_3.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		label_3.setBounds(22, 79, 75, 24);
		contentPane.add(label_3);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(120, 82, 114, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button_4 = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u7EA7");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TMS tms = new TMS();
				tms.setResizable(false);
				tms.setLocationRelativeTo(null);
				tms.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				tms.setVisible(true);
				dispose();
				
			}
		});
		button_4.setBounds(319, 315, 105, 24);
		contentPane.add(button_4);
	}
}
