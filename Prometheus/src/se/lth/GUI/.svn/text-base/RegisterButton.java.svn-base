package se.lth.GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JTextField;

import se.lth.register.FinishTimeWriter;
import se.lth.register.StartTimeWriter;
import se.lth.register.TimeWriter;

@SuppressWarnings("serial")
public class RegisterButton extends JButton implements ActionListener {
	JTextField riderNbr;
	TimeWriter timeWriter;
	HistoryPanel histPanel;
	HistoryArea hist;
	StartSelectionButton sb;

	/**
	 * Creates the button that registers
	 */
	public RegisterButton(JTextField riderNbr, HistoryPanel histPanel,
			StartSelectionButton sb) {
		super("Register");
		this.histPanel = histPanel;
		setPreferredSize(new Dimension(300, 150));
		setFont(new Font("Arial", Font.BOLD, 48));
		this.riderNbr = riderNbr;
		this.sb = sb;
		addActionListener(this);
		hist = histPanel.getHistoryArea();
	}

	/**
	 * Add time and id to historyArea
	 */
	public void actionPerformed(ActionEvent arg0) {
		File file;

		if (sb.isSelected()) {
			file = new File("start.txt");
			timeWriter = new StartTimeWriter(new File("start.txt"));
		} else {
			file = new File("finish.txt");
			timeWriter = new FinishTimeWriter(new File("finish.txt"));
		}

		String text = timeWriter.register(riderNbr.getText()) + "; " + file
				+ "\n";
		hist.setText(text);
		riderNbr.setText("");
		riderNbr.setFocusable(true);
		histPanel.forceScrollToTop();

	}

}
