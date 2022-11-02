package onboarding;

import java.util.List;

class Problem1 {

    public static void main(String[] args) {
        System.out.println(solution(List.of(97, 98), List.of(197, 198)));
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 유효성 검사 (오른쪽 = 왼쪽 + 1이 아닌 경우 // 왼쪽 홀수 아닌 경우)
        if (checkException(pobi) || checkException(crong)) {
            return -1;
        }

        // 점수 구하기
        int maxValueOfPobi = getMaxValueOfPlayer(pobi);
        int maxValueOfCrong = getMaxValueOfPlayer(crong);

        // 값 비교 검사
        answer = getResult(maxValueOfPobi, maxValueOfCrong);

        return answer;
    }

    public static int getResult(int scoreOfPobi, int scoreOfCrong) {
        if (scoreOfPobi == scoreOfCrong) {
            return 0;
        }

        // 추후에 상수로 변경
        return scoreOfPobi > scoreOfCrong ? 1 : 2;
    }

    public static boolean checkException(List<Integer> pages) {
        boolean isException = false;

        if (pages.get(0) + 1 != pages.get(1) || pages.get(0) % 2 == 0) {
            isException = true;
        }

        return isException;
    }

    public static int getMaxValueOfPlayer(List<Integer> pages) {
        // [왼쪽 페이지 합, 오른쪽 페이지 합, 왼쪽 페이지 곱, 오른쪽 페이지 곱]
        int leftMaxValue = getMaxValueOfPage(pages.get(0));
        int rightMaxValue = getMaxValueOfPage(pages.get(1));

        int maxValueOfPages = leftMaxValue >= rightMaxValue ? leftMaxValue : rightMaxValue;
        return maxValueOfPages;
    }

    public static int getMaxValueOfPage(int page) {
        String pageTypeOfString = String.valueOf(page);

        int sum = getSumOfPage(pageTypeOfString);
        int mul = getMultipleOfPage(pageTypeOfString);

        int max = sum >= mul ? sum : mul;
        return max;
    }

    public static int getSumOfPage(String pageTypeOfString) {
        int sum = 0;

        for (int i = 0; i < pageTypeOfString.length(); i++) {
            int temp = pageTypeOfString.charAt(i) - '0';
            sum += temp;
        }
        return sum;
    }

    public static int getMultipleOfPage(String pageTypeOfString) {
        int multiple = 1;

        for (int i = 0; i < pageTypeOfString.length(); i++) {
            int temp = pageTypeOfString.charAt(i) - '0';
            multiple *= temp;
        }
        return multiple;
    }
}
