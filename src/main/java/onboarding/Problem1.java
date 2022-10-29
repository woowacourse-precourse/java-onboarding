package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if ((!isValidity(pobi)&&isValidity(crong)))
            return -1;
        else{
            answer = chooseWinner(pobi, crong);
            return answer;
        }
    }

    /** 주어진 책의 페이지가 연속된 숫자라면 true, 아니면 false 반환합니다. */
    private static boolean isValidity(List<Integer> pages) {
        if (pages.get(1)-pages.get(0) == 1)
            return true;
        else
            return false;
    }

    /** pobi가 이기면 1, crong이 이기면 2, 무승부면 0 반환합니다. */
    private static int chooseWinner(List<Integer> pobi, List<Integer> crong) {
        int scorePobi = score(pobi);
        int scoreCrong = score(crong);

        if (scorePobi > scoreCrong)
            return 1;
        else if(scorePobi < scoreCrong)
            return 2;
        else
            return 0;
    }

    /** 펼쳐진 페이지로부터 점수를 계산하여 반환합니다. */
    private static int score(List<Integer> pages) {
        return bigger(sum(pages.get(0)), product(pages.get(1)));
    }

    /** 두 개의 숫자 중 더 크거나 같은 숫자를 반환합니다. */
    private static int bigger(int left, int right) {
        return (left>right) ? left : right;
    }

    /** 각 자리 숫자를 모두 더한 값을 반환합니다. */
    private static int sum(Integer page) {
        int result = 0;
        String pageStr = page.toString();
        for(int i=0;i<pageStr.length();i++)
            result = result +Character.getNumericValue(pageStr.charAt(i));
        return result;
    }

    /** 각 자리 숫자를 모두 곱한 값을 반환합니다. */
    private static int product(Integer page) {
        int result = 1;
        String pageStr = page.toString();
        for(int i=0;i<pageStr.length();i++)
            result = result * Character.getNumericValue(pageStr.charAt(i));
        return result;
    }
}