package se.lth.prometheus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ConfigFileReader {
	private BufferedReader br;
	private TreeMap<String, String> variables;

	public ConfigFileReader(File file) throws Exception {
		variables = new TreeMap<String, String>();
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			throw new Exception("Hittade inte filen: " + file.toString());
		}

		readFile();
	}
	
	private String readLine(){
		String line = "";
		try {
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}

	private void readFile() {
		String line = readLine();
		while (line != null) {
			StringTokenizer str = new StringTokenizer(line, ": ");
			String varName = str.nextToken();
			String value = str.nextToken();
			variables.put(varName, value);			
			line = readLine();
		}
	}

	public String get(String string) {
		return variables.get(string);
	}

	public Object getMultiple(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
