package com.NewsAgency.presentation.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LoginView extends JFrame {
	
	
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JButton btnLoginReader;
	private JButton buttonLoginWriter;


	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 398);
		getContentPane().setLayout(null);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldUsername.setBounds(130, 83, 167, 20);
		getContentPane().add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(130, 58, 167, 14);
		getContentPane().add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(130, 124, 167, 14);
		getContentPane().add(lblPassword);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(130, 149, 167, 20);
		getContentPane().add(textFieldPassword);
		
		btnLoginReader = new JButton("View Articles");
		btnLoginReader.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLoginReader.setBounds(43, 221, 140, 52);
		getContentPane().add(btnLoginReader);
		
		buttonLoginWriter = new JButton("Login Writer");
		buttonLoginWriter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonLoginWriter.setBounds(228, 221, 140, 52);
		getContentPane().add(buttonLoginWriter);
		
		
	}
	
	public void addLoginReaderButton(ActionListener e)
	{
		btnLoginReader.addActionListener(e);
	}
	
	public void addLoginWriterButton(ActionListener e)
	{
		buttonLoginWriter.addActionListener(e);
	}
	
	public String getEmail()
	{
		return textFieldUsername.getText();
	}
	
	public String getPassword()
	{
		return textFieldPassword.getText();
	}
	public void showErrorMessage(String text)
	{
		JOptionPane.showMessageDialog(null, text);
	}
	

	
}
