package se.lth.print;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import se.lth.prometheus.Rider;

public abstract class Printer {
	protected static final String CHEAT = "; Omöjlig Totaltid?";
	private File file;
	protected String topString;
	protected BufferedWriter bw;

	/**
	 * Creates a Printer
	 * 
	 * @param file
	 *            prints to the given file
	 */
	public Printer(File file) {
		this.file = file;
	}

	/**
	 * Saves the contents in the Map depending on the subclass to BufferedWriter
	 * 
	 * @param map
	 *            the map that should be printed
	 * @throws IOException
	 *             if there was any problem with the file
	 */
	protected abstract void handle(Map<String, Rider> map) throws IOException;

	/**
	 * Prints the contents in the Map
	 * 
	 * @param map
	 *            the map that should be printed
	 * @throws IOException
	 *             if there was any problem with the file
	 */
	public void print(Map<String, Rider> map) throws IOException {
		file.createNewFile();
		FileWriter fw = new FileWriter(file);
		bw = new BufferedWriter(fw);
		privatePrint(map, bw, null);
	}

	public void classPrint(Map<String, Rider> map, String string)
			throws IOException {
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file,true);
		bw = new BufferedWriter(fw);
		privatePrint(map, bw, string);
	}

	private void privatePrint(Map<String, Rider> map, BufferedWriter bw,
			String string) throws IOException {

		bw.write(topString + (topString.length() > 0 ? "\n" : ""));
		if (string != null) {
			bw.write(string + "\n");
		}
		handle(map);

		bw.close();
	}
}
