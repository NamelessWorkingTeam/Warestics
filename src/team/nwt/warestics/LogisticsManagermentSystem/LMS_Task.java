package team.nwt.warestics.LogisticsManagermentSystem;

import java.util.Timer;
import java.util.TimerTask;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import team.nwt.warestics.MySQLConnect;
import team.nwt.warestics.LogisticsManagermentSystem.*;

public class LMS_Task { 
	    public static void main(String[] args) {  
	        TimerTask task = new TimerTask() {  
	            @Override  
	            public void run() {  
	                // task to run goes here  
	            	CarAlarm();
//	            	System.out.println("Hello !!!"); 
	            }  
	        };  
	        Timer timer = new Timer();  
	        long delay = 0;  
	        long intevalPeriod = 30*1000;  
	        // schedules the task to be run in an interval  
	        timer.scheduleAtFixedRate(task, delay, intevalPeriod);  
	    } // end of main  

	    
	    
	    
	    
	    
		protected static void CarAlarm() {
			// TODO 自动生成的方法存根
			    String String_CheckStorgesql = null;   
			    MySQLConnect db = null;  
			    ResultSet Result_Storge = null;  
		    	String_CheckStorgesql= "SELECT car_id,car_status FROM tb_car";	
		       db = new MySQLConnect(String_CheckStorgesql);							
		       try {
		       	Result_Storge = db.pst.executeQuery();					
					while (Result_Storge.next()) {
		               String String_CheckName = Result_Storge.getString("car_id");
		               int Int_CheckStorge = Result_Storge.getInt("car_status");
		               if (Int_CheckStorge>=6)
		               { 
		               //System.out.println(String_CheckName);
		               //System.out.println(Result_Storge.getInt("MED_STORGE"));
		            JOptionPane.showMessageDialog(null,"编号："+ String_CheckName+"货车出现异常！", "警告", JOptionPane.ERROR_MESSAGE); //弹窗警告
		               	}
		               }
					Result_Storge.close();		
			        db.close();			
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
 
}
