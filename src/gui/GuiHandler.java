package gui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.*;

public class GuiHandler {
	
	private JFrame f;
	private JPanel p;
	private JLabel l;
	
	public GuiHandler() {
		createAndShowGUI();
	}
	
	private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Chanels");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton addButton = new JButton();
        addButton.setText("Add");
        
        addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent a) {
				JFrame addNewFrame = new JFrame("Add");
				addNewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				addNewFrame.setVisible(true);
				
		        JButton addButton = new JButton();
		        addButton.setText("Save");
		        
		        JPanel addNewPanel = new JPanel();
		        addNewPanel.add(addButton);
		        addNewFrame.add(addNewPanel);
		        
		        addNewFrame.setSize(new Dimension(200, 300));
			}
		});
        
        //Create and set up the content pane.
        TabularInfo newContentPane = new TabularInfo();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        
        newContentPane.add(addButton);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
