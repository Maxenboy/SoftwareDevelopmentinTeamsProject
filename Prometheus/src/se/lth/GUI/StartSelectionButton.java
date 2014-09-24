package se.lth.GUI;

@SuppressWarnings("serial")
public class StartSelectionButton extends TimeSelectionButton {
	/**
	 * creates a StartSelectionButton
	 * 
	 * @param file
	 *            the file that should be written to
	 */
	public StartSelectionButton(String file) {
		super("Start Time", file);
	}

	@Override
	protected void opSetFile() {
		file = "start.txt";

	}

}
