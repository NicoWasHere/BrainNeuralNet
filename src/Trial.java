import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Trial {
private boolean truth;
private List<Datapoint> readings = new ArrayList<Datapoint>();
public Trial() {}
public Trial(List <int[]>readings) {
for(int x = 0;x<readings.size();x++) {
	this.readings.set(x, new Datapoint(readings.get(x)));
}
}
public Trial(boolean truth, List <int[]>readings) {
	this.truth = truth;
	for(int x = 0;x<readings.size();x++) {
		this.readings.set(x, new Datapoint(readings.get(x),truth));
	}
	this.readings.get(readings.size()).setTruth(truth);
}
public void addReading(int[] reading) {
	this.readings.add(new Datapoint(reading,truth));
}

public void setTruth(boolean tr) {
	this.truth = tr;
	for(Datapoint point: readings) {
	point.setTruth(truth);
	}
}

public List<Datapoint> getReadings(){
	return readings;
}

public Datapoint getRandomReading(){
	Random rand = new Random();
	return readings.get(rand.nextInt(readings.size()));
}


public boolean getTruth() {
	return truth;
}


}
