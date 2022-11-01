
/*
 * Classname(Problem1)
 * 
 * Version Information(0.1.0)
 * 
 * Date(2022/10/28)
 * 
 * Copyright Notice(MIT License)
 */
import java.util.ArrayList;
import java.util.List;
/*
class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int pobiScore = Problem1.pickPage(pobi);
		int crongScore = Problem1.pickPage(crong);
		*/
		if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
			return -1;
		}
		/*
		if (pobiScore == crongScore) {
			return 0;
		}
		if (pickWinner(pobiScore, crongScore) == pobiScore) {
			return 1;
		} else{return 2;}
	}

	public static int plusDigits(int page) {
		return page / 100 + (page % 100) / 10 + (page % 100) % 10;
	}

	public static int multiplyDigits(int page) {
		return page / 100 * ((page % 100) / 10) * ((page % 100) % 10);
	}
	*/
/*
	public static int pickPage(List<Integer> someone) {
		int leftpage = Integer.max(plusDigits(someone.get(0)), multiplyDigits(someone.get(0)));
		int rightpage = Integer.max(plusDigits(someone.get(1)), multiplyDigits(someone.get(1)));
		return Integer.max(leftpage, rightpage);
	}

	public static int pickWinner(int competitorScore1, int competitorScore2) {
		if (competitorScore1 == competitorScore2) {
			return 0;
		} else {
			return Integer.max(competitorScore1, competitorScore2);
		}
	}
}*/