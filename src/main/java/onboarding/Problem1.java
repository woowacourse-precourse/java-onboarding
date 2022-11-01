package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (checkPageException(pobi) || checkPageException(crong)) {
            return -1;
        }
        return calcWinner(calcPoint(pobi), calcPoint(crong));
    }

    private static boolean checkPageException(List<Integer> pages) {
        int right = pages.get(1);
        if(2 < right && right < 400 && pages.get(0) + 1 == right) {
            return right % 2 == 1;
        }
        return true;
    }

    private static int calcPoint(List<Integer> pages) {
        int point = 0;
        for(Integer page: pages) {
            List<Integer> digits = digitPage(page);
            point = Math.max(point, Math.max(addDigit(digits), mutiplyDigit(digits)));
        }
        return point;
    }

    private static List<Integer> digitPage(Integer num) {
        List<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add(num % 10);
            num /= 10;
        }
        return digits;
    }

    private static int addDigit(List<Integer> digits) {
        return digits.stream().mapToInt(Integer::intValue).sum();
    }

    private static int mutiplyDigit(List<Integer> digits) {
        return digits.stream().reduce(1, (a, b) -> a * b);
    }

    private static int calcWinner(int poingOfPobi, int pointOfCrong) {
        return (poingOfPobi == pointOfCrong) ? 0 : ((poingOfPobi > pointOfCrong) ? 1 : 2);
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}