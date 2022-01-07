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

	public String toString(){
		return String.format("%s %f",green?"Green":"Red", result);
	}

}
