import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class main {
	public static int numOfMembers = 50;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileWriter read = new FileWriter("latest.txt");
		PrintWriter write = new PrintWriter(read);	
		
		Random rand = new Random();
		List<Trial> data = pullJson("src/data.JSON");
		List<Trial> trueData = getTrue(data);
		List<Trial> falseData = getFalse(data);
		Member[] members = generateMembers();
		Member[] members2 = new Member[numOfMembers];
		int count = 0;
		int bestFit = 0;
		while(true) {
			
			//Single Data Point
			
//			int a = rand.nextInt(data.size());
//	//	for(int a = 0; a<data.size();a++) {
//			count = 0;
//			for(Member x:members) {
//				System.out.print(count+": ");
//				count++;
//				System.out.println(data.get(a).getTruth()+"  " +x.calcFit(data.get(a)));
//				write.println(data.get(a).getTruth()+" "+x.getdWeight()+","+x.gettWeight()+","+x.getlAWeight()+","+x.gethAWeight()+","+x.gethAWeight()+","+x.getlBWeight()+","+x.gethBWeight()+","+x.getlGWeight()+","+x.gethGWeight()+" fWeight: "+x.getfWeight()+" Fitness: "+x.getFitness());
//				if(x.getFitness()>bestFit) {
//					FileWriter best = new FileWriter("bestFit.txt");
//					PrintWriter highFit = new PrintWriter(best);	
//					bestFit = x.getFitness();
//					highFit.println(data.get(a).getTruth()+" "+x.getdWeight()+","+x.gettWeight()+","+x.getlAWeight()+","+x.gethAWeight()+","+x.gethAWeight()+","+x.getlBWeight()+","+x.gethBWeight()+","+x.getlGWeight()+","+x.gethGWeight()+" fWeight: "+x.getfWeight()+" Fitness: "+x.getFitness());
//					highFit.close();
//				}
//			}
//			
//			
//			
//			for(int x = 0;x<members2.length;x++) {
//	
//				members2[x] = new Member(getParents(members));
//			}
//			if(a<data.size()-1) {
//			a= rand.nextInt(data.size());
//			count = 0;
//			for(Member x:members2) {
//				
//				System.out.print(count+": ");
//				count++;
//				System.out.println(data.get(a).getTruth()+"  " +x.calcFit(data.get(a)));
//			}
//			for(int x = 0;x<members.length;x++) {
//				
//				members[x] = new Member(getParents(members2));
//			}
//	
//			}
//			
			
			//True False Approach 
			
			int a = rand.nextInt(trueData.size()), b = rand.nextInt(falseData.size());
			for(Member x:members) {
				System.out.print(count+": ");
				count++;
				int fitness = (x.calcFit(trueData.get(a))+x.calcFit(falseData.get(b)))/2;
				System.out.println(fitness);
				x.setFitness(fitness);
				write.println(x.getdWeight()+","+x.gettWeight()+","+x.getlAWeight()+","+x.gethAWeight()+","+x.gethAWeight()+","+x.getlBWeight()+","+x.gethBWeight()+","+x.getlGWeight()+","+x.gethGWeight()+" fWeight: "+x.getfWeight()+" Fitness: "+x.getFitness());
				if(x.getFitness()>bestFit) {
					FileWriter best = new FileWriter("bestFit.txt");
					PrintWriter highFit = new PrintWriter(best);	
					bestFit = x.getFitness();
					highFit.println(x.getdWeight()+","+x.gettWeight()+","+x.getlAWeight()+","+x.gethAWeight()+","+x.gethAWeight()+","+x.getlBWeight()+","+x.gethBWeight()+","+x.getlGWeight()+","+x.gethGWeight()+" fWeight: "+x.getfWeight()+" Fitness: "+x.getFitness());
					highFit.close();
				}
			}
			
			
			
			for(int x = 0;x<members2.length;x++) {
	
				members2[x] = new Member(getParents(members));
			}
			if(a<data.size()-1) {
			a= rand.nextInt(trueData.size());
			b = rand.nextInt(falseData.size());
			count = 0;
			for(Member x:members2) {
				System.out.print(count+": ");
				count++;
				int fitness = (x.calcFit(trueData.get(a))+x.calcFit(falseData.get(b)))/2;
				System.out.println(fitness);
				x.setFitness(fitness);
				write.println(x.getdWeight()+","+x.gettWeight()+","+x.getlAWeight()+","+x.gethAWeight()+","+x.gethAWeight()+","+x.getlBWeight()+","+x.gethBWeight()+","+x.getlGWeight()+","+x.gethGWeight()+" fWeight: "+x.getfWeight()+" Fitness: "+x.getFitness());
				if(x.getFitness()>bestFit) {
					FileWriter best = new FileWriter("bestFit.txt");
					PrintWriter highFit = new PrintWriter(best);	
					bestFit = x.getFitness();
					highFit.println(x.getdWeight()+","+x.gettWeight()+","+x.getlAWeight()+","+x.gethAWeight()+","+x.gethAWeight()+","+x.getlBWeight()+","+x.gethBWeight()+","+x.getlGWeight()+","+x.gethGWeight()+" fWeight: "+x.getfWeight()+" Fitness: "+x.getFitness());
					highFit.close();
				}
			}
			for(int x = 0;x<members.length;x++) {
				
				members[x] = new Member(getParents(members2));
			}
	
			}
		}
	
		
	}
	
	public static List<Trial> pullJson(String path) {
		List<Trial> trials = new ArrayList<Trial>();
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
					trials.add(temp);
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
			//if (line.indexOf("name")!=-1) {
			//	objectNum++;
			//}
		
		}
		dataPull.close();
