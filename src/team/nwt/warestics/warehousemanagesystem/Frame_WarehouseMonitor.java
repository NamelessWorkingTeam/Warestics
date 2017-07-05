package team.nwt.warestics.warehousemanagesystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import team.nwt.warestics.QRCode.ImagePanel;
import team.nwt.warestics.dao.Stock;
import team.nwt.warestics.dao.StockDao;

public class Frame_WarehouseMonitor extends JFrame {

	private JPanel contentPane;
	private JFrame frmMonitor;
	private static JTable table_1;
	private JTextField textField;
	
    private String PAT_ID = null;
    private Vector vData_table_4 = null;
    private Vector vName_table_4 = null;
    private Vector vRow_table_4 = null;
    private Vector vData_table_5 = null;
    private Vector vName_table_5 = null;
    private Vector vRow_table_5 = null;
    private ImagePanel panel_1 = null;
    private static JTable table_3;
    private JTable table_4;
    
    private JButton button1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_WarehouseMonitor frame = new Frame_WarehouseMonitor();
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
	public Frame_WarehouseMonitor() {
		setTitle(" Monitor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1269, 767);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);
//		frmMonitor = new JFrame();
//		frmMonitor.setTitle("Monitor");
//		frmMonitor.setBounds(100, 100, 1269, 767);
//		frmMonitor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frmMonitor.getContentPane().setLayout(null);
//		frmMonitor.setResizable(false);
		
		JLabel label_0 = new JLabel("待入库单号");
		label_0.setBounds(10, 10, 200, 38);
		label_0.setFont(new Font("微软雅黑", Font.BOLD, 36));
		contentPane.add(label_0);
		
//		Vector rowName,vData;
//    	//建立表头
//    	rowName= new Vector();
//    	rowName.add("进货单号");
//
//    	//数据库连接
//    	StockDao stockDao=new StockDao();
//    	//获得数据
//    	vData=stockDao.selectStockId("S");
//    	//关闭数据库连接
//    	stockDao.close();
	
		JPanel panel = new JPanel();
		panel.setBounds(323, 40, 760, 645);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		

		
//	    ActionListener taskPerformer = new ActionListener() {
//	        public void actionPerformed(ActionEvent evt) {
//	            String s=String.format("%tY-%<tm-%<td   %<tH:%<tM:%<tS",new Date());
//	            label_0.setText(s);
//	        }
//	    };  
//	    new Timer(1000, taskPerformer).start();
//		vData_table_4 = new Vector();
//		vName_table_4 = new Vector();
//		vName_table_4.add("column1");
//		vName_table_4.add("column2");
//		vName_table_4.add("column3");
//		
//		vData_table_5 = new Vector();
//		vName_table_5 = new Vector();
//		vName_table_5.add("column1");
//		vName_table_5.add("column2");
//		vName_table_5.add("column3");
		
		JLabel label_4 = new JLabel("入库信息");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("微软雅黑", Font.BOLD, 36));
		
		JLabel label_5 = new JLabel("单   号：");
		label_5.setFont(new Font("微软雅黑", Font.BOLD, 36));
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("微软雅黑", Font.BOLD, 30));
		textField.setColumns(10);
		
		button1 = new JButton("入  库");
		//button1.setEnabled(false);
		button1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				 
				String String_stock_id=textField.getText();
				int Int_stock_id=Integer.parseInt(String_stock_id);
				StockDao stockDao=new StockDao();
				Stock stock=stockDao.getStockInformation(Int_stock_id);
				stockDao.close();
				WarehouseManageUtil warehouseManageUtil=new WarehouseManageUtil();
				if(warehouseManageUtil.stock(stock)){
					JOptionPane.showMessageDialog(contentPane,
							 "入库成功!", "入库信息", JOptionPane.INFORMATION_MESSAGE); 
					
				}else{
					JOptionPane.showMessageDialog(null, "入库失败!", "警告", JOptionPane.ERROR_MESSAGE);
				}
				 
				Vector rowName=new Vector<>();
				rowName.add("物品ID");
				rowName.add("物品名称");
				rowName.add("物品数量");
				Vector vData=new Vector<>();
				
