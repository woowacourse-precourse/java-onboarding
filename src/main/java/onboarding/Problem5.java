package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
	public static List<Integer> solution(int money) {
		List<Integer> answer = new ArrayList<Integer>();
		int min = 0;
		min = (int) (money / 50000);
		answer.add(min);
		money -= min * 50000;
		min = (int) (money / 10000);
		answer.add(min);
		money -= min * 10000;
		min = (int) (money / 5000);
		answer.add(min);
		money -= min * 5000;
		min = (int) (money / 1000);
		answer.add(min);
		money -= min * 1000;
		min = (int) (money / 500);
		answer.add(min);
		money -= min * 500;
		min = (int) (money / 100);
		answer.add(min);
		money -= min * 100;
		min = (int) (money / 50);
		answer.add(min);
		money -= min * 50;
		min = (int) (money / 10);
		answer.add(min);
		money -= min * 10;
		answer.add(money);
		return answer;
	}
}
