package onboarding;

import java.util.List;

/**
 * 📚 기능 목록
 *
 * 1. 주어진 페이지의 유효성을 검증하는 기능
 * 2. 사용자의 점수를 구하는 기능
 * 2-1. 두 수중 큰 수를 구하는 기능
 * 2-2. 각 자리수의 합을 구하는 기능
 * 2-3. 각 자리수의 곱을 구하는 기능
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(isValidPage(pobi) || isValidPage(crong)) {
            return -1;
        }

        int pobiScore = getUserScore(pobi);
        int crongScore = getUserScore(crong);

        if(pobiScore > crongScore) {
            return 1;
        }

        if(pobiScore < crongScore) {
            return 2;
        }

        if(pobiScore == crongScore) {
            return 0;
        }

        return -1;
    }

    // 책은 펼쳤을 때 연속된 수가 나와야한다.
    // 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수번호다.
    private static boolean isValidPage(List<Integer> person) {
        Integer leftPage = person.get(0);
        Integer rightPage = person.get(1);

        return (rightPage - leftPage) != 1 || (rightPage % 2) != 0 || (leftPage % 2) != 1;
    }

    private static int getUserScore(List<Integer> person) {
        Integer leftPage = person.get(0);
        Integer rightPage = person.get(1);

        return Math.max(getMaxScore(leftPage), getMaxScore(rightPage));
    }

    private static int getMaxScore(Integer page) {
        return Math.max(getPageSum(page), getPageMultiple(page));
    }

    private static int getPageSum(Integer page) {
        String str = page.toString();
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            result += str.charAt(i) - '0';
        }
        return result;
    }

    private static int getPageMultiple(Integer page) {
        String str = page.toString();
        int result = 1;
        for (int i = 0; i < str.length(); i++) {
            result *= str.charAt(i) - '0';
        }
        return result;
    }
}