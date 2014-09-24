package se.lth.GUI;

import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class HistoryArea extends JTextArea {
	/**
	 * Window with the earlier registration
	 * 
	 */
	public HistoryArea() {
		super(20, 150);
		setEditable(false);
	}

	/**
	 * Sets text.
	 * 
	 * @param text
	 */
	public void setText(String text) {
		insert(text, 0);
	}
}