				table_4.setModel(new DefaultTableModel(vData,rowName));
			}
		});
		//button1.setEnabled(false);
		button1.setFont(new Font("微软雅黑", Font.BOLD, 30));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(299)
					.addComponent(label_4)
					.addContainerGap(313, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_5, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(button1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addGap(78))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 669, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(77, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(button1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)))
					.addGap(31)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 445, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		
		Vector rowName=new Vector<>();
		rowName.add("物品ID");
		rowName.add("物品名称");
		rowName.add("物品数量");
		Vector vData=new Vector<>();
		table_4 = new JTable();
		table_4.setModel(new DefaultTableModel(vData,rowName));
		scrollPane_2.setViewportView(table_4);
		table_4.setRowHeight(36);
		table_4.setFont(new Font("微软雅黑", Font.BOLD, 36));
		table_4.setModel(new DefaultTableModel(vData,rowName));
		panel.setLayout(gl_panel);
		contentPane.setLayout(null);
		contentPane.add(label_0);
		
				
				JLabel label_2 = new JLabel("已入库单号");
				label_2.setBounds(10, 331, 200, 49);
				label_2.setFont(new Font("微软雅黑", Font.BOLD, 36));
				contentPane.add(label_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 290, 282);
		contentPane.add(scrollPane);
		
		
    	table_1=new JTable() {
    		// 设置表内数据不可修改
    			public boolean isCellEditable(int row, int column) { 
    				return false;
    			}
    		};
    	scrollPane.setViewportView(table_1);
    	show_stock_state_table(table_1, "S");
    	//    	table_1.setRowHeight(36);
    	//    	table_1.setFont(new Font("微软雅黑", Font.BOLD, 36));
    	//    	table_1.setModel(new DefaultTableModel(vData,rowName));
    			table_1.addMouseListener(new MouseAdapter() {
    				@Override
    				public void mouseClicked(MouseEvent e) {
    					// 获取选中单元格的值
    					String String_Selected_STA_ID = table_1.getValueAt(table_1.getSelectedRow(), 0).toString();
    					int Int_Selected_stock_id=Integer.parseInt(String_Selected_STA_ID);
    					//更新显示的单号
    					textField.setText(String_Selected_STA_ID);
    					//在table_4中显示该表的信息
    					StockTableModel stockTableModel=new StockTableModel(Int_Selected_stock_id);
    					table_4.setModel(stockTableModel);
    					table_4.addNotify();
    						
    					// 选中列表中信息后开启按钮功能
    					button1.setEnabled(true);
    				}
    			});
		contentPane.add(panel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 390, 290, 269);
		contentPane.add(scrollPane_1);
		
		table_3 = new JTable();
		scrollPane_1.setViewportView(table_3);
		show_stock_state_table(table_3, "Y");
		table_3.setFont(new Font("微软雅黑", Font.BOLD, 36));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		Thread thread1=new Thread(new Table(table_1, table_3));
		thread1.start();
	}
	public void show_stock_state_table(JTable table,String stock_state){
		Vector rowName,vData;
    	//建立表头
    	rowName= new Vector();
    	rowName.add("进货单号");
    	
    	//数据库连接
    	StockDao stockDao=new StockDao();
    	//获得数据
    	vData=stockDao.selectStockId(stock_state);
    	//关闭数据库连接
    	stockDao.close();
    	
    	table.setRowHeight(36);
    	table.setFont(new Font("微软雅黑", Font.BOLD, 36));
    	table.setModel(new DefaultTableModel(vData,rowName));
    	
	}

}
class Table implements Runnable{
	private JTable table_stock_wait;
	private JTable table_stock_finish;
	public Table(){
		
	}
	public Table(JTable table_stock_wait,JTable table_stock_finish){
		this.table_stock_wait=table_stock_wait;
		this.table_stock_finish=table_stock_finish;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//以线程形式定时刷新table中的数据
		while(true){
			try {
				show_stock_state_table(table_stock_wait,"S");
				show_stock_state_table(table_stock_finish, "Y");
//				Vector<String> rowName=new Vector<>();
//				rowName.add("仓库位置");
//				rowName.add("物品ID");
//				rowName.add("物品名称");		
//				rowName.add("库存量");
//				WarehouseInformationDao warehouseDao=new WarehouseInformationDao();
//				Vector<Vector<String>> vData=warehouseDao.getInventoryInformation();	
//				
//				warehouseDao.close();
//				DefaultTableModel DFM=new DefaultTableModel(vData,rowName);
//				table.setModel(DFM);
//				//table.updateUI();
//				table.addNotify();
				new Thread().sleep(5000);
				System.out.println("thread :"  
						+ Thread.currentThread().getName()); 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void show_stock_state_table(JTable table,String stock_state){
		Vector rowName,vData;
    	//建立表头
    	rowName= new Vector();
    	rowName.add("进货单号");
    	
    	//数据库连接
    	StockDao stockDao=new StockDao();
    	//获得数据
    	vData=stockDao.selectStockId(stock_state);
    	//关闭数据库连接
    	stockDao.close();
    	
    	table.setRowHeight(36);
    	table.setFont(new Font("微软雅黑", Font.BOLD, 36));
    	table.setModel(new DefaultTableModel(vData,rowName));
    	
    	table.addNotify();
	}

};

