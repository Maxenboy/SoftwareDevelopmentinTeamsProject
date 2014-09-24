package se.lth.GUI;

import java.awt.BorderLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {
	protected EditPanel editPanel;
	protected HistoryArea hist;

	/**
	 * The Main panel of the window, adds editpanel and History Area
	 */
	public MainPanel() {
		super(new BorderLayout());

		HistoryPanel histPanel = new HistoryPanel();
		EditPanel editPanel = new EditPanel(histPanel);
		add(editPanel, BorderLayout.NORTH);
		add(histPanel, BorderLayout.SOUTH);

	}

}
