package se.lth.GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public abstract class TimeSelectionButton extends JRadioButton implements
		ActionListener {
	String file;

	/**
	 * Creates the radio buttons
	 * 
	 * @param name
	 */
	public TimeSelectionButton(String name, String file) {
		super(name);
		this.file = file;
		setPreferredSize(new Dimension(300, 150));
		addActionListener(this);
	}

	/**
	 * Choosing if it's finish or start selectionsbutton
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		opSetFile();
	}

	/**
	 * Sets file depending on the subclass
	 */
	protected abstract void opSetFile();
}
