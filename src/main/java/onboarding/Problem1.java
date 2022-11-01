package onboarding;

import java.util.List;


//기능 요구 사항
//1. 주어진 페이지가 유효한지
//2. 페이지가 유효하다 했을 때 사용자의 점수를 구하는 기능
//3. 두 수중 큰 수를 구하는 기능
//4. 각 자리수의 합
//5. 각 자리수의 곱

class Problem1 {
    final static int MIN_PAGE = 1;
    final static int MAX_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!isValidPages(pobi) || !isValidPages(crong)) {
            return -1;
        }

        int crongScore = getFinalMaxScore(crong);
        int pobiScore = getFinalMaxScore(pobi);


        if(pobiScore > crongScore) {
            return 1;
        }

        if(crongScore > pobiScore) {
            return 2;
        }

        return 0;
    }

    private static boolean isValidPages(List<Integer> pages) {
        return isValidRange(pages) && isConsecutivePages(pages);
    }

    private static boolean isValidRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number <= MIN_PAGE || number >= MAX_PAGE)
                return false;
        }
        return true;
    }

    private static boolean isConsecutivePages(List<Integer> numbers) {
        return (numbers.get(0) % 2 == 1) && (numbers.get(1) - numbers.get(0) == 1);
    }

    private static int getFinalMaxScore(List<Integer> pages) {
        int leftMax = getMaxScore(pages.get(0));
        int rightMax = getMaxScore(pages.get(1));
        return Math.max(leftMax, rightMax);
    }

    private static int getMaxScore(int number) {
        return Math.max(getPageSum(toIntArray(number)), getPageMul(toIntArray(number)));
    }
    private static int getPageSum(int[] numbers) {
        int sum = 0;
        for(int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static int getPageMul(int[] numbers) {
        int multiple = 1;
        for(int number : numbers) {
            multiple *= number;
        }
        return multiple;
    }

    private static int[] toIntArray(int number) {
        String str = String.valueOf(number);
        int[] numbers = new int[str.length()];
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = str.charAt(i) -'0';
        }
        return numbers;
    }
}