package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

import drawingPanel.GDrawingPanel;
import global.GConstants.EFileMenu;
import sound.MakeSound;


@SuppressWarnings("serial")
public class GFileMenu extends JMenu {
	private static MakeSound makeSound = new MakeSound();
	

	private File directory, file;

	// association
	private GDrawingPanel drawingPanel;

	public GFileMenu(String text) {
		super(text);
		ActionHandler actionHandler = new ActionHandler();

		this.file = null;
		this.directory = new File("data");

		for (EFileMenu emenuItem : EFileMenu.values()) {
			JMenuItem menuItem = new JMenuItem(emenuItem.getText());
			menuItem.setActionCommand(emenuItem.getMethod());
			menuItem.addActionListener(actionHandler);
			this.add(menuItem);
			menuItem.setToolTipText(emenuItem.getText());
			switch (emenuItem.getText()) {
				case "새로 만들기":
					menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
					
					break;
				case "불러오기":
					menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
					
					break;
				case "저장하기":
					menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
				
					break;
				case "다른 이름으로 저장하기":
					menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
					
					this.addSeparator();
					break;
				case "프린트하기":
					menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,InputEvent.CTRL_MASK));
					
					this.addSeparator();
					break;
				case "닫기":
					menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,InputEvent.ALT_MASK));
					
					break;
				default:
					break;
			}
		
		}
	}
	public void print(){
		this.drawingPanel = new GDrawingPanel();
		PrinterJob pjob = PrinterJob.getPrinterJob();
		PageFormat preformat = pjob.defaultPage();
		preformat.setOrientation(PageFormat.LANDSCAPE);
		PageFormat postformat = pjob.pageDialog(preformat);
		//If user does not hit cancel then print.
		if (preformat != postformat) {
		    //Set print component
		    pjob.setPrintable(new GPrinter(drawingPanel), postformat);
		    if (pjob.printDialog()) {
		        try {
					pjob.print();
				} catch (PrinterException e) {e.printStackTrace();}
		    }
		}
		
	}
	public void nnew() {
		//뉴를 하면 빈화면을 저장함 . 수정해야함
		


		this.drawingPanel.restoreShapeVetor(null);
		this.drawingPanel.setUpdated(true);
	}

	private void readObject() {
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(file)));
			this.drawingPanel.restoreShapeVetor(objectInputStream.readObject());
			objectInputStream.close();
			this.drawingPanel.setUpdated(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() {
		//현재 열려있는 파일을 다시 열려고 했을때는 저장할 것인지 물어봐야함.


		JFileChooser chooser = new JFileChooser(this.directory);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Graphic date", "god");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(this.drawingPanel);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			this.directory = chooser.getCurrentDirectory();
			this.file = chooser.getSelectedFile();
			this.readObject();
		}
	}

	private void writeObject() {
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(this.file)));
			objectOutputStream.writeObject(drawingPanel.getShapeVetor());
			objectOutputStream.close();
			this.drawingPanel.setUpdated(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void save() {
		if (this.drawingPanel.isUpdated()) {
			if (file == null) {
				this.saveAs();
			} else {
				this.writeObject();
			}
		}
	}

	public void saveAs() {
		JFileChooser chooser = new JFileChooser(this.directory);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Graphic date", "god");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showSaveDialog(this.drawingPanel);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			this.directory = chooser.getCurrentDirectory();
			this.file = chooser.getSelectedFile();
			this.writeObject();
		}
	}

//	private boolean checkSave() {
//		boolean cancel = false;
//		int reply = JOptionPane.NO_OPTION;
//		if(this.getDrawingPanel().isUpdated()){
//			reply = JOptionPane.showConfirmDialog(this.getDrawingPanel(), "변경 내용을 저장할까요?");
//			if(reply == JOptionPane.CANCEL_OPTION) {
//				cancel = true;
//			}
//			if(!cancel) {
//				if(reply == JOptionPane.OK_OPTION) {
//					cancel = this.save();
//				}
//			}
//		}
//		return cancel;
//	}

	public void close() {
		this.save();
		makeSound.playSound("end.wav");
	    int result = JOptionPane.showConfirmDialog(null, "프로그램을 종료하시 겠습니까?", "알림",JOptionPane.OK_CANCEL_OPTION);
	
	    System.out.printf("%d\n", result);
        if (result == 0) {
            System.exit(0);
        }
	}

	private void invokeMethod(String name) {
		try {this.getClass().getMethod(name).invoke(this);}
		catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException| SecurityException e) {e.printStackTrace();}
	}

	private class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {invokeMethod(e.getActionCommand());}
	}

	public void associate(GDrawingPanel drawingPanel) {this.drawingPanel = drawingPanel;}
	public void initialize() {}
	

}