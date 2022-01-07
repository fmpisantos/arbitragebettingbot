import java.io.BufferedReader;
import java.io.InputStreamReader;
import calculations.*;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		InputStreamReader sys = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(sys);
		String input = "";
		int maxI = 0;
		Bet bet = new Bet();
		List<SimpleBet> simple;

		float stake = getStake(reader);

		maxI = getNumberOfPossibilities(reader);
			
		while(true){
			simple = new ArrayList<SimpleBet>();
			System.out.println("Press enter to add new simple bet or write DONE if you've added all the bets");
			input = reader.readLine();
			if(input.equalsIgnoreCase("done"))
				break;
			else{
				for(int i = 0; i < maxI; i++){
					SimpleBet s = loadNext(reader);
					if(s == null)
						i--;
					else
						simple.add(s);
			
				}
				bet.addNewBet(simple);
			}
		}
		
		System.out.println(bet.toString(stake));
	}

	public static SimpleBet loadNext(BufferedReader reader) throws IOException{
		try{
		System.out.println("Odd: ");
		float odd = Float.parseFloat(reader.readLine());
		System.out.println("Info: ");
		return new SimpleBet(reader.readLine(),odd);
		}catch(Exception e){
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	public static int getNumberOfPossibilities(BufferedReader reader) throws IOException {
		System.out.println("Enter the number of possible outcomes: ");
		try{
			return Integer.parseInt(reader.readLine());
		}catch(Exception e){
			System.out.println("The input for this needs to be a number.\nPlease try again!");	
			return getNumberOfPossibilities(reader);
		}
	}

	public static float getStake(BufferedReader reader) throws IOException {
		System.out.println("Enter your stake: ");
		try{
			return Float.parseFloat(reader.readLine());
		}catch(Exception e){
			System.out.println("The input for this needs to be a number.\nPlease try again!");	
			return getStake(reader);
		}
	}

}

