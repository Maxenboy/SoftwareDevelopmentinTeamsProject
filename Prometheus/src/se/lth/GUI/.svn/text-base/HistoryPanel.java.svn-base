package se.lth.GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class HistoryPanel extends JPanel {
	private HistoryArea hist;
	private JScrollPane scroll;

	/**
	 * Creates a HistoryPanel
	 */
	public HistoryPanel() {
		hist = new HistoryArea();
		scroll = new JScrollPane(hist);
		scroll.setPreferredSize(EditPanel.dim);
		add(scroll);
	}

	/**
	 * 
	 * @return HistoryArea
	 */
	public HistoryArea getHistoryArea() {
		return hist;
	}

	/**
	 * Force the scroll to the top
	 */
	public void forceScrollToTop() {
		hist.setCaretPosition(0);
	}
}
