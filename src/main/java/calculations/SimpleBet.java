package calculations;

public class SimpleBet {

	private String info;
	private float odd;

	public SimpleBet(String info, float odd){
		this.info = info;
		this.odd = odd;
	}

	public float getOdd(){
		return this.odd;
	}

	public String getInfo(){
		return this.info;
	}

	public boolean isBigger(SimpleBet bet){
		return this.odd > bet.getOdd();
	}

	public String toString(){
		return String.format("%s %f",info,odd);
	}

}

