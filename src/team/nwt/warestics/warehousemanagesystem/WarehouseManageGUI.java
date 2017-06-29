package team.nwt.warestics.warehousemanagesystem;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import team.nwt.warestics.MySQLConnect;
import team.nwt.warestics.dao.WarehouseDao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class WarehouseManageGUI {

	private JFrame frame;
	private JTextField textField_0;
	private JTextField textField_2_0;
	private JTextField textField_3;
	private JTable table_0;	
	private JTable table_1;
	
	private JScrollPane scrollPane_0_1 ;
	private JComboBox comboBox_0_0;
	private JComboBox comboBox_0_1 ;
	private JComboBox comboBox_2_0;
	private JComboBox comboBox_2_1;
	private JRadioButton rdbtnNewRadioButton_0_0;
	private JRadioButton rdbtnNewRadioButton_0_1 ;
	private ButtonGroup buttonGroup_0;
	private JPanel[] panels;
	private JScrollPane scrollPane_0;
	private JScrollPane scrollPane_1;
	private JPanel panel_2;
	private JPanel panel_0;
	private JPanel panel_1;
	private int X=100;
	private int Y=100;
	private JPanel panel_3;
	private JPanel panel_4;
	private static MySQLConnect db=null;
	private JTextField textField_2_1;
	private JTextField textField_2_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WarehouseManageGUI window = new WarehouseManageGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WarehouseManageGUI() {
		initialize();
		show_panel(0);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(X, Y, 810,550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem_0 = new JMenuItem("查询");
		mntmNewMenuItem_0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				show_panel(0);
			}
		});
		mntmNewMenuItem_0.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		menuBar.add(mntmNewMenuItem_0);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("质检");
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				show_panel(1);
				String sql="select `tb_goods`.`goods_id`,`goods_name`,"
						+ "`goods_productiondate`,`goods_shelflife`,`warehouse_id`,`goods_number` "
						+ "from `tb_goods`,`tb_warehouse` "
						+ "where `tb_goods`.`goods_id`=`tb_warehouse`.`goods_id`";//查询语句
				show_quality_table(sql);
				//panel_1.updateUI();
			}
		});
		menuBar.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("调拨");
		mntmNewMenuItem_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				show_panel(2);
				int warehouse_id=1;
				update_comboBox_2_0(comboBox_2_0, warehouse_id);
				
				panel_2.updateUI();
			}
		});
		menuBar.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("移库");
		mntmNewMenuItem_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				show_panel(3);
			}
		});
		menuBar.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("盘点");
		mntmNewMenuItem_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				show_panel(4);
			}
		});
		menuBar.add(mntmNewMenuItem_4);
		frame.getContentPane().setLayout(null);
		
		buttonGroup_0=new ButtonGroup();
		
		panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 800, 450);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_2_0 = new JLabel("物品名:");
		label_2_0.setBounds(60, 98, 90, 15);
		panel_2.add(label_2_0);
		
		comboBox_2_0 = new JComboBox();
		comboBox_2_0.setBounds(174, 95, 90, 21);
		panel_2.add(comboBox_2_0);
		
		JLabel label_2_1 = new JLabel("仓库号:");
		label_2_1.setBounds(60, 32, 90, 15);
		panel_2.add(label_2_1);
		
		comboBox_2_1 = new JComboBox();
		comboBox_2_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				int warehouse_id=Integer.parseInt((String)comboBox_2_1.getSelectedItem()) ;
				//System.out.println(warehouse_id);
				update_comboBox_2_0(comboBox_2_0, warehouse_id);
				//panel_2.updateUI();
			}
		});
		comboBox_2_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		comboBox_2_1.setBounds(174, 28, 90, 21);
		panel_2.add(comboBox_2_1);
		
		JLabel label_2_2 = new JLabel("调往");
		label_2_2.setBounds(278, 73, 90, 15);
		panel_2.add(label_2_2);
		
		JLabel label_2_3 = new JLabel("仓库号:");
		label_2_3.setBounds(336, 32, 90, 15);
		panel_2.add(label_2_3);
		
		JComboBox comboBox_2_2 = new JComboBox();
		comboBox_2_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		comboBox_2_2.setBounds(417, 28, 90, 21);
		panel_2.add(comboBox_2_2);
		
		JLabel label_2_4 = new JLabel("数量:");
		label_2_4.setBounds(334, 98, 90, 15);
		panel_2.add(label_2_4);
		
		textField_2_0 = new JTextField();
		textField_2_0.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				 int keyChar = arg0.getKeyChar();                 
	                if(keyChar==KeyEvent.VK_DECIMAL||keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){  
	                	
	                	if(!textField_2_0.getText().equals("")){
	                		double num=Double.parseDouble(textField_2_0.getText());
		                      if(num>Double.parseDouble(textField_2_2.getText())){
		                    	  arg0.consume();
		                      }
	                    }
	                	
	                }else{  
	                	arg0.consume(); //关键，屏蔽掉非法输入  
	                }  
			}
		});
		textField_2_0.setBounds(420, 98, 90, 21);
		panel_2.add(textField_2_0);
		textField_2_0.setColumns(10);
		
		JButton button_2 = new JButton("提交");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int Int_start_warehouse_id=Integer.parseInt((String)comboBox_2_1.getSelectedItem());
				int Int_end_warehouse_id=Integer.parseInt((String)comboBox_2_2.getSelectedItem());
				int Int_goods_id=Integer.parseInt(textField_2_1.getText());
				double Double_update_number=Double.parseDouble(textField_2_0.getText());
				double Double_goods_number=Double.parseDouble(textField_2_2.getText());
				if(Double_update_number==Double_goods_number){
					WarehouseDao warehouseDao=new WarehouseDao();
					if(warehouseDao.deleteByGoodsId(Int_goods_id)){
						System.out.println("删除成功");
					}else{
						System.out.println("删除失败");
					}
					if(warehouseDao.updateGoods(Int_end_warehouse_id, Int_goods_id, Double_update_number)){
						System.out.println("更新成功");
					}else{
						System.out.println("更新失败");
					}
					warehouseDao.close();
				}else if(Double_update_number<Double_goods_number){
					//更新start仓库的物品信息
					WarehouseDao warehouseDao=new WarehouseDao();
					if(warehouseDao.updateGoods(Int_start_warehouse_id, Int_goods_id, -Double_update_number)){
						System.out.println("start更新成功");
					}else{
						System.out.println("start更新失败");
					}
					//更新end仓库的物品信息
					if(warehouseDao.updateGoods(Int_end_warehouse_id, Int_goods_id, Double_update_number)){
						System.out.println("end更新成功");
					}else{
						System.out.println("end更新失败");
					}
				}
				
				int warehouse_id=1;
				update_comboBox_2_0(comboBox_2_0, warehouse_id);
				panel_2.updateUI();
			}
		});
		button_2.setBounds(417, 181, 90, 23);
		panel_2.add(button_2);
		
		JLabel label_2_5 = new JLabel("物品ID:");
		label_2_5.setBounds(60, 145, 54, 15);
		panel_2.add(label_2_5);
		
		textField_2_1 = new JTextField();
		textField_2_1.setEditable(false);
		textField_2_1.setBounds(174, 142, 90, 21);
		panel_2.add(textField_2_1);
		textField_2_1.setColumns(10);
		
		JLabel label_2_6 = new JLabel("库存量");
		label_2_6.setBounds(60, 195, 54, 15);
		panel_2.add(label_2_6);
		
		textField_2_2 = new JTextField();
		textField_2_2.setEditable(false);
		textField_2_2.setBounds(174, 192, 90, 21);
		panel_2.add(textField_2_2);
		textField_2_2.setColumns(10);
		
		panel_0 = new JPanel();
		panel_0.setBounds(0, 0, 800, 450);
		//panel_0.setBounds(X, Y, 500, 500);
		frame.getContentPane().add(panel_0);
		panel_0.setLayout(null);
		
		
		
				
				JTextField textField_0_1 = new JTextField();
				textField_0_1.setBounds(47, 45, 66, 21);
				panel_0.add(textField_0_1);
				textField_0_1.setColumns(10);
				
				JButton button_0 = new JButton("查询");
				button_0.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						
					}
				});
				button_0.setBounds(145, 44, 90, 23);
				button_0.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//选择订单查询
						if(rdbtnNewRadioButton_0_0.isSelected()){
							System.out.println((String)comboBox_0_0.getSelectedItem());
							String content=textField_0_1.getText();
							content=content.trim();
							if(content.equals("")){
								System.out.println("content is space");
								String sql="select `order_id`,`order_time`,`order_status`,`order_startusername`,"
										+ "`order_startuserphone`,`order_startuseraddress`,"
										+ "`order_endusername`,`order_enduserphone`,`order_enduseraddress`,"
										+ "`order_money`,`delivery_time`,`delivery_status` "
										+ "from `tb_order` ";
								show_order_table(sql);
							}
							else{
								if(comboBox_0_0.getSelectedItem().equals("订单号")){
									String sql="select `order_id`,`order_time`,`order_status`,`order_startusername`,"
											+ "`order_startuserphone`,`order_startuseraddress`,"
											+ "`order_endusername`,`order_enduserphone`,`order_enduseraddress`,"
											+ "`order_money`,`delivery_time`,`delivery_status` "
											+ "from `tb_order` "
											+ "where `order_id` like '%"+content+"%'";
									show_order_table(sql);
								}else if(comboBox_0_0.getSelectedItem().equals("始发地")){
									String sql="select `order_id`,`order_time`,`order_status`,`order_startusername`,"
											+ "`order_startuserphone`,`order_startuseraddress`,"
											+ "`order_endusername`,`order_enduserphone`,`order_enduseraddress`,"
											+ "`order_money`,`delivery_time`,`delivery_status` "
											+ "from `tb_order` "
											+ "where `order_startuseraddress` like '%"+content+"%'";
									show_order_table(sql);
								}else if(comboBox_0_0.getSelectedItem().equals("目的地")){
									String sql="select `order_id`,`order_time`,`order_status`,`order_startusername`,"
											+ "`order_startuserphone`,`order_startuseraddress`,"
											+ "`order_endusername`,`order_enduserphone`,`order_enduseraddress`,"
											+ "`order_money`,`delivery_time`,`delivery_status` "
											+ "from `tb_order` "
											+ "where `order_enduseraddress` like '%"+content+"%'";
									show_order_table(sql);
								}
							}
							//comboBox_0_0.getSelectedItem();
						}
						//选择物品查询
						else if(rdbtnNewRadioButton_0_1.isSelected()){
							//System.out.println(comboBox_0_1.getSelectedItem()); //获取查询标准
							String content=textField_0_1.getText();				//获取查询条件
							content=content.trim();								//去除首尾空格
							if(content.equals("")){
								System.out.println("content is space");
								String sql="select `tb_goods`.`goods_id`,`goods_name`,`goods_weight`,`goods_volume`,"
										+ "`goods_picture`,`goods_productiondate`,`goods_shelflife`,`warehouse_id`,`goods_number` "
										+ "from `tb_goods`,`tb_warehouse` "
										+ "where `tb_goods`.`goods_id`=`tb_warehouse`.`goods_id`";//查询语句
								show_goods_table(sql);
							}
							else{
								if(comboBox_0_1.getSelectedItem().equals("保质期")){
									String sql="select `tb_goods`.`goods_id`,`goods_name`,`goods_weight`,`goods_volume`,"
											+ "`goods_picture`,`goods_productiondate`,`goods_shelflife`,`warehouse_id`,`goods_number` "
											+ "from `tb_goods`,`tb_warehouse` "
											+ "where `tb_goods`.`goods_id`=`tb_warehouse`.`goods_id` "
											+ "and `goods_shelflife`="+content;//查询语句
									show_goods_table(sql);
								}else if(comboBox_0_1.getSelectedItem().equals("物品ID")){
									String sql="select `tb_goods`.`goods_id`,`goods_name`,`goods_weight`,`goods_volume`,"
											+ "`goods_picture`,`goods_productiondate`,`goods_shelflife`,`warehouse_id`,`goods_number` "
											+ "from `tb_goods`,`tb_warehouse` "
											+ "where `tb_goods`.`goods_id`=`tb_warehouse`.`goods_id` "
											+ "and `goods_id`="+content;//查询语句
									show_goods_table(sql);
								}else if(comboBox_0_1.getSelectedItem().equals("存储位置")){
									String sql="select `tb_goods`.`goods_id`,`goods_name`,`goods_weight`,`goods_volume`,"
											+ "`goods_picture`,`goods_productiondate`,`goods_shelflife`,`warehouse_id`,`goods_number` "
											+ "from `tb_goods`,`tb_warehouse` "
											+ "where `tb_goods`.`goods_id`=`tb_warehouse`.`goods_id` "
											+ "and `warehouse_id`="+content;//查询语句
									show_goods_table(sql);
								}else if(comboBox_0_1.getSelectedItem().equals("生产日期")){
									String sql="select `tb_goods`.`goods_id`,`goods_name`,`goods_weight`,`goods_volume`,"
											+ "`goods_picture`,`goods_productiondate`,`goods_shelflife`,`warehouse_id`,`goods_number` "
											+ "from `tb_goods`,`tb_warehouse` "
											+ "where `tb_goods`.`goods_id`=`tb_warehouse`.`goods_id` "
											+ "and `goods_productiondate`="+content;//查询语句
									show_goods_table(sql);
								}
							}
						}
					}
				});
				panel_0.add(button_0);
				
				rdbtnNewRadioButton_0_0 = new JRadioButton("订单");
				rdbtnNewRadioButton_0_0.setBounds(47, 89, 90, 23);
				rdbtnNewRadioButton_0_0.setSelected(true);
				rdbtnNewRadioButton_0_0.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(rdbtnNewRadioButton_0_0.isSelected()){
							comboBox_0_0.setVisible(true);
							comboBox_0_1.setVisible(false);
						}else{
							comboBox_0_0.setVisible(false);
						}
					}
				});
				panel_0.add(rdbtnNewRadioButton_0_0);
				
				rdbtnNewRadioButton_0_1 = new JRadioButton("物品");
				rdbtnNewRadioButton_0_1.setBounds(145, 89, 90, 23);
				rdbtnNewRadioButton_0_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(rdbtnNewRadioButton_0_1.isSelected()){
							comboBox_0_0.setVisible(false);
							comboBox_0_1.setVisible(true);
						}else{
							comboBox_0_1.setVisible(false);
						}
					}
					
					
				});
				panel_0.add(rdbtnNewRadioButton_0_1);
				buttonGroup_0.add(rdbtnNewRadioButton_0_0);
				buttonGroup_0.add(rdbtnNewRadioButton_0_1);
				
				scrollPane_0_1 = new JScrollPane();
				scrollPane_0_1.setBounds(47, 129, 709, 300);
				panel_0.add(scrollPane_0_1);
				

				
	JTable table_0_1 = new JTable();
	scrollPane_0_1.setViewportView(table_0_1);
	
	
	comboBox_0_0 = new JComboBox();
	comboBox_0_0.setBounds(280, 77, 100, 21);
	
	panel_0.add(comboBox_0_0);
	comboBox_0_0.setModel(new DefaultComboBoxModel(new String[] {"始发地", "订单号", "目的地"}));
	
	comboBox_0_1 = new JComboBox();
	comboBox_0_1.setBounds(392, 77, 100, 21);
	comboBox_0_1.setVisible(false);
	panel_0.add(comboBox_0_1);
	comboBox_0_1.setModel(new DefaultComboBoxModel(new String[] {"保质期", "进货日期", "存储位置", "物品ID"}));
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 800, 450);
		frame.getContentPane().add(panel_1);
		
			panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			scrollPane_1 = new JScrollPane();
			panel_1.add(scrollPane_1);
			table_1 = new JTable();
			scrollPane_1.setViewportView(table_1);
	

	
