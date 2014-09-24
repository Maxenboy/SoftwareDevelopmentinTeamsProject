package se.lth.sort;

import se.lth.prometheus.RaceFileReader;

public abstract class FileSorter {
	protected RaceFileReader raceFileReader;

	/**
	 * Creates a FileSorter
	 * 
	 * @param raceFileReader
	 *            the reader that should be used
	 * 
	 */
	public FileSorter(RaceFileReader raceFileReader) {
		this.raceFileReader = raceFileReader;
	}

	/**
	 * Reads the file into a RaceFileReader
	 * 
	 * @param filename
	 *            file to be read
	 * @return RaceFileReader that has read the file
	 */
	public RaceFileReader readFile(String filename) {

		try {
			read(filename);
		} catch (Exception e) {
			System.out.println("Filen hittades inte: " + filename);
			System.exit(1);
		}

		return raceFileReader;

	}

	/**
	 * Reads the file
	 * 
	 * @param filename
	 *            file to be read
	 * @throws Exception
	 *             if there is anything wrong with the given file
	 */
	protected abstract void read(String filename) throws Exception;
}
