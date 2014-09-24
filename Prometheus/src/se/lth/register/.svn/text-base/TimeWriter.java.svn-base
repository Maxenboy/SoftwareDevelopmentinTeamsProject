package se.lth.register;

import java.io.File;
import java.io.IOException;
import java.util.TreeMap;
import java.util.Map;


import se.lth.print.Printer;
import se.lth.print.RegisterFinishPrinter;
import se.lth.print.RegisterStartPrinter;
import se.lth.prometheus.FinishFileReader;
import se.lth.prometheus.RaceFileReader;
import se.lth.prometheus.Rider;
import se.lth.prometheus.StartFileReader;

public abstract class TimeWriter {
	protected TreeMap<String, Rider> riders = new TreeMap<String, Rider>();
	protected Printer printer;
	protected RaceFileReader fileReader;

	/**
	 * Creates a TimeWriter
	 * 
	 * @param file
	 *            the file that should be read from or written to
	 * @param isFinishFileReader
	 *            determins if the file is a finish file or a start file
	 */
	public TimeWriter(File file, Boolean isFinishFileReader) {
		try {
			if (isFinishFileReader) {
				fileReader = new FinishFileReader(file);
			} else {
				fileReader = new StartFileReader(file);
			}
			fileReader.editMap(riders);
		} catch (Exception e) {

		}
		if (isFinishFileReader) {
			printer = new RegisterFinishPrinter(file);
		} else {
			printer = new RegisterStartPrinter(file);
		}

	}

	/**
	 * Gets a String with rider id and finish or start time
	 * 
	 * @param rider
	 *            the given rider that should be turned in to a string
	 * @return String with rider id and finish or start time
	 */
	protected abstract String opText(Rider rider);

	/**
	 * Gets a Rider with the given id and finish or start time
	 * 
	 * @param id
	 *            the given id that should be used to create a rider
	 * @return Rider with the given id and finish or start time
	 */
	protected abstract Rider opRider(String id);

	/**
	 * Adds the rider with the given id to the map
	 * 
	 * @param riders
	 *            Map that should add the rider
	 * @param id
	 *            the id of the rider
	 */
	protected abstract void mapReg(Map<String, Rider> riders, String id);

	/**
	 * Register and prints the rider with the given id then returns the string
	 * from method opText
	 * 
	 * @param id
	 *            the id of the rider
	 * @return string from method opText
	 */
	public String register(String id) {
		Rider rider = opRider(id);
		String text = opText(rider);
		mapReg(riders, id);

		try {
			printer.print(riders);
		} catch (IOException e) {
			System.err.println("Could not write to file");
			e.printStackTrace();
		}

		return text;
	}

}