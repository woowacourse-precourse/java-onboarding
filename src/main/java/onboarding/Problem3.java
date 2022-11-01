package onboarding;

public class Problem3 {
	public static int solution(int number) {
		int clap_Sum = 0;
		for (int times = 1; times <= number; times++) {
			String numberToCountClaps = Integer.toString(times);
			clap_Sum += addClap(numberToCountClaps);
		}
		return clap_Sum;
	}

	public static int addClap(String numberToString) {
		final int CLAP = 3;
		int howManyTimesClap = 0;
		for (int i = 0; i < numberToString.length(); i++) {
			int digit = numberToString.charAt(i) - '0';
			if (digit != 0 && digit % CLAP == 0) {
				++howManyTimesClap;
			}
		}
		return howManyTimesClap;
	}
}
