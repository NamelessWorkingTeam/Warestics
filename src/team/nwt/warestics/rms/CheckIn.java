package team.nwt.warestics.rms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import team.nwt.warestics.MySQLConnect;
import team.nwt.warestics.QRCode.QRCode;
import team.nwt.warestics.network.Client;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class CheckIn extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel label_3;
	private JTextField textField_3;
	private JButton button;
	private String stock_amount;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckIn frame = new CheckIn(null, null);
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
	public CheckIn(String stock_id, String goods_id) {
		setTitle("入库审核");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 384, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("进货编码");
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setText(stock_id);
		
		JLabel label_1 = new JLabel("物品编码");
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setText(goods_id);
		
		JLabel label_2 = new JLabel("应到数量");
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		
		
		label_3 = new JLabel("实到数量");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		Client CheckInClient = new Client();			// 建立审核网络连接客户端
		CheckInClient.startUp();
		
		button = new JButton("生成审核报告");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String whetherpassed;
				if(textField_2.getText().compareTo(textField_3.getText()) == 0) {
					// 审核成功，修改状态码为S
					whetherpassed = "YES";
			        String String_SQL_UPDATE_STATE = "UPDATE tb_stock SET stock_state = 'S'"
							+ " WHERE stock_id = '" + textField.getText() + "';";
					MySQLConnect MySQLConnect_Connection_UPDATE_STATE = new MySQLConnect(String_SQL_UPDATE_STATE);
					try {
						MySQLConnect_Connection_UPDATE_STATE.pst.executeUpdate();
						MySQLConnect_Connection_UPDATE_STATE.pst.close();
						MySQLConnect_Connection_UPDATE_STATE.close();
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					CheckInClient.SendMessage("inbound" + textField.getText());
				}
				else {
					whetherpassed = "NO";
			        String String_SQL_UPDATE_STATE = "UPDATE tb_stock SET stock_state = 'E'"
							+ " WHERE stock_id = '" + textField.getText() + "';";
					MySQLConnect MySQLConnect_Connection_UPDATE_STATE = new MySQLConnect(String_SQL_UPDATE_STATE);
					try {
						MySQLConnect_Connection_UPDATE_STATE.pst.executeUpdate();
						MySQLConnect_Connection_UPDATE_STATE.pst.close();
						MySQLConnect_Connection_UPDATE_STATE.close();
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				// 生成审核报告
				//Step 1—Create a Document.  
				Document document = new Document();  
				//Step 2—Get a PdfWriter instance.  
				try {
					PdfWriter.getInstance(document, new FileOutputStream("stock" + stock_id +".pdf"));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
				//Step 3—Open the Document.  
				document.open();  
			
				//Step 4—Add content.  
				BaseFont bf = null;
				try {
					bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
				} catch (DocumentException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}  
		        Font font = new Font(bf, 12, Font.NORMAL);  
				try {

					document.add(new Paragraph("转运编码：   " + stock_id, font));
					document.add(new Paragraph("物品编码：   " + goods_id, font));
					document.add(new Paragraph("应到数量:   " + stock_amount, font));
					document.add(new Paragraph("实到数量:   " + textField_3.getText(), font));
					document.add(new Paragraph("审核是否通过:   " + whetherpassed, font));
					JOptionPane.showMessageDialog(null, "审核报告生成成功！", "提示",JOptionPane.INFORMATION_MESSAGE);

				} catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
				FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new BaseColor(255, 150, 200));  
				//Step 5—Close the Document.  
				
				document.close();
				dispose();

				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(58)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addGap(14)
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addGap(14)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(label_1)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textField_1))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(label)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(115)
							.addComponent(button)))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(label_2))
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(label_3))
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(button)
					.addContainerGap(181, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		
		
        String String_SQL_DOC_NAME = "SELECT stock_amount " +
				 "FROM tb_stock WHERE stock_id = " + stock_id;
		MySQLConnect Connection_DOC_NAME = new MySQLConnect(String_SQL_DOC_NAME);
		try {
			ResultSet RS_DOC_NAME = Connection_DOC_NAME.pst.executeQuery();
			RS_DOC_NAME.next();
			stock_amount = RS_DOC_NAME.getString("stock_amount");
			textField_2.setText(stock_amount);
			RS_DOC_NAME.close();
			Connection_DOC_NAME.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}

}