return trials;
	
	}

	public static int convertData (String data) {
		int num = 0;
		if(data.length() == 1) {
			return (int)data.charAt(0)-48;
		}
		else {
			
			return (int)data.charAt(data.length()-1)-48 + 10*convertData(data.substring(0, data.length()-1));
		}
		
	}
	
	public static Member[] generateMembers () {
		
		Random rand = new Random();
		Member[] members = new Member[numOfMembers];
	
		for(int a = 0; a<numOfMembers;a++ ) {
		members[a] = new Member();
			int sum = 0;
		int[] values = new int[9];
		for(int x = 0; x<9; x++) {
			values[x] = rand.nextInt(100001);
		}
		for(int x = 0; x<8; x++) {
			sum += values[x];
		}
		members[a].setdWeight((double)values[0]/sum);
		members[a].sethAWeight((double)values[1]/sum);
		members[a].sethBWeight((double)values[2]/sum);
		members[a].sethGWeight((double)values[3]/sum);
		members[a].setlAWeight((double)values[4]/sum);
		members[a].setlBWeight((double)values[5]/sum);
		members[a].setlGWeight((double)values[6]/sum);
		members[a].settWeight((double)values[7]/sum);
		members[a].setfWeight((double)values[8]/100000);
		
		}
		return members;
	}
	
	public static Parents getParents(Member[] members) {
		Member parent1, parent2;
		Random rand = new Random();
		int sum= 0;
		int legitness = 0;
		boolean incest = true;
		int safety = 0;
		for(int x = 0; x< members.length;x++) {
			sum+= members[x].getFitness();
			if (members[x].getFitness()>0) {
			
				legitness++;
				safety = x;
			}
		}
	
	if(legitness == 0) {

		parent1 = members[rand.nextInt(members.length)];

		parent2 = new Member();
		while (incest) {
	
			parent2 = members[rand.nextInt(members.length)];
		if(parent1 != parent2) {
		
			incest = false;
		}
		
		}
		
	
		return (new Parents(parent1,parent2));
	}
	else if(legitness == 1) {
		parent1 = members[safety];
		parent2 = new Member();
		while (incest) {
			parent2 = members[rand.nextInt(members.length)];
		if(parent1 != parent2) {
			incest = false;
		}
		
		return( new Parents(parent1,parent2));
		
	}}
	else {
		int[] fit = new int[sum];
		int last = 0;
		for(int x =0; x<members.length;x++) {
			for(int a = 0; a<members[x].getFitness();a++) {
				fit[a+last] = x;
			}
			last+=members[x].getFitness();
			
		}
		
		int selection = rand.nextInt(sum);
		selection = fit[selection];
		parent1 = members[selection];
		
	incest = true;
		parent2 = new Member();
		while(incest) {
			selection = rand.nextInt(sum);
			selection = fit[selection];
			parent2 = members[selection];
			if(parent1!=parent2) {
				incest = false;
			}
		}
		
		Parents parentalUnit = new Parents(parent1,parent2);
		return parentalUnit;
	}
	return null;
	}
	
	public static List<Trial> getTrue(List<Trial> data){
		List<Trial> trueData = new ArrayList<Trial>();
		for(Trial dataPoint: data) {
			if (dataPoint.getTruth()) {
				trueData.add(dataPoint);
			}
		}
		return trueData;
	}
	public static List<Trial> getFalse(List<Trial> data){
		List<Trial> falseData = new ArrayList<Trial>();
		for(Trial dataPoint: data) {
			if (!dataPoint.getTruth()) {
				falseData.add(dataPoint);
			}
		}
		return falseData;
	}
	
	}

