import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		float result = 0;
		for(String a : args){
			try{
				result += 1/Float.parseFloat(a); 
			}catch(Exception e){
				System.err.println(e.getMessage());
				break;
			}
		}
		System.out.println(String.format("%s: %f",(result<1?"Green":"Red"),result));
	}

}

