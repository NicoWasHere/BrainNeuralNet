import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



public class jsonParser {
	
	private List<Trial>data = new ArrayList<Trial>();
	
	public jsonParser(String path) {
		String currentTrial;
		File data = new File(path);
		Scanner dataPull = null;
		String line, trialID;
		int trialNum = 0;
		try {
			dataPull = new Scanner(data);
		}
		catch(FileNotFoundException ex) {
			System.out.println("*** Cannot open " + path
					+ " ***");
			System.exit(1);  // quit the program
		}
		String type;
		Trial temp = new Trial();
		char lastTrial = '1';
		int[] reading = new int[8]; //delta, theta ,lowAlpha, highAlpha, lowBeta, highBeta, lowGamma, highGamma
		while(dataPull.hasNextLine()) {
			line = dataPull.nextLine();
			if (line.indexOf("\"")!=-1) {
			type = line.substring(line.indexOf("\"")+1,line.indexOf(':')-1);
			String dataReading;
			switch(type) {
			case "trial":
				if(line.charAt(line.length()-2)!=lastTrial) {
					trialNum++;
					this.data.add(temp);
					temp = new Trial();
					lastTrial = line.charAt(line.length()-2);
				}
				
				break;
			case "true":
				temp.setTruth((line.charAt(line.length()-2)==49));
				break;
			case "delta":
				dataReading = line.substring(line.indexOf(type)+type.length()+4,line.length()-2);
				reading[0] = convertData(dataReading);
				break;
			case "theta":
				dataReading = line.substring(line.indexOf(type)+type.length()+4,line.length()-2);
				reading[1] = convertData(dataReading);
				break;
			case "lowAlpha":
				dataReading = line.substring(line.indexOf(type)+type.length()+4,line.length()-2);
				reading[2] = convertData(dataReading);
				break;
			case "highAlpha":
				dataReading = line.substring(line.indexOf(type)+type.length()+4,line.length()-2);
				reading[3] = convertData(dataReading);
				break;
			case "lowBeta":
				dataReading = line.substring(line.indexOf(type)+type.length()+4,line.length()-2);
				reading[4] = convertData(dataReading);
				break;
			case "highBeta":
				dataReading = line.substring(line.indexOf(type)+type.length()+4,line.length()-2);
				reading[5] = convertData(dataReading);
				break;
			case "lowGamma":
				dataReading = line.substring(line.indexOf(type)+type.length()+4,line.length()-2);
				reading[6] = convertData(dataReading);
				break;
			case "highGamma":
				dataReading = line.substring(line.indexOf(type)+type.length()+4,line.length()-1);
				reading[7] = convertData(dataReading);
				temp.addReading(reading);
				reading = new int[8];
				break;
			default:
				break;
			}
			}
		
		}
		dataPull.close();
	}
	private int convertData (String data) {
		int num = 0;
		if(data.length() == 1) {
			return (int)data.charAt(0)-48;
		}
		else {
			
			return (int)data.charAt(data.length()-1)-48 + 10*convertData(data.substring(0, data.length()-1));
		}
		
	}
	public Datapoint getRandomData() {
		Random rand = new Random();
		int rands = rand.nextInt(data.size());
		return data.get(rands).getRandomReading();
	}
}
