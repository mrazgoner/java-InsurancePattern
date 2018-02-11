package com.gui;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import javax.swing.JScrollPane;

/**
 * 
 * @author Owner
 *
 */

@SuppressWarnings("serial")
public class ConsoleScreen extends JFrame{

	private JTextArea textArea;

	public ConsoleScreen() {
		getContentPane().setLayout(null);

		//740X490
		setSize(800, 650);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 30, 750, 540);
		getContentPane().add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);

	}

	public void append(String str)
	{
		textArea.append(str);
		textArea.setCaretPosition(textArea.getDocument().getLength());

	}

}
