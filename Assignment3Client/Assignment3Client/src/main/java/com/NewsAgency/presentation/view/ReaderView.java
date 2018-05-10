package com.NewsAgency.presentation.view;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import com.NewsAgency.entity.*;

public class ReaderView extends JFrame {
	private JTable table;
	private JTextField textFieldArticleId;
	private JButton btnViewArticle;



	public ReaderView(Object[][] data) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 477);
		getContentPane().setLayout(null);
		

		
		JPanel panel = new JPanel();
		panel.setBounds(10, 23, 534, 311);
		getContentPane().add(panel);
		
		String[] columns = {"Id","Title","Abstract","Writer"};
		table = new JTable(data,columns);
		panel.add(table);
		
		
		JLabel lblNewLabel = new JLabel("Article Id");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 345, 80, 30);
		getContentPane().add(lblNewLabel);
		
		textFieldArticleId = new JTextField();
		textFieldArticleId.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldArticleId.setBounds(100, 352, 44, 20);
		getContentPane().add(textFieldArticleId);
		textFieldArticleId.setColumns(10);
		
		btnViewArticle = new JButton("Read Article");
		btnViewArticle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnViewArticle.setBounds(154, 345, 138, 60);
		getContentPane().add(btnViewArticle);
		
	}
	
	
	public void addViewArticleListener (ActionListener e)
	{
		btnViewArticle.addActionListener(e);
	}
	
	public String getArticleId()
	{
		return textFieldArticleId.getText();
	}
	
	public void updateTable(Object[][] data)
	{
		
	}
}
