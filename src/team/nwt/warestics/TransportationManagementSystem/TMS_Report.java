package team.nwt.warestics.TransportationManagementSystem;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TMS_Report extends JFrame {

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
					TMS_Report frame = new TMS_Report();
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
	public TMS_Report() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("转运报告");
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		label.setBounds(132, 10, 105, 34);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("转运单号：");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_1.setBounds(61, 64, 75, 24);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("始发地：");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_2.setBounds(61, 109, 75, 24);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("目的地：");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_3.setBounds(61, 155, 75, 24);
		contentPane.add(label_3);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(47, 194, 341, 81);
		contentPane.add(panel);
		
		JLabel label_4 = new JLabel("审核：");
		label_4.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_4.setBounds(10, 10, 75, 24);
		panel.add(label_4);
		
		JCheckBox checkBox = new JCheckBox("合格");
		checkBox.setSelected(true);
		checkBox.setFont(new Font("Dialog", Font.PLAIN, 12));
		checkBox.setBounds(112, 11, 80, 24);
		panel.add(checkBox);
		
		textField = new JTextField();
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(146, 67, 114, 21);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(146, 112, 114, 21);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(146, 158, 114, 21);
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
		button.setBounds(319, 312, 105, 24);
		contentPane.add(button);
	}
}
