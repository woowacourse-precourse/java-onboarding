package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(1) < pobi.get(0) || crong.get(1) < crong.get(0)) return -1;
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) return -1;
        if (pobi.get(0) <= 1 || crong.get(1) >= 400) return -1;

        int pobiMaxNumber = getGameScore(pobi);
        int crongMaxNumber = getGameScore(crong);

        if (pobiMaxNumber == crongMaxNumber) return 0;
        return pobiMaxNumber > crongMaxNumber ? 1 : 2;
    }

    static int getGameScore(List<Integer> pages) {
        return pages.stream().mapToInt(Problem1::findGreaterOfSumAndProduct).max().getAsInt();
    }

    static int findGreaterOfSumAndProduct(int number) {
        int sum = 0;
        int multiply = 1;
        while (number != 0) {
            int units = number % 10;
            sum += units;
            multiply *= units;
            number /= 10;
        }
        return (sum >= multiply) ? sum : multiply;  // Math. max?
    }

}