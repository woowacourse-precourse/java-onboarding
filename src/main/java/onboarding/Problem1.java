package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 예외 거르고
        if (pobi.size() !=2 || crong.size()!=2) return -1;
        if (pobi.get(1) < pobi.get(0) || crong.get(1) < crong.get(0)) return -1;
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) return -1;
        if (pobi.get(0) == 1 || crong.get(1) == 400) return -1;
        // pobi, crong 모두 왼쪽 숫자, 오른쪽 숫자 각각 곱하거나 더해서 큰수 고른다
        // 둘중 큰수
        // 둘 비교해서 값 반환.
        int pobiNum = 0;
        int crongNum = 0;

        if (pobiNum > crongNum) return 1;
        if (pobiNum < crongNum) return 2;
        if (pobiNum == crongNum) return 0;
        return -1;
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
        return (sum >= multiply) ? sum : multiply;
    }

}