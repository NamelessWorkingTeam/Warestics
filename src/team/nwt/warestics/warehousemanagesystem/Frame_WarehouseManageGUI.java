package team.nwt.warestics.warehousemanagesystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import team.nwt.warestics.CreatePDF;
import team.nwt.warestics.MySQLConnect;
import team.nwt.warestics.dao.WarehouseInformation;
import team.nwt.warestics.dao.WarehouseInformationDao;

public class Frame_WarehouseManageGUI extends JFrame {

	private JPanel contentPane;
	private static String fontName="微软雅黑";
	private static int fontStyle= Font.PLAIN;
	private static int fontSize=20;
	private static int rowHeight=20;
	private static Font generalfont=new Font(fontName, fontStyle, fontSize);
	private JFrame frame;
	private JTextField textField_0;
	private JTextField textField_2_0;
	private JTable table_0;	
	private JTable table_1;
	private JTable table_4;

	private JScrollPane scrollPane_0_1 ;
	private JComboBox comboBox_0_0;
	private JComboBox comboBox_0_1 ;
	private JComboBox comboBox_2_endWarehouseId;
	private JComboBox comboBox_2_endPositionId ;
	private JComboBox comboBox_2_endAreaId ;
	private JRadioButton rdbtnNewRadioButton_0_0;
	private JRadioButton rdbtnNewRadioButton_0_1 ;
	private ButtonGroup buttonGroup_0;
	private JPanel[] panels;
	private JScrollPane scrollPane_0;
	private JScrollPane scrollPane_1;
	private JPanel panel_2;
	private JPanel panel_0;
	private JPanel panel_1;
	private int X=400;
	private int Y=200;
	private JPanel panel_3;
	private static MySQLConnect db=null;
	private JTextField textField_2_startGoodsId;
	private JTextField textField_2_startGoodsNumber;

	private JMenuItem mntmNewMenuItem_0;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JTextField textField_2_goodsId;
	private JScrollPane scrollPane_2;
	private JTable table_2_warehouseInformation;
	private JTextField textField_2_startWarehouseID;
	private JTextField textField_2_startAreaID;
	private JTextField textField_2_startPositionID;
	private JTextField textField_2_startGoodsName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_WarehouseManageGUI frame = new Frame_WarehouseManageGUI();
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
	public Frame_WarehouseManageGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(X, Y, 1096,609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);
		setFont(new Font("微软雅黑", Font.PLAIN, 12));
		//		frame = new JFrame();
		//		frame.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		//		frame.getContentPane().setFont(new Font("微软雅黑", Font.PLAIN, 12));
		//		frame.setResizable(false);
		//		frame.setBounds(X, Y, 1096,609);
		//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		//menuBar.setBounds(0, 0, 800, 30);
		//		frame.setJMenuBar(menuBar);

		mntmNewMenuItem_0 = new JMenuItem("查 询");
		mntmNewMenuItem_0.setFont(generalfont);
		mntmNewMenuItem_0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				show_panel(0);
				mntmNewMenuItem_0.setBackground(Color.gray);
				mntmNewMenuItem_1.setBackground(null);
				mntmNewMenuItem_2.setBackground(null);
				mntmNewMenuItem_3.setBackground(null);
			}
		});

		menuBar.add(mntmNewMenuItem_0);

		mntmNewMenuItem_1 = new JMenuItem("质 检");
		mntmNewMenuItem_1.setFont(generalfont);
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				show_panel(1);
				show_quality_table();
				mntmNewMenuItem_1.setBackground(Color.gray);
				mntmNewMenuItem_0.setBackground(null);
				mntmNewMenuItem_2.setBackground(null);
				mntmNewMenuItem_3.setBackground(null);
			}
		});
		menuBar.add(mntmNewMenuItem_1);

		mntmNewMenuItem_2 = new JMenuItem("调 拨");
		mntmNewMenuItem_2.setFont(generalfont);
		mntmNewMenuItem_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
