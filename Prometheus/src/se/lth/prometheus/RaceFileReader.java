package se.lth.prometheus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public abstract class RaceFileReader {
	protected BufferedReader br;
	protected HashMap<String, TreeMap<String, Rider>> classMapsMap;
	

	/**
	 * Creates the Reader for the whole race
	 * 
	 * @param file
	 *            The file that will be read
	 * @throws Exception
	 */
	public RaceFileReader(File file) throws Exception {

		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			throw new Exception("Hittade inte filen: " + file.toString());
		}
	}
	
	

	/**
	 * Parse the given String to a Rider
	 * 
	 * @param (String) The String that will be parsed from a file
	 * @return (Rider) A Rider parsed from a line in a file
	 */
	protected abstract Rider parseStringToRider(String parseString);

	/**
	 * adds a specific attribute to the given rider
	 * 
	 * @param rider
	 *            the rider who shall be given an attribute
	 */
	protected abstract void addAttributeToRider(Rider rider);

	/**
	 * Edit the given map
	 * 
	 * @param map
	 *            enter the map that needs to be edited
	 * @throws IOException
	 */
	public void editMap(Map<String, Rider> map) throws IOException {
		String raceClass = "";
		String line = br.readLine();

		classMapsMap = new HashMap<String, TreeMap<String, Rider>>();

		
		while (line != null && !line.equals("")) {
			if(!Character.isDigit(line.charAt(0))){

				raceClass = line;
				classMapsMap.put(line, new TreeMap<String, Rider>());
			}
			else {

				Rider rider = parseStringToRider(line);
				
				if(!raceClass.equals("")){
					rider.setRaceClass(raceClass);
					classMapsMap.get(raceClass).put(rider.getId(), rider);
				}
				
				if (map.containsKey(rider.getId())) {
					addAttributeToRider(map.get(rider.getId()));
				} else {
					map.put(rider.getId(), rider);
//					classMapsMap.get(raceClass).put(rider.getId(), rider);
				}
			}
			line = br.readLine();
		}
	}

}
