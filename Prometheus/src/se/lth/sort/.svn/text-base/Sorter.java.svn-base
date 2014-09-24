package se.lth.sort;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import se.lth.print.LapRacePrinter;
import se.lth.print.MarathonPrinter;
import se.lth.print.Printer;
import se.lth.prometheus.PersonFileReader;
import se.lth.prometheus.RaceFileReader;
import se.lth.prometheus.Rider;

/**
 * Combines start file and finish file into a result file.
 */
public class Sorter {
	public static TreeMap<String, Rider> riderMap;

	public static void main(String[] args) throws IOException {
		riderMap = new TreeMap<String, Rider>();

		String resultFileName = args[0];
		String startFileNames = args[1];
		String finishFileNames = args[2];
		String nameFileName = args[3];
		
		//OBS! RÖR INGA KOMMENTARER!!! TASK 10.1 IN PROGRESS!!! //Felix & Max
		
//		ConfigFileReader cfr = new ConfigFileReader(new File("config.txt"));	
//		String resultFileName = cfr.get("resultFile");
//		ArrayList<String> startFileNames = cfr.getMultiple("startFile");
//		ArrayList<String> finishFileNames = cfr.getMultiple("finishFile");
//		String nameFileName = cfr.get("nameFile");
		
		String raceType;
		Printer printer;
		try {
			raceType = args[4];
			int nbrOfLaps = Integer.parseInt(raceType);
			printer = new LapRacePrinter(new File(resultFileName), nbrOfLaps);

		} catch (Exception e) {
			printer = new MarathonPrinter(new File(resultFileName));
		}

		RaceFileReader sfr = null, ffr = null, pfr = null;

		StartFileSorter sfs = new StartFileSorter(sfr);
		FinishFileSorter ffs = new FinishFileSorter(ffr);
		PersonFileSorter pfs = new PersonFileSorter(pfr);

		sfr = sfs.readFile(startFileNames);
		ffr = ffs.readFile(finishFileNames);
		pfr = pfs.readFile(nameFileName);
		PersonFileReader personFileReader = (PersonFileReader) pfr;
		
		try {
			pfr.editMap(riderMap);
			sfr.editMap(riderMap);
//			for(String finish : finishFileNames){
//				ffr = ffs.readFile(finishFileName); //Byt till finishFileNames sen...
				ffr.editMap(riderMap);
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Map<String, TreeMap<String, Rider>> map = personFileReader
				.getClassMapsMap();
		if (map == null) {
			printer.print(riderMap);
		} else {
			Set<Map.Entry<String, TreeMap<String, Rider>>> set = map.entrySet();
			Iterator<Entry<String, TreeMap<String, Rider>>> itr = set
					.iterator();
			while (itr.hasNext()) {

				Entry<String, TreeMap<String, Rider>> entry = itr.next();

				printer.classPrint(entry.getValue(), entry.getKey());
			}
		}
	}
}
