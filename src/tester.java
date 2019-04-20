
public class tester {
	public static void main(String[] args) {
	jsonParser json = new jsonParser("src/data.JSON");
	Datapoint d = json.getRandomData();
	int[]data=d.getData();
	System.out.println(d.getTruth());
	System.out.println((data[3]-48841)/488);
	System.out.println((((data[4])-81371)/813));
	System.out.println(((data[5])-259157)/2591);
	System.out.println((data[3]-48841)/488+(((data[4])-81371)/813)+(((data[5])-259157)/2591));

	Threshold t = new Threshold(200);
	System.out.println("\n"+t.makeGuess(data));
	
	Threshold a = new Threshold();
	Threshold b = new Threshold();
	a.setScore(10);
	b.setScore(11);
	}
}
