package team.nwt.warestics.DMSAdminSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DMSAdminSystem extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DMSAdminSystem frame = new DMSAdminSystem();
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
	public DMSAdminSystem() {
		setTitle("发货管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("发货需求管理");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DMSAdminSystemDemandManage newframe = new DMSAdminSystemDemandManage();
				newframe.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setBounds(128, 48, 169, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("登出");
		btnNewButton_2.setBounds(128, 168, 169, 27);
		contentPane.add(btnNewButton_2);
	}

}
