package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import drawingPanel.GDrawingPanel;
import global.GConstants.EEditMenu;

public class GEditMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	
	private GDrawingPanel drawingPanel;
	
	public GEditMenu(String text) {
		super(text);
		ActionHandler actionHandler = new ActionHandler();

		for (EEditMenu emenuItem : EEditMenu.values()) {
			JMenuItem menuItem = new JMenuItem(emenuItem.getText());
			menuItem.setActionCommand(emenuItem.getMethod());
			menuItem.addActionListener(actionHandler);
			this.add(menuItem);
			menuItem.setToolTipText(emenuItem.getText());
			switch (emenuItem.getText()) {
			case "되돌리기":
				menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,InputEvent.CTRL_MASK));
				
				break;
			case "다시실행":
				menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,InputEvent.CTRL_MASK));
				this.addSeparator();
				
				break;
			case "잘라내기":
				menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));
				
				break;
			case "복사하기":
				menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
				
				break;
			case "붙여넣기":
				menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK));
				
				this.addSeparator();
				break;
			case "그룹":
				menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,InputEvent.CTRL_MASK));
				
				break;
			case "언그룹":
				menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,InputEvent.CTRL_MASK));
				
				break;
			default:
				break;
		}

		}
	}
	
	public void undo() {
		
	}
	public void redo() {
		
	}
	public void cut() {
		this.drawingPanel.cut();
	}
	public void copy() {
		this.drawingPanel.copy();
	}
	public void paste() {
		this.drawingPanel.paste();
	}
	public void group() {
		
	}
	public void ungroup() {
		
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
