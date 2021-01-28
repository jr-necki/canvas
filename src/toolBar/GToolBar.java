package toolBar;

import java.awt.GridLayout;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.mommoo.flat.layout.linear.LinearLayout;
import com.mommoo.flat.layout.linear.Orientation;

import drawingPanel.GDrawingPanel;
import global.GConstants;
import global.GConstants.EToolBar;
import shape.GShape;
import sound.MakeSound;
import toolBar.GToolBar.MyChangeListener;


@SuppressWarnings("serial")
public class GToolBar extends JToolBar{

	private Vector<JRadioButton> buttons;
	private GDrawingPanel drawingPanel;
	private ButtonGroup buttonGroup;
	private GShape shape;
	public JSlider slider;
	private static MakeSound makeSound = new MakeSound();
	
	public void associate(GDrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}

	public GToolBar() {
		ActionHandler actionHandler = new ActionHandler();
//		this.setLayout(new LinearLayout(Orientation.VERTICAL,0));
		this.buttons = new Vector<JRadioButton>();
		this.buttonGroup = new ButtonGroup();
		for (EToolBar eToolBar : EToolBar.values()) {
			JRadioButton button = new JRadioButton();
			button.setIcon(new ImageIcon(GConstants.library + eToolBar.name() + GConstants.imageSufix));
			button.setSelectedIcon(new ImageIcon(
					GConstants.library + eToolBar.name() + GConstants.selectedImage + GConstants.imageSufix));
			button.setActionCommand(eToolBar.name());
			button.addActionListener(actionHandler);
	
			button.setToolTipText(eToolBar.name());
			this.buttons.add(button);
			this.buttonGroup.add(button);
			this.add(button);
		}
		this.slider=new JSlider(JSlider.HORIZONTAL,0,100,20);
		this.slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setPaintTrack(true);
		slider.setMajorTickSpacing(50);
		slider.setMinorTickSpacing(10);
		slider.addChangeListener(new MyChangeListener());
		this.add(slider);

			
		
	}
	private void setPensize(Object event) {
        drawingPanel.setPenSize((((JSlider) event).getValue()));
	}
	public class MyChangeListener implements ChangeListener{
		public void stateChanged(ChangeEvent e){
			setPensize(e.getSource());
		}
	}
	

	public void initialize() {
		buttons.get(EToolBar.rectangle.ordinal()).doClick();
	}
	
	private class ActionHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			drawingPanel.setCurrentTool(EToolBar.valueOf(e.getActionCommand()));
			makeSound.playSound("button.wav");
		}
	}

}
