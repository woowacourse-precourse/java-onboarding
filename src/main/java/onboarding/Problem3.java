package onboarding;

import onboarding.validatechecker.Problem3ValidateChecker;

public class Problem3 {
	private static int[] gameResult = new int[10001];
	public static final int GAME_NUMBER3=3;
	public static final int GAME_NUMBER6=6;
	public static final int GAME_NUMBER9=9;

	public static int solution(int number) {
		Problem3ValidateChecker.isNumberValidate(number);
		calculateGameResult(number);
		return gameResult[number];
	}

	private static void calculateGameResult(int number){
		for(int i = 1; i <= number; i++){
			gameResult[i]=gameResult[i-1]+check369InNumber(i);
		}
	}

	private static int check369InNumber(int number){
		int count369=0;
		while(number!=0){
			int digit=number%10;
			if(digit == GAME_NUMBER3 || digit == GAME_NUMBER6
				|| digit == GAME_NUMBER9)
				count369+=1;
			number=number/10;
		}
		return count369;
	}
}
