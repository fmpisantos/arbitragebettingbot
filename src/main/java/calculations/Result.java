package calculations;

public class Result{
	private boolean green;
	private float result;
	public Result(boolean green, float result){
		this.green = green;
		this.result = result;
	}

	public boolean isGreen(){
		return this.green;
	}

	public float getResult(){
		return this.result;
	}

	public float calculateWinnings(float stake){
		return stake/this.result - stake;
	}

	public String toString(float stake){
		return String.format("%s - Winning: %f",green?"Green":"Red", calculateWinnings(stake));
	}

}
