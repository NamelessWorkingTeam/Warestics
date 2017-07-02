package team.nwt.warestics.TransportationManagementSystem;



import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;

//import team.nwsh.nwshospital.AdminSystem.AdminSystemShowMEDInfo;
//import team.nwsh.nwshospital.DirectorSystem.MedicineModel;
import team.nwt.warestics.MySQLConnect;
import team.nwt.warestics.DMSAdminSystem.DMSDeliveryModel;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

//import javax.swing.border.EmptyBorder;
//import javax.swing.table.DefaultTableModel;
import team.nwt.warestics.MySQLConnect;

public class TMS_GoodsList extends JFrame implements ActionListener  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    JTable jt=null;
    JScrollPane jsp=null;
    
    static String GoodsList_transfer_id=TMS.text;
    static String GoodsList_order_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TMS_GoodsList frame = new TMS_GoodsList();
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
	public TMS_GoodsList() {
		
		String sql_id = "SELECT order_id FROM tb_transfer WHERE transfer_id='"+GoodsList_transfer_id+"'";
		MySQLConnect con_id = new MySQLConnect(sql_id);
		try {
			ResultSet result_id = con_id.pst.executeQuery();
			while(result_id.next()){
				GoodsList_order_id = result_id.getString("order_id");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		JButton btnNewButton_2 = new JButton("\u8FD4\u56DE");
		btnNewButton_2.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TMS_ChargeBack ChargeBack = new TMS_ChargeBack();
				ChargeBack.setResizable(false);
				ChargeBack.setLocationRelativeTo(null);
				ChargeBack.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				ChargeBack.setVisible(true);
				dispose();
			}
		});
		panel_1.add(btnNewButton_2);

		
		
		setTitle("退单商品列表");

        TMS_Model x=new TMS_Model();
        jt=new JTable(x);
		jsp=new JScrollPane(jt);
		getContentPane().add(jsp);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("订单ID：");
		panel.add(lblNewLabel);
		
		JLabel Label_id = new JLabel("New label");
		panel.add(Label_id);
		this.setBounds(12, 76, 380, 560);
		this.setVisible(true);
		Label_id.setText(GoodsList_order_id);

		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void actionPerformed1(ActionEvent arg0) {
		// TODO 自动生成的方法存根
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		if(arg0.getSource()==BtnNewButton)//检查
//		{
//			String name=this.textField.getText();//获取textfield信息
//			//String sql="select * from MEDICINE where MED_NAME='"+name+"'";//实现模糊查询
//			String sql="select * from tb_orderinformation where goods_id like'%"+name+"%'";
//			TMS_Model x=new TMS_Model(sql);
//		jt.setModel(x);
//		}
	}
}

