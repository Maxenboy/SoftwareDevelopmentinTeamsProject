package se.lth.prometheus;

import java.io.File;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class PersonFileReader extends RaceFileReader {
	private String headerLine;

	/**
	 * 
	 * @param file
	 *            the file to be read
	 * @throws Exception
	 */
	public PersonFileReader(File file) throws Exception {
		super(file);
		headerLine = br.readLine();
	}

	/**
	 * Getter for the Headerline with column names
	 * 
	 * @return returns the headerline of the given file
	 */
	public String getHeaderLine() {
		return headerLine;
	}

	@Override
	protected Rider parseStringToRider(String parseString) {

		StringTokenizer st = new StringTokenizer(parseString, "; ");
		String id = st.nextToken();
		String name = st.nextToken() + " " + st.nextToken();
		Rider rider = new Rider(id, name);
		return rider;
	}

	@Override
	protected void addAttributeToRider(Rider rider) {

	}

	public Map<String, TreeMap<String, Rider>> getClassMapsMap() {
		if (classMapsMap.size() > 1) {
			return classMapsMap;
		} else {
			return null;
		}
	}

}
