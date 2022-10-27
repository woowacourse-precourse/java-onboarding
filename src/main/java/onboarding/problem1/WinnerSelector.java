package onboarding.problem1;

import static onboarding.problem1.ResultType.*;

public class WinnerSelector {

	public ResultType getWinner(int pobiScore, int crongScore) {
		if (pobiScore == crongScore)
			return ERROR;
		return (pobiScore > crongScore) ? POBI_WIN : CRONG_WIN;
	}
}
