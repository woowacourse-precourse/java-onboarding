package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiScore = getMyBestScore(pobi);
        int crongScore = getMyBestScore(crong);

        // 예외처리
        if (pobi.get(0) <= 1 || pobi.get(0) >= 400 ||
            pobi.get(1) <= 1 || pobi.get(1) >= 400 ||
            pobi.get(0) % 2 != 1 || pobi.get(1) % 2 != 0 ||
            pobi.get(1) - pobi.get(0) != 1 ||
            crong.get(0) <= 1 || crong.get(0) >= 400 ||
            crong.get(1) <= 1 || crong.get(1) >= 400 ||
            crong.get(0) % 2 != 1 || crong.get(1) % 2 != 0 ||
            crong.get(1) - crong.get(0) != 1) {

            return -1;
        }

        if (pobiScore > crongScore) answer = 1;
        else if(pobiScore < crongScore) answer = 2;
        else if(pobiScore == crongScore) answer = 0;
        return answer;
    }

    // 자신의 최고 점수를 구한다.
    private static int getMyBestScore(List<Integer> pages) {

        // 왼쪽 페이지 최고 점수 (홀수 번호)
        int lScore = makeBestNum(pages.get(0).toString());
        // 오른쪽 페이지 최고 점수 (짝수 번호)
        int rScore = makeBestNum(pages.get(1).toString());
        // 나의 점수
        int myScore = lScore > rScore ? lScore : rScore;
        return myScore;
    }

    // 도출할 수 있는 가장 큰 점수를 구한다.
    private static int makeBestNum(String pages) {
        int allSum = 0;
        int allMulti = 1;
        for (int i = 0; i < pages.length(); i++) {
            allSum += pages.charAt(i) - '0';
            allMulti *= pages.charAt(i) - '0';
        }
        int bigNum = allSum > allMulti ? allSum : allMulti;
        return bigNum;
    }
}