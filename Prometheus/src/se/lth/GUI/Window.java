package se.lth.GUI;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame {
	/**
	 * The main frame of the program
	 */
	public Window() {
		super("Program");
		add(new MainPanel());
		this.setSize(500, 500);
		this.setVisible(true);
		this.setResizable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}

	public static void main(String[] args) {
		new Window();
	}

}
