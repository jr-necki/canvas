package menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import drawingPanel.GDrawingPanel;
import global.GConstants;
import global.GConstants.EColorMenu;

public class GColorMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	
	private GDrawingPanel drawingPanel;
	
	public GColorMenu(String text) {
		super(text);
		ActionHandler actionHandler = new ActionHandler();

		for (EColorMenu emenuItem : EColorMenu.values()) {
			JMenuItem menuItem = new JMenuItem(emenuItem.getText());
			menuItem.setActionCommand(emenuItem.getMethod());
			menuItem.addActionListener(actionHandler);
			this.add(menuItem);
			switch (emenuItem.getText()) {
			case "면색":
				menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,InputEvent.ALT_MASK));
				this.addSeparator();
				menuItem.setToolTipText("FACE COLOR");
				break;
			case "선색":
				menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,InputEvent.ALT_MASK));
				menuItem.setToolTipText("LINE COLOR");
				break;
			case "면색 초기화":
				menuItem.setToolTipText("FACE COLOR CLEAR");
				break;
			case "선색 초기화":
				menuItem.setToolTipText("LINE COLOR CLEAR");
				break;
			default:
				break;
			}
		}
	}
	public void changeLineColor() {
		Color color = JColorChooser.showDialog(null, EColorMenu.lineColor.name(), null);
		if(color != null) {
			drawingPanel.setLineColor(color);
		}
	}
	
	public void changeFillColor() {
		Color color = JColorChooser.showDialog(null, GConstants.EColorMenu.fillColor.name(), null);
		if(color != null) {
			drawingPanel.setFillColor(color);
		}
	}
	
	public void clearLineColor() {
		drawingPanel.setLineColor(getBackground());
	}
	

	public void clearFillColor() {
		drawingPanel.setFillColor(Color.WHITE);
	}
private class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			invokeMethod(e.getActionCommand());
		}
	}
	private void invokeMethod(String name) {
		try {
			this.getClass().getMethod(name).invoke(this);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
		}
	}
	public void associate(GDrawingPanel drawingPanel) {this.drawingPanel = drawingPanel;}
	public void initialize() {}
}