//				comboBox_2_startWarehouseId.setSelectedIndex(0);;
//				comboBox_2_startAreaId.setSelectedIndex(0);
//				comboBox_2_startPositionId.setSelectedIndex(0);
				comboBox_2_endWarehouseId.setSelectedIndex(0);;
				comboBox_2_endAreaId.setSelectedIndex(0);
				comboBox_2_endPositionId.setSelectedIndex(0);
				textField_2_0.setText("");
				int warehouse_id=1;
				int area_id=1;
				int position_id=1;
//				update_comboBox_2_0(comboBox_2_startGoodsName, warehouse_id,area_id,position_id);
				panel_2.updateUI();
				show_panel(2);
				mntmNewMenuItem_2.setBackground(Color.gray);
				mntmNewMenuItem_1.setBackground(null);
				mntmNewMenuItem_0.setBackground(null);
				mntmNewMenuItem_3.setBackground(null);
			}
		});
		menuBar.add(mntmNewMenuItem_2);

		mntmNewMenuItem_3 = new JMenuItem("盘 点");
		mntmNewMenuItem_3.setFont(generalfont);
		mntmNewMenuItem_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				show_inventory_table();
				show_panel(3);
				mntmNewMenuItem_3.setBackground(Color.gray);
				mntmNewMenuItem_1.setBackground(null);
				mntmNewMenuItem_2.setBackground(null);
				mntmNewMenuItem_0.setBackground(null);

			}
		});
		menuBar.add(mntmNewMenuItem_3);

		buttonGroup_0=new ButtonGroup();
		contentPane.setLayout(null);

		panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 1090, 546);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel label_2_0 = new JLabel("物品名");
		label_2_0.setFont(generalfont);
		label_2_0.setBounds(450, 128, 90, 25);
		panel_2.add(label_2_0);

		JLabel label_2_1 = new JLabel("仓库号");
		label_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		label_2_1.setBounds(450, 32, 90, 25);
		panel_2.add(label_2_1);

		JLabel label_2_2 = new JLabel("调 往");
		label_2_2.setFont(new Font("宋体", Font.PLAIN, 41));
		label_2_2.setBounds(699, 97, 120, 71);
		panel_2.add(label_2_2);

		JLabel label_2_3 = new JLabel("仓库号");
		label_2_3.setFont(generalfont);
		label_2_3.setBounds(850, 32, 90, 25);
		panel_2.add(label_2_3);

		comboBox_2_endWarehouseId = new JComboBox();
		comboBox_2_endWarehouseId.setFont(generalfont);
		comboBox_2_endWarehouseId.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboBox_2_endWarehouseId.setBounds(950, 29, 90, 25);
		panel_2.add(comboBox_2_endWarehouseId);

		JLabel label_2_4 = new JLabel("数量");
		label_2_4.setFont(generalfont);
		label_2_4.setBounds(850, 150, 90, 25);
		panel_2.add(label_2_4);

		textField_2_0 = new JTextField();
		textField_2_0.setFont(generalfont);
		textField_2_0.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				int keyChar = arg0.getKeyChar();                 
				if(keyChar==KeyEvent.VK_DECIMAL||keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){  

					if(!textField_2_0.getText().equals("")){
						double num=Double.parseDouble(textField_2_0.getText());
						if(num>Double.parseDouble(textField_2_startGoodsNumber.getText())){
							arg0.consume();
						}
					}

				}else{  
					arg0.consume(); //关键，屏蔽掉非法输入  
				}  
			}
		});
		textField_2_0.setBounds(950, 149, 90, 25);
		panel_2.add(textField_2_0);
		textField_2_0.setColumns(10);

		JButton button_2 = new JButton("提 交");
		button_2.setFont(generalfont);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField_2_0.getText().equals("")){					
					JOptionPane.showMessageDialog(contentPane,
							"数量不能为空!", "警告", JOptionPane.ERROR_MESSAGE);
				}else{
					double Double_update_number=Double.parseDouble(textField_2_0.getText());

					int Int_start_warehouse_id=Integer.parseInt(textField_2_startWarehouseID.getText());
					int Int_start_area_id=Integer.parseInt(textField_2_startAreaID.getText());
					int Int_start_position_id=Integer.parseInt(textField_2_startPositionID.getText());
					int Int_end_warehouse_id=Integer.parseInt((String)comboBox_2_endWarehouseId.getSelectedItem());
					int Int_end_area_id=Integer.parseInt((String)comboBox_2_endAreaId.getSelectedItem());
					int Int_end_position_id=Integer.parseInt((String)comboBox_2_endPositionId.getSelectedItem());
					int Int_goods_id=Integer.parseInt(textField_2_startGoodsId.getText());				
					double Double_goods_number=Double.parseDouble(textField_2_startGoodsNumber.getText());
					if(Double_update_number==Double_goods_number){
						WarehouseInformationDao warehouseInformationDao=new WarehouseInformationDao();
						if(warehouseInformationDao.deleteWarehoueInformation(Int_start_position_id, Int_start_area_id, Int_start_position_id, Int_goods_id)){
							System.out.println("删除成功");
						}else{
							System.out.println("删除失败");
						}
						if(warehouseInformationDao.updateWarehouseInformation(Int_end_warehouse_id, Int_end_area_id, Int_end_position_id, Int_goods_id, Double_update_number)){
							System.out.println("更新成功");
						}else{
							System.out.println("更新失败");
						}
						warehouseInformationDao.close();
					}else if(Double_update_number<Double_goods_number){
						//更新start仓库的物品信息
						WarehouseInformationDao warehouseInformationDao=new WarehouseInformationDao();
						if(warehouseInformationDao.updateWarehouseInformation(Int_start_warehouse_id,Int_start_area_id,Int_start_position_id, Int_goods_id, -Double_update_number)){
							System.out.println("start更新成功");
						}else{
							System.out.println("start更新失败");
							JOptionPane.showMessageDialog(contentPane,
									"更新失败!", "警告", JOptionPane.ERROR_MESSAGE);
						}
						//更新end仓库的物品信息
						if(warehouseInformationDao.updateWarehouseInformation(Int_end_warehouse_id,Int_end_area_id,Int_end_position_id,Int_goods_id, Double_update_number)){
							System.out.println("end更新成功");
							JOptionPane.showMessageDialog(contentPane,
									"更新成功!", "系统信息", JOptionPane.INFORMATION_MESSAGE);
						}else{
							System.out.println("end更新失败");
							JOptionPane.showMessageDialog(contentPane,
									"更新失败!", "警告", JOptionPane.ERROR_MESSAGE);
						}
						String String_GoodsID=textField_2_goodsId.getText();
						int Int_GoodsID=Integer.parseInt(String_GoodsID);
						//WarehouseInformationDao warehouseInformationDao=new WarehouseInformationDao();
						Vector<String> rowName=new Vector<>();
						rowName.add("仓库号");
						rowName.add("区域");
						rowName.add("货架");
						rowName.add("物品ID");
						rowName.add("物品名");
						rowName.add("物品数量");
						Vector<Vector<String>> vData=warehouseInformationDao.getInventoryInformation(Int_GoodsID);
						DefaultTableModel defaultTableModel=new DefaultTableModel(vData, rowName);
						table_2_warehouseInformation.setModel(defaultTableModel);
						table_2_warehouseInformation.addNotify();
						warehouseInformationDao.close();
						
						//更新显示的单号
						textField_2_startWarehouseID.setText("");
						
						textField_2_startAreaID.setText("");
						textField_2_startPositionID.setText("");
						textField_2_startGoodsId.setText("");
						textField_2_startGoodsName.setText("");
						textField_2_startGoodsNumber.setText("");
						
					}

//					comboBox_2_startWarehouseId.setSelectedIndex(0);;
//					comboBox_2_startAreaId.setSelectedIndex(0);
//					comboBox_2_startPositionId.setSelectedIndex(0);
					comboBox_2_endWarehouseId.setSelectedIndex(0);;
					comboBox_2_endAreaId.setSelectedIndex(0);
					comboBox_2_endPositionId.setSelectedIndex(0);
					textField_2_0.setText("");
					int warehouse_id=1;
					int area_id=1;
					int position_id=1;
//					update_comboBox_2_0(comboBox_2_startGoodsName, warehouse_id,area_id,position_id);
					panel_2.updateUI();
				}
			}
		});
		button_2.setBounds(579, 291, 187, 25);
		panel_2.add(button_2);

		JLabel lblid = new JLabel("物品ID");
		lblid.setFont(generalfont);
		lblid.setBounds(450, 159, 90, 25);
		panel_2.add(lblid);

		textField_2_startGoodsId = new JTextField();
		textField_2_startGoodsId.setEditable(false);
		textField_2_startGoodsId.setBounds(550, 160, 90, 25);
		panel_2.add(textField_2_startGoodsId);
		textField_2_startGoodsId.setColumns(10);

		JLabel label_2_6 = new JLabel("库存量");
		label_2_6.setFont(generalfont);
		label_2_6.setBounds(450, 195, 90, 25);
		panel_2.add(label_2_6);

		textField_2_startGoodsNumber = new JTextField();
		textField_2_startGoodsNumber.setEditable(false);
		textField_2_startGoodsNumber.setBounds(550, 196, 90, 25);
		panel_2.add(textField_2_startGoodsNumber);
		textField_2_startGoodsNumber.setColumns(10);

		JLabel label_2_7 = new JLabel("区域");
		label_2_7.setFont(generalfont);
		label_2_7.setBounds(450, 62, 54, 25);
		panel_2.add(label_2_7);

		JLabel label_2_8 = new JLabel("货架");
		label_2_8.setFont(generalfont);
		label_2_8.setBounds(450, 95, 54, 25);
		panel_2.add(label_2_8);

		JLabel label = new JLabel("区域");
		label.setFont(generalfont);
		label.setFont(generalfont);
		label.setBounds(850, 61, 54, 25);
		panel_2.add(label);

		comboBox_2_endAreaId = new JComboBox();
		comboBox_2_endAreaId.setFont(generalfont);
		comboBox_2_endAreaId.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		comboBox_2_endAreaId.setBounds(950, 58, 90, 25);
		panel_2.add(comboBox_2_endAreaId);

		JLabel label_1 = new JLabel("货架");
		label_1.setFont(generalfont);
		label_1.setBounds(850, 95, 54, 25);
		panel_2.add(label_1);

		comboBox_2_endPositionId = new JComboBox();
		comboBox_2_endPositionId.setFont(generalfont);
		comboBox_2_endPositionId.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		comboBox_2_endPositionId.setBounds(950, 92, 90, 25);
		panel_2.add(comboBox_2_endPositionId);

		textField_2_goodsId = new JTextField();
		textField_2_goodsId.setBounds(95, 24, 152, 38);
		panel_2.add(textField_2_goodsId);
		textField_2_goodsId.setColumns(10);

		JButton btnNewButton = new JButton("查找");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String String_GoodsID=textField_2_goodsId.getText();
				int Int_GoodsID=Integer.parseInt(String_GoodsID);
				WarehouseInformationDao warehouseInformationDao=new WarehouseInformationDao();
				Vector<String> rowName=new Vector<>();
				rowName.add("仓库号");
				rowName.add("区域");
				rowName.add("货架");
				rowName.add("物品ID");
				rowName.add("物品名");
				rowName.add("物品数量");
				Vector<Vector<String>> vData=warehouseInformationDao.getInventoryInformation(Int_GoodsID);
				DefaultTableModel defaultTableModel=new DefaultTableModel(vData, rowName);
				table_2_warehouseInformation.setModel(defaultTableModel);
				table_2_warehouseInformation.addNotify();
			}
		});
		btnNewButton.setBounds(310, 25, 117, 29);
		panel_2.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 291, 4, 4);
		panel_2.add(scrollPane);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(19, 67, 408, 249);
		panel_2.add(scrollPane_2);

		table_2_warehouseInformation = new JTable();
		table_2_warehouseInformation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 获取选中单元格的值
				String String_Selected_warehouseID = table_2_warehouseInformation.getValueAt(table_2_warehouseInformation.getSelectedRow(), 0).toString();
				String String_Selected_areaID=table_2_warehouseInformation.getValueAt(table_2_warehouseInformation.getSelectedRow(), 1).toString();
				String String_Selected_positionID=table_2_warehouseInformation.getValueAt(table_2_warehouseInformation.getSelectedRow(), 2).toString();
				String String_Selected_goodsID=table_2_warehouseInformation.getValueAt(table_2_warehouseInformation.getSelectedRow(), 3).toString();
				String String_Selected_goodsName=table_2_warehouseInformation.getValueAt(table_2_warehouseInformation.getSelectedRow(), 4).toString();
				String String_Selected_goodsNumber=table_2_warehouseInformation.getValueAt(table_2_warehouseInformation.getSelectedRow(), 5).toString();
				//更新显示的单号
				textField_2_startWarehouseID.setText(String_Selected_warehouseID);
				
				textField_2_startAreaID.setText(String_Selected_areaID);
				textField_2_startPositionID.setText(String_Selected_positionID);
				textField_2_startGoodsId.setText(String_Selected_goodsID);
				textField_2_startGoodsName.setText(String_Selected_goodsName);
				textField_2_startGoodsNumber.setText(String_Selected_goodsNumber);
				//在table_4中显示该表的信息
				//StockTableModel stockTableModel=new StockTableModel(Int_Selected_stock_id);
