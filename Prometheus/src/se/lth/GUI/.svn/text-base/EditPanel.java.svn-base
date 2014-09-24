package se.lth.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 */
@SuppressWarnings("serial")
public class EditPanel extends JPanel {
	private JTextField riderNbr;
	private RegisterButton button;
	private ButtonGroup selection;

	private StartSelectionButton startTime;
	private FinishSelectionButton finishTime;
	public static Dimension dim;
	public String file;

	/**
	 * Creates the edit panel
	 */
	public EditPanel(HistoryPanel histPanel) {
		this.setLayout(new GridLayout(1, 4));
		Font fontL = new Font("Arial", Font.BOLD, 80);
		Font fontS = new Font("Arial", Font.BOLD, 32);
		dim = new Dimension(Window.WIDTH, 150);
		file = "start.txt";
		riderNbr = new JTextField("");
		riderNbr.setFont(fontL);
		riderNbr.setPreferredSize(dim);

		riderNbr.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					button.actionPerformed(null);

				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
		});

		selection = new ButtonGroup();
		startTime = new StartSelectionButton(file);
		startTime.setFont(fontS);
		startTime.setSelected(true);
		button = new RegisterButton(riderNbr, histPanel, startTime);

		JLabel riderId = new JLabel("ID");
		riderId.setFont(fontS);

		finishTime = new FinishSelectionButton(file);
		finishTime.setFont(fontS);

		selection.add(startTime);
		selection.add(finishTime);

		add(riderId, BorderLayout.NORTH);
		add(riderNbr, BorderLayout.NORTH);
		add(startTime, BorderLayout.NORTH);
		add(finishTime, BorderLayout.NORTH);
		add(button, BorderLayout.CENTER);
	}

}
