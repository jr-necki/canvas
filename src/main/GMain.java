package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import global.GConstants;
import sound.MakeSound;

public class GMain {

	static GMainFrame mainFrame;
	private static MakeSound makeSound = new MakeSound();
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(GConstants.defaulttheme);
			mainFrame = new GMainFrame();
			mainFrame.initialize();
			mainFrame.setVisible(true);

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {e.printStackTrace();}
	}
}
