
public class control {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jsonParser json = new jsonParser("src/data.JSON");
		DataAnalyzer data = new DataAnalyzer(json);
		data.train();
	}

}
