package onboarding;

import java.util.List;

class Problem1 {
    private static boolean checkPage(List<Integer> list) {
        int a = list.get(0), b = list.get(1);
        return a + 1 != b;
    }

	private static int getScore(List<Integer> list) {
		int sum = 0, mul = 1, tmp;
        for(int page : list) {
            while(page > 0) {
                tmp = page % 10;
                sum += tmp;
                mul *= tmp;
                page /= 10;
            }
        }
        return Math.max(sum, mul);
	}

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(checkPage(pobi) || checkPage(crong)) return -1;
        int p = getScore(pobi), c = getScore(crong);
        return p > c ? 1 : p < c ? 2 : 0;
    }
}