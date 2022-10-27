package onboarding;

import onboarding.problem4.Frog;
import onboarding.problem4.FrogDictionary;

public class Problem4 {
	public static String solution(String word) {
		Frog frog = new Frog(new FrogDictionary());
		return frog.convert(word);
	}
}
