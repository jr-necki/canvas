package main;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import drawingPanel.GDrawingPanel;
import global.GConstants;
import global.GConstants.EMainFrame;
import menu.GMenuBar;
import toolBar.GToolBar;

@SuppressWarnings("serial")
public class GMainFrame extends JFrame {

	//Component = 요녀석 안에서 new를 하면 된다.
	private GMenuBar menuBar;
	private GToolBar toolBar;
	private GDrawingPanel drawingPanel;
	private ActionListener themeactionListener;

	
	public GMainFrame(){
		// attributes
		this.setSize(EMainFrame.w.getText(),EMainFrame.h.getText());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.themeactionListener = new ThemeActionHandler();
		// components
		this.menuBar = new GMenuBar(this.themeactionListener);
		this.setJMenuBar(menuBar);
		
		this.toolBar = new GToolBar();
		this.add(this.toolBar, BorderLayout.NORTH);
		
		this.drawingPanel = new GDrawingPanel();
		this.add(this.drawingPanel, BorderLayout.CENTER);
	
	}

	public void initialize() {
		//Associations
		this.toolBar.associate(this.drawingPanel);
		this.menuBar.associate(this.drawingPanel);
		
		menuBar.initialize();
		toolBar.initialize();
		drawingPanel.initialize();
	}
	public void setTheme(String theme) {
		try {
		    UIManager.setLookAndFeel(theme);
		    SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
		}
	}
	
	public class ThemeActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {setTheme(e.getActionCommand());}
	}
}
