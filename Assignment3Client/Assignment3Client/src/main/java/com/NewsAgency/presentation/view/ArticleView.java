package com.NewsAgency.presentation.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.NewsAgency.entity.Article;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class ArticleView extends JFrame {

	private JPanel contentPane;
	private JLabel lblTitle;
	private JLabel lblWriter;
	private JTextArea textArea;
	
	public ArticleView(Article article) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 583, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel(article.getTitle());
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitle.setBounds(10, 11, 547, 45);
		contentPane.add(lblTitle);
		
		
		
		lblWriter = new JLabel(article.getWriter().getName());
		lblWriter.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWriter.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWriter.setBounds(10, 297, 495, 45);
		contentPane.add(lblWriter);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textArea.setEditable(false);
		textArea.setBounds(20, 67, 537, 237);
		contentPane.add(textArea);
		
		textArea.append("Abstract \n"+article.getArticleAbstract()+"\n Body \n"+article.getBody());
	}
}