//				table_4.setModel(stockTableModel);
//				table_4.addNotify();
					
				// 选中列表中信息后开启按钮功能
//				button1.setEnabled(true);
			}
		});
		scrollPane_2.setViewportView(table_2_warehouseInformation);

		JLabel lblNewLabel = new JLabel("物品ID");
		lblNewLabel.setFont(generalfont);
		lblNewLabel.setBounds(19, 29, 61, 16);
		panel_2.add(lblNewLabel);
		
		textField_2_startWarehouseID = new JTextField();
		textField_2_startWarehouseID.setEditable(false);
		textField_2_startWarehouseID.setBounds(550, 34, 130, 26);
		panel_2.add(textField_2_startWarehouseID);
		textField_2_startWarehouseID.setColumns(10);
		
		textField_2_startAreaID = new JTextField();
		textField_2_startAreaID.setEditable(false);
		textField_2_startAreaID.setBounds(550, 64, 130, 26);
		panel_2.add(textField_2_startAreaID);
		textField_2_startAreaID.setColumns(10);
		
		textField_2_startPositionID = new JTextField();
		textField_2_startPositionID.setEditable(false);
		textField_2_startPositionID.setBounds(550, 97, 130, 26);
		panel_2.add(textField_2_startPositionID);
		textField_2_startPositionID.setColumns(10);
		
		textField_2_startGoodsName = new JTextField();
		textField_2_startGoodsName.setEditable(false);
		textField_2_startGoodsName.setBounds(550, 130, 130, 26);
		panel_2.add(textField_2_startGoodsName);
		textField_2_startGoodsName.setColumns(10);

		panel_0 = new JPanel();
		panel_0.setBounds(0, 0, 1090, 546);
		//panel_0.setBounds(X, Y, 500, 500);
		contentPane.add(panel_0);
		panel_0.setLayout(null);




		JTextField textField_0_1 = new JTextField();
		textField_0_1.setBounds(47, 45, 258, 21);
		panel_0.add(textField_0_1);
		textField_0_1.setColumns(10);

		JButton button_0 = new JButton("查询");
		button_0.setFont(generalfont);
		button_0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		button_0.setBounds(800, 44, 90, 30);
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
								+ "from `tb_goods`,`tb_warehouseinformation` "
								+ "where `tb_goods`.`goods_id`=`tb_warehouseinformation`.`goods_id`";//查询语句
						show_goods_table(sql);
					}
					else{
						if(comboBox_0_1.getSelectedItem().equals("保质期")){
							String sql="select `tb_goods`.`goods_id`,`goods_name`,`goods_weight`,`goods_volume`,"
									+ "`goods_picture`,`goods_productiondate`,`goods_shelflife`,`warehouse_id`,`goods_number` "
									+ "from `tb_goods`,`tb_warehouseinformation` "
									+ "where `tb_goods`.`goods_id`=`tb_warehouseinformation`.`goods_id` "
									+ "and `goods_shelflife`="+content;//查询语句
							show_goods_table(sql);
						}else if(comboBox_0_1.getSelectedItem().equals("物品ID")){
							String sql="select `tb_goods`.`goods_id`,`goods_name`,`goods_weight`,`goods_volume`,"
									+ "`goods_picture`,`goods_productiondate`,`goods_shelflife`,`warehouse_id`,`goods_number` "
									+ "from `tb_goods`,`tb_warehouseinformation` "
									+ "where `tb_goods`.`goods_id`=`tb_warehouseinformation`.`goods_id` "
									+ "and `tb_goods`.`goods_id`="+content;//查询语句
							show_goods_table(sql);
						}else if(comboBox_0_1.getSelectedItem().equals("生产日期")){
							String sql="select `tb_goods`.`goods_id`,`goods_name`,`goods_weight`,`goods_volume`,"
									+ "`goods_picture`,`goods_productiondate`,`goods_shelflife`,`warehouse_id`,`goods_number` "
									+ "from `tb_goods`,`tb_warehouseinformation` "
									+ "where `tb_goods`.`goods_id`=`tb_warehouseinformation`.`goods_id` "
									+ "and `goods_productiondate`='"+content+"'";//查询语句
							show_goods_table(sql);
						}
					}
				}
			}
		});
		panel_0.add(button_0);

		rdbtnNewRadioButton_0_0 = new JRadioButton("订单");
		rdbtnNewRadioButton_0_0.setBounds(338, 44, 74, 23);
		rdbtnNewRadioButton_0_0.setFont(generalfont);
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
		rdbtnNewRadioButton_0_1.setFont(generalfont);
		rdbtnNewRadioButton_0_1.setBounds(443, 44, 74, 23);
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
		scrollPane_0_1.setBounds(47, 100, 914, 409);
		panel_0.add(scrollPane_0_1);



		JTable table_0_1 = new JTable();
		scrollPane_0_1.setViewportView(table_0_1);


		comboBox_0_0 = new JComboBox();
		comboBox_0_0.setFont(generalfont);
		comboBox_0_0.setBounds(574, 40, 142, 30);
		comboBox_0_0.setVisible(false);
		panel_0.add(comboBox_0_0);
		comboBox_0_0.setModel(new DefaultComboBoxModel(new String[] {"订单号", "始发地", "目的地"}));

		comboBox_0_1 = new JComboBox();
		comboBox_0_1.setFont(generalfont);
		comboBox_0_1.setBounds(574, 40, 142, 30);
		comboBox_0_1.setVisible(false);
		panel_0.add(comboBox_0_1);
		comboBox_0_1.setModel(new DefaultComboBoxModel(new String[] {"物品ID", "保质期", "生产日期"}));



		//	table_1 = new JTable();
		//	scrollPane_1.setViewportView(table_1);
		//	ButtonGroup buttonGroup_0 = new ButtonGroup();



		panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 1090, 546);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(69, 25, 928, 379);
		panel_3.add(scrollPane_3);

		table_4 = new JTable();
		table_4.setFont(generalfont);
		table_4.setRowHeight(rowHeight);
		scrollPane_3.setViewportView(table_4);

		JButton btnNewButton_3 = new JButton("打印表格");
		btnNewButton_3.setFont(generalfont);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] head={"warehouse_id","area_id","position_id","goods_id","goods_name","goods_number"};
				List<WarehouseInformation>warehouses=new WarehouseInformationDao().getInventoryInformationForPDF();
				String filePath = new CreatePDF().generatePDFs(head,warehouses);
				System.out.println(filePath);
				 JOptionPane.showMessageDialog(contentPane,
						 "PDF文件生成成功!", "系统信息", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_3.setBounds(832, 452, 165, 23);
		panel_3.add(btnNewButton_3);

		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1090, 556);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(79, 10, 875, 460);
		panel_1.add(scrollPane_1);
		table_1 = new JTable();
		table_1.setFont(generalfont);
		table_1.setRowHeight(rowHeight);
		scrollPane_1.setViewportView(table_1);



		Panels_Init();
		show_panel(0);

	}
	private void show_panel(int key){


		for(int i=0;i<4;i++){
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
	private void show_quality_table(){
		WarehouseInformationDao warehouseInformationDao=new WarehouseInformationDao();



		Vector<String> rowName=new Vector<>();
		rowName.add("物品ID");
		rowName.add("物品名称");
		rowName.add("生产日期");
		rowName.add("保质期");
		rowName.add("仓库");
		rowName.add("区域");
		rowName.add("位置");
		rowName.add("物品数量");

		Vector<Vector<String>> vData=warehouseInformationDao.getQualityInformation();
		warehouseInformationDao.close();
		DefaultTableModel DFM_1=new DefaultTableModel(vData,rowName);
		table_1.setModel(DFM_1);
		//table_1.updateUI();
		//scrollPane_1.updateUI();
		panel_1.updateUI();
	}
	private void show_inventory_table(){
		Vector<String> rowName=new Vector<>();
		rowName.add("仓库号");
		rowName.add("区域");
		rowName.add("货架");
		rowName.add("物品ID");
		rowName.add("物品名称");		
		rowName.add("库存量");
		WarehouseInformationDao warehouseInformationDao=new WarehouseInformationDao();
		Vector<Vector<String>> vData=warehouseInformationDao.getInventoryInformation();	

		warehouseInformationDao.close();
		DefaultTableModel DFM=new DefaultTableModel(vData,rowName);
		table_4.setModel(DFM);
	}
	private void update_comboBox_2_0(JComboBox comboBox_2_0,int warehouse_id,int area_id,int position_id){

		WarehouseInformationDao warehouseInformationDao=new WarehouseInformationDao();

		int max=warehouseInformationDao.getCountofGoodsId(warehouse_id, area_id, position_id);


		if(max>0){

			String[]columnNames=new String[max];
			double[] goods_numbers=new double[max];
			int[] goods_ids=new int[max];

			ResultSet resultSet=warehouseInformationDao.getResultSetofGoodsId(warehouse_id, area_id, position_id);
			try {

				int i=0;
				while(resultSet.next()){
					columnNames[i]=resultSet.getString("goods_name");
					goods_numbers[i]=resultSet.getDouble("goods_number");
					goods_ids[i]=resultSet.getInt("goods_id");
				}
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			warehouseInformationDao.close();
			comboBox_2_0.setModel(new DefaultComboBoxModel<>(columnNames));
			textField_2_startGoodsId.setText(""+goods_ids[0]);
			textField_2_startGoodsNumber.setText(""+goods_numbers[0]);
		}else if(max==0){
			comboBox_2_0.setModel(new DefaultComboBoxModel<>(new String[]{}));
			textField_2_startGoodsId.setText("");
			textField_2_startGoodsNumber.setText("");
		}
		comboBox_2_0.updateUI();
		textField_2_startGoodsId.updateUI();
		textField_2_startGoodsNumber.updateUI();
	}
}
