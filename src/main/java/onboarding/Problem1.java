package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 왼쪽, 오른쪽 페이지에 대한 각각의 점수를 저장하는 List
        // 페이지 번호의 각 자리 숫자를 모두 더하거나 곱한 후, 둘 중 가장 큰 수들을 List로 저장
        List<Integer> scoreList_pobi = getScoreList(pobi);
        List<Integer> scoreList_crong = getScoreList(crong);

        // 가장 큰 점수 계산

        // 가장 큰 점수끼리 비교 후 answer 값을 지정

        return answer;
    }

    // 왼쪽, 오른쪽 페이지에 대한 각각의 가장 큰 점수들을 List로 반환하는 함수
    private static List<Integer> getScoreList(List<Integer> pageNumList) {
        List<Integer> scoreList = new ArrayList<>();
        for (int pageNum : pageNumList) {
            scoreList.add(getScore(pageNum)); // // 페이지 번호의 각 자리 숫자를 모두 더하거나 곱한 후, 둘 중 가장 큰 수를 반환
        }
        return scoreList;
    }

    // 페이지 번호의 각 자리 숫자를 모두 더하거나 곱한 후, 둘 중 가장 큰 수를 반환하는 함수
    private static int getScore(int pageNum) {
        int plusResult = 0; // 각 자리 숫자를 모두 더한 결과값
        int multiplyResult = 1; // 각 자리 숫자를 모두 곱한 결과값

        String pageNumToString = Integer.toString(pageNum); // 페이지 번호를 String으로 변환 (index로 각 수를 접근하기 위함)
        for (int i = 0; i < pageNumToString.length(); i++) {
            int digit = pageNumToString.charAt(i) - '0'; // 각 자리 숫자
            plusResult += digit;
            multiplyResult *= digit;
        }

        return Math.max(plusResult, multiplyResult);
    }

}