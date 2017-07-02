package team.nwt.warestics.warehousemanagesystem;

import java.awt.EventQueue;
import java.util.Date;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import team.nwt.warestics.dao.WarehouseInformationDao;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class WarehouseMonitor {

	private JFrame frame;
	private JScrollPane scrollPane;
	private static JTable table;

	/**
	 * 监测窗口,监测物品传输流程
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WarehouseMonitor window = new WarehouseMonitor();
					window.frame.setVisible(true);
					Table tablethread=new Table(table);
					Thread thread1=new Thread(tablethread);
					thread1.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WarehouseMonitor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 414, 241);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 404, 155);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
	}
	/**
	 * 进货物品,入库前,二次检测,若无问题,则添加进仓库,更细数据库.若结果与第一次有差异,则在窗口显示异常信息.
	 * 
	 */



}
class Table implements Runnable{
	private JTable table;
	public Table(){
		
	}
	public Table(JTable table){
		this.table=table;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//以线程形式定时刷新table中的数据
		while(true){
			try {


				Vector<String> rowName=new Vector<>();
				rowName.add("仓库位置");
				rowName.add("物品ID");
				rowName.add("物品名称");		
				rowName.add("库存量");
				WarehouseInformationDao warehouseDao=new WarehouseInformationDao();
				Vector<Vector<String>> vData=warehouseDao.getInventoryInformation();	
				
				warehouseDao.close();
				DefaultTableModel DFM=new DefaultTableModel(vData,rowName);
				table.setModel(DFM);
				//table.updateUI();
				table.addNotify();
				new Thread().sleep(5000);
				System.out.println("thread :"  
						+ Thread.currentThread().getName()); 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

};


