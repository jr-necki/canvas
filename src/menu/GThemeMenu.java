package menu;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import global.GConstants.EThemeMenu;
import global.GConstants.EThemechangeMenu;


public class GThemeMenu extends JMenu {
	private static final long serialVersionUID = 1L;

	public GThemeMenu(String text, ActionListener themeactionListener) {
		super(text);
		// 테바 변경
		JMenu setThememenu = new JMenu(EThemechangeMenu.settheme.getText());
		this.add(setThememenu);
		for (EThemeMenu ethemeItem : EThemeMenu.values()) {
			JMenuItem themeItem = new JMenuItem(ethemeItem.getText());
			themeItem.setActionCommand(ethemeItem.getTheme());
			themeItem.addActionListener(themeactionListener);
			setThememenu.add(themeItem);
		}

		// 테마 초기화
		JMenuItem clearThememenu = new JMenuItem(EThemechangeMenu.cleartheme.getText());
		clearThememenu.setActionCommand(EThemechangeMenu.cleartheme.getTheme());
		clearThememenu.addActionListener(themeactionListener);
		this.add(clearThememenu);
	}
}