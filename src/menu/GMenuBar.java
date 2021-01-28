package menu;

import java.awt.event.ActionListener;

import javax.swing.JMenuBar;

import drawingPanel.GDrawingPanel;
import global.GConstants.EMenu;

@SuppressWarnings("serial")
public class GMenuBar extends JMenuBar{

	//Components
	private GFileMenu fileMenu;
	private GEditMenu editMenu;
	private GColorMenu colorMenu;
	private GThemeMenu themeMenu;
	
	
	//Association
	@SuppressWarnings("unused")
	private GDrawingPanel drawingPanel;
	
	public void associate(GDrawingPanel drawingPanel) {
		this.drawingPanel=drawingPanel;
	}
	
	public GMenuBar(ActionListener themeactionListener){
		// initialize attribute
		
		//create components
		this.fileMenu = new GFileMenu(EMenu.fileMenu.getText());
		this.add(fileMenu);
		this.editMenu = new GEditMenu(EMenu.editMenu.getText());
		this.add(editMenu);
		this.colorMenu = new GColorMenu(EMenu.colorMenu.getText());
		this.add(colorMenu);
		this.themeMenu = new GThemeMenu(EMenu.themeMenu.getText(), themeactionListener);
		this.add(themeMenu);
		
	}

	public void initialize() {
		//associate
		this.fileMenu.associate(this.drawingPanel);
		this.editMenu.associate(this.drawingPanel);
		this.colorMenu.associate(this.drawingPanel);
		
		//initialize components
		fileMenu.initialize();
		editMenu.initialize();
		colorMenu.initialize();
	}

}
