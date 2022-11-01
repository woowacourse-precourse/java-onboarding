package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Problem1 {

	public static int solution(List<Integer> pobi, List<Integer> crong) {

		int a = 0;
		int b = 0;
		int c = 0;
		int sum = 0;
		int gop = 0;

		int pPage = (int) ((400) * Math.random() + 1);
		int cPage = (int) ((400) * Math.random() + 1);

		if (pPage % 2 == 0) {
			pobi.add(pPage - 1);
			pobi.add(pPage);
		} else {
			pobi.add(pPage);
			pobi.add(pPage + 1);
		}

		if (cPage % 2 == 0) {
			crong.add(cPage - 1);
			crong.add(cPage);
		} else {
			crong.add(cPage);
			crong.add(cPage + 1);
		}

		for (int num : pobi) {

			a = num / 100;
			b = num / 10 - (a * 10);
			c = num % 10;
			sum = a + b + c;

			if (a == 0 && b == 0) {
				gop = c;
			} else if (a == 0) {
				gop = b * c;
			} else {
				gop = a * b * c;
			}

		}

		for (int num : crong) {

			a = num / 100;
			b = num / 10 - (a * 10);
			c = num % 10;
			sum = a + b + c;

			if (a == 0 && b == 0) {
				gop = c;
			} else if (a == 0) {
				gop = b * c;
			} else {
				gop = a * b * c;
			}

		}

		int answer = Integer.MAX_VALUE;

		return answer;
	}
}