package calculations;

import java.util.List;
import java.util.ArrayList;

public class Bet {
	/*
	 *This is a bet class, containing a array of simple bets corresponding to all the available outcomes
	 * This class also does the calculations corresponding to this specific bet
	 * The input for this class is as follows:
	 * nBets = number of bets in the array (used to calculate the number of outcomes per bet)
	 * nInfoPerBet = used to know if there is any extra info
	 */

	List<SimpleBet> bestBet;
	float result;

	public Bet(List<SimpleBet> bet){
		this.bestBet = bet;
	}

	public Bet(){
		this.bestBet = null;
	}

	public void addNewBet(List<SimpleBet> bet){
		if(bestBet == null)
			this.bestBet = bet;
		else{
			int idx = 0;
			for(SimpleBet b : bet){
				if(b.isBigger(bestBet.get(idx)))
					bestBet.set(idx, b);
				idx++;
			}
		}
	}

	public Result getResult(){
		float result = 0;
		for(SimpleBet bet : bestBet)
			result += 1/bet.getOdd();
		return new Result(result < 1, result);
	}

	public float getBestBet(float stake, float result, float odd){
		return stake * odd / result;
	}

	public String toString(float stake){
		Result result = getResult();
		StringBuilder s = new StringBuilder();
		for(SimpleBet simple : bestBet)
			s.append(String.format("%s - Amount to bet: %f\n",simple.toString(),getBestBet(stake,result.getResult(),1/simple.getOdd())));
		return String.format("%s%s",s.toString(),result.toString(stake));
	}

}
