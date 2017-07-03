package team.nwt.warestics.LogisticsManagermentSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
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
import team.nwt.warestics.LogisticsManagermentSystem.*;
import team.nwt.warestics.MySQLConnect;
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
import team.nwt.warestics.MySQLConnect;
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
import javax.swing.JOptionPane;
import team.nwt.warestics.MySQLConnect;

public class CarAlerm {
	static private void CarAlarm(){
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
               JOptionPane.showMessageDialog(null,"��ţ�"+ String_CheckName+"���������쳣��", "����", JOptionPane.ERROR_MESSAGE); //��������
               	}
               }
			Result_Storge.close();		
	        db.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}}
