import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class DataAnalyzer {

	private static final int membersPerGeneration = 40; //how many thresholds are tested
	private static final int testsPerGeneration = 50; //the number of data points that get evaluated each generation
	private static final int mutationRate = 10; //how often a child will be replaced by a random member

	private jsonParser trials;
	private Threshold[] members = new Threshold[membersPerGeneration]; 
	public DataAnalyzer(jsonParser trials) {
		this.trials = trials; //the data
	}

	private void setupMembers() { //initializes the members
		for(int x = 0; x< members.length;x++) {
			members[x] = new Threshold();
		
		}
	}

	private void evaluateMembers() { //calculates the fitness against the data
		Datapoint data = trials.getRandomData();
		for(int x = 0; x<testsPerGeneration;x++) { 
			data = trials.getRandomData(); //pulls testsPerGeneration number of data

			for(int y = 0; y< members.length;y++) {
				members[y].inspect(data); //test the data for each of the members
			}
		}
	}
	private void produceOffspring() { //makes the next generatiomn
		Random rand = new Random();
		Threshold[] children = new Threshold[membersPerGeneration];
		List<Threshold>scores = new ArrayList<Threshold>(); //for probability
		Arrays.sort(members);
		int boost = -1*members[0].getScore(); //finds the distance of the lowest score to 0
		for(Threshold hold:members) {
			for(int x = 0; x<hold.getScore()+boost;x++) {
				scores.add(hold); //scales all the scores to at least 0
			}
		}
		for(int a = 0; a< children.length;a++)  { //makes a full gen of new kids
			if(rand.nextInt(100)>mutationRate) { //tests if mutated
				children[a] = new Threshold(); 
			}
			else {
				Threshold parent1 = members[rand.nextInt(members.length)]; //gets parent 1
				Threshold parent2 = parent1;
				do { 
					parent2 = members[rand.nextInt(members.length)];
				}
				while(parent1 == parent2); //prevents incest
				children[a] = parent1.produceOffspring(parent2); //makes new child
			}
		}
		for(int x = 0;x<members.length;x++) {
			members[x] = children[x]; //sets members to the new gen
		}
	}
		private void displayMembers() {
			for(Threshold t:this.members) {
				if(t.getScore()>0)
					System.out.println("Threshold: "+t.getThreshold()+" Score: "+t.getScore());
			}
		}
	public void train() {
		setupMembers();
		while(true) {
			evaluateMembers();
			displayMembers();
			produceOffspring();
		}
	}
}
