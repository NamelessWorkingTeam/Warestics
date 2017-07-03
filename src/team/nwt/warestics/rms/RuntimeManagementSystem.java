package team.nwt.warestics.rms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import team.nwt.warestics.MySQLConnect;
import team.nwt.warestics.QRCode.QRCode;
import team.nwt.warestics.network.Client;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.DefaultComboBoxModel;
import team.nwt.warestics.QRCode.*;
/**
 * 
 * @author liu
 * 请参考107至171行学习使用表格信息的插入！
 * 请在仔细查看后再进行修改！
 * 祝一次成功！
 * 
 */


public class RuntimeManagementSystem extends JFrame {

	private JPanel contentPane;
	private static JTable table_1;
	private static JTable table_2;
	private JTextField textField;
    
    private String PAT_ID = null;
    private Vector vData_table_4 = null;
    private Vector vName_table_4 = null;
    private Vector vRow_table_4 = null;
    private Vector vData_table_5 = null;
    private Vector vName_table_5 = null;
    private Vector vRow_table_5 = null;
    private ImagePanel panel_1 = null;
    /**
	 * @wbp.nonvisual location=969,148
	 */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RuntimeManagementSystem frame = new RuntimeManagementSystem(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void PackageWaitTable() {
		// START待处理物品展示
        String String_SQL_PAC_NAME_WAIT = "SELECT transfer_id, transfer_end " +
									 	  "FROM tb_transfer WHERE transfer_state = 'N';";
		MySQLConnect MySQLConnect_Connection_WAIT = new MySQLConnect(String_SQL_PAC_NAME_WAIT);
		ResultSet RS_PAC_NAME_WAIT;
		Vector RowData_WAIT, ColumnNames_WAIT;
		ColumnNames_WAIT= new Vector();			// 建立列集合
		ColumnNames_WAIT.add("");				// 添加列头
		ColumnNames_WAIT.add("");				// 添加列头
		
		RowData_WAIT=new Vector(); 				// 建立行数据集合
		boolean INT_Found_PAT_NAME_WAIT = false;
	    try {
	    	RS_PAC_NAME_WAIT = MySQLConnect_Connection_WAIT.pst.executeQuery();
	    	if(RS_PAC_NAME_WAIT.next()) {
	    		INT_Found_PAT_NAME_WAIT = true;
	    		Vector hang_WAIT=new Vector();									// 建立行内数据集合
	    		hang_WAIT.add(RS_PAC_NAME_WAIT.getString("transfer_id"));		// 添加行内第一列数据
	        	hang_WAIT.add(RS_PAC_NAME_WAIT.getString("transfer_end"));		// 添加行内第二列数据
	        	RowData_WAIT.add(hang_WAIT);									// 将添加完数据的 行内数据集 添加到 行数据集合 中去
				while (RS_PAC_NAME_WAIT.next()) {								// 循环创建 行内数据集 并添加到 行数据集合
		            hang_WAIT=new Vector();
		            hang_WAIT.add(RS_PAC_NAME_WAIT.getString("transfer_id"));
		            hang_WAIT.add(RS_PAC_NAME_WAIT.getString("transfer_end"));
		        	RowData_WAIT.add(hang_WAIT);
		        }
				RS_PAC_NAME_WAIT.close();
		        MySQLConnect_Connection_WAIT.close();
	    	}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    /**
	     * 
	     * 注意！此处我们使用模板来向表中添加数据！
	     * 这样可以避免重复声明表格的步骤！方便多次修改！
	     * 多次修改的用法请参考本文件第947行上下文使用方式！
	     * 本文件还涉及到另一种动态添加的方式，请参考本文件562行至601行内容！
	     * 
	     */
	    
	    // 用以上生成的“列数据集合”和“行数据集合”作为参数声明一个新的 表格模板
		DefaultTableModel model_table_1 = new DefaultTableModel(RowData_WAIT, ColumnNames_WAIT);
		table_1.setModel(model_table_1);		// 将表格模板更换为新生成的模板模板
		
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		table_1.setRowHeight(50);
		
		if(INT_Found_PAT_NAME_WAIT) {
			// START 设置 table_1 内容居中
			DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
			tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样
			table_1.setDefaultRenderer(Object.class, tcr);
			// END 设置 table_1 内容居中
		}
		// END 候诊病人列表展示		
	}
	
	public static void PackageDoneTable() {
		// START 已处理包裹列表展示
		
		String String_SQL_PAC_NAME_DONE = "SELECT transfer_id, transfer_end " +
			 	  "FROM tb_transfer WHERE transfer_state = 'W';";;
		MySQLConnect MySQLConnect_Connection_DONE = new MySQLConnect(String_SQL_PAC_NAME_DONE);
		ResultSet RS_PAC_NAME_DONE;
		Vector RowData_DONE, ColumnNames_DONE;
		ColumnNames_DONE= new Vector();
		ColumnNames_DONE.add("");
		ColumnNames_DONE.add("");
		// 建立表头
		
		RowData_DONE=new Vector(); 
		boolean INT_Found_PAC_NAME_DONE = false;
		try {
			RS_PAC_NAME_DONE = MySQLConnect_Connection_DONE.pst.executeQuery();
			if(RS_PAC_NAME_DONE.next()) {
				INT_Found_PAC_NAME_DONE = true;
				Vector hang_DONE=new Vector();
				hang_DONE.add(RS_PAC_NAME_DONE.getString("transfer_id"));
				hang_DONE.add(RS_PAC_NAME_DONE.getString("transfer_end"));
				RowData_DONE.add(hang_DONE);
				while (RS_PAC_NAME_DONE.next()) {
					hang_DONE=new Vector();
					hang_DONE.add(RS_PAC_NAME_DONE.getString("transfer_id"));
					hang_DONE.add(RS_PAC_NAME_DONE.getString("transfer_end"));
					RowData_DONE.add(hang_DONE);
				}
				RS_PAC_NAME_DONE.close();
				MySQLConnect_Connection_DONE.close();
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		


		DefaultTableModel model_table_2 = new DefaultTableModel(RowData_DONE, ColumnNames_DONE);
		table_2.setModel(model_table_2);

		table_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_2.setRowHeight(50);
		table_2.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		if(INT_Found_PAC_NAME_DONE) {
			// START 设置table内容居中
			DefaultTableCellRenderer tsr_DONE = new DefaultTableCellRenderer();   
			tsr_DONE.setHorizontalAlignment(JLabel.CENTER);   
			table_2.setDefaultRenderer(Object.class, tsr_DONE);
			// END 设置table内容居中
		}
		// END 已处理包裹列表展示
	}
	
	/**
	 * Create the frame.
	 * @param DOC_NAME 
	 * @throws IOException 
	 */
	public RuntimeManagementSystem(String account_id) throws IOException {
		setTitle("NWSH \u533B\u751F\u7AEF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setExtendedState(JFrame.MAXIMIZED_BOTH);

		setBounds(100, 100, 1259, 922);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menu = new JMenu("\u83DC\u5355");
		menu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
		menuBar.add(menu);
		
		
		JMenuItem menuItem = new JMenuItem("\u767B\u51FA");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//		        GeneralLogin JFrame_Login = new GeneralLogin();		// 新建登录窗口
//		        JFrame_Login.setLocationRelativeTo(null);			// 将窗口放置于屏幕正中心
//		        dispose(); 											// 关闭当前窗口
//		        JFrame_Login.setVisible(true);						// 开启窗口
			}
		});
		
		JMenuItem menuItem_1 = new JMenuItem("开始处理");
		JMenuItem menuItem_2 = new JMenuItem("结束处理");
		menuItem_2.setEnabled(false);
		

				menuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
				menu.add(menuItem_1);

				menuItem_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
				menu.add(menuItem_2);
				menuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
				menuItem.setHorizontalAlignment(SwingConstants.RIGHT);
				menu.add(menuItem);
		
		
				
		// 列出等候病人列表
		table_1=new JTable() {
		// 设置表内数据不可修改
			public boolean isCellEditable(int row, int column) { 
				return false;
			}
		};
		PackageWaitTable();
		table_1.setEnabled(false);
				

		
		JLabel label = new JLabel("入库待处理");
		label.setFont(new Font("微软雅黑", Font.BOLD, 28));

		
		
		JLabel label_1 = new JLabel("入库已处理");
		label_1.setFont(new Font("微软雅黑", Font.BOLD, 28));

		
		
		// 列出已诊断病人列表
		table_2 = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		PackageDoneTable();
		table_2.setEnabled(false);
		
		
		
		// 新建网络客户端
		Client RMSClient = new Client();
		RMSClient.startUp();
		
		// System.out.println(RMSClient.incoming);
		
		
		JLabel label_2 = new JLabel("\u5965\u65AF\u7279\u6D1B\u592B");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("微软雅黑", Font.BOLD, 36));
		
		JLabel lblnwsh = new JLabel("，您好！欢迎使用Warestics入库系统！");
		lblnwsh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblnwsh.setFont(new Font("微软雅黑", Font.BOLD, 36));

        String String_SQL_DOC_NAME = "SELECT account_name " +
				 "FROM tb_account WHERE account_id = " + "10000";
		MySQLConnect Connection_DOC_NAME = new MySQLConnect(String_SQL_DOC_NAME);
		try {
			ResultSet RS_DOC_NAME = Connection_DOC_NAME.pst.executeQuery();
			RS_DOC_NAME.next();
			label_2.setText(RS_DOC_NAME.getString("account_name"));
			RS_DOC_NAME.close();
			Connection_DOC_NAME.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel lblNewLabel = new JLabel("\u8FD9\u91CC\u662F\u4E00\u4E2A\u65F6\u949F\u6A21\u5757\u54E6\uFF01");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 40));
		
	    ActionListener taskPerformer = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	            String s=String.format("%tY-%<tm-%<td   %<tH:%<tM:%<tS",new Date());
	            lblNewLabel.setText(s);
	        }
	    };  
	    new Timer(1000, taskPerformer).start();
		

	    
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(label_1)
											.addGap(79)))
									.addComponent(table_2, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label)
									.addGap(74)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(14)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(label_2)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblnwsh))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(68)
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 760, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE))
						.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, 1241, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(table_2, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblnwsh, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 495, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)))
					.addGap(198))
		);
		vData_table_4 = new Vector();
		vName_table_4 = new Vector();
		vName_table_4.add("column1");
		vName_table_4.add("column2");
		vName_table_4.add("column3");
		
		vData_table_5 = new Vector();
		vName_table_5 = new Vector();
		vName_table_5.add("column1");
		vName_table_5.add("column2");
		vName_table_5.add("column3");
		
		JLabel label_4 = new JLabel("入库信息");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("微软雅黑", Font.BOLD, 36));
		
		JLabel label_5 = new JLabel("单   号：");
		label_5.setFont(new Font("微软雅黑", Font.BOLD, 36));
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("微软雅黑", Font.BOLD, 30));
		textField.setColumns(10);
		
		JButton button1 = new JButton("入  库");
		//button1.setEnabled(false);
		button1.setFont(new Font("微软雅黑", Font.BOLD, 30));
		
		JButton button2 = new JButton("转  运");
		button2.setEnabled(false);
		button2.setFont(new Font("微软雅黑", Font.BOLD, 30));
		
		panel_1 = new ImagePanel("453645");
		panel_1.setVisible(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(label_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
							.addGap(30))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(112)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addComponent(button2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
					.addGap(78))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(299)
					.addComponent(label_4)
					.addContainerGap(313, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(button1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addGap(63)
							.addComponent(button2, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		// END 已处理包裹列表展示
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// 获取选中单元格的值
				String String_Selected_STA_ID = table_1.getValueAt(table_1.getSelectedRow(), 0).toString();
		        String String_SQL_PAC_INFO = "SELECT transfer_id " +
						 					 "FROM tb_transfer " + 
						 					 "WHERE transfer_id = " + 
						 					 String_Selected_STA_ID + ";";
				MySQLConnect Connection_PAC_INFO = new MySQLConnect(String_SQL_PAC_INFO);
				try {
					ResultSet RS_PAC_INFO = Connection_PAC_INFO.pst.executeQuery();
					if(RS_PAC_INFO.next()) {
						textField.setText(RS_PAC_INFO.getString("transfer_id"));
						String transfer_id = RS_PAC_INFO.getString("transfer_id");
						// 动态显示二维码
						panel_1.setImage(QRCode.encodeQRcode(transfer_id, 300, 300));
						panel_1.setVisible(true);
						RS_PAC_INFO.close();
						Connection_PAC_INFO.close();
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// 选中列表中信息后开启按钮功能
				button2.setEnabled(true);
			}
		});
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuItem_1.setEnabled(false);
				menuItem_2.setEnabled(true);
				menuItem.setEnabled(false);
				table_1.setEnabled(true);
				table_2.setEnabled(true);
			}
		});
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuItem_1.setEnabled(true);
				menuItem_2.setEnabled(false);
				menuItem.setEnabled(true);
				table_1.setEnabled(false);
				table_2.setEnabled(false);
				button1.setEnabled(false);
				button2.setEnabled(false);
			}
		});
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				button1.setEnabled(false);
				button2.setEnabled(false);
				menuItem_2.setEnabled(false);
			}
		});
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PackageWaitTable();
				PackageDoneTable();
				// 提交转运，修改状态码为W
		        String String_SQL_UPDATE_STATE = "UPDATE tb_transfer SET transfer_state = 'W'"
						+ " WHERE transfer_id = '" + textField.getText() + "';";
				MySQLConnect MySQLConnect_Connection_UPDATE_STATE = new MySQLConnect(String_SQL_UPDATE_STATE);
				try {
					MySQLConnect_Connection_UPDATE_STATE.pst.executeUpdate();
					MySQLConnect_Connection_UPDATE_STATE.pst.close();
					MySQLConnect_Connection_UPDATE_STATE.close();
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				RMSClient.SendMessage("transfer" + textField.getText());
				textField.setText(null);
				PackageWaitTable();
				PackageDoneTable();
				
				panel_1.setVisible(false);
				button2.setEnabled(false);
				menuItem_2.setEnabled(true);
			}
		});
		

		

	}
}
