package onboarding.problem1;

public class WinnerSelector {

	public int getWinner(int pobiScore, int crongScore) {
		if (pobiScore == crongScore)
			return 0;
		return (pobiScore > crongScore) ? 1 : 2;
	}
}
