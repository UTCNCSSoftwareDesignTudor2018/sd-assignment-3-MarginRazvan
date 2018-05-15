package com.NewsAgency.presentation.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.NewsAgency.entity.Writer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WriterView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTitle;
	private JLabel lblWriter;
    private JTextArea textAreaAbstract;
    private JTextArea textAreaBody;
    private JButton btnAddArticle;
    private JLabel lblId;
    private JTextField textFieldId;
    private JButton btnDelArticle;

	public WriterView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 545, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    lblWriter = new JLabel();
		lblWriter.setHorizontalAlignment(SwingConstants.CENTER);
		lblWriter.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWriter.setBounds(10, 11, 509, 42);
		contentPane.add(lblWriter);
		
		JLabel lblNewLabel = new JLabel("Title");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 64, 509, 42);
		contentPane.add(lblNewLabel);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldTitle.setBounds(161, 116, 217, 42);
		contentPane.add(textFieldTitle);
		textFieldTitle.setColumns(10);
		
		JLabel lblAbstract = new JLabel("Abstract");
		lblAbstract.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbstract.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAbstract.setBounds(10, 155, 252, 42);
		contentPane.add(lblAbstract);
		
		textAreaAbstract = new JTextArea();
		textAreaAbstract.setBounds(10, 199, 252, 164);
		contentPane.add(textAreaAbstract);
		
		JLabel lblBody = new JLabel("Body");
		lblBody.setHorizontalAlignment(SwingConstants.CENTER);
		lblBody.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBody.setBounds(277, 155, 252, 42);
		contentPane.add(lblBody);
		
		textAreaBody = new JTextArea();
		textAreaBody.setBounds(272, 199, 252, 164);
		contentPane.add(textAreaBody);
		
		btnAddArticle = new JButton("Add Article");
		btnAddArticle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddArticle.setBounds(47, 374, 167, 36);
		contentPane.add(btnAddArticle);
		
		lblId = new JLabel("Id");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(203, 374, 94, 42);
		contentPane.add(lblId);
		
	    btnDelArticle = new JButton("Delete Article");
		btnDelArticle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelArticle.setBounds(339, 374, 167, 36);
		contentPane.add(btnDelArticle);
		
		textFieldId = new JTextField();
		textFieldId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldId.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldId.setBounds(277, 374, 51, 36);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
	}
	
	public void addButtonListener(ActionListener e)
	{
		btnAddArticle.addActionListener(e);
	}
	
	public void addDeleteButtonListener(ActionListener e)
	{
		btnDelArticle.addActionListener(e);
	}

	
	
	

	public String getTextFieldId() {
		return textFieldId.getText();
	}


	public String getTextFieldTitle() {
		return textFieldTitle.getText();
	}

	public String getTextAreaAbstract() {
		return textAreaAbstract.getText();
	}


	public String getTextAreaBody() {
		return textAreaBody.getText();
	}

	public String getLblWriter() {
		return lblWriter.getText();
	}

	public void setLblWriter(String lblWriter) {
		this.lblWriter.setText(lblWriter);;
	}
	
	public void showErrorMessage(String text)
	{
		JOptionPane.showMessageDialog(null, text);
	}
}
