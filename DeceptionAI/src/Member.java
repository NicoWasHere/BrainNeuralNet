import java.util.List;
import java.util.Random;

public class Member {
	//headset values
private double dWeight, tWeight, lAWeight, hAWeight, lBWeight, hBWeight, lGWeight, hGWeight; 
private double fWeight; //falseWeight
private int fitness;
public static double threshold = 600000;
public static int mutation = 10;

public Member() {}
	
public Member(Parents parent) {
	Random rand = new Random();

	//dWeight
	int choice = rand.nextInt(100);
	if(choice<mutation) {
		//mutate 
		double life = (double)rand.nextInt(100001)/100000;
	   this.dWeight=life;
	}
	else if (choice < ((100-mutation)/4)+10) {
		//parent 1
		this.dWeight=parent.getParent1().getdWeight();
	}
	else if (choice < ((100-mutation)/2)+10) {
		//parent 2
		this.dWeight=parent.getParent2().getdWeight();
	}
	else {
		//average
		this.dWeight = (parent.getParent1().getdWeight()+parent.getParent2().getdWeight())/2;
	}
	//tWeight
	 choice = rand.nextInt(100);
	if(choice<mutation) {
		//mutate 
		double life = (double)rand.nextInt(100001)/100000;
		   this.tWeight=life;
	}
	else if (choice < ((100-mutation)/4)+10) {
		//parent 1
		this.tWeight=parent.getParent1().gettWeight();
	}
	else if (choice < ((100-mutation)/2)+10) {
		//parent 2
		this.tWeight=parent.getParent2().gettWeight();
	}
	else {
		//average
		this.tWeight = (parent.getParent1().gettWeight()+parent.getParent2().gettWeight())/2;
	}
	
	//lAWeight
	 choice = rand.nextInt(100);
	if(choice<mutation) {
		//mutate 
		double life = (double)rand.nextInt(100001)/100000;
		   this.lAWeight=life;
	}
	else if (choice < ((100-mutation)/4)+10) {
		//parent 1
		this.lAWeight=parent.getParent1().getlAWeight();
	}
	else if (choice < ((100-mutation)/2)+10) {
		//parent 2
		this.lAWeight=parent.getParent2().getlAWeight();
	}
	else {
		//average
		this.lAWeight = (parent.getParent1().getlAWeight()+parent.getParent2().getlAWeight())/2;
	}
	//hAWeight
	 choice = rand.nextInt(100);
	 if(choice<mutation) {
			//mutate 
		 double life = (double)rand.nextInt(100001)/100000;
		   this.hAWeight=life;
		}
		else if (choice < ((100-mutation)/4)+10) {
			//parent 1
			this.hAWeight=parent.getParent1().gethAWeight();
		}
		else if (choice < ((100-mutation)/2)+10) {
			//parent 2
			this.hAWeight=parent.getParent2().gethAWeight();
		}
		else {
			//average
			this.hAWeight = (parent.getParent1().gethAWeight()+parent.getParent2().gethAWeight())/2;
		}
	//lBWeight
	 choice = rand.nextInt(100);
	 if(choice<mutation) {
			//mutate 
		 double life = (double)rand.nextInt(100001)/100000;
		   this.lBWeight=life;
		}
		else if (choice < ((100-mutation)/4)+10) {
			//parent 1
			this.lBWeight=parent.getParent1().getlBWeight();
		}
		else if (choice < ((100-mutation)/2)+10) {
			//parent 2
			this.lBWeight=parent.getParent2().getlBWeight();
		}
		else {
			//average
			this.lBWeight = (parent.getParent1().getlBWeight()+parent.getParent2().getlBWeight())/2;
		}
	//hBWeight
	choice = rand.nextInt(100);
	if(choice<mutation) {
		//mutate 
		double life = (double)rand.nextInt(100001)/100000;
		   this.hBWeight=life;
	}
	else if (choice < ((100-mutation)/4)+10) {
		//parent 1
		this.hBWeight=parent.getParent1().gethBWeight();
	}
	else if (choice < ((100-mutation)/2)+10) {
		//parent 2
		this.hBWeight=parent.getParent2().gethBWeight();
	}
	else {
		//average
		this.hBWeight = (parent.getParent1().gethBWeight()+parent.getParent2().gethBWeight())/2;
	}
	//lGWeight
	 choice = rand.nextInt(100);
	 if(choice<mutation) {
			//mutate
		 double life = (double)rand.nextInt(100001)/100000;
		   this.lGWeight=life;
		}
		else if (choice < ((100-mutation)/4)+10) {
			//parent 1
			this.lGWeight=parent.getParent1().getlGWeight();
		}
		else if (choice < ((100-mutation)/2)+10) {
			//parent 2
			this.lGWeight=parent.getParent2().getlGWeight();
		}
		else {
			//average
			this.lGWeight = (parent.getParent1().getlGWeight()+parent.getParent2().getlGWeight())/2;
		}
	//hGWeight
	 choice = rand.nextInt(100);
	 if(choice<mutation) {
			//mutate
		 double life = (double)rand.nextInt(100001)/100000;
		   this.hGWeight=life;
		}
		else if (choice < ((100-mutation)/4)+10) {
			//parent 1
			this.hGWeight=parent.getParent1().gethGWeight();
		}
		else if (choice < ((100-mutation)/2)+10) {
			//parent 2
			this.hGWeight=parent.getParent2().gethGWeight();
		}
		else {
			//average
			this.hGWeight = (parent.getParent1().gethGWeight()+parent.getParent2().gethGWeight())/2;
		}
	//fWeight
	 choice = rand.nextInt(100);
	 if(choice<mutation) {
			//mutate 
		 double life = (double)rand.nextInt(100001)/100000;
		   this.fWeight=life;	
	 }
		else if (choice < ((100-mutation)/4)+10) {
			//parent 1
			this.fWeight=parent.getParent1().getfWeight();
		}
		else if (choice < ((100-mutation)/2)+10) {
			//parent 2
			this.fWeight=parent.getParent2().getfWeight();
		}
		else {
			//average
			this.fWeight = (parent.getParent1().getfWeight()+parent.getParent2().getfWeight())/2;
		}
	double sum = this.dWeight+ this.tWeight+ this.lAWeight+ this.hAWeight+ this.lBWeight+ this.hBWeight+ this.lGWeight+ this.hGWeight; 
	this.dWeight /=sum; this.tWeight /=sum; this.lAWeight /=sum; this.hAWeight/=sum; this.lBWeight/=sum; this.hBWeight/=sum; this.lGWeight/=sum; this.hGWeight/=sum; 
}

public double getdWeight() {
	return dWeight;
}
public void setdWeight(double dWeight) {
	this.dWeight = dWeight;
}
public double gettWeight() {
	return tWeight;
}
public void settWeight(double tWeight) {
	this.tWeight = tWeight;
}
public double getlAWeight() {
	return lAWeight;
}
public void setlAWeight(double lAWeight) {
	this.lAWeight = lAWeight;
}
public double gethAWeight() {
	return hAWeight;
}
public void sethAWeight(double hAWeigth) {
	this.hAWeight = hAWeigth;
}
public double getlBWeight() {
	return lBWeight;
}
public void setlBWeight(double lBWeight) {
	this.lBWeight = lBWeight;
}
public double gethBWeight() {
	return hBWeight;
}
public void sethBWeight(double hBWeight) {
	this.hBWeight = hBWeight;
}
public double getlGWeight() {
	return lGWeight;
}
public void setlGWeight(double lGWeigth) {
	this.lGWeight = lGWeigth;
}
public double gethGWeight() {
	return hGWeight;
}
public void sethGWeight(double hGWeight) {
	this.hGWeight = hGWeight;
}
public double getfWeight() {
	return fWeight;
}
public void setfWeight(double fWeight) {
	this.fWeight = fWeight;
}
public int getFitness() {
	return fitness;
}


public void setFitness(int fitness) {
	this.fitness = fitness;
}

public int calcFit(Trial data) {
	if (data.getTruth()) {
		fitness = (int) (100*(1-falseChance(data)));
	}
	else {
		fitness = (int)(100*(falseChance(data)));
	}
	return fitness;
}

public double falseChance(Trial data) {
	int falseNum = 0;
	List<int[]>readings = data.getReadings();
	for (int[]reading:readings) {
		if (calculate(reading, threshold)) {
			falseNum++;
		}
	}
	return falseNum/(falseNum+falseNum*(1-fWeight));
	
}

private boolean calculate(int[] reading, double threshold) {
	double num = (double)reading[0]*dWeight+(double)reading[1]*tWeight+
			(double)reading[2]*lAWeight+(double)reading[3]*hAWeight+
			(double)reading[4]*lBWeight+(double)reading[5]*hBWeight+
			(double)reading[6]*lGWeight+(double)reading[7]*hGWeight;
	//System.out.println(num);
			
	return (threshold<num);
}
public void setRandom() {
	Random rand = new Random();

	
	int sum = 0;
int[] values = new int[9];
for(int x = 0; x<9; x++) {
	values[x] = rand.nextInt(100001);
}
for(int x = 0; x<8; x++) {
	sum += values[x];
}
this.dWeight=(double)values[0]/sum;
this.hAWeight=(double)values[1]/sum;
this.hBWeight=(double)values[2]/sum;
this.hGWeight=(double)values[3]/sum;
this.lAWeight=(double)values[4]/sum;
this.lBWeight=(double)values[5]/sum;
this.lGWeight=(double)values[6]/sum;
this.tWeight=(double)values[7]/sum;
this.fWeight = (double)values[8]/100000;

}
}