
public class Datapoint {
private int[]data;
private boolean truth;
public Datapoint(int[]data) {
	this.data=data;
}
public Datapoint(int[]data,boolean truth) {
	this.data=data;
	this.truth = truth;
}
public int[] getData() {
	return data;
}
public void setData(int[] data) {
	this.data = data;
}
public boolean getTruth() {
	return truth;
}
public void setTruth(boolean truth) {
	this.truth = truth;
}

}
