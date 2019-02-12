import java.util.ArrayList;
import java.util.List;

public class Trial {
private boolean truth;
private List<int[]> readings = new ArrayList<int[]>();
public Trial() {}
public Trial(List <int[]>readings) {
	this.readings = readings;
}
public Trial(boolean truth, List <int[]>readings) {
	this.truth = truth;
	this.readings = readings;
}
public void addReading(int[] reading) {
	this.readings.add(reading);
}

public void setTruth(boolean tr) {
	this.truth = tr;
}

public List<int[]> getReadings(){
	return readings;
}

public boolean getTruth() {
	return truth;
}

}