//	table_1 = new JTable();
//	scrollPane_1.setViewportView(table_1);
//	ButtonGroup buttonGroup_0 = new ButtonGroup();
		

		
	panel_4 = new JPanel();
	panel_4.setBounds(0, 0, 800, 450);
	frame.getContentPane().add(panel_4);
	panel_4.setLayout(null);
	
	
	panel_3 = new JPanel();
	panel_3.setBounds(0, 0, 800, 450);
	frame.getContentPane().add(panel_3);
	

	
	Panels_Init();
	Inventory_Init(panel_4);
	Transfer_Init(panel_3);
	
	}
	private void Inventory_Init(JPanel  panel_4) {		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(31, 24, 332, 190);
		panel_4.add(scrollPane_4);
		
		
		Vector<String> rowName=new Vector<>();
		rowName.add("商品名称");
		rowName.add("单位");
		rowName.add("库存量");
		Vector<Vector<String>> vData=new Vector<>();	
		
		DefaultTableModel DFM=new DefaultTableModel(vData,rowName);
		
		JTable table_4 = new JTable(DFM);
		scrollPane_4.setViewportView(table_4);
		
		JButton btnNewButton_4 = new JButton("打印表格");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(270, 224, 93, 23);
		panel_4.add(btnNewButton_4);
	}
	private void Transfer_Init(JPanel panel_3) {		
		panel_3.setLayout(null);
		JLabel label_3_0 = new JLabel("物品名:");
		label_3_0.setBounds(100, 59, 42, 15);
		panel_3.add(label_3_0);
		
		JComboBox comboBox_3_0 = new JComboBox();
		comboBox_3_0.setBounds(168, 25, 83, 21);
		panel_3.add(comboBox_3_0);
		
		JLabel label_3_1 = new JLabel("仓库号:");
		label_3_1.setBounds(100, 28, 42, 15);
		panel_3.add(label_3_1);
		
		JComboBox comboBox_3_1 = new JComboBox();
		comboBox_3_1.setBounds(168, 56, 32, 21);
		panel_3.add(comboBox_3_1);
		
		JLabel label_3_2 = new JLabel("移向");
		label_3_2.setBounds(275, 59, 24, 15);
		panel_3.add(label_3_2);
		
		JLabel label_3_3 = new JLabel("数量:");
		label_3_3.setBounds(100, 117, 30, 15);
		panel_3.add(label_3_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(168, 114, 66, 21);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		JButton button_3 = new JButton("提交");
		button_3.setBounds(292, 113, 57, 23);
		panel_3.add(button_3);
		
		JLabel label_3_4 = new JLabel("目的地");
		label_3_4.setBounds(304, 28, 36, 15);
		panel_3.add(label_3_4);
	}	



	private void show_panel(int key){

		
		for(int i=0;i<5;i++){
			if(i==key){
				panels[i].setVisible(true);
			}else{
				panels[i].setVisible(false);
			}
		}
	}
	private void Panels_Init(){
		panels=new JPanel[5];
		panels[0]=panel_0;
		panels[1]=panel_1;
		panels[2]=panel_2;
		panels[3]=panel_3;	
		panels[4]=panel_4;
	}
	private void show_goods_table(String sql){
		//String sql="select * from `tb_goods`";			//查询语句
		db=new MySQLConnect(sql);
		Vector<Vector<String>> vData_0=new Vector<>();	
		try {
			ResultSet resultSet=db.pst.executeQuery();
			while(resultSet.next()){
				Vector<String>rowData=new Vector<>();
				rowData.add(""+resultSet.getInt(1));
				
				rowData.add(resultSet.getString(2));
				rowData.add(resultSet.getString(3));
				rowData.add(resultSet.getString(4));
				rowData.add(resultSet.getString(5));
				rowData.add(resultSet.getString(6));
				rowData.add(resultSet.getString(7));
				rowData.add(resultSet.getString(8));
				rowData.add(resultSet.getString(9));
				
				vData_0.add(rowData);
			}
			
			resultSet.close();		// 关闭执行的语句连接
	        db.close();			// 关闭数据库连接
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Vector<String> rowName_0=new Vector<>();
		rowName_0.add("商品id");
		rowName_0.add("商品名称");
		rowName_0.add("商品净重");
		rowName_0.add("商品体积");
		rowName_0.add("商品图片");
		rowName_0.add("生产日期");
		rowName_0.add("保质期");
		rowName_0.add("仓库位置");
		rowName_0.add("库存量");									
		
		DefaultTableModel DFM=new DefaultTableModel(vData_0,rowName_0);
		
		JTable table_0_1 = new JTable(DFM);
		scrollPane_0_1.setViewportView(table_0_1);
	}
	private void show_order_table(String sql){
		db=new MySQLConnect(sql);
		Vector<Vector<String>> vData_0=new Vector<>();	
		try {
			ResultSet resultSet=db.pst.executeQuery();
			while(resultSet.next()){
				Vector<String>rowData=new Vector<>();
				rowData.add(resultSet.getString(1));				
				rowData.add(resultSet.getString(2));
				rowData.add(resultSet.getString(3));
				rowData.add(resultSet.getString(4));
				rowData.add(resultSet.getString(5));
				rowData.add(resultSet.getString(6));
				rowData.add(resultSet.getString(7));
				rowData.add(resultSet.getString(8));
				rowData.add(resultSet.getString(9));
				rowData.add(resultSet.getString(10));
				rowData.add(resultSet.getString(11));
				rowData.add(resultSet.getString(12));				
				vData_0.add(rowData);
			}
			resultSet.close();		// 关闭执行的语句连接
	        db.close();			// 关闭数据库连接
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Vector<String> rowName_0=new Vector<>();
		rowName_0.add("订单id");
		rowName_0.add("订单时间");
		rowName_0.add("订单状态");
		rowName_0.add("寄货人姓名");
		rowName_0.add("寄货人电话");
		rowName_0.add("寄货人地址");
		rowName_0.add("收货人姓名");
		rowName_0.add("收货人电话");
		rowName_0.add("收货人地址");
		rowName_0.add("订单金额");
		rowName_0.add("发货时间");
		rowName_0.add("发货状态");									
		
		DefaultTableModel DFM=new DefaultTableModel(vData_0,rowName_0);
		
		JTable table_0_1 = new JTable(DFM);
		scrollPane_0_1.setViewportView(table_0_1);
	}
	
	private void show_quality_table(String sql){
		db=new MySQLConnect(sql);
		Vector<Vector<String>> vData_1=new Vector<>();	
		try {
			ResultSet resultSet=db.pst.executeQuery();
			while(resultSet.next()){
				Vector<String>rowData=new Vector<>();
				rowData.add(resultSet.getString(1));				
				rowData.add(resultSet.getString(2));
				rowData.add(resultSet.getString(3));
				rowData.add(resultSet.getString(4));
				rowData.add(resultSet.getString(5));
				rowData.add(resultSet.getString(6));
				
				vData_1.add(rowData);
			}
			resultSet.close();		// 关闭执行的语句连接
	        db.close();			// 关闭数据库连接

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Vector<String> rowName=new Vector<>();
		rowName.add("物品ID");
		rowName.add("物品名称");
		rowName.add("生产日期");
		rowName.add("保质期");
		rowName.add("存储位置");
		rowName.add("物品数量");
		//Vector<Vector<String>> vData=new Vector<>();		
		
		DefaultTableModel DFM_1=new DefaultTableModel(vData_1,rowName);
		table_1.setModel(DFM_1);
		//table_1.updateUI();
		//scrollPane_1.updateUI();
		panel_1.updateUI();
	}
	private void update_comboBox_2_0(JComboBox comboBox_2_0,int warehouse_id){
		String sql_count_1="select count(`goods_id`) as `number` from `tb_warehouse` where `warehouse_id`="+warehouse_id;
		
		db=new MySQLConnect(sql_count_1);
		ResultSet resultSet=null;
		
		int max=0;
		try {
			resultSet=db.pst.executeQuery();
			if(resultSet.next()){
				max=resultSet.getInt("number");
			}
			resultSet.close();
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="select `tb_goods`.`goods_id`,`goods_name`,`goods_number` "
				+ "from `tb_goods`,`tb_warehouse`  "
				+ "where `tb_goods`.`goods_id`=`tb_warehouse`.`goods_id` "
				+ "and `warehouse_id`="+warehouse_id;
		if(max>0){
			db=new MySQLConnect(sql);
			String[]columnNames=new String[max];
			double[] goods_numbers=new double[max];
			int[] goods_ids=new int[max];
			db=new MySQLConnect(sql);
			ResultSet reSet=null;
			try {
				reSet=db.pst.executeQuery();
				int i=0;
				while(reSet.next()){
					columnNames[i]=reSet.getString("goods_name");
					goods_numbers[i]=reSet.getDouble("goods_number");
					goods_ids[i]=reSet.getInt("goods_id");
				}
				reSet.close();
				db.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			comboBox_2_0.setModel(new DefaultComboBoxModel<>(columnNames));
			textField_2_1.setText(""+goods_ids[0]);
			textField_2_2.setText(""+goods_numbers[0]);
		}else if(max==0){
			comboBox_2_0.setModel(new DefaultComboBoxModel<>(new String[]{}));
			textField_2_1.setText("");
			textField_2_2.setText("");
		}
		comboBox_2_0.updateUI();
		textField_2_1.updateUI();
		textField_2_2.updateUI();
	}
}


