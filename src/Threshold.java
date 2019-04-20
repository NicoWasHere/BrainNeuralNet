import java.util.Comparator;
import java.util.Random;

public class Threshold implements Comparable<Threshold>{
	private int threshold;
	private int score;

	public static final int numerator = 9;   //numerator/demonanator of the outputs will be correctly flagged
	public static final int denomanator = 10;
	
	/*this is the member class that is going to be evolving. 
It acts as a holder for the threshold and score variables
Threshold is the one we want to get good
Score keeps track of fitness*/

	public Threshold() {
		Random rand = new Random();
		this.threshold = rand.nextInt(2001); //Initializes a new threshold between 0 and 2000
	}
	public Threshold(int threshold) {
		this.threshold = threshold;
	}

	public int getThreshold() {
		return threshold;
	}
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	private void correctGuess() { //if a point was correctly marked false
		this.score +=denomanator-numerator;
	}
	private void incorrectGuess() { //if a point was marked false but wasn't false
		this.score -= numerator;
	}

	public void inspect (Datapoint data) { //updates fitness based on a data point
		if (!makeGuess(data.getData())) { //if it's false
			if (data.getTruth()) {
				incorrectGuess(); //decreases the score cause it was wrong
			}
			else {
				correctGuess(); //increases the score because it was correct
			}
		}
	}

	public boolean makeGuess(int[] data) { //marks points as true or false
		//uses low beta, high beta, and low gamma. The formula uses their deviations from the averages
		//scaled down by the average to make them equally weighted
		if((data[3]-48841)/488+(((data[4])-81371)/813)+(((data[5])-259157)/2591)<this.threshold){
			return true; //doesn't know
		}
		return false; //thinks it's false
	}

	public Threshold produceOffspring(Threshold parent2) { //how to create the next gen
		Random rand = new Random();
		double weight = rand.nextDouble();
		//makes a new object with a threshold that is a mix of the two parents (random mix)
		return (new Threshold ((int)(this.threshold*weight+parent2.getThreshold()*(1-weight))));
		
		//I should add a mutation state once I figure out threshold numbers
	}
	
//	@Override
//	public int compare(Threshold o1, Threshold o2) { //compares 2 Threshold objects by their score
//		
//	}
	@Override
	public int compareTo(Threshold o) {
		// TODO Auto-generated method stub
		return this.getScore()-o.getScore();
	}
	
	
	}
