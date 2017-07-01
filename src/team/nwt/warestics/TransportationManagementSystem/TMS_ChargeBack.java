package team.nwt.warestics.TransportationManagementSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class TMS_ChargeBack extends JFrame {

	private JPanel contentPane;

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
	 * tb_transfer的order_id来查tb_orderinformation的goods_id和goods_number提交给warehouse
	 */
	public TMS_ChargeBack() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("返回上一级");
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
		button.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		button.setBounds(325, 383, 105, 24);
		contentPane.add(button);
		
		JLabel label = new JLabel("转运单号：");
		label.setFont(new Font("Dialog", Font.PLAIN, 14));
		label.setBounds(92, 68, 75, 24);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel((String) null);
		label_1.setBounds(179, 69, 114, 24);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("始发地：");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_2.setBounds(92, 109, 75, 24);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel((String) null);
		label_3.setBounds(179, 110, 114, 24);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("中转站：");
		label_4.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_4.setBounds(92, 145, 75, 24);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel((String) null);
		label_5.setBounds(179, 146, 114, 24);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("目的地：");
		label_6.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_6.setBounds(92, 181, 75, 24);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel((String) null);
		label_7.setBounds(179, 182, 114, 24);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("审核情况：");
		label_8.setFont(new Font("Dialog", Font.PLAIN, 14));
		label_8.setBounds(92, 217, 75, 24);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel((String) null);
		label_9.setBounds(179, 218, 114, 24);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("退单报告");
		label_10.setFont(new Font("Dialog", Font.BOLD, 16));
		label_10.setBounds(179, 6, 153, 34);
		contentPane.add(label_10);
	}
}
