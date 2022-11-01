package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (isException(pobi) || isException(crong)) {
            return -1;
        }

        int pobiMax = -1;
        int crongMax = -1;
        pobiMax = Math.max(findMax(pobi.get(0)), findMax(pobi.get(1)));
        crongMax = Math.max(findMax(crong.get(0)), findMax(crong.get(1)));
        answer = findWinner(pobiMax, crongMax);
        return answer;
}

    // 예외 경우인지를 판단하는 함수 isException()
    private static boolean isException(List<Integer> pages) {
        if (pages.get(0) % 2 == 0 || pages.get(1) % 2 == 1) {
            return true;
        }
        if (pages.get(0) + 1 != pages.get(1)) {
            return true;
        }
        if (pages.get(0) == 1 || pages.get(1) == 400) {
            return true;
        }
        return false;
    }


    // 각 자리수를 추출하는 함수 parseNumber()
    private static int[] parseNumber(Integer number) {
        String numberString = number.toString();
        char[] numberChar = numberString.toCharArray();
        int[] numbers = new int[numberChar.length];

        for (int i = 0; i < numberChar.length; i++) {
            numbers[i] = numberChar[i] - '0';
        }

        return numbers;
    }

    // 숫자들로 만들 수 있는 최댓값을 찾는 함수 findMax()
    private static int findMax(Integer page) {
        int[] numbers = parseNumber(page);

        int add = 0;
        int mul = 1;
        for (int i = 0; i < numbers.length; i++) {
            add += numbers[i];
            mul *= numbers[i];
        }

        return Math.max(add, mul);
    }

    // 결과를 판단하는 함수 findWinner()
    private static int findWinner(int pobi, int crong) {
        if (pobi > crong) {
            return 1;
        } else if (pobi < crong) {
            return 2;
        } else {
            return 0;
        }
    }

